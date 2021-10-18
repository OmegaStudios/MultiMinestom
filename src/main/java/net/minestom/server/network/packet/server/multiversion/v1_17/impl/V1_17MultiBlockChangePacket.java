package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.MultiBlockChangePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17MultiBlockChangePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        MultiBlockChangePacket packet_ = (MultiBlockChangePacket) packet;
        writer.writeLong(((long) (packet_.chunkX & 0x3FFFFF) << 42) | (packet_.section & 0xFFFFF) | ((long) (packet_.chunkZ & 0x3FFFFF) << 20));
        writer.writeBoolean(packet_.suppressLightUpdates);
        writer.writeArray(packet_.blockChanges);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.MULTI_BLOCK_CHANGE;
    }

}