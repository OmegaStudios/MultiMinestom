package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.TagsPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17TagsPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        TagsPacket packet_ = (TagsPacket) packet;
        writer.writeVarInt(packet_.tagsMap.size());
        for (var entry : packet_.tagsMap.entrySet()) {
            final var type = entry.getKey();
            final var tags = entry.getValue();
            writer.writeSizedString(type.getIdentifier());
            writer.writeVarInt(tags.size());
            for (var tag : tags) {
                writer.writeSizedString(tag.getName().asString());
                final var values = tag.getValues();
                writer.writeVarInt(values.size());
                for (var name : values) {
                    writer.writeVarInt(type.getFunction().apply(name.asString()));
                }
            }
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.TAGS;
    }

}