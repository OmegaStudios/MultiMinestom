package net.minestom.server.network.packet.server.play;

import net.kyori.adventure.text.Component;
import net.minestom.server.network.packet.server.ComponentHoldingServerPacket;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.function.UnaryOperator;

public class DisconnectPacket implements ComponentHoldingServerPacket {

    private PacketAdapter packetAdapter;
    public Component message;

    /**
     * Creates a new disconnect packet with a given message.
     *
     * @param message the message
     */
    public DisconnectPacket(@NotNull Component message) {
        this.message = message;
    }

    private DisconnectPacket() {
        this(Component.text("Disconnected."));
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeComponent(message);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        message = reader.readComponent();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getDisconnectPacket().getId();
    }

    @Override
    public @NotNull Collection<Component> components() {
        return Collections.singleton(message);
    }

    @Override
    public @NotNull ServerPacket copyWithOperator(@NotNull UnaryOperator<Component> operator) {
        return new DisconnectPacket(operator.apply(message));
    }
}
