package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SpawnPositionPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SpawnPositionPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SpawnPositionPacket packet_ = (SpawnPositionPacket) packet;
        writer.writeBlockPosition(packet_.position);
        writer.writeFloat(packet_.angle);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SPAWN_POSITION;
    }

}