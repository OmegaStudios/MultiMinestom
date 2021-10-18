package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class TimeUpdatePacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public long worldAge;
    public long timeOfDay;

    public TimeUpdatePacket(long worldAge, long timeOfDay) {
        this.worldAge = worldAge;
        this.timeOfDay = timeOfDay;
    }

    public TimeUpdatePacket() {
        this(0, 0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getTimeUpdatePacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        worldAge = reader.readLong();
        timeOfDay = reader.readLong();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getTimeUpdatePacket().getId();
    }
}
