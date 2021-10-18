package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.UpdateLightPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17UpdateLightPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        UpdateLightPacket packet_ = (UpdateLightPacket) packet;
        writer.writeVarInt(packet_.chunkX);
        writer.writeVarInt(packet_.chunkZ);

        writer.writeBoolean(packet_.trustEdges);

        writer.writeLongArray(packet_.skyLightMask.toLongArray());
        writer.writeLongArray(packet_.blockLightMask.toLongArray());

        writer.writeLongArray(packet_.emptySkyLightMask.toLongArray());
        writer.writeLongArray(packet_.emptyBlockLightMask.toLongArray());

        writer.writeVarInt(packet_.skyLight.size());
        for (byte[] bytes : packet_.skyLight) {
            writer.writeVarInt(2048); // Always 2048 length
            writer.writeBytes(bytes);
        }

        writer.writeVarInt(packet_.blockLight.size());
        for (byte[] bytes : packet_.blockLight) {
            writer.writeVarInt(2048); // Always 2048 length
            writer.writeBytes(bytes);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.UPDATE_LIGHT;
    }

}