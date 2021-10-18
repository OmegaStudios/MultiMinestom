package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class WorldBorderLerpSizePacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public double oldDiameter;
    public double newDiameter;
    public long speed;

    public static WorldBorderLerpSizePacket of(double oldDiameter, double newDiameter, long speed) {
        WorldBorderLerpSizePacket packet = new WorldBorderLerpSizePacket();
        packet.oldDiameter = oldDiameter;
        packet.newDiameter = newDiameter;
        packet.speed = speed;
        return packet;
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.oldDiameter = reader.readDouble();
        this.newDiameter = reader.readDouble();
        this.speed = reader.readVarLong();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getWorldBorderLerpSizePacket().writePacket(writer, this);
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getWorldBorderLerpSizePacket().getId();
    }
}
