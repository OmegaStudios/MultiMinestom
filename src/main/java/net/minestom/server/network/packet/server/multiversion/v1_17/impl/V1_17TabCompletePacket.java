package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.TabCompletePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17TabCompletePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        TabCompletePacket packet_ = (TabCompletePacket) packet;
        writer.writeVarInt(packet_.transactionId);
        writer.writeVarInt(packet_.start);
        writer.writeVarInt(packet_.length);

        writer.writeVarInt(packet_.matches.length);
        for (TabCompletePacket.Match match : packet_.matches) {
            writer.writeSizedString(match.match);
            writer.writeBoolean(match.hasTooltip);
            if (match.hasTooltip)
                writer.writeComponent(match.tooltip);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.TAB_COMPLETE;
    }

}