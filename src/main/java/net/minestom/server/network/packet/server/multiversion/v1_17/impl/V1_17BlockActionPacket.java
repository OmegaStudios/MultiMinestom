package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.BlockActionPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17BlockActionPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        BlockActionPacket packet_ = (BlockActionPacket) packet;
        writer.writeBlockPosition(packet_.blockPosition);
        writer.writeByte(packet_.actionId);
        writer.writeByte(packet_.actionParam);
        writer.writeVarInt(packet_.blockId);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.BLOCK_ACTION;
    }

}