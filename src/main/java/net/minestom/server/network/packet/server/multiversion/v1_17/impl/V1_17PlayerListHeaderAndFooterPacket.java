package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.kyori.adventure.text.Component;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.PlayerListHeaderAndFooterPacket;
import net.minestom.server.utils.binary.BinaryWriter;

import java.util.Objects;

public class V1_17PlayerListHeaderAndFooterPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        PlayerListHeaderAndFooterPacket packet_ = (PlayerListHeaderAndFooterPacket) packet;
        writer.writeComponent(Objects.requireNonNullElseGet(packet_.header, Component::empty));
        writer.writeComponent(Objects.requireNonNullElseGet(packet_.footer, Component::empty));
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.PLAYER_LIST_HEADER_AND_FOOTER;
    }

}