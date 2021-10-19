package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.AttachEntityPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8AttachEntityPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Attach_Entity
    //Packet works differently in 1.8
    //In 1.8 this packet is also used to set passengers of an entity (I THINK?! We need to test this)
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        AttachEntityPacket packet_ = (AttachEntityPacket) packet;
        writer.writeInt(packet_.attachedEntityId); //Attached entity's ID
        writer.writeInt(packet_.holdingEntityId); //ID of entity that holds the lead
        writer.writeBoolean(packet_.holdingEntityId != -1); //If true leashes the entity to the vehicle
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.ATTACH_ENTITY;
    }

}