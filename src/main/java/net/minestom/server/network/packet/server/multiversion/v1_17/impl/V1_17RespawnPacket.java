package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.RespawnPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17RespawnPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        RespawnPacket packet_ = (RespawnPacket) packet;
        writer.writeNBT("", packet_.dimensionType.toNBT());

        // Warning: must be different for each dimension type! Otherwise the client seems to cache the world name
        writer.writeSizedString(packet_.dimensionType.getName().toString());

        writer.writeLong(packet_.hashedSeed);
        writer.writeByte(packet_.gameMode.getId());
        writer.writeByte(packet_.gameMode.getId()); // Hardcore flag not included
        writer.writeBoolean(packet_.isDebug);
        writer.writeBoolean(packet_.isFlat);
        writer.writeBoolean(packet_.copyMeta);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.RESPAWN;
    }

}