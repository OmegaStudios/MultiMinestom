package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.OpenHorseWindowPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17OpenHorseWindowPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        OpenHorseWindowPacket packet_ = (OpenHorseWindowPacket) packet;
        writer.writeByte(packet_.windowId);
        writer.writeVarInt(packet_.slotCount);
        writer.writeInt(packet_.entityId);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.OPEN_HORSE_WINDOW;
    }

}