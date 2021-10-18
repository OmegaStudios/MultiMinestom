package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.WorldBorderLerpSizePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17WorldBorderLerpSizePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        WorldBorderLerpSizePacket packet_ = (WorldBorderLerpSizePacket) packet;
        writer.writeDouble(packet_.oldDiameter);
        writer.writeDouble(packet_.newDiameter);
        writer.writeVarLong(packet_.speed);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.WORLD_BORDER_LERP_SIZE;
    }

}