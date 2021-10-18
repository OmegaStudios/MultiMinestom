package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityTeleportPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EntityTeleportPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityTeleportPacket packet_ = (EntityTeleportPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeDouble(packet_.position.x());
        writer.writeDouble(packet_.position.y());
        writer.writeDouble(packet_.position.z());
        writer.writeByte((byte) (packet_.position.yaw() * 256f / 360f));
        writer.writeByte((byte) (packet_.position.pitch() * 256f / 360f));
        writer.writeBoolean(packet_.onGround);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ENTITY_TELEPORT;
    }

}