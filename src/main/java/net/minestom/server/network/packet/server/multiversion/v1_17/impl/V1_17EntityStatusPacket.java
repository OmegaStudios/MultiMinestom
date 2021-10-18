package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityStatusPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EntityStatusPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityStatusPacket packet_ = (EntityStatusPacket) packet;
        writer.writeInt(packet_.entityId);
        writer.writeByte(packet_.status);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ENTITY_STATUS;
    }

}