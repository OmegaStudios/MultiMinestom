package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class UpdateLightPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int chunkX;
    public int chunkZ;
    //todo make changeable
    public boolean trustEdges = true;

    public BitSet skyLightMask = new BitSet();
    public BitSet blockLightMask = new BitSet();

    public BitSet emptySkyLightMask = new BitSet();
    public BitSet emptyBlockLightMask = new BitSet();

    public List<byte[]> skyLight = new ArrayList<>();
    public List<byte[]> blockLight = new ArrayList<>();

    /**
     * Default constructor, required for reflection operations.
     */
    public UpdateLightPacket() {
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getUpdateLightPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        chunkX = reader.readVarInt();
        chunkZ = reader.readVarInt();

        trustEdges = reader.readBoolean();

        skyLightMask = BitSet.valueOf(reader.readLongArray());
        blockLightMask = BitSet.valueOf(reader.readLongArray());

        emptySkyLightMask = BitSet.valueOf(reader.readLongArray());
        emptyBlockLightMask = BitSet.valueOf(reader.readLongArray());

        // sky light
        skyLight.clear();
        final int skyLightCount = reader.readVarInt();
        for (int i = 0; i < skyLightCount; i++) {
            int length = reader.readVarInt();
            if (length != 2048) {
                throw new IllegalStateException("Length must be 2048.");
            }
            byte[] bytes = reader.readBytes(length);
            skyLight.add(bytes);
        }

        // block light
        blockLight.clear();
        final int blockLightCount = reader.readVarInt();
        for (int i = 0; i < blockLightCount; i++) {
            int length = reader.readVarInt();
            if (length != 2048) {
                throw new IllegalStateException("Length must be 2048.");
            }

            byte[] bytes = reader.readBytes(length);
            blockLight.add(bytes);
        }
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getUpdateLightPacket().getId();
    }
}
