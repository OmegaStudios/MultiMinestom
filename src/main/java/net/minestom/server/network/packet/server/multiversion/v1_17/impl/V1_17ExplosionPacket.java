package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.ExplosionPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17ExplosionPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        ExplosionPacket packet_ = (ExplosionPacket) packet;
        writer.writeFloat(packet_.x);
        writer.writeFloat(packet_.y);
        writer.writeFloat(packet_.z);
        writer.writeFloat(packet_.radius);
        writer.writeVarInt(packet_.records.length / 3); // each record is 3 bytes long
        for (byte record : packet_.records)
            writer.writeByte(record);
        writer.writeFloat(packet_.playerMotionX);
        writer.writeFloat(packet_.playerMotionY);
        writer.writeFloat(packet_.playerMotionZ);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.EXPLOSION;
    }

}