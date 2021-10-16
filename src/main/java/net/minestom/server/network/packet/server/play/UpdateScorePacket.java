package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class UpdateScorePacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public String entityName;
    public byte action;
    public String objectiveName;
    public int value;

    /**
     * Default constructor, required for reflection operations.
     */
    public UpdateScorePacket() {
        entityName = "";
        objectiveName = "";
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeSizedString(entityName);
        writer.writeByte(action);
        writer.writeSizedString(objectiveName);
        if (action != 1) {
            writer.writeVarInt(value);
        }
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        entityName = reader.readSizedString();
        action = reader.readByte();
        objectiveName = reader.readSizedString();
        if (action != 1) {
            value = reader.readVarInt();
        }
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getUpdateScorePacket().getId();
    }
}
