package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.CollectItemPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17CollectItemPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        CollectItemPacket packet_ = (CollectItemPacket) packet;
        writer.writeVarInt(packet_.collectedEntityId);
        writer.writeVarInt(packet_.collectorEntityId);
        writer.writeVarInt(packet_.pickupItemCount);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.COLLECT_ITEM;
    }

}