package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.minestom.server.adventure.AdventurePacketConvertor;
import net.minestom.server.network.packet.server.ComponentHoldingServerPacket;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import java.util.function.UnaryOperator;

public class V1_17BossBarPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {

    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.BOSS_BAR;
    }

}