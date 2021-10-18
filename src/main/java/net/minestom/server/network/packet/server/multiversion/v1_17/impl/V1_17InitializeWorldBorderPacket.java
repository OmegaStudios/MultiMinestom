package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.InitializeWorldBorderPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17InitializeWorldBorderPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        InitializeWorldBorderPacket packet_ = (InitializeWorldBorderPacket) packet;
        writer.writeDouble(packet_.x);
        writer.writeDouble(packet_.z);
        writer.writeDouble(packet_.oldDiameter);
        writer.writeDouble(packet_.newDiameter);
        writer.writeVarLong(packet_.speed);
        writer.writeVarInt(packet_.portalTeleportBoundary);
        writer.writeVarInt(packet_.warningTime);
        writer.writeVarInt(packet_.warningBlocks);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.INITIALIZE_WORLD_BORDER;
    }

}