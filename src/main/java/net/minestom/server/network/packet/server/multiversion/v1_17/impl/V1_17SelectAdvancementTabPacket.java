package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SelectAdvancementTabPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SelectAdvancementTabPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SelectAdvancementTabPacket packet_ = (SelectAdvancementTabPacket) packet;
        final boolean hasId = packet_.identifier != null;

        writer.writeBoolean(hasId);
        if (hasId) {
            writer.writeSizedString(packet_.identifier);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SELECT_ADVANCEMENT_TAB;
    }

}