package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.AcknowledgePlayerDiggingPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17AcknowledgePlayerDiggingPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        AcknowledgePlayerDiggingPacket packet_ = (AcknowledgePlayerDiggingPacket) packet;
        writer.writeBlockPosition(packet_.blockPosition);
        writer.writeVarInt(packet_.blockStateId);
        writer.writeVarInt(packet_.status.ordinal());
        writer.writeBoolean(packet_.successful);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ACKNOWLEDGE_PLAYER_DIGGING;
    }

}
