package net.minestom.server.network.packet.server.play;

import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.instance.block.Block;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class BlockActionPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public Point blockPosition;
    public byte actionId;
    public byte actionParam;
    public int blockId;

    public BlockActionPacket(Point blockPosition, byte actionId, byte actionParam, int blockId) {
        this.blockPosition = blockPosition;
        this.actionId = actionId;
        this.actionParam = actionParam;
        this.blockId = blockId;
    }

    public BlockActionPacket(Point blockPosition, byte actionId, byte actionParam, Block block) {
        this(blockPosition, actionId, actionParam, block.id());
    }

    public BlockActionPacket() {
        this(Vec.ZERO, (byte) 0, (byte) 0, Block.AIR);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getBlockActionPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.blockPosition = reader.readBlockPosition();
        this.actionId = reader.readByte();
        this.actionParam = reader.readByte();
        this.blockId = reader.readVarInt();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getBlockActionPacket().getId();
    }
}
