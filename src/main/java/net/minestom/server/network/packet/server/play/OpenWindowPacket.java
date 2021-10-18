package net.minestom.server.network.packet.server.play;

import net.kyori.adventure.text.Component;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class OpenWindowPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int windowId;
    public int windowType;
    public Component title = Component.text("");

    public OpenWindowPacket() {
    }

    public OpenWindowPacket(Component title) {
        this.title = title;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getOpenWindowPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        windowId = reader.readVarInt();
        windowType = reader.readVarInt();
        title = reader.readComponent();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getOpenWindowPacket().getId();
    }
}
