package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.ChatMessagePacket;
import net.minestom.server.utils.binary.BinaryWriter;

/**
 * Represents an outgoing chat message packet.
 */
public class V1_17ChatMessagePacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        ChatMessagePacket packet_ = (ChatMessagePacket) packet;
        writer.writeComponent(packet_.message);
        writer.writeByte((byte) packet_.position.ordinal());
        writer.writeUuid(packet_.uuid);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.CHAT_MESSAGE;
    }

}