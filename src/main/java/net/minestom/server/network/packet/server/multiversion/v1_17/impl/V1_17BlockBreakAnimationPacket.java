package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.BlockBreakAnimationPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17BlockBreakAnimationPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        BlockBreakAnimationPacket packet_ = (BlockBreakAnimationPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeBlockPosition(packet_.blockPosition);
        writer.writeByte(packet_.destroyStage);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.BLOCK_BREAK_ANIMATION;
    }

}