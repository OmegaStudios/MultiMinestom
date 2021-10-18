package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.OpenSignEditorPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17OpenSignEditorPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        OpenSignEditorPacket packet_ = (OpenSignEditorPacket) packet;
        writer.writeBlockPosition(packet_.signPosition);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.OPEN_SIGN_EDITOR;
    }

}