package net.minestom.server.network.packet.server.multiversion.v1_17.impl;

import net.minestom.server.adventure.AdventurePacketConvertor;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.TeamsPacket;
import net.minestom.server.utils.binary.BinaryWriter;

/**
 * The packet creates or updates teams
 */
public class V1_17TeamsPacket implements VersionedPacket {

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        TeamsPacket packet_ = (TeamsPacket) packet;
        writer.writeSizedString(packet_.teamName);
        writer.writeByte((byte) packet_.action.ordinal());

        switch (packet_.action) {
            case CREATE_TEAM:
            case UPDATE_TEAM_INFO:
                writer.writeComponent(packet_.teamDisplayName);
                writer.writeByte(packet_.friendlyFlags);
                writer.writeSizedString(packet_.nameTagVisibility.getIdentifier());
                writer.writeSizedString(packet_.collisionRule.getIdentifier());
                writer.writeVarInt(AdventurePacketConvertor.getNamedTextColorValue(packet_.teamColor));
                writer.writeComponent(packet_.teamPrefix);
                writer.writeComponent(packet_.teamSuffix);
                break;
            case REMOVE_TEAM:

                break;
        }

        if (packet_.action == TeamsPacket.Action.CREATE_TEAM || packet_.action == TeamsPacket.Action.ADD_PLAYERS_TEAM || packet_.action == TeamsPacket.Action.REMOVE_PLAYERS_TEAM) {
            if (packet_.entities == null || packet_.entities.length == 0) {
                writer.writeVarInt(0); // Empty
            } else {
                writer.writeStringArray(packet_.entities);
            }
        }
    }

    @Override
    public int getId() {
        return V1_17ServerPacketIdentifier.TEAMS;
    }

}