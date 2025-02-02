package net.minestom.server.network.packet.server.play;

import net.minestom.server.MinecraftServer;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;
import org.jglrxavpok.hephaistos.nbt.NBT;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;
import org.jglrxavpok.hephaistos.nbt.NBTEnd;
import org.jglrxavpok.hephaistos.nbt.NBTException;

import java.io.IOException;

public class NbtQueryResponsePacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int transactionId;
    public NBTCompound nbtCompound;

    public NbtQueryResponsePacket() {}

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getNbtQueryResponsePacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        transactionId = reader.readVarInt();
        try {
            NBT nbt = reader.readTag();

            if (nbt instanceof NBTEnd) {
                return;
            }

            nbtCompound = (NBTCompound) nbt;
        } catch (IOException | NBTException e) {
            MinecraftServer.getExceptionManager().handleException(e);
            // TODO: should we throw? the packet is not valid
        }
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getNbtQueryResponsePacket().getId();
    }
}
