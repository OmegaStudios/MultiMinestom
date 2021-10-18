package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SpawnExperienceOrbPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SpawnExperienceOrbPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SpawnExperienceOrbPacket packet_ = (SpawnExperienceOrbPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeDouble(packet_.position.x());
        writer.writeDouble(packet_.position.y());
        writer.writeDouble(packet_.position.z());
        writer.writeShort(packet_.expCount);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SPAWN_EXPERIENCE_ORB;
    }

}