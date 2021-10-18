package net.minestom.server.network.packet.server.play;

import net.minestom.server.coordinate.Pos;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SpawnLivingEntityPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public UUID entityUuid;
    public int entityType;
    public Pos position;
    public float headPitch;
    public short velocityX, velocityY, velocityZ;

    public SpawnLivingEntityPacket() {
        entityUuid = new UUID(0, 0);
        position = Pos.ZERO;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getSpawnLivingEntityPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        entityId = reader.readVarInt();
        entityUuid = reader.readUuid();
        entityType = reader.readVarInt();

        position = new Pos(reader.readDouble(), reader.readDouble(), reader.readDouble(),
                reader.readByte() * 360f / 256f,
                reader.readByte() * 360f / 256f);
        headPitch = reader.readByte() * 360f / 256f;

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
        return this.packetAdapter.getSpawnLivingEntityPacket().getId();
    }
}
