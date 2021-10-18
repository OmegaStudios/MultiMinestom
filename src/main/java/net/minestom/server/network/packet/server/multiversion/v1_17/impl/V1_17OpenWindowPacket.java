package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.OpenWindowPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17OpenWindowPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        OpenWindowPacket packet_ = (OpenWindowPacket) packet;
        writer.writeVarInt(packet_.windowId);
        writer.writeVarInt(packet_.windowType);
        writer.writeComponent(packet_.title);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.OPEN_WINDOW;
    }

}