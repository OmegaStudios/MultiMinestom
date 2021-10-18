package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.DisconnectPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8DisconnectPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        DisconnectPacket packet_ = (DisconnectPacket) packet;
        writer.writeComponent(packet_.message);
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.DISCONNECT;
    }

}