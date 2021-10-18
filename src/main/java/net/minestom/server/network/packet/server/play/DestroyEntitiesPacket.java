package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class DestroyEntitiesPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int[] entityIds;

    public DestroyEntitiesPacket(int[] entityIds) {
        this.entityIds = entityIds;
    }

    public DestroyEntitiesPacket(int entityId) {
        this(new int[]{entityId});
    }

    public DestroyEntitiesPacket() {
        this(0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getDestroyEntitiesPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.entityIds = reader.readVarIntArray();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getDestroyEntitiesPacket().getId();
    }
}
