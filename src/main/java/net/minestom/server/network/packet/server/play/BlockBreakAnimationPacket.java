package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public class BlockBreakAnimationPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public Point blockPosition;
    public byte destroyStage;

    public BlockBreakAnimationPacket() {
        blockPosition = Vec.ZERO;
    }

    public BlockBreakAnimationPacket(int entityId, Point blockPosition, byte destroyStage) {
        this.entityId = entityId;
        this.blockPosition = blockPosition;
        this.destroyStage = destroyStage;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(entityId);
        writer.writeBlockPosition(blockPosition);
        writer.writeByte(destroyStage);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.entityId = reader.readVarInt();
        this.blockPosition = reader.readBlockPosition();
        this.destroyStage = reader.readByte();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getBlockBreakAnimationPacket().getId();
    }
}