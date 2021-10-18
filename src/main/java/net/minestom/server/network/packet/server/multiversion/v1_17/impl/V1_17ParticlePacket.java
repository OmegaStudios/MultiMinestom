package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.ParticlePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17ParticlePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        ParticlePacket packet_ = (ParticlePacket) packet;
        writer.writeInt(packet_.particleId);
        writer.writeBoolean(packet_.longDistance);
        writer.writeDouble(packet_.x);
        writer.writeDouble(packet_.y);
        writer.writeDouble(packet_.z);
        writer.writeFloat(packet_.offsetX);
        writer.writeFloat(packet_.offsetY);
        writer.writeFloat(packet_.offsetZ);
        writer.writeFloat(packet_.particleData);
        writer.writeInt(packet_.particleCount);

        writer.writeBytes(packet_.data);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.PARTICLE;
    }

}