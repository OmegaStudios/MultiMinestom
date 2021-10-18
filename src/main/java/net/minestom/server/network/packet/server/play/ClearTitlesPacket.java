package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ClearTitlesPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public boolean reset;

    public ClearTitlesPacket() {
    }

    public ClearTitlesPacket(boolean reset) {
        this.reset = reset;
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.reset = reader.readBoolean();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getClearTitlesPacket().writePacket(writer, this);
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getClearTitlesPacket().getId();
    }
}
