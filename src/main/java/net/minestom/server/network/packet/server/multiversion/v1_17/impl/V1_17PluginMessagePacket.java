package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.PluginMessagePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17PluginMessagePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        PluginMessagePacket packet_ = (PluginMessagePacket) packet;
        writer.writeSizedString(packet_.channel);
        writer.writeBytes(packet_.data);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.PLUGIN_MESSAGE;
    }

}