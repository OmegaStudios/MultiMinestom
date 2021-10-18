package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SpawnPlayerPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8SpawnPlayerPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Spawn_Player
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SpawnPlayerPacket packet_ = (SpawnPlayerPacket) packet;
        writer.writeVarInt(packet_.entityId); //Entity ID
        writer.writeUuid(packet_.playerUuid); //Player UUID
        writer.writeInt((int) packet_.position.x()); //X as int
        writer.writeInt((int) packet_.position.y()); //Y as int
        writer.writeInt((int) packet_.position.z()); //Z as int
        writer.writeByte((byte) (packet_.position.yaw() * 256f / 360f)); //Yaw
        writer.writeByte((byte) (packet_.position.pitch() * 256f / 360f)); //Pitch
        writer.writeShort((short) 0); //held item (0 for none)
        //write metadata (client would crash if not present)
        writer.writeVarInt(packet_.entityId); //Entity ID
        writer.writeByte((byte) 0xFF); // End metadata
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.SPAWN_PLAYER;
    }

}