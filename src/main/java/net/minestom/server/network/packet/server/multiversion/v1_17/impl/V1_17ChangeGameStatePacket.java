package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.ChangeGameStatePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17ChangeGameStatePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        ChangeGameStatePacket packet_ = (ChangeGameStatePacket) packet;
        writer.writeByte((byte) packet_.reason.ordinal());
        writer.writeFloat(packet_.value);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.CHANGE_GAME_STATE;
    }

}