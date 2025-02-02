package net.minestom.server.network.packet.server.play;

import net.kyori.adventure.text.Component;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class DeathCombatEventPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int playerId;
    public int entityId;
    public Component message = Component.empty();

    public static DeathCombatEventPacket of(int playerId, int entityId, Component message) {
        DeathCombatEventPacket packet = new DeathCombatEventPacket();
        packet.playerId = playerId;
        packet.entityId = entityId;
        packet.message = message;
        return packet;
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.playerId = reader.readVarInt();
        this.entityId = reader.readInt();
        this.message = reader.readComponent();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getDeathCombatEventPacket().writePacket(writer, this);
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getDeathCombatEventPacket().getId();
    }
}
