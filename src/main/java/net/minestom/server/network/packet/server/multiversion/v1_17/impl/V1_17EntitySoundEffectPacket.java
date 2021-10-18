package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.adventure.AdventurePacketConvertor;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntitySoundEffectPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EntitySoundEffectPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntitySoundEffectPacket packet_ = (EntitySoundEffectPacket) packet;
        writer.writeVarInt(packet_.soundId);
        writer.writeVarInt(AdventurePacketConvertor.getSoundSourceValue(packet_.soundSource));
        writer.writeVarInt(packet_.entityId);
        writer.writeFloat(packet_.volume);
        writer.writeFloat(packet_.pitch);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ENTITY_SOUND_EFFECT;
    }

}