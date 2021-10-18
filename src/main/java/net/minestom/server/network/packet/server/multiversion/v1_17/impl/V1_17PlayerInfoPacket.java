package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.PlayerInfoPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17PlayerInfoPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        PlayerInfoPacket packet_ = (PlayerInfoPacket) packet;
        writer.writeVarInt(packet_.action.ordinal());
        writer.writeVarInt(packet_.playerInfos.size());

        for (PlayerInfoPacket.PlayerInfo playerInfo : packet_.playerInfos) {
            if (!playerInfo.getClass().equals(packet_.action.getClazz())) continue;
            writer.writeUuid(playerInfo.uuid);
            playerInfo.write(writer);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.PLAYER_INFO;
    }

}