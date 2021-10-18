package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SculkVibrationSignal;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17SculkVibrationSignal implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SculkVibrationSignal packet_ = (SculkVibrationSignal) packet;
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.SCULK_VIBRATION_SIGNAL;
    }

}