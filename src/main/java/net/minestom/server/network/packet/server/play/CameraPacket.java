package net.minestom.server.network.packet.server.play;

import net.minestom.server.entity.Entity;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class CameraPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int cameraId;

    public CameraPacket(int cameraId) {
        this.cameraId = cameraId;
    }

    public CameraPacket(@NotNull Entity camera) {
        this(camera.getEntityId());
    }

    public CameraPacket() {
        this(0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(cameraId);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        cameraId = reader.readVarInt();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getCameraPacket().getId();
    }
}
