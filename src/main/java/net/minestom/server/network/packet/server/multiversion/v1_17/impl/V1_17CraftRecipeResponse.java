package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.CraftRecipeResponse;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17CraftRecipeResponse implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        CraftRecipeResponse packet_ = (CraftRecipeResponse) packet;
        writer.writeByte(packet_.windowId);
        writer.writeSizedString(packet_.recipe);
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.CRAFT_RECIPE_RESPONSE;
    }

}