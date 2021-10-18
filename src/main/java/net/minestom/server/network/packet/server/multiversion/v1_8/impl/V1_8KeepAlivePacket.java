package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.KeepAlivePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8KeepAlivePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        KeepAlivePacket packet_ = (KeepAlivePacket) packet;
        writer.writeVarInt((int) packet_.id); //Random Integer; converts long to int; maybe unsafe!
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.KEEP_ALIVE;
    }

}