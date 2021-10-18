package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityVelocityPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EntityVelocityPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityVelocityPacket packet_ = (EntityVelocityPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeShort(packet_.velocityX);
        writer.writeShort(packet_.velocityY);
        writer.writeShort(packet_.velocityZ);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ENTITY_VELOCITY;
    }

}