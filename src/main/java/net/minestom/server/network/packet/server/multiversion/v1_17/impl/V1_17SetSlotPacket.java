package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SetSlotPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SetSlotPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SetSlotPacket packet_ = (SetSlotPacket) packet;
        writer.writeByte(packet_.windowId);
        writer.writeVarInt(packet_.stateId);
        writer.writeShort(packet_.slot);
        writer.writeItemStack(packet_.itemStack);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SET_SLOT;
    }

}