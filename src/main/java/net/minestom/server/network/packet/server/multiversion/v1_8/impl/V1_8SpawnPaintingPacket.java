package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SpawnPaintingPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8SpawnPaintingPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Spawn_Painting
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SpawnPaintingPacket packet_ = (SpawnPaintingPacket) packet;
        writer.writeVarInt(packet_.entityId); //Entity ID
        writer.writeSizedString(this.translateMotive(packet_.motive)); //Title of painting (max. length = 13)
        writer.writeBlockPosition(packet_.position); //Position (Center coordinates)
        writer.writeByte(this.translateDirection(packet_.direction)); //Direction (0 = north, 1 = west, 2 = south, 3 = east)
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.SPAWN_PAINTING;
    }

    //Translates the new motive id to the old 1.8 String
    //https://github.com/Attano/Spigot-1.8/blob/master/net/minecraft/server/v1_8_R3/EntityPainting.java#L93
    private String translateMotive(int modernMotive) {

        switch (modernMotive) {

            default:
            case 0: return "Kebab";
            case 1: return "Aztec";
            case 2: return "Alban";
            case 3: return "Aztec2";
            case 4: return "Bomb";
            case 5: return "Plant";
            case 6: return "Wasteland";
            case 7: return "Pool";
            case 8: return "Courbet";
            case 9: return "Sea";
            case 10: return "Sunset";
            case 11: return "Creebet";
            case 12: return "Wanderer";
            case 13: return "Graham";
            case 14: return "Match";
            case 15: return "Bust";
            case 16: return "Stage";
            case 17: return "Void";
            case 18: return "SkullAndRoses";
            case 19: return "Wither";
            case 20: return "Fighters";
            case 21: return "Pointer";
            case 22: return "Pigscene";
            case 23: return "BurningSkull";
            case 24: return "Skeleton";
            case 25: return "DonkeyKong";

        }

    }

    //Translates the new direction byte to the old 1.8 direction byte
    private byte translateDirection(byte modernDirection) {

        switch (modernDirection) {

            default:
            case (byte) 0:
                return (byte) 2; //South
            case (byte) 1:
                return (byte) 1; //West
            case (byte) 2:
                return (byte) 0; //North
            case (byte) 3:
                return (byte) 3; //East

        }

    }

}