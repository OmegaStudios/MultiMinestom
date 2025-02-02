package net.minestom.server.network.packet.server.play;

import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SpawnPaintingPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public UUID entityUuid;
    public int motive;
    public Point position;
    public byte direction;

    public SpawnPaintingPacket() {
        entityUuid = new UUID(0, 0);
        position = Vec.ZERO;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getSpawnPaintingPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.entityId = reader.readVarInt();
        this.entityUuid = reader.readUuid();
        this.motive = reader.readVarInt();
        this.position = reader.readBlockPosition();
        this.direction = reader.readByte();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getSpawnPaintingPacket().getId();
    }
}
