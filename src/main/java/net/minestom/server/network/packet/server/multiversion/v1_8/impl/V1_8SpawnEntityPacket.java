package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SpawnEntityPacket;
import net.minestom.server.network.packet.server.play.SpawnPlayerPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8SpawnEntityPacket implements VersionedPacket {


    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Spawn_Object
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SpawnEntityPacket packet_ = (SpawnEntityPacket) packet;

        int translatedEntityID = translateEntityTypeID(packet_.type);

        writer.writeVarInt(packet_.entityId); //Entity ID
        writer.writeByte((byte) translatedEntityID); //Entity object type

        writer.writeInt((int) (packet_.position.x() * 32.0D)); //X; Using fixed-point numbers (double respresented by an integer)
        writer.writeInt((int) (packet_.position.y() * 32.0D)); //Y; https://wiki.vg/Data_types#Fixed-point_numbers
        writer.writeInt((int) (packet_.position.z() * 32.0D)); //Z
        writer.writeByte((byte) (packet_.position.pitch() * 256 / 360)); //Yaw
        writer.writeByte((byte) (packet_.position.yaw() * 256 / 360)); //Pitch

        //TODO use the link below to specify data for minecarts, falling blocks, item frames and so on
        writer.writeInt(0); //Data; Set to 0 for now to ignore velocity shorts; https://wiki.vg/index.php?title=Object_Data&oldid=7248

        //Not needed for now if data is set to 0
        //writer.writeShort(packet_.velocityX);
        //writer.writeShort(packet_.velocityY);
        //writer.writeShort(packet_.velocityZ);
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.SPAWN_ENTITY;
    }

    //TODO There are no entity IDs for players, lightning bolts and fishing hooks
    //1.8: https://wiki.vg/index.php?title=Entity_metadata&oldid=7415#Mobs <-- unreliable source, shows different IDs
    //1.8: https://pokechu22.github.io/Burger/1.8.html#entities
    //1.8: https://minecraft.fandom.com/wiki/Java_Edition_data_values/Pre-flattening/Entity_IDs
    //1.8: https://mcreator.net/wiki/entity-ids
    //1.17: https://wiki.vg/Entity_metadata#Mobs
    //1.17: https://pokechu22.github.io/Burger/1.17.1.html#entities
    public static int translateEntityTypeID(int modernID){

        switch (modernID) {
            case 1: return 30; // Armor Stand
            case 2: return 10; // Arrow
            case 4: return 65; // Bat
            case 6: return 61; // Blaze
            case 7: return 41; // Boat
            case 8:
            case 59: return 98; // Ocelot/Cat
            case 9: return 59; // Cave Spider
            case 10: return 93; // Chicken
            case 12: return 92; // Cow
            case 13: return 50; // Creeper
            case 20: return 63; // Ender Dragon
            case 21: return 58; // Enderman
            case 25: return 2; // XP Orb
            case 26: return 15; // Eye of Ender
            case 27: return 21; // FallingSand
            case 28: return 22; // Firework
            case 30: return 56; // Ghast
            case 31: return 53; // Giant
            case 37:
            case 57:
            case 15: return 100; // Horse. Donkey and mule also uses the horse entity
            case 40: return 99; // Iron Golem
            case 41: return 1; // ItemStack
            case 42: return 18; // Item Frame
            case 43: return 12; // Fireball
            case 44: return 8; // Leash knot
            case 48: return 62; // Magma Cube
            case 50: return 10; // Minecart
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56: return 10; // Minecart. All types of minecart uses entity ID 10.
            case 58: return 96; // Mooshroom Cow
            case 60: return 9; // Painting
            case 64: return 90; // Pig
            case 65:
            case 66: return 57; // Piglin and Piglin Brute goes into zombie villager
            case 69: return 50; // Primed TNT
            case 71: return 101; // Rabbit
            case 74: return 91; // Sheep
            case 75: return 69; // Shulker
            case 76: return 67; // Shulker Projectile
            case 77: return 60; // Silverfish
            case 78: return 51; // Skeleton
            case 80: return 55; // Slime
            case 81: return 13; // Small fireball
            case 82: return 97; // Snowman
            case 83: return 61; // Snowball
            case 84: return 24; // Spectral Arrow
            case 85: return 52; // Spider
            case 86: return 94; // Squid
            case 89: return 7; //Thrown Egg
            case 90: return 14; // Thrown Ender Pearl
            case 91: return 17; // Thrown XP Bottle
            case 92: return 16; // Thrown Potion
            case 98: return 120; // Villager
            case 101: return 66; // Witch
            case 102: return 64; // Wither
            case 103: return 5; // Wither Skeleton
            case 104: return 19; // Wither Skull
            case 105: return 95; // Wolf
            case 107: return 54; // Zombie
            case 109: return 27; // Zombie Villager


            default: return -1; // 1.17 entity that doesnt exist in 1.8 //TODO unsafe; check what happens if 1.8 client receives type id -1
        }

    }

}