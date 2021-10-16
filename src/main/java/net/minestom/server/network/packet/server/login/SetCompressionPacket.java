package net.minestom.server.network.packet.server.login;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class SetCompressionPacket implements ServerPacket {

    public int threshold;

    /**
     * DO NOT USE
     */
    private SetCompressionPacket() {
        threshold = 256;
    }

    public SetCompressionPacket(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(threshold);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        threshold = reader.readVarInt();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        //TODO not sure if needed yet
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.LOGIN_SET_COMPRESSION;
    }
}
