package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityEquipmentPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8EntityEquipmentPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Entity_Equipment
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {

        EntityEquipmentPacket packet_ = (EntityEquipmentPacket) packet;

        if (packet_.slots == null || packet_.itemStacks == null || packet_.slots.length == 0) {
            throw new IllegalArgumentException("You need to specify at least one slot and one item");
        }

        if (packet_.slots.length != packet_.itemStacks.length) {
            throw new IllegalArgumentException("You need the same amount of slots and items");
        }

        if(packet_.slots.length == 1) {

            writer.writeVarInt(packet_.entityId); //Entity ID
            writer.writeShort((byte) packet_.slots[0].ordinal()); //Slot
            writer.writeItemStack(packet_.itemStacks[0]); //Item

        } else {
            //send follow up packets
            if(packet_.getSendsTo() != null) {

                for (int i = 1; i < packet_.slots.length; i++) {

                    packet_.getSendsTo().sendPacket(new V1_8EntityEquipmentFollowPacket(packet_.entityId, packet_.slots[i], packet_.itemStacks[i]));

                }

            }

        }

    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.ENTITY_EQUIPMENT;
    }

}