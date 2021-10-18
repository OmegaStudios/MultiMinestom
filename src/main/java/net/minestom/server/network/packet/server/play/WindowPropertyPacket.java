package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class WindowPropertyPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public byte windowId;
    public short property;
    public short value;

    public WindowPropertyPacket(byte windowId, short property, short value) {
        this.windowId = windowId;
        this.property = property;
        this.value = value;
    }

    public WindowPropertyPacket() {
        this((byte) 0, (short) 0, (short) 0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getWindowPropertyPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        windowId = reader.readByte();
        property = reader.readShort();
        value = reader.readShort();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getWindowPropertyPacket().getId();
    }
}
