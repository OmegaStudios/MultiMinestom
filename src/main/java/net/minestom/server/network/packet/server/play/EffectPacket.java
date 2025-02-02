package net.minestom.server.network.packet.server.play;

import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class EffectPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int effectId;
    public Point position;
    public int data;
    public boolean disableRelativeVolume;

    public EffectPacket(int effectId, Point position, int data, boolean disableRelativeVolume) {
        this.effectId = effectId;
        this.position = position;
        this.data = data;
        this.disableRelativeVolume = disableRelativeVolume;
    }

    public EffectPacket() {
        this(0, Vec.ZERO, 0, false);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getEffectPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.effectId = reader.readInt();
        this.position = reader.readBlockPosition();
        this.data = reader.readInt();
        this.disableRelativeVolume = reader.readBoolean();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getEffectPacket().getId();
    }
}
