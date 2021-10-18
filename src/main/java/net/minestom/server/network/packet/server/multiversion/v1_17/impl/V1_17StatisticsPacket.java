package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.StatisticsPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17StatisticsPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        StatisticsPacket packet_ = (StatisticsPacket) packet;
        writer.writeVarInt(packet_.statistics.length);
        for (StatisticsPacket.Statistic statistic : packet_.statistics) {
            statistic.write(writer);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.STATISTICS;
    }

}