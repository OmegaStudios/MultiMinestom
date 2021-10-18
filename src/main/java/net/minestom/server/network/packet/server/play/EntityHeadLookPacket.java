package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class EntityHeadLookPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public float yaw;

    public EntityHeadLookPacket(int entityId, float yaw) {
        this.entityId = entityId;
        this.yaw = yaw;
    }

    public EntityHeadLookPacket() {
        this(0, 0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getEntityHeadLookPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        entityId = reader.readVarInt();
        yaw = reader.readByte() * 360f / 256f;
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getEntityHeadLookPacket().getId();
    }
}
