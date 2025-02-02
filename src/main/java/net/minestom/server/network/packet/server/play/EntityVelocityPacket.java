package net.minestom.server.network.packet.server.play;

import net.minestom.server.coordinate.Point;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class EntityVelocityPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public short velocityX, velocityY, velocityZ;

    public EntityVelocityPacket(int entityId, short velocityX, short velocityY, short velocityZ) {
        this.entityId = entityId;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
    }

    public EntityVelocityPacket(int entityId, Point velocity) {
        this(entityId, (short) velocity.x(), (short) velocity.y(), (short) velocity.z());
    }

    public EntityVelocityPacket() {
        this(0, (short) 0, (short) 0, (short) 0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getEntityVelocityPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        entityId = reader.readVarInt();
        velocityX = reader.readShort();
        velocityY = reader.readShort();
        velocityZ = reader.readShort();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getEntityVelocityPacket().getId();
    }
}
