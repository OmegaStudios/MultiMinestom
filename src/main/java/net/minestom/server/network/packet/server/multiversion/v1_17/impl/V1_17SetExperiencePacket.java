package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SetExperiencePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SetExperiencePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SetExperiencePacket packet_ = (SetExperiencePacket) packet;
        writer.writeFloat(packet_.percentage);
        writer.writeVarInt(packet_.level);
        writer.writeVarInt(packet_.totalExperience);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SET_EXPERIENCE;
    }

}