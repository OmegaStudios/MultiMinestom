package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.FacePlayerPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17FacePlayerPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        FacePlayerPacket packet_ = (FacePlayerPacket) packet;
        writer.writeVarInt(packet_.facePosition.ordinal());
        writer.writeDouble(packet_.targetX);
        writer.writeDouble(packet_.targetY);
        writer.writeDouble(packet_.targetZ);

        final boolean isEntity = packet_.entityId > 0;
        writer.writeBoolean(isEntity);
        if (isEntity) {
            writer.writeVarInt(packet_.entityId);
            writer.writeVarInt(packet_.entityFacePosition.ordinal());
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.FACE_PLAYER;
    }

}