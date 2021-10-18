package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SetTitleTextPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SetTitleTextPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SetTitleTextPacket packet_ = (SetTitleTextPacket) packet;
        writer.writeComponent(packet_.title);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SET_TITLE_TEXT;
    }

}