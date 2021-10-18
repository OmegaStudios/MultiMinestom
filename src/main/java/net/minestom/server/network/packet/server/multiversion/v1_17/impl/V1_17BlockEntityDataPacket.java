package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.BlockEntityDataPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17BlockEntityDataPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        BlockEntityDataPacket packet_ = (BlockEntityDataPacket) packet;
        writer.writeBlockPosition(packet_.blockPosition);
        writer.writeByte(packet_.action);
        if (packet_.nbtCompound != null) {
            writer.writeNBT("", packet_.nbtCompound);
        } else {
            // TAG_End
            writer.writeByte((byte) 0x00);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.BLOCK_ENTITY_DATA;
    }

}