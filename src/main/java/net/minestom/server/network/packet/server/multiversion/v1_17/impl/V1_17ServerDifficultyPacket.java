package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.ServerDifficultyPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17ServerDifficultyPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        ServerDifficultyPacket packet_ = (ServerDifficultyPacket) packet;
        writer.writeByte((byte) packet_.difficulty.ordinal());
        writer.writeBoolean(packet_.locked);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SERVER_DIFFICULTY;
    }

}