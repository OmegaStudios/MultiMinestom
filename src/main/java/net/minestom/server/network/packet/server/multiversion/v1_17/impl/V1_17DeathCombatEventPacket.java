package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.DeathCombatEventPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17DeathCombatEventPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        DeathCombatEventPacket packet_ = (DeathCombatEventPacket) packet;
        writer.writeVarInt(packet_.playerId);
        writer.writeInt(packet_.entityId);
        writer.writeComponent(packet_.message);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.DEATH_COMBAT_EVENT;
    }

}