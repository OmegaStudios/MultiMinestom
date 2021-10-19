package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.attribute.AttributeModifier;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17ServerPacketIdentifier;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityPropertiesPacket;
import net.minestom.server.utils.binary.BinaryWriter;

import java.util.Collection;

public class V1_8EntityPropertiesPacket implements VersionedPacket {

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Entity_Properties
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {
        EntityPropertiesPacket packet_ = (EntityPropertiesPacket) packet;
        writer.writeVarInt(packet_.entityId); //Entity ID
        writer.writeInt(packet_.properties.length); //Number of properties

        for (EntityPropertiesPacket.Property property : packet_.properties) {

            float maxValue = property.attribute.getMaxValue();

            // Bypass vanilla limit client-side if needed (by sending the max value allowed)
            final double v = property.value > maxValue ? maxValue : property.value;

            String translatedKey = this.translateKeys(property.attribute.getKey());

            if(translatedKey == null) {
                //TODO cancel packet send here
                return;
            }

            writer.writeSizedString(translatedKey);
            writer.writeDouble(v);

            Collection<AttributeModifier> modifiers = property.instance.getModifiers();
            writer.writeVarInt(modifiers.size());

            //TODO check later
            for (var modifier : modifiers) {
                writer.writeUuid(modifier.getId());
                writer.writeDouble(modifier.getAmount());
                writer.writeByte((byte) modifier.getOperation().getId());
            }

        }

    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.ENTITY_PROPERTIES;
    }

    public String translateKeys(String modernKey) {

        switch(modernKey) {
            case "generic.max_health":
                return "generic.maxHealth";
            case "generic.follow_range":
                return "generic.followRange";
            case "generic.knockback_resistance":
                return "generic.knockbackResistance";
            case "generic.movement_speed":
                return "generic.movementSpeed";
            case "generic.attack_damage":
                return "generic.attackDamage";
            case "horse.jump_strength":
                return "horse.jumpStrength";
            case "zombie.spawn_reinforcements":
                return "zombie.spawnReinforcements";
            default:
                return null;
        }

    }

}