package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.UpdateScorePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17UpdateScorePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        UpdateScorePacket packet_ = (UpdateScorePacket) packet;
        writer.writeSizedString(packet_.entityName);
        writer.writeByte(packet_.action);
        writer.writeSizedString(packet_.objectiveName);
        if (packet_.action != 1) {
            writer.writeVarInt(packet_.value);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.UPDATE_SCORE;
    }

}