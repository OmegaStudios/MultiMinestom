package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class OpenHorseWindowPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public byte windowId;
    public int slotCount;
    public int entityId;

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeByte(windowId);
        writer.writeVarInt(slotCount);
        writer.writeInt(entityId);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        windowId = reader.readByte();
        slotCount = reader.readVarInt();
        entityId = reader.readInt();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getOpenHorseWindowPacket().getId();
    }
}
