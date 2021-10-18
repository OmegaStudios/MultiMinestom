package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class WorldBorderWarningReachPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int warningBlocks;

    public static WorldBorderWarningReachPacket of(int warningBlocks) {
        WorldBorderWarningReachPacket packet = new WorldBorderWarningReachPacket();
        packet.warningBlocks = warningBlocks;
        return packet;
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.warningBlocks = reader.readVarInt();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getWorldBorderWarningReachPacket().writePacket(writer, this);
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getWorldBorderWarningReachPacket().getId();
    }
}
