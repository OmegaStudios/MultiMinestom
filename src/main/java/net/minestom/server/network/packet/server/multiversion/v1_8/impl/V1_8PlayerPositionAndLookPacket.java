package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.PlayerPositionAndLookPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8PlayerPositionAndLookPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Player_Position_And_Look
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        PlayerPositionAndLookPacket packet_ = (PlayerPositionAndLookPacket) packet;
        writer.writeDouble(packet_.position.x()); //X
        writer.writeDouble(packet_.position.y()); //Y
        writer.writeDouble(packet_.position.z()); //Z
        writer.writeFloat(packet_.position.yaw()); //Yaw
        writer.writeFloat(packet_.position.pitch()); //Pitch
        writer.writeByte(packet_.flags); //Flags
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.PLAYER_POSITION_AND_LOOK;
    }

}