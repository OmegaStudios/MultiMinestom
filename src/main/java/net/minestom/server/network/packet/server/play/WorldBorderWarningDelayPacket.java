package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class WorldBorderWarningDelayPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int warningTime;

    public static WorldBorderWarningDelayPacket of(int warningTime) {
        WorldBorderWarningDelayPacket packet = new WorldBorderWarningDelayPacket();
        packet.warningTime = warningTime;
        return packet;
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.warningTime = reader.readVarInt();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getWorldBorderWarningDelayPacket().writePacket(writer, this);
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getWorldBorderWarningDelayPacket().getId();
    }
}
