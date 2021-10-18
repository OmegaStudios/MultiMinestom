package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SpawnPlayerPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SpawnPlayerPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SpawnPlayerPacket packet_ = (SpawnPlayerPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeUuid(packet_.playerUuid);
        writer.writeDouble(packet_.position.x());
        writer.writeDouble(packet_.position.y());
        writer.writeDouble(packet_.position.z());
        writer.writeByte((byte) (packet_.position.yaw() * 256f / 360f));
        writer.writeByte((byte) (packet_.position.pitch() * 256f / 360f));
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SPAWN_PLAYER;
    }

}