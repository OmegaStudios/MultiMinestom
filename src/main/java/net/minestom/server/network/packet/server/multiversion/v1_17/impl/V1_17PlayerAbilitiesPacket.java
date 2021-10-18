package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.PlayerAbilitiesPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17PlayerAbilitiesPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        PlayerAbilitiesPacket packet_ = (PlayerAbilitiesPacket) packet;
        writer.writeByte(packet_.flags);
        writer.writeFloat(packet_.flyingSpeed);
        writer.writeFloat(packet_.fieldViewModifier);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.PLAYER_ABILITIES;
    }

}