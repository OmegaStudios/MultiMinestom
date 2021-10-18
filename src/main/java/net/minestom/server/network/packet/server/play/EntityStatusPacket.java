package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class EntityStatusPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public byte status;

    public EntityStatusPacket(int entityId, byte status) {
        this.entityId = entityId;
        this.status = status;
    }

    public EntityStatusPacket() {
        this(0, (byte) 0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getEntityStatusPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        entityId = reader.readInt();
        status = reader.readByte();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getEntityStatusPacket().getId();
    }
}
