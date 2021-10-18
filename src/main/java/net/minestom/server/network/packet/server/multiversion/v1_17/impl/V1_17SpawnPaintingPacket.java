package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SpawnPaintingPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SpawnPaintingPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SpawnPaintingPacket packet_ = (SpawnPaintingPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeUuid(packet_.entityUuid);
        writer.writeVarInt(packet_.motive);
        writer.writeBlockPosition(packet_.position);
        writer.writeByte(packet_.direction);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SPAWN_PAINTING;
    }

}