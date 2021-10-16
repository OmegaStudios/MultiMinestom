package net.minestom.server.network.packet.server.play;

import net.kyori.adventure.text.Component;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class SetTitleSubTitlePacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public Component subtitle = Component.empty();

    public SetTitleSubTitlePacket() {
    }

    public SetTitleSubTitlePacket(Component subtitle) {
        this.subtitle = subtitle;
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.subtitle = reader.readComponent();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeComponent(subtitle);
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getSetTitleSubTitlePacket().getId();
    }
}
