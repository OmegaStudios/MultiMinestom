package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.UpdateViewDistancePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17UpdateViewDistancePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        UpdateViewDistancePacket packet_ = (UpdateViewDistancePacket) packet;
        writer.writeVarInt(packet_.viewDistance);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.UPDATE_VIEW_DISTANCE;
    }

}