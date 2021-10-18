package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.DeclareRecipesPacket;
import net.minestom.server.utils.binary.BinaryWriter;
import net.minestom.server.utils.validate.Check;

public class V1_17DeclareRecipesPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        DeclareRecipesPacket packet_ = (DeclareRecipesPacket) packet;
        Check.notNull(packet_.recipes, "Recipes cannot be null!");

        writer.writeVarInt(packet_.recipes.length);
        for (DeclareRecipesPacket.DeclaredRecipe recipe : packet_.recipes) {
            recipe.write(writer);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.DECLARE_RECIPES;
    }

}