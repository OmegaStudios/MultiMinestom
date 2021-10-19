package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.DestroyEntitiesPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8DestroyEntitiesPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Destroy_Entities
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        DestroyEntitiesPacket packet_ = (DestroyEntitiesPacket) packet;
        writer.writeVarIntArray(packet_.entityIds); //Write int[] of entities to destroy
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.DESTROY_ENTITIES;
    }

}