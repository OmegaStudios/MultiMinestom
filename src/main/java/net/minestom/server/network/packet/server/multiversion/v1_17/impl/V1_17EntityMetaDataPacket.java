package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.entity.Metadata;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityMetaDataPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17EntityMetaDataPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityMetaDataPacket packet_ = (EntityMetaDataPacket) packet;
        writer.writeVarInt(packet_.entityId);

        if (packet_.entries != null) {
            // Write all the fields
            for (Metadata.Entry<?> entry : packet_.entries) {
                entry.write(writer);
            }
        }

        writer.writeByte((byte) 0xFF); // End
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.ENTITY_METADATA;
    }

}