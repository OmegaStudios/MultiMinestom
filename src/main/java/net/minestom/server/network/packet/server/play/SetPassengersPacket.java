package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class SetPassengersPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int vehicleEntityId;
    public int[] passengersId;

    public SetPassengersPacket() {
        passengersId = new int[0];
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getSetPassengersPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        vehicleEntityId = reader.readVarInt();
        passengersId = reader.readVarIntArray();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getSetPassengersPacket().getId();
    }
}
