package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.potion.PotionEffect;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class RemoveEntityEffectPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public PotionEffect effect = PotionEffect.ABSORPTION;

    public RemoveEntityEffectPacket() {}

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(entityId);
        writer.writeByte((byte) effect.id());
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        entityId = reader.readVarInt();
        effect = PotionEffect.fromId(reader.readByte());
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getRemoveEntityEffectPacket().getId();
    }
}
