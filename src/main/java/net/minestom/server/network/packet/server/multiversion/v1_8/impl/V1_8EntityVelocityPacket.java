package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityVelocityPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8EntityVelocityPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Entity_Velocity
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityVelocityPacket packet_ = (EntityVelocityPacket) packet;
        writer.writeVarInt(packet_.entityId); //Entity ID
        writer.writeShort(packet_.velocityX); //Velocity X
        writer.writeShort(packet_.velocityY); //Velocity Y
        writer.writeShort(packet_.velocityZ); //Velocity Z
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.ENTITY_VELOCITY;
    }

}