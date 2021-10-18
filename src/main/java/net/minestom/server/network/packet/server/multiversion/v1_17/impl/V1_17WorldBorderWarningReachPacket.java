package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.WorldBorderWarningReachPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17WorldBorderWarningReachPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        WorldBorderWarningReachPacket packet_ = (WorldBorderWarningReachPacket) packet;
        writer.writeVarInt(packet_.warningBlocks);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.WORLD_BORDER_WARNING_REACH;
    }

}