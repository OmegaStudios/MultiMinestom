package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class UpdateViewDistancePacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int viewDistance;

    public UpdateViewDistancePacket(int viewDistance) {
        this.viewDistance = viewDistance;
    }

    public UpdateViewDistancePacket() {
        this(0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getUpdateViewDistancePacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        viewDistance = reader.readVarInt();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getUpdateViewDistancePacket().getId();
    }
}
