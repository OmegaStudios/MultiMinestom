package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityRotationPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8EntityRotationPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Entity_Look
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityRotationPacket packet_ = (EntityRotationPacket) packet;
        writer.writeVarInt(packet_.entityId); //Entity ID
        writer.writeByte((byte) (packet_.yaw * 256 / 360)); //Yaw
        writer.writeByte((byte) (packet_.pitch * 256 / 360)); //Pitch
        writer.writeBoolean(packet_.onGround); //On Ground
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.ENTITY_ROTATION;
    }

}