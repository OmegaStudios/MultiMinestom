package net.minestom.server.network.packet.server.play;

import net.kyori.adventure.sound.Sound;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class EntitySoundEffectPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int soundId;
    public Sound.Source soundSource;
    public int entityId;
    public float volume;
    public float pitch;

    public EntitySoundEffectPacket() {
        soundSource = Sound.Source.NEUTRAL;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getEntitySoundEffectPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        soundId = reader.readVarInt();
        soundSource = Sound.Source.values()[reader.readVarInt()];
        entityId = reader.readVarInt();
        volume = reader.readFloat();
        pitch = reader.readFloat();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getEntitySoundEffectPacket().getId();
    }
}
