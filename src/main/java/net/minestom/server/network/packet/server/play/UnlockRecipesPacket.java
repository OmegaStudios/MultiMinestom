package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class UnlockRecipesPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int mode;

    public boolean craftingRecipeBookOpen;
    public boolean craftingRecipeBookFilterActive;
    public boolean smeltingRecipeBookOpen;
    public boolean smeltingRecipeBookFilterActive;

    public String[] recipesId;

    // Only if mode = 0
    public String[] initRecipesId;

    /**
     * Default constructor, required for reflection operations.
     */
    public UnlockRecipesPacket() {
        recipesId = new String[0];
        initRecipesId = new String[0];
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getUnlockRecipesPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        mode = reader.readVarInt();

        craftingRecipeBookOpen = reader.readBoolean();
        craftingRecipeBookFilterActive = reader.readBoolean();
        smeltingRecipeBookOpen = reader.readBoolean();
        smeltingRecipeBookFilterActive = reader.readBoolean();

        int length = reader.readVarInt();
        recipesId = new String[length];
        for (int i = 0; i < length; i++) {
            recipesId[i] = reader.readSizedString();
        }

        if (mode == 0) {
            int initRecipesLength = reader.readVarInt();
            initRecipesId = new String[initRecipesLength];
            for (int i = 0; i < length; i++) {
                initRecipesId[i] = reader.readSizedString();
            }
        }
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getUnlockRecipesPacket().getId();
    }
}
