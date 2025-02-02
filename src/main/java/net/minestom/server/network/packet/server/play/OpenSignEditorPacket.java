package net.minestom.server.network.packet.server.play;

import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class OpenSignEditorPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    /**
     * WARNING: There must be a sign in this location (you can send a BlockChangePacket beforehand)
     */
    public Point signPosition;

    public OpenSignEditorPacket() {
        signPosition = Vec.ZERO;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getOpenSignEditorPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.signPosition = reader.readBlockPosition();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getOpenSignEditorPacket().getId();
    }
}
