package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import net.minestom.server.world.Difficulty;
import org.jetbrains.annotations.NotNull;

public class ServerDifficultyPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public Difficulty difficulty;
    public boolean locked;

    public ServerDifficultyPacket(Difficulty difficulty, boolean locked) {
        this.difficulty = difficulty;
        this.locked = locked;
    }

    public ServerDifficultyPacket() {
        this(Difficulty.NORMAL, false);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getServerDifficultyPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        difficulty = Difficulty.values()[reader.readByte()];
        locked = reader.readBoolean();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getServerDifficultyPacket().getId();
    }
}
