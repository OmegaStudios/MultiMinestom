package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.MinecraftServer;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.RespawnPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8RespawnPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Respawn
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        RespawnPacket packet_ = (RespawnPacket) packet;
        writer.writeInt(0); //Dimension //TODO defaulted to 0 for now, update later
        writer.writeByte(MinecraftServer.getDifficulty().getId()); //Difficulty
        writer.writeByte(packet_.gameMode.getId()); //Gamemode
        writer.writeSizedString(packet_.isFlat ? "flat" : "default"); //World type
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.RESPAWN;
    }

}