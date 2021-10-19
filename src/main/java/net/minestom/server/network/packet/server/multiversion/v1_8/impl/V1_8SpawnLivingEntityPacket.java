package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SpawnEntityPacket;
import net.minestom.server.network.packet.server.play.SpawnLivingEntityPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8SpawnLivingEntityPacket implements VersionedPacket {


    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Spawn_Mob
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SpawnLivingEntityPacket packet_ = (SpawnLivingEntityPacket) packet;

        int translatedEntityID = V1_8SpawnEntityPacket.translateEntityTypeID(packet_.entityType);

        writer.writeVarInt(packet_.entityId); //Entity ID
        writer.writeByte((byte) translatedEntityID); //Entity mob type

        writer.writeInt((int) (packet_.position.x() * 32.0D)); //X; Using fixed-point numbers (double respresented by an integer)
        writer.writeInt((int) (packet_.position.y() * 32.0D)); //Y; https://wiki.vg/Data_types#Fixed-point_numbers
        writer.writeInt((int) (packet_.position.z() * 32.0D)); //Z
        writer.writeByte((byte) (packet_.position.yaw() * 256 / 360)); //Pitch
        writer.writeByte((byte) (packet_.position.pitch() * 256 / 360)); //Yaw
        writer.writeShort((short) packet_.headPitch);

        writer.writeShort(packet_.velocityX);
        writer.writeShort(packet_.velocityY);
        writer.writeShort(packet_.velocityZ);
        //TODO add Metadata field
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.SPAWN_LIVING_ENTITY;
    }


}