package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.HeldItemChangePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17HeldItemChangePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        HeldItemChangePacket packet_ = (HeldItemChangePacket) packet;
        writer.writeByte(packet_.slot);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.HELD_ITEM_CHANGE;
    }

}