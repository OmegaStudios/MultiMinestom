package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ExplosionPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public float x, y, z;
    public float radius; // UNUSED
    public byte[] records = new byte[0];
    public float playerMotionX, playerMotionY, playerMotionZ;

    public ExplosionPacket() {
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getExplosionPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        x = reader.readFloat();
        y = reader.readFloat();
        z = reader.readFloat();
        radius = reader.readFloat();
        int recordCount = reader.readVarInt() * 3;
        records = reader.readBytes(recordCount);
        playerMotionX = reader.readFloat();
        playerMotionY = reader.readFloat();
        playerMotionZ = reader.readFloat();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getExplosionPacket().getId();
    }
}
