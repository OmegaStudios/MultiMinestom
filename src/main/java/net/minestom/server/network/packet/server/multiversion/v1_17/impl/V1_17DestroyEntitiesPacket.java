package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.DestroyEntitiesPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17DestroyEntitiesPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        DestroyEntitiesPacket packet_ = (DestroyEntitiesPacket) packet;
        writer.writeVarIntArray(packet_.entityIds);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.DESTROY_ENTITIES;
    }

}