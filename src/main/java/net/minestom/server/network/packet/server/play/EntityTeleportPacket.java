package net.minestom.server.network.packet.server.play;

import net.minestom.server.coordinate.Pos;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class EntityTeleportPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public Pos position;
    public boolean onGround;

    public EntityTeleportPacket(int entityId, Pos position, boolean onGround) {
        this.entityId = entityId;
        this.position = position;
        this.onGround = onGround;
    }

    public EntityTeleportPacket() {
        this(0, Pos.ZERO, false);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getEntityTeleportPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        entityId = reader.readVarInt();
        position = new Pos(
                reader.readDouble(),
                reader.readDouble(),
                reader.readDouble(),
                reader.readByte() * 360f / 256f,
                reader.readByte() * 360f / 256f
        );
        onGround = reader.readBoolean();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getEntityTeleportPacket().getId();
    }
}
