package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.TradeListPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17TradeListPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        TradeListPacket packet_ = (TradeListPacket) packet;
        writer.writeVarInt(packet_.windowId);
        writer.writeByte((byte) packet_.trades.length);
        for (TradeListPacket.Trade trade : packet_.trades) {
            trade.write(writer);
        }
        writer.writeVarInt(packet_.villagerLevel);
        writer.writeVarInt(packet_.experience);
        writer.writeBoolean(packet_.regularVillager);
        writer.writeBoolean(packet_.canRestock);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.TRADE_LIST;
    }

}