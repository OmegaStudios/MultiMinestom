package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class FacePlayerPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public FacePosition facePosition;
    public double targetX, targetY, targetZ;
    public int entityId;
    public FacePosition entityFacePosition;

    public FacePlayerPacket() {
        facePosition = FacePosition.EYES;
        entityFacePosition = FacePosition.EYES;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getFacePlayerPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        facePosition = FacePosition.values()[reader.readVarInt()];
        targetX = reader.readDouble();
        targetY = reader.readDouble();
        targetZ = reader.readDouble();

        boolean isEntity = reader.readBoolean();
        if(isEntity) {
            entityId = reader.readVarInt();
            entityFacePosition = FacePosition.values()[reader.readVarInt()];
        } else {
            entityId = 0;
        }
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getFacePlayerPacket().getId();
    }

    public enum FacePosition {
        FEET, EYES
    }

}
