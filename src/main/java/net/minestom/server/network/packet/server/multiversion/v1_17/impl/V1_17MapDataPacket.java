package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.MapDataPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_17MapDataPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        MapDataPacket packet_ = (MapDataPacket) packet;
        writer.writeVarInt(packet_.mapId);
        writer.writeByte(packet_.scale);
        writer.writeBoolean(packet_.locked);
        writer.writeBoolean(packet_.trackingPosition);

        if (packet_.trackingPosition) {
            if (packet_.icons != null && packet_.icons.length > 0) {
                writer.writeVarInt(packet_.icons.length);
                for (MapDataPacket.Icon icon : packet_.icons) {
                    icon.write(writer);
                }
            } else {
                writer.writeVarInt(0);
            }
        }

        writer.writeByte((byte) packet_.columns);
        if (packet_.columns <= 0) {
            return;
        }

        writer.writeByte((byte) packet_.rows);
        writer.writeByte(packet_.x);
        writer.writeByte(packet_.z);
        if (packet_.data != null && packet_.data.length > 0) {
            writer.writeVarInt(packet_.data.length);
            writer.writeBytes(packet_.data);
        } else {
            writer.writeVarInt(0);
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.MAP_DATA;
    }

}