package net.minestom.server.network.packet.server.play;

import net.kyori.adventure.text.Component;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.resourcepack.ResourcePack;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ResourcePackSendPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public String url = "";
    public String hash = "0000000000000000000000000000000000000000"; // Size 40
    public boolean forced;
    public Component forcedMessage;

    public ResourcePackSendPacket() {
    }

    public ResourcePackSendPacket(@NotNull ResourcePack resourcePack) {
        this.url = resourcePack.getUrl();
        this.hash = resourcePack.getHash();
        this.forced = resourcePack.isForced();
        this.forcedMessage = resourcePack.getForcedMessage();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getResourcePackSendPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.url = reader.readSizedString();
        this.hash = reader.readSizedString();
        this.forced = reader.readBoolean();

        final boolean hasMessage = reader.readBoolean();
        if (hasMessage) {
            this.forcedMessage = reader.readComponent();
        } else {
            this.forcedMessage = null;
        }
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getResourcePackSendPacket().getId();
    }
}
