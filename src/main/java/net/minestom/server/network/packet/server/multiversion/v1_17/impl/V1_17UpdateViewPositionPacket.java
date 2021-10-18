package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.UpdateViewPositionPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17UpdateViewPositionPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        UpdateViewPositionPacket packet_ = (UpdateViewPositionPacket) packet;
        writer.writeVarInt(packet_.chunkX);
        writer.writeVarInt(packet_.chunkZ);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.UPDATE_VIEW_POSITION;
    }

}