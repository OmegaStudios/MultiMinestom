package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import it.unimi.dsi.fastutil.ints.Int2LongRBTreeMap;
import net.minestom.server.instance.Section;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.ChunkDataPacket;
import net.minestom.server.utils.PacketUtils;
import net.minestom.server.utils.Utils;
import net.minestom.server.utils.binary.BinaryWriter;

import java.nio.ByteBuffer;

public class V1_8ChunkDataPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Chunk_Data
    //https://wiki.vg/index.php?title=Chunk_Format&oldid=7164
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {

        ChunkDataPacket packet_ = (ChunkDataPacket) packet;

        writer.writeInt(packet_.chunkX); //Chunk X
        writer.writeInt(packet_.chunkZ); //Chunk Z
        writer.writeBoolean(true); //Is Ground-Up Continuous //TODO always true?

        //TODO not finished (will most likely not work)
        ByteBuffer blocks = PacketUtils.localBuffer();
        Int2LongRBTreeMap maskMap = new Int2LongRBTreeMap();

        for (var entry : packet_.sections.entrySet()) {
            final int index = entry.getKey();
            final Section section = entry.getValue();

            final int lengthIndex = index % 64;
            final int maskIndex = index / 64;

            long mask = maskMap.get(maskIndex);
            mask |= 1L << lengthIndex;
            maskMap.put(maskIndex, mask);

            Utils.writePaletteBlocks(blocks, section.getPalette());
        }

        writer.writeShort(Short.MAX_VALUE); //Primary Bit Mask //TODO set to all 1s for now

        //Data
        writer.writeVarInt(blocks.position()); //Size of Data
        writer.write(blocks); //Chunk Data

    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.CHUNK_DATA;
    }

}