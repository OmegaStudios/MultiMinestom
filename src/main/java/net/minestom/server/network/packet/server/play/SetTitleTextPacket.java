package net.minestom.server.network.packet.server.play;

import net.kyori.adventure.text.Component;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class SetTitleTextPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public Component title = Component.empty();

    public SetTitleTextPacket() {
    }

    public SetTitleTextPacket(Component title) {
        this.title = title;
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.title = reader.readComponent();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getSetTitleTextPacket().writePacket(writer, this);
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getSetTitleTextPacket().getId();
    }
}
