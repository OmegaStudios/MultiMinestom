package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityPropertiesPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EntityPropertiesPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityPropertiesPacket packet_ = (EntityPropertiesPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeVarInt(packet_.properties.length);
        for (EntityPropertiesPacket.Property property : packet_.properties) {
            property.write(writer);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ENTITY_PROPERTIES;
    }

}