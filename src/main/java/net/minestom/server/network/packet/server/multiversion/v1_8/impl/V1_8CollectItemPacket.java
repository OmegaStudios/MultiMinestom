package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.CollectItemPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8CollectItemPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Collect_Item
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        CollectItemPacket packet_ = (CollectItemPacket) packet;
        writer.writeVarInt(packet_.collectedEntityId); //Collected Entity ID
        writer.writeVarInt(packet_.collectorEntityId); //Collector Entity ID
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.COLLECT_ITEM;
    }

}