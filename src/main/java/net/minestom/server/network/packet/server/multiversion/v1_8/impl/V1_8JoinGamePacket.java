package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.MinecraftServer;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.JoinGamePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8JoinGamePacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Join_Game
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        JoinGamePacket packet_ = (JoinGamePacket) packet;
        writer.writeInt(packet_.entityId); //Entity ID
        writer.writeByte(packet_.gameMode.getId()); //Gamemode (0 = Survival; 1 = Creative; 2 = Advanture; 3 = Spectator)
        writer.writeByte((byte) 0); //Set dimension to 0 (Overworld) //TODO change for Nether/End later
        writer.writeByte(MinecraftServer.getDifficulty().getId()); //Difficulty
        writer.writeByte(Byte.MAX_VALUE); //Max Players (Used to draw player list)
        writer.writeSizedString(packet_.isFlat ? "flat" : "default"); //World Type
        writer.writeBoolean(packet_.reducedDebugInfo); //Reduced Debug Info
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.JOIN_GAME;
    }

}