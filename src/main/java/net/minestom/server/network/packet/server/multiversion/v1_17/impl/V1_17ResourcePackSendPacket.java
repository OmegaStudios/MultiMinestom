package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.ResourcePackSendPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17ResourcePackSendPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        ResourcePackSendPacket packet_ = (ResourcePackSendPacket) packet;
        writer.writeSizedString(packet_.url);
        writer.writeSizedString(packet_.hash);
        writer.writeBoolean(packet_.forced);
        if (packet_.forcedMessage != null) {
            writer.writeBoolean(true);
            writer.writeComponent(packet_.forcedMessage);
        } else {
            writer.writeBoolean(false);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.RESOURCE_PACK_SEND;
    }

}