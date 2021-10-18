package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.AdvancementsPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17AdvancementsPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        AdvancementsPacket packet_ = (AdvancementsPacket) packet;
        writer.writeBoolean(packet_.resetAdvancements);

        writer.writeVarInt(packet_.advancementMappings.length);
        for (AdvancementsPacket.AdvancementMapping advancementMapping : packet_.advancementMappings) {
            advancementMapping.write(writer);
        }
        writer.writeStringArray(packet_.identifiersToRemove);

        writer.writeVarInt(packet_.progressMappings.length);
        for (AdvancementsPacket.ProgressMapping progressMapping : packet_.progressMappings) {
            progressMapping.write(writer);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ADVANCEMENTS;
    }

}