package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.AttachEntityPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17AttachEntityPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        AttachEntityPacket packet_ = (AttachEntityPacket) packet;
        writer.writeInt(packet_.attachedEntityId);
        writer.writeInt(packet_.holdingEntityId);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ATTACH_ENTITY;
    }

}