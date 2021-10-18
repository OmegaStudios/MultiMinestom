package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.CloseWindowPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17CloseWindowPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        CloseWindowPacket packet_ = (CloseWindowPacket) packet;
        writer.writeByte(packet_.windowId);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.CLOSE_WINDOW;
    }

}