package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.WorldBorderSizePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17WorldBorderSizePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        WorldBorderSizePacket packet_ = (WorldBorderSizePacket) packet;
        writer.writeDouble(packet_.diameter);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.WORLD_BORDER_SIZE;
    }

}