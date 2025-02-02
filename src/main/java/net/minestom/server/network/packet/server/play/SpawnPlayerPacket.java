package net.minestom.server.network.packet.server.play;

import net.minestom.server.coordinate.Pos;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SpawnPlayerPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public UUID playerUuid;
    public Pos position;

    public SpawnPlayerPacket(int entityId, UUID playerUuid, Pos position) {
        this.entityId = entityId;
        this.playerUuid = playerUuid;
        this.position = position;
    }

    public SpawnPlayerPacket() {
        this(0, new UUID(0, 0), Pos.ZERO);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getSpawnPlayerPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.entityId = reader.readVarInt();
        this.playerUuid = reader.readUuid();
        this.position = new Pos(reader.readDouble(), reader.readDouble(), reader.readDouble(),
                (reader.readByte() * 360f) / 256f,
                (reader.readByte() * 360f) / 256f);
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getSpawnPlayerPacket().getId();
    }
}
