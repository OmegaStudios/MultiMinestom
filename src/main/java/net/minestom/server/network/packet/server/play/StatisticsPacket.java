package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.statistic.StatisticCategory;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import net.minestom.server.utils.binary.Readable;
import net.minestom.server.utils.binary.Writeable;
import org.jetbrains.annotations.NotNull;

public class StatisticsPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public Statistic[] statistics;

    public StatisticsPacket() {
        statistics = new Statistic[0];
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getStatisticsPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        int length = reader.readVarInt();
        statistics = new Statistic[length];
        for (int i = 0; i < length; i++) {
            statistics[i] = new Statistic();
            statistics[i].read(reader);
        }
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getStatisticsPacket().getId();
    }

    public static class Statistic implements Writeable, Readable {

        public StatisticCategory category;
        public int statisticId;
        public int value;

        @Override
        public void write(BinaryWriter writer) {
            writer.writeVarInt(category.ordinal());
            writer.writeVarInt(statisticId);
            writer.writeVarInt(value);
        }

        @Override
        public void read(@NotNull BinaryReader reader) {
            category = StatisticCategory.values()[reader.readVarInt()];
            statisticId = reader.readVarInt();
            value = reader.readVarInt();
        }
    }

}
