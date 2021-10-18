package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityAnimationPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8EntityAnimationPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Animation
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityAnimationPacket packet_ = (EntityAnimationPacket) packet;
        writer.writeVarInt(packet_.entityId); //Entity ID
        writer.writeByte((byte) packet_.animation.ordinal()); //Animation //TODO 3 = eat food for 1.8, but swing offhand for 1.17
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.ENTITY_ANIMATION;
    }

}