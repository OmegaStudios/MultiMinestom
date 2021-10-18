package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SpawnPositionPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8SpawnPositionPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Spawn_Position
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SpawnPositionPacket packet_ = (SpawnPositionPacket) packet;
        writer.writeBlockPosition(packet_.position); //Location
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.SPAWN_POSITION;
    }

}