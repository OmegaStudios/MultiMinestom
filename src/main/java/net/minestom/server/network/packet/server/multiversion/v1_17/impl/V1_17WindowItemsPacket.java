package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.item.ItemStack;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.WindowItemsPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17WindowItemsPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        WindowItemsPacket packet_ = (WindowItemsPacket) packet;
        writer.writeByte(packet_.windowId);
        writer.writeVarInt(packet_.stateId);

        if (packet_.items == null) {
            writer.writeVarInt(0);
        } else {
            writer.writeVarInt(packet_.items.length);
            for (ItemStack item : packet_.items) {
                writer.writeItemStack(item);
            }
        }
        writer.writeItemStack(packet_.carriedItem);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.WINDOW_ITEMS;
    }

}