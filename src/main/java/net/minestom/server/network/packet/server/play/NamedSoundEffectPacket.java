package net.minestom.server.network.packet.server.play;

import net.kyori.adventure.sound.Sound.Source;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class NamedSoundEffectPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public String soundName;
    public Source soundSource;
    public int x, y, z;
    public float volume;
    public float pitch;

    public NamedSoundEffectPacket() {
        soundName = "";
        soundSource = Source.AMBIENT;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getNamedSoundEffectPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        soundName = reader.readSizedString();
        soundSource = Source.values()[reader.readVarInt()];
        x = reader.readInt() / 8;
        y = reader.readInt() / 8;
        z = reader.readInt() / 8;
        volume = reader.readFloat();
        pitch = reader.readFloat();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getNamedSoundEffectPacket().getId();
    }
}
