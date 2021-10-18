package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityEffectPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EntityEffectPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityEffectPacket packet_ = (EntityEffectPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeByte((byte) packet_.potion.getEffect().id());
        writer.writeByte(packet_.potion.getAmplifier());
        writer.writeVarInt(packet_.potion.getDuration());
        writer.writeByte(packet_.potion.getFlags());
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ENTITY_EFFECT;
    }

}