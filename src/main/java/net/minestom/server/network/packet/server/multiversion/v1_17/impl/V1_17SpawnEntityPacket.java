package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SpawnEntityPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SpawnEntityPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SpawnEntityPacket packet_ = (SpawnEntityPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeUuid(packet_.uuid);
        writer.writeVarInt(packet_.type);

        writer.writeDouble(packet_.position.x());
        writer.writeDouble(packet_.position.y());
        writer.writeDouble(packet_.position.z());

        writer.writeByte((byte) (packet_.position.yaw() * 256 / 360));
        writer.writeByte((byte) (packet_.position.pitch() * 256 / 360));

        writer.writeInt(packet_.data);

        writer.writeShort(packet_.velocityX);
        writer.writeShort(packet_.velocityY);
        writer.writeShort(packet_.velocityZ);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SPAWN_ENTITY;
    }

}