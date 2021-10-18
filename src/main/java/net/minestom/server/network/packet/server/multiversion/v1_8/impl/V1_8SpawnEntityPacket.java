package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.SpawnEntityPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8SpawnEntityPacket implements VersionedPacket {

    // https://wiki.vg/index.php?title=Protocol&oldid=7368#Spawn_Object
    // https://pokechu22.github.io/Burger/1.8.html
    // https://wiki.vg/Entity_metadata#Mobs

    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        SpawnEntityPacket packet_ = (SpawnEntityPacket) packet;
        writer.writeVarInt(packet_.entityId);
        writer.writeByte((byte) translateEntityTypeID(packet_.type));

        writer.writeDouble((int) (packet_.position.x() * 32.0D)); // Using fixed-point numbers (double respresented by an integer)
        writer.writeDouble((int) (packet_.position.y() * 32.0D)); // https://wiki.vg/Data_types#Fixed-point_numbers
        writer.writeDouble((int) (packet_.position.z() * 32.0D));
        writer.writeByte((byte) (packet_.position.pitch() * 256 / 360));
        writer.writeByte((byte) (packet_.position.yaw() * 256 / 360));

        //todo use the link below to specify data for minecarts, falling blocks, item frames and so on
        writer.writeInt(packet_.data); // https://wiki.vg/Object_Data

        writer.writeShort(packet_.velocityX);
        writer.writeShort(packet_.velocityY);
        writer.writeShort(packet_.velocityZ);
    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.SPAWN_ENTITY;
    }

    /*
        //todo finish and make sure the IDs are all 100% correct
     */
    public int translateEntityTypeID(int modernID){


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
            case 66: return 57; // Piglin, Piglin Brute goes into zombie villager
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

            default: return -1; // 1.17 entity that doesnt exist in 1.8
        }

    }

}