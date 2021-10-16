package net.minestom.server.network.packet.server.play;

import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class OpenBookPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public Player.Hand hand;

    public OpenBookPacket(Player.Hand hand) {
        this.hand = hand;
    }

    public OpenBookPacket() {
        this(Player.Hand.MAIN);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(hand.ordinal());
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        hand = Player.Hand.values()[reader.readVarInt()];
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getOpenBookPacket().getId();
    }
}
