package net.minestom.server.network.packet.server.play;

import net.minestom.server.item.ItemStack;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class WindowItemsPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public byte windowId;
    public int stateId;
    public ItemStack[] items;
    public ItemStack carriedItem;

    public WindowItemsPacket(byte windowId, int stateId, ItemStack[] items, ItemStack carriedItem) {
        this.windowId = windowId;
        this.stateId = stateId;
        this.items = items;
        this.carriedItem = carriedItem;
    }

    public WindowItemsPacket() {
        this((byte) 0, 0, new ItemStack[]{}, ItemStack.AIR);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getWindowItemsPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        windowId = reader.readByte();
        stateId = reader.readVarInt();

        final int length = reader.readVarInt();
        items = new ItemStack[length];
        for (int i = 0; i < length; i++) {
            items[i] = reader.readItemStack();
        }
        carriedItem = reader.readItemStack();
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getWindowItemsPacket().getId();
    }
}
