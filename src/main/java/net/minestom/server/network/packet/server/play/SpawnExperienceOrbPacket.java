package net.minestom.server.network.packet.server.play;

import net.minestom.server.coordinate.Pos;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class SpawnExperienceOrbPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public Pos position;
    public short expCount;

    public SpawnExperienceOrbPacket() {
        position = Pos.ZERO;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getSpawnExperienceOrbPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        entityId = reader.readVarInt();
        position = new Pos(reader.readDouble(), reader.readDouble(), reader.readDouble());
        expCount = reader.readShort();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getSpawnExperienceOrbPacket().getId();
    }
}
