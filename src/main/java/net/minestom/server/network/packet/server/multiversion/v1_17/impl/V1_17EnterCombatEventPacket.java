package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EnterCombatEventPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EnterCombatEventPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EnterCombatEventPacket packet_ = (EnterCombatEventPacket) packet;
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ENTER_COMBAT_EVENT;
    }

}