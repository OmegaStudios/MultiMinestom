package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.WorldBorderWarningDelayPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17WorldBorderWarningDelayPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        WorldBorderWarningDelayPacket packet_ = (WorldBorderWarningDelayPacket) packet;
        writer.writeVarInt(packet_.warningTime);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.WORLD_BORDER_WARNING_DELAY;
    }

}