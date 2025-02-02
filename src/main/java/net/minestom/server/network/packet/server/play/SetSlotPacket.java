package net.minestom.server.network.packet.server.play;

import net.minestom.server.item.ItemStack;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class SetSlotPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public byte windowId;
    public int stateId;
    public short slot;
    public ItemStack itemStack;

    public SetSlotPacket(byte windowId, int stateId, short slot, ItemStack itemStack) {
        this.windowId = windowId;
        this.stateId = stateId;
        this.slot = slot;
        this.itemStack = itemStack;
    }

    public SetSlotPacket() {
        this((byte) 0, 0, (short) 0, ItemStack.AIR);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getSetSlotPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        windowId = reader.readByte();
        stateId = reader.readVarInt();
        slot = reader.readShort();
        itemStack = reader.readItemStack();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getSetSlotPacket().getId();
    }

    /**
     * Returns a {@link SetSlotPacket} used to change a player cursor item.
     *
     * @param cursorItem the cursor item
     * @return a set slot packet to change a player cursor item
     */
    public static @NotNull SetSlotPacket createCursorPacket(@NotNull ItemStack cursorItem) {
        return new SetSlotPacket((byte) -1, 0, (short) -1, cursorItem);
    }
}
