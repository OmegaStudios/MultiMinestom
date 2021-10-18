package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SetCooldownPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SetCooldownPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SetCooldownPacket packet_ = (SetCooldownPacket) packet;
        writer.writeVarInt(packet_.itemId);
        writer.writeVarInt(packet_.cooldownTicks);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SET_COOLDOWN;
    }

}