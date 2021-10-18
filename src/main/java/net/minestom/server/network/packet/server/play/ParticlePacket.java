package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ParticlePacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int particleId;
    public boolean longDistance;
    public double x, y, z;
    public float offsetX, offsetY, offsetZ;
    public float particleData;
    public int particleCount;

    public byte[] data;

    public ParticlePacket() {
        data = new byte[0];
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getParticlePacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        particleId = reader.readInt();
        longDistance = reader.readBoolean();
        x = reader.readDouble();
        y = reader.readDouble();
        z = reader.readDouble();
        offsetX = reader.readFloat();
        offsetY = reader.readFloat();
        offsetZ = reader.readFloat();
        particleData = reader.readFloat();
        particleCount = reader.readInt();

        data = reader.readRemainingBytes();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getParticlePacket().getId();
    }
}
