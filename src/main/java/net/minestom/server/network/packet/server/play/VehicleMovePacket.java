package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class VehicleMovePacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public double x, y, z;
    public float yaw, pitch;

    /**
     * Default constructor, required for reflection operations.
     */
    public VehicleMovePacket() {}

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getVehicleMovePacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        x = reader.readDouble();
        y = reader.readDouble();
        z = reader.readDouble();
        yaw = reader.readFloat();
        pitch = reader.readFloat();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getVehicleMovePacket().getId();
    }
}
