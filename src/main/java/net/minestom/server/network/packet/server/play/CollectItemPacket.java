package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class CollectItemPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int collectedEntityId;
    public int collectorEntityId;
    public int pickupItemCount;

    public CollectItemPacket(int collectedEntityId, int collectorEntityId, int pickupItemCount) {
        this.collectedEntityId = collectedEntityId;
        this.collectorEntityId = collectorEntityId;
        this.pickupItemCount = pickupItemCount;
    }

    public CollectItemPacket() {
        this(0, 0, 0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getCollectItemPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        collectedEntityId = reader.readVarInt();
        collectorEntityId = reader.readVarInt();
        pickupItemCount = reader.readVarInt();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getCollectItemPacket().getId();
    }
}
