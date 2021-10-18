package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.adventure.AdventurePacketConvertor;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SoundEffectPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SoundEffectPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SoundEffectPacket packet_ = (SoundEffectPacket) packet;
        writer.writeVarInt(packet_.soundId);
        writer.writeVarInt(AdventurePacketConvertor.getSoundSourceValue(packet_.soundSource));
        writer.writeInt(packet_.x * 8);
        writer.writeInt(packet_.y * 8);
        writer.writeInt(packet_.z * 8);
        writer.writeFloat(packet_.volume);
        writer.writeFloat(packet_.pitch);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SOUND_EFFECT;
    }

}