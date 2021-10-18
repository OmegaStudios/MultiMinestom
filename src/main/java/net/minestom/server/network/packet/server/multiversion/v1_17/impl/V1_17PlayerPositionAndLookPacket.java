package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.PlayerPositionAndLookPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17PlayerPositionAndLookPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        PlayerPositionAndLookPacket packet_ = (PlayerPositionAndLookPacket) packet;
        writer.writeDouble(packet_.position.x());
        writer.writeDouble(packet_.position.y());
        writer.writeDouble(packet_.position.z());

        writer.writeFloat(packet_.position.yaw());
        writer.writeFloat(packet_.position.pitch());

        writer.writeByte(packet_.flags);
        writer.writeVarInt(packet_.teleportId);
        writer.writeBoolean(packet_.dismountVehicle);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.PLAYER_POSITION_AND_LOOK;
    }

}