package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.DisplayScoreboardPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17DisplayScoreboardPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        DisplayScoreboardPacket packet_ = (DisplayScoreboardPacket) packet;
        writer.writeByte(packet_.position);
        writer.writeSizedString(packet_.scoreName);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.DISPLAY_SCOREBOARD;
    }

}