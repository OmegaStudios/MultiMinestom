package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.adventure.AdventurePacketConvertor;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.BossBarPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17BossBarPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        BossBarPacket packet_ = (BossBarPacket) packet;
        writer.writeUuid(packet_.uuid);
        writer.writeVarInt(packet_.action.ordinal());

        switch (packet_.action) {
            case ADD:
                writer.writeComponent(packet_.title);
                writer.writeFloat(packet_.health);
                writer.writeVarInt(AdventurePacketConvertor.getBossBarColorValue(packet_.color));
                writer.writeVarInt(AdventurePacketConvertor.getBossBarOverlayValue(packet_.overlay));
                writer.writeByte(packet_.flags);
                break;
            case REMOVE:

                break;
            case UPDATE_HEALTH:
                writer.writeFloat(packet_.health);
                break;
            case UPDATE_TITLE:
                writer.writeComponent(packet_.title);
                break;
            case UPDATE_STYLE:
                writer.writeVarInt(AdventurePacketConvertor.getBossBarColorValue(packet_.color));
                writer.writeVarInt(AdventurePacketConvertor.getBossBarOverlayValue(packet_.overlay));
                break;
            case UPDATE_FLAGS:
                writer.writeByte(packet_.flags);
                break;
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.BOSS_BAR;
    }

}