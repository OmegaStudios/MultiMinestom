package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EndCombatEventPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EndCombatEventPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EndCombatEventPacket packet_ = (EndCombatEventPacket) packet;
        writer.writeVarInt(packet_.duration);
        writer.writeInt(packet_.entityId);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.END_COMBAT_EVENT;
    }

}