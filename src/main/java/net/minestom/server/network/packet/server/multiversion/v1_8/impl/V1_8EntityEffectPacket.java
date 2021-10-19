package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityEffectPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8EntityEffectPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Entity_Effect
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityEffectPacket packet_ = (EntityEffectPacket) packet;
        writer.writeVarInt(packet_.entityId); //Entity ID
        writer.writeByte((byte) packet_.potion.getEffect().id()); //Effect ID
        writer.writeByte(packet_.potion.getAmplifier()); //Amplifier
        writer.writeVarInt((int) (packet_.potion.getDuration()/20.0F)); //Duration in seconds (?!) //TODO test if its really seconds
        writer.writeBoolean(((packet_.potion.getFlags() >>> 1) & 1) == 0); //Hide particles //TODO Im tired, needs to be checked
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.ENTITY_EFFECT;
    }

}