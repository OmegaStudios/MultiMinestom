package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class WorldBorderSizePacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public double diameter;

    public static WorldBorderSizePacket of(double diameter) {
        WorldBorderSizePacket packet = new WorldBorderSizePacket();
        packet.diameter = diameter;
        return packet;
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.diameter = reader.readDouble();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeDouble(diameter);
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getWorldBorderSizePacket().getId();
    }
}
