package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.coordinate.Vec;
import net.minestom.server.instance.Chunk;
import net.minestom.server.instance.block.Block;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import net.minestom.server.utils.binary.Writeable;
import org.jetbrains.annotations.NotNull;

public class V1_17MultiBlockChangePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {

    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.MULTI_BLOCK_CHANGE;
    }

}