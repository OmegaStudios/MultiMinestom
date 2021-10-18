package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.TimeUpdatePacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8TimeUpdatePacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Time_Update
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        TimeUpdatePacket packet_ = (TimeUpdatePacket) packet;
        writer.writeLong(packet_.worldAge); //World Age
        writer.writeLong(packet_.timeOfDay); //Time of day
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.TIME_UPDATE;
    }

}