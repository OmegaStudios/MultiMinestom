package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.UpdateHealthPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17UpdateHealthPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        UpdateHealthPacket packet_ = (UpdateHealthPacket) packet;
        writer.writeFloat(packet_.health);
        writer.writeVarInt(packet_.food);
        writer.writeFloat(packet_.foodSaturation);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.UPDATE_HEALTH;
    }

}