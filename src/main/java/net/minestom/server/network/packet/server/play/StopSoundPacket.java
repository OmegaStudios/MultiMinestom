package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class StopSoundPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public byte flags;
    public int source;
    public String sound;

    public StopSoundPacket() {
        sound = "";
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getStopSoundPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        flags = reader.readByte();
        if (flags == 3 || flags == 1) {
            source = reader.readVarInt();
        }
        if (flags == 2 || flags == 3) {
            sound = reader.readSizedString();
        }
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getStopSoundPacket().getId();
    }
}
