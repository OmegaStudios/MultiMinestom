package net.minestom.server.network.packet.server.play;

import net.minestom.server.attribute.Attribute;
import net.minestom.server.attribute.AttributeInstance;
import net.minestom.server.attribute.AttributeModifier;
import net.minestom.server.attribute.AttributeOperation;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import net.minestom.server.utils.binary.Readable;
import net.minestom.server.utils.binary.Writeable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class EntityPropertiesPacket implements ServerPacket {

    private PacketAdapter packetAdapter;
    public int entityId;
    public Property[] properties = new Property[0];

    public EntityPropertiesPacket() {
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getEntityPropertiesPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        entityId = reader.readVarInt();
        int propertyCount = reader.readVarInt();
        properties = new Property[propertyCount];
        for (int i = 0; i < propertyCount; i++) {
            properties[i] = new Property();
            properties[i].read(reader);
        }
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getEntityPropertiesPacket().getId();
    }

    public static class Property implements Writeable, Readable {

        public Attribute attribute;
        public double value;
        public AttributeInstance instance;

        public void write(BinaryWriter writer) {
            float maxValue = attribute.getMaxValue();

            // Bypass vanilla limit client-side if needed (by sending the max value allowed)
            final double v = value > maxValue ? maxValue : value;

            writer.writeSizedString(attribute.getKey());
            writer.writeDouble(v);

            {
                Collection<AttributeModifier> modifiers = instance.getModifiers();
                writer.writeVarInt(modifiers.size());

                for (var modifier : modifiers) {
                    writer.writeUuid(modifier.getId());
                    writer.writeDouble(modifier.getAmount());
                    writer.writeByte((byte) modifier.getOperation().getId());
                }
            }
        }

        @Override
        public void read(@NotNull BinaryReader reader) {
            String key = reader.readSizedString();
            attribute = Attribute.fromKey(key);

            value = reader.readDouble();

            int modifierCount = reader.readVarInt();
            instance = new AttributeInstance(attribute, null);
            for (int i = 0; i < modifierCount; i++) {
                AttributeModifier modifier = new AttributeModifier(reader.readUuid(), "", (float) reader.readDouble(), AttributeOperation.fromId(reader.readByte()));
                instance.addModifier(modifier);
            }
        }
    }

}
