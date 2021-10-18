package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SetPassengersPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SetPassengersPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SetPassengersPacket packet_ = (SetPassengersPacket) packet;
        writer.writeVarInt(packet_.vehicleEntityId);
        writer.writeVarIntArray(packet_.passengersId);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SET_PASSENGERS;
    }

}