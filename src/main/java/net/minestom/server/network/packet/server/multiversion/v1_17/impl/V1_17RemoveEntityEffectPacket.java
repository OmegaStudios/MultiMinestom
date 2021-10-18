package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.RemoveEntityEffectPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17RemoveEntityEffectPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        RemoveEntityEffectPacket packet_ = (RemoveEntityEffectPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeByte((byte) packet_.effect.id());
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.REMOVE_ENTITY_EFFECT;
    }

}