package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.ScoreboardObjectivePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17ScoreboardObjectivePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        ScoreboardObjectivePacket packet_ = (ScoreboardObjectivePacket) packet;
        writer.writeSizedString(packet_.objectiveName);
        writer.writeByte(packet_.mode);

        if (packet_.mode == 0 || packet_.mode == 2) {
            writer.writeComponent(packet_.objectiveValue);
            writer.writeVarInt(packet_.type.ordinal());
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SCOREBOARD_OBJECTIVE;
    }

}