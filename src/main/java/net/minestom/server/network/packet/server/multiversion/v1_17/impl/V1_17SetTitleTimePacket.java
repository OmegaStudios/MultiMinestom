package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SetTitleTimePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SetTitleTimePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SetTitleTimePacket packet_ = (SetTitleTimePacket) packet;
        writer.writeInt(packet_.fadeIn);
        writer.writeInt(packet_.stay);
        writer.writeInt(packet_.fadeOut);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SET_TITLE_TIME;
    }

}