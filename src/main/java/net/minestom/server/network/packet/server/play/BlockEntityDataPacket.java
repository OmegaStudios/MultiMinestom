package net.minestom.server.network.packet.server.play;

import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;
import org.jglrxavpok.hephaistos.nbt.NBT;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;
import org.jglrxavpok.hephaistos.nbt.NBTException;

import java.io.IOException;

public class BlockEntityDataPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public Point blockPosition;
    public byte action;
    public NBTCompound nbtCompound;

    public BlockEntityDataPacket() {
        blockPosition = Vec.ZERO;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getBlockEntityDataPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        blockPosition = reader.readBlockPosition();
        action = reader.readByte();
        try {
            NBT tag = reader.readTag();
            if (tag instanceof NBTCompound) {
                nbtCompound = (NBTCompound) tag;
            }
        } catch (IOException | NBTException e) {
            MinecraftServer.getExceptionManager().handleException(e);
        }
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getBlockEntityDataPacket().getId();
    }
}
