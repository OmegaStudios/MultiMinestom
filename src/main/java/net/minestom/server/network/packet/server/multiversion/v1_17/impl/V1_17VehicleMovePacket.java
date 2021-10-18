package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.VehicleMovePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17VehicleMovePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        VehicleMovePacket packet_ = (VehicleMovePacket) packet;
        writer.writeDouble(packet_.x);
        writer.writeDouble(packet_.y);
        writer.writeDouble(packet_.z);
        writer.writeFloat(packet_.yaw);
        writer.writeFloat(packet_.pitch);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.VEHICLE_MOVE;
    }

}