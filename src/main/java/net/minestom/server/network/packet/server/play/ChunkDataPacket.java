package net.minestom.server.network.packet.server.play;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.Section;
import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.instance.palette.Palette;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import net.minestom.server.world.biomes.Biome;
import org.jetbrains.annotations.NotNull;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;
import org.jglrxavpok.hephaistos.nbt.NBTException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChunkDataPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public Biome[] biomes;
    public int chunkX, chunkZ;

    public Map<Integer, Section> sections = new HashMap<>();
    public Map<Integer, Block> entries = new HashMap<>();

    private static final byte CHUNK_SECTION_COUNT = 16;

    public NBTCompound heightmapsNBT = new NBTCompound();

    public ChunkDataPacket() {
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getChunkDataPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.chunkX = reader.readInt();
        this.chunkZ = reader.readInt();

        int maskCount = reader.readVarInt();
        long[] masks = new long[maskCount];
        for (int i = 0; i < maskCount; i++) {
            masks[i] = reader.readLong();
        }
        try {
            // TODO: Use heightmaps
            // unused at the moment
            this.heightmapsNBT = (NBTCompound) reader.readTag();

            // Biomes
            int[] biomesIds = reader.readVarIntArray();
            this.biomes = new Biome[biomesIds.length];
            for (int i = 0; i < biomesIds.length; i++) {
                this.biomes[i] = MinecraftServer.getBiomeManager().getById(biomesIds[i]);
            }

            // Data
            this.sections = new HashMap<>();
            int blockArrayLength = reader.readVarInt();
            if (maskCount > 0) {
                final long mask = masks[0]; // TODO support for variable size
                for (int sectionIndex = 0; sectionIndex < CHUNK_SECTION_COUNT; sectionIndex++) {
                    final boolean hasSection = (mask & 1 << sectionIndex) != 0;
                    if (!hasSection) continue;
                    final Section section = sections.computeIfAbsent(sectionIndex, i -> new Section());
                    final Palette palette = section.getPalette();
                    final short blockCount = reader.readShort();
                    palette.setBlockCount(blockCount);
                    final byte bitsPerEntry = reader.readByte();
                    // Resize palette if necessary
                    if (bitsPerEntry > palette.getBitsPerEntry()) {
                        palette.resize(bitsPerEntry);
                    }
                    // Retrieve palette values
                    if (bitsPerEntry < 9) {
                        int paletteSize = reader.readVarInt();
                        for (int i = 0; i < paletteSize; i++) {
                            final int paletteValue = reader.readVarInt();
                            palette.getPaletteBlockArray()[i] = (short) paletteValue;
                            palette.getBlockPaletteMap().put((short) paletteValue, (short) i);
                        }
                    }
                    // Read blocks
                    palette.setBlocks(reader.readLongArray());
                }
            }

            // Block entities
            final int blockEntityCount = reader.readVarInt();
            this.entries = new Int2ObjectOpenHashMap<>(blockEntityCount);
            for (int i = 0; i < blockEntityCount; i++) {
                NBTCompound tag = (NBTCompound) reader.readTag();
                final String id = tag.getString("id");
                final BlockHandler handler = MinecraftServer.getBlockManager().getHandlerOrDummy(id);
                final int x = tag.getInt("x");
                final int y = tag.getInt("y");
                final int z = tag.getInt("z");
                // TODO add to handlerMap & nbtMap
            }
        } catch (IOException | NBTException e) {
            MinecraftServer.getExceptionManager().handleException(e);
            // TODO: should we throw to avoid an invalid packet?
        }
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getChunkDataPacket().getId();
    }
}