package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.UnloadChunkPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8UnloadChunkPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Chunk_Data
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        UnloadChunkPacket packet_ = (UnloadChunkPacket) packet;
        writer.writeInt(packet_.chunkX); //Chunk X
        writer.writeInt(packet_.chunkZ); //Chunk Z
        writer.writeBoolean(true); //Ground-Up Continuous (must be true for unloading chunks)
        writer.writeShort((short) 0); //Primary Bit Mask (must be 0 for unloading chunks)
        //Data //TODO not sure if still needed yet
        writer.writeVarInt(1);
        writer.writeByte((byte) 0);
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.CHUNK_DATA;
    }

}