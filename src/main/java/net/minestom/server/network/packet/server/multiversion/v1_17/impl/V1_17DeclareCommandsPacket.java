package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.DeclareCommandsPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17DeclareCommandsPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        DeclareCommandsPacket packet_ = (DeclareCommandsPacket) packet;
        writer.writeVarInt(packet_.nodes.length);
        for (DeclareCommandsPacket.Node node : packet_.nodes) {
            node.write(writer);
        }
        writer.writeVarInt(packet_.rootIndex);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.DECLARE_COMMANDS;
    }

}