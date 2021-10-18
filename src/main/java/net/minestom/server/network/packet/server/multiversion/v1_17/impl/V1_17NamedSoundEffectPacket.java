package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.adventure.AdventurePacketConvertor;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.NamedSoundEffectPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17NamedSoundEffectPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        NamedSoundEffectPacket packet_ = (NamedSoundEffectPacket) packet;
        writer.writeSizedString(packet_.soundName);
        writer.writeVarInt(AdventurePacketConvertor.getSoundSourceValue(packet_.soundSource));
        writer.writeInt(packet_.x * 8);
        writer.writeInt(packet_.y * 8);
        writer.writeInt(packet_.z * 8);
        writer.writeFloat(packet_.volume);
        writer.writeFloat(packet_.pitch);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.NAMED_SOUND_EFFECT;
    }

}