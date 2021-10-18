package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.PingPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17PingPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        PingPacket packet_ = (PingPacket) packet;
        writer.writeInt(packet_.id);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.PING;
    }

}