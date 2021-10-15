package net.minestom.server.network.packet.server.multiversion;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public interface VersionedPacket {

    void writePacket(BinaryWriter writer, ServerPacket packet);
    int getId();

}
