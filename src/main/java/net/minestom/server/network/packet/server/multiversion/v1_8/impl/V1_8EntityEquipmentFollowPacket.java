package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.entity.EquipmentSlot;
import net.minestom.server.item.ItemStack;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class V1_8EntityEquipmentFollowPacket implements ServerPacket {

    public int entityId;
    public EquipmentSlot slot;
    public ItemStack itemStack;

    public V1_8EntityEquipmentFollowPacket(int entityId, EquipmentSlot slot, ItemStack itemStack) {
        this.entityId = entityId;
        this.slot = slot;
        this.itemStack = itemStack;
    }

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Entity_Equipment
    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeInt(entityId); //Entity ID
        writer.writeShort((byte) slot.ordinal()); //Slot
        writer.writeItemStack(itemStack); //Item
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) { }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.ENTITY_EQUIPMENT;
    }

}
