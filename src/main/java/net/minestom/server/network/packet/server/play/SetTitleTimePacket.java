package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class SetTitleTimePacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int fadeIn;
    public int stay;
    public int fadeOut;

    public SetTitleTimePacket() {
    }

    public SetTitleTimePacket(int fadeIn, int stay, int fadeOut) {
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.fadeIn = reader.readInt();
        this.stay = reader.readInt();
        this.fadeOut = reader.readInt();

    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getSetTitleTimePacket().writePacket(writer, this);
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getSetTitleTimePacket().getId();
    }
}
