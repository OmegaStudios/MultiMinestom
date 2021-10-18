package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.BlockChangePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17BlockChangePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        BlockChangePacket packet_ = (BlockChangePacket) packet;
        writer.writeBlockPosition(packet_.blockPosition);
        writer.writeVarInt(packet_.blockStateId);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.BLOCK_CHANGE;
    }

}