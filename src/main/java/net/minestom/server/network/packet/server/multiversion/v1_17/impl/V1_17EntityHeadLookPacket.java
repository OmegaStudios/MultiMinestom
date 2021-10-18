package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityHeadLookPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EntityHeadLookPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityHeadLookPacket packet_ = (EntityHeadLookPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeByte((byte) (packet_.yaw * 256 / 360));
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ENTITY_HEAD_LOOK;
    }

}