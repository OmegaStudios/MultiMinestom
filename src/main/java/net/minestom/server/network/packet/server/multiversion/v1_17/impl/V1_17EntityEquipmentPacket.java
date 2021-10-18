package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.entity.EquipmentSlot;
import net.minestom.server.item.ItemStack;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityEquipmentPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EntityEquipmentPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityEquipmentPacket packet_ = (EntityEquipmentPacket) packet;
        writer.writeVarInt(packet_.entityId);

        if (packet_.slots == null || packet_.itemStacks == null) {
            throw new IllegalArgumentException("You need to specify at least one slot and one item");
        }

        if (packet_.slots.length != packet_.itemStacks.length) {
            throw new IllegalArgumentException("You need the same amount of slots and items");
        }

        for (int i = 0; i < packet_.slots.length; i++) {
            final EquipmentSlot slot = packet_.slots[i];
            final ItemStack itemStack = packet_.itemStacks[i];
            final boolean last = i == packet_.slots.length - 1;

            byte slotEnum = (byte) slot.ordinal();
            if (!last) {
                slotEnum |= 0x80;
            }

            writer.writeByte(slotEnum);
            writer.writeItemStack(itemStack);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ENTITY_EQUIPMENT;
    }

}