package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import it.unimi.dsi.fastutil.ints.Int2LongRBTreeMap;
import net.minestom.server.instance.Section;
import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.ChunkDataPacket;
import net.minestom.server.tag.Tag;
import net.minestom.server.utils.PacketUtils;
import net.minestom.server.utils.Utils;
import net.minestom.server.utils.binary.BinaryWriter;
import net.minestom.server.utils.chunk.ChunkUtils;
import net.minestom.server.world.biomes.Biome;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class V1_17ChunkDataPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        ChunkDataPacket packet_ = (ChunkDataPacket) packet;
        writer.writeInt(packet_.chunkX);
        writer.writeInt(packet_.chunkZ);

        ByteBuffer blocks = PacketUtils.localBuffer();

        Int2LongRBTreeMap maskMap = new Int2LongRBTreeMap();

        for (var entry : packet_.sections.entrySet()) {
            final int index = entry.getKey();
            final Section section = entry.getValue();

            final int lengthIndex = index % 64;
            final int maskIndex = index / 64;

            long mask = maskMap.get(maskIndex);
            mask |= 1L << lengthIndex;
            maskMap.put(maskIndex, mask);

            Utils.writePaletteBlocks(blocks, section.getPalette());
        }

        final int maskSize = maskMap.size();
        writer.writeVarInt(maskSize);
        for (int i = 0; i < maskSize; i++) {
            final long value = maskMap.getOrDefault(i, 0);
            writer.writeLong(value);
        }

        // Heightmap
        writer.writeNBT("", packet_.heightmapsNBT);

        // Biomes
        if (packet_.biomes == null || packet_.biomes.length == 0) {
            writer.writeVarInt(0);
        } else {
            writer.writeVarInt(packet_.biomes.length);
            for (Biome biome : packet_.biomes) {
                writer.writeVarInt(biome.getId());
            }
        }

        // Data
        writer.writeVarInt(blocks.position());
        writer.write(blocks);

        // Block entities
        if (packet_.entries == null || packet_.entries.isEmpty()) {
            writer.writeVarInt(0);
        } else {
            List<NBTCompound> compounds = new ArrayList<>();
            for (var entry : packet_.entries.entrySet()) {
                final int index = entry.getKey();
                final Block block = entry.getValue();
                final String blockEntity = block.registry().blockEntity();
                if (blockEntity == null) continue; // Only send block entities to client
                final NBTCompound resultNbt = new NBTCompound();
                // Append handler tags
                final BlockHandler handler = block.handler();
                if (handler != null) {
                    final NBTCompound blockNbt = Objects.requireNonNullElseGet(block.nbt(), NBTCompound::new);
                    for (Tag<?> tag : handler.getBlockEntityTags()) {
                        final var value = tag.read(blockNbt);
                        if (value != null) {
                            // Tag is present and valid
                            tag.writeUnsafe(resultNbt, value);
                        }
                    }
                }
                // Add block entity
                final var blockPosition = ChunkUtils.getBlockPosition(index, packet_.chunkX, packet_.chunkZ);
                resultNbt.setString("id", blockEntity)
                        .setInt("x", blockPosition.blockX())
                        .setInt("y", blockPosition.blockY())
                        .setInt("z", blockPosition.blockZ());
                compounds.add(resultNbt);
            }
            writer.writeVarInt(compounds.size());
            compounds.forEach(nbtCompound -> writer.writeNBT("", nbtCompound));
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.CHUNK_DATA;
    }

}