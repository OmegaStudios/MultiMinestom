package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class EntityRotationPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public float yaw, pitch;
    public boolean onGround;

    public EntityRotationPacket(int entityId, float yaw, float pitch, boolean onGround) {
        this.entityId = entityId;
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }

    public EntityRotationPacket() {
        this(0, 0, 0, false);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getEntityRotationPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        entityId = reader.readVarInt();
        yaw = reader.readByte() * 360f / 256f;
        pitch = reader.readByte() * 360f / 256f;
        onGround = reader.readBoolean();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getEntityRotationPacket().getId();
    }

    @NotNull
    public static EntityRotationPacket getPacket(int entityId,
                                                 float yaw, float pitch,
                                                 boolean onGround) {
        EntityRotationPacket entityRotationPacket = new EntityRotationPacket();
        entityRotationPacket.entityId = entityId;
        entityRotationPacket.yaw = yaw;
        entityRotationPacket.pitch = pitch;
        entityRotationPacket.onGround = onGround;

        return entityRotationPacket;
    }
}
