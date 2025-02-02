package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class WorldBorderCenterPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public double x;
    public double z;

    public static WorldBorderCenterPacket of(double x, double z) {
        WorldBorderCenterPacket packet = new WorldBorderCenterPacket();
        packet.x = x;
        packet.z = z;
        return packet;
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.x = reader.readDouble();
        this.z = reader.readDouble();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getWorldBorderCenterPacket().writePacket(writer, this);
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getWorldBorderCenterPacket().getId();
    }
}
