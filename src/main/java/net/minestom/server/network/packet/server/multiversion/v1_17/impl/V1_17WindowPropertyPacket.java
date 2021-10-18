package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.WindowPropertyPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17WindowPropertyPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        WindowPropertyPacket packet_ = (WindowPropertyPacket) packet;
        writer.writeByte(packet_.windowId);
        writer.writeShort(packet_.property);
        writer.writeShort(packet_.value);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.WINDOW_PROPERTY;
    }

}