package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.MinecraftServer;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.JoinGamePacket;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;

public class V1_17JoinGamePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        JoinGamePacket packet_ = (JoinGamePacket) packet;
        writer.writeInt(packet_.entityId);
        writer.writeBoolean(packet_.hardcore);
        writer.writeByte(packet_.gameMode.getId());

        if (packet_.previousGameMode == null) {
            writer.writeByte(packet_.gameMode.getId());
        } else {
            writer.writeByte(packet_.previousGameMode.getId());
        }

        //array of worlds
        writer.writeVarInt(1);
        writer.writeSizedString("minestom:world");
        NBTCompound nbt = new NBTCompound();
        NBTCompound dimensions = MinecraftServer.getDimensionTypeManager().toNBT();
        NBTCompound biomes = MinecraftServer.getBiomeManager().toNBT();

        nbt.set("minecraft:dimension_type", dimensions);
        nbt.set("minecraft:worldgen/biome", biomes);

        writer.writeNBT("", nbt);
        writer.writeNBT("", packet_.dimensionType.toNBT());

        writer.writeSizedString(packet_.dimensionType.getName().toString());
        writer.writeLong(packet_.hashedSeed);
        writer.writeVarInt(packet_.maxPlayers);
        writer.writeVarInt(packet_.viewDistance);
        writer.writeBoolean(packet_.reducedDebugInfo);
        writer.writeBoolean(packet_.enableRespawnScreen);
        //debug
        writer.writeBoolean(packet_.isDebug);
        //is flat
        writer.writeBoolean(packet_.isFlat);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.JOIN_GAME;
    }

}