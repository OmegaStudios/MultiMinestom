package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.ChatMessagePacket;
import net.minestom.server.utils.binary.BinaryWriter;

/**
 * Represents an outgoing chat message packet.
 */
public class V1_8ChatMessagePacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Chat_Message
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        ChatMessagePacket packet_ = (ChatMessagePacket) packet;
        writer.writeComponent(packet_.message); //Chat message (json) //TODO limit to 32767 bytes
        writer.writeByte((byte) packet_.position.ordinal()); //Position
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.CHAT_MESSAGE;
    }

}