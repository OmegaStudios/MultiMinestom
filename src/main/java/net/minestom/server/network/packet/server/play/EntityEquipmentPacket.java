package net.minestom.server.network.packet.server.play;

import net.minestom.server.entity.EquipmentSlot;
import net.minestom.server.item.ItemStack;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class EntityEquipmentPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public EquipmentSlot[] slots;
    public ItemStack[] itemStacks;

    public EntityEquipmentPacket() {
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getEntityEquipmentPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        entityId = reader.readVarInt();

        boolean hasRemaining = true;
        List<EquipmentSlot> slots = new LinkedList<>();
        List<ItemStack> stacks = new LinkedList<>();
        while (hasRemaining) {
            byte slotEnum = reader.readByte();
            hasRemaining = (slotEnum & 0x80) == 0x80;

            slots.add(EquipmentSlot.values()[slotEnum & 0x7F]);
            stacks.add(reader.readItemStack());
        }

        this.slots = slots.toArray(new EquipmentSlot[0]);
        this.itemStacks = stacks.toArray(new ItemStack[0]);
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getEntityEquipmentPacket().getId();
    }

}
