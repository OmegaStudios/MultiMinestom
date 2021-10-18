package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityPositionAndRotationPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EntityPositionAndRotationPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityPositionAndRotationPacket packet_ = (EntityPositionAndRotationPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeShort(packet_.deltaX);
        writer.writeShort(packet_.deltaY);
        writer.writeShort(packet_.deltaZ);
        writer.writeByte((byte) (packet_.yaw * 256 / 360));
        writer.writeByte((byte) (packet_.pitch * 256 / 360));
        writer.writeBoolean(packet_.onGround);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ENTITY_POSITION_AND_ROTATION;
    }

}