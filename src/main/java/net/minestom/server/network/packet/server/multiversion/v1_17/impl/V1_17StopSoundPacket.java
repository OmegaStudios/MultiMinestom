package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.StopSoundPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17StopSoundPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        StopSoundPacket packet_ = (StopSoundPacket) packet;
        writer.writeByte(packet_.flags);
        if (packet_.flags == 3 || packet_.flags == 1)
            writer.writeVarInt(packet_.source);
        if (packet_.flags == 2 || packet_.flags == 3)
            writer.writeSizedString(packet_.sound);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.STOP_SOUND;
    }

}