package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SetTitleSubTitlePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SetTitleSubTitlePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SetTitleSubTitlePacket packet_ = (SetTitleSubTitlePacket) packet;
        writer.writeComponent(packet_.subtitle);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SET_TITLE_SUBTITLE;
    }

}