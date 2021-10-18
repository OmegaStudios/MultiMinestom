package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.HeldItemChangePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8HeldItemChangePacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Held_Item_Change
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        HeldItemChangePacket packet_ = (HeldItemChangePacket) packet;
        writer.writeByte(packet_.slot); //Slot
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.HELD_ITEM_CHANGE;
    }

}