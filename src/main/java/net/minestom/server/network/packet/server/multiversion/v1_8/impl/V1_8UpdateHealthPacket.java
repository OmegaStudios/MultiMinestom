package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.UpdateHealthPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8UpdateHealthPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Update_Health
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        UpdateHealthPacket packet_ = (UpdateHealthPacket) packet;
        writer.writeFloat(packet_.health); //Health
        writer.writeVarInt(packet_.food); //Food
        writer.writeFloat(packet_.foodSaturation); //Saturation
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.UPDATE_HEALTH;
    }

}