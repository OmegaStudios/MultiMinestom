package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.WorldBorderCenterPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17WorldBorderCenterPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        WorldBorderCenterPacket packet_ = (WorldBorderCenterPacket) packet;
        writer.writeDouble(packet_.x);
        writer.writeDouble(packet_.z);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.WORLD_BORDER_CENTER;
    }

}