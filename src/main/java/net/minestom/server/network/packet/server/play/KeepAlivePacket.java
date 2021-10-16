package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class KeepAlivePacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public long id;

    KeepAlivePacket() {}

    public KeepAlivePacket(long id) {
        this.id = id;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeLong(id);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        id = reader.readLong();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getKeepAlivePacket().getId();
    }
}
