package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.OpenBookPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17OpenBookPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        OpenBookPacket packet_ = (OpenBookPacket) packet;
        writer.writeVarInt(packet_.hand.ordinal());
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.OPEN_BOOK;
    }

}