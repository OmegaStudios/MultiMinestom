package net.minestom.server.network.packet.server.play;

import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class SpawnPositionPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public Point position;
    public float angle;

    public SpawnPositionPacket(Point position, float angle) {
        this.position = position;
        this.angle = angle;
    }

    public SpawnPositionPacket() {
        this(Vec.ZERO, 0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getSpawnPositionPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.position = reader.readBlockPosition();
        this.angle = reader.readFloat();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getSpawnPositionPacket().getId();
    }
}
