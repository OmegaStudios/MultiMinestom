package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class DisplayScoreboardPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public byte position;
    public String scoreName;

    public DisplayScoreboardPacket() {
        scoreName = "";
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getDisplayScoreboardPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        position = reader.readByte();
        scoreName = reader.readSizedString();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getDisplayScoreboardPacket().getId();
    }
}
