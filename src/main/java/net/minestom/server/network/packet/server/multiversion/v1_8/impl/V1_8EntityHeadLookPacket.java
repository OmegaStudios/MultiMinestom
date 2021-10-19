package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityHeadLookPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8EntityHeadLookPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Entity_Head_Look
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityHeadLookPacket packet_ = (EntityHeadLookPacket) packet;
        writer.writeVarInt(packet_.entityId); //EntityID
        writer.writeByte((byte) (packet_.yaw * 256 / 360)); //Head Yaw
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.ENTITY_HEAD_LOOK;
    }

}