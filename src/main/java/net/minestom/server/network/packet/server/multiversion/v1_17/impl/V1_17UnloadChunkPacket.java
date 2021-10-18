package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.UnloadChunkPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17UnloadChunkPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        UnloadChunkPacket packet_ = (UnloadChunkPacket) packet;
        writer.writeInt(packet_.chunkX);
        writer.writeInt(packet_.chunkZ);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.UNLOAD_CHUNK;
    }

}