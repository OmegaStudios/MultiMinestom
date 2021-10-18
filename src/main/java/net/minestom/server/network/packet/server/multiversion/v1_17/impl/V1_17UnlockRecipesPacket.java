package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.UnlockRecipesPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17UnlockRecipesPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        UnlockRecipesPacket packet_ = (UnlockRecipesPacket) packet;
        writer.writeVarInt(packet_.mode);

        writer.writeBoolean(packet_.craftingRecipeBookOpen);
        writer.writeBoolean(packet_.craftingRecipeBookFilterActive);
        writer.writeBoolean(packet_.smeltingRecipeBookOpen);
        writer.writeBoolean(packet_.smeltingRecipeBookFilterActive);

        writer.writeVarInt(packet_.recipesId.length);
        for (String string : packet_.recipesId) {
            writer.writeSizedString(string);
        }

        if (packet_.mode == 0) {
            writer.writeVarInt(packet_.initRecipesId.length);
            for (String string : packet_.initRecipesId) {
                writer.writeSizedString(string);
            }
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.UNLOCK_RECIPES;
    }

}