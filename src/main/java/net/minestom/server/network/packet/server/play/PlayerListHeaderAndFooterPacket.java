package net.minestom.server.network.packet.server.play;

import net.kyori.adventure.text.Component;
import net.minestom.server.network.packet.server.ComponentHoldingServerPacket;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;

public class PlayerListHeaderAndFooterPacket implements ComponentHoldingServerPacket {

    private PacketAdapter packetAdapter;
    public Component header;
    public Component footer;

    public PlayerListHeaderAndFooterPacket() {
        this(null, null);
    }

    public PlayerListHeaderAndFooterPacket(@Nullable Component header, @Nullable Component footer) {
        this.header = header;
        this.footer = footer;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getPlayerListHeaderAndFooterPacket().writePacket(writer, this);
    }

    @Override
    public @NotNull Collection<Component> components() {
        List<Component> components = new ArrayList<>();
        if (header != null) {
            components.add(header);
        }
        if (footer != null) {
            components.add(footer);
        }
        return components;
    }

    @Override
    public @NotNull ServerPacket copyWithOperator(@NotNull UnaryOperator<Component> operator) {
        return new PlayerListHeaderAndFooterPacket(header == null ? null : operator.apply(header), footer == null ? null : operator.apply(footer));
    }

    public void read(@NotNull BinaryReader reader) {
        header = reader.readComponent();
        footer = reader.readComponent();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getPlayerListHeaderAndFooterPacket().getId();
    }
}
