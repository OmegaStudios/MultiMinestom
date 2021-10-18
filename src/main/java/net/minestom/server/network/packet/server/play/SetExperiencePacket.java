package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class SetExperiencePacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public float percentage;
    public int level;
    public int totalExperience;

    public SetExperiencePacket(float percentage, int level, int totalExperience) {
        this.percentage = percentage;
        this.level = level;
        this.totalExperience = totalExperience;
    }

    public SetExperiencePacket() {
        this(0, 0, 0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getSetExperiencePacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        percentage = reader.readFloat();
        level = reader.readVarInt();
        totalExperience = reader.readVarInt();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getSetExperiencePacket().getId();
    }
}
