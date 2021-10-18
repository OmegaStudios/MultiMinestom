package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EffectPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EffectPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EffectPacket packet_ = (EffectPacket) packet;
        writer.writeInt(packet_.effectId);
        writer.writeBlockPosition(packet_.position);
        writer.writeInt(packet_.data);
        writer.writeBoolean(packet_.disableRelativeVolume);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.EFFECT;
    }

}