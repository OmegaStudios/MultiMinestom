package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class PlayerAbilitiesPacket implements ServerPacket {
    public static final byte FLAG_INVULNERABLE  = 0x01;
    public static final byte FLAG_FLYING        = 0x02;
    public static final byte FLAG_ALLOW_FLYING  = 0x04;
    public static final byte FLAG_INSTANT_BREAK = 0x08;

    private PacketAdapter packetAdapter;
    public byte flags;
    public float flyingSpeed;
    public float fieldViewModifier;

    public PlayerAbilitiesPacket(byte flags, float flyingSpeed, float fieldViewModifier) {
        this.flags = flags;
        this.flyingSpeed = flyingSpeed;
        this.fieldViewModifier = fieldViewModifier;
    }

    public PlayerAbilitiesPacket() {
        this((byte) 0, 0f, 0f);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getPlayerAbilitiesPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.flags = reader.readByte();
        this.flyingSpeed = reader.readFloat();
        this.fieldViewModifier = reader.readFloat();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getPlayerAbilitiesPacket().getId();
    }
}
