package net.minestom.server.network.packet.server.play;

import net.minestom.server.MinecraftServer;
import net.minestom.server.gamedata.tags.Tag;
import net.minestom.server.network.packet.FramedPacket;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.utils.PacketUtils;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagsPacket implements ServerPacket {

    public static FramedPacket GET_DEFAULT_TAGS(PacketAdapter adapter) {
        return PacketUtils.allocateTrimmedPacket(new TagsPacket(MinecraftServer.getTagManager().getTagMap()), adapter);
    }

    private PacketAdapter packetAdapter;
    public Map<Tag.BasicType, List<Tag>> tagsMap;

    public TagsPacket(Map<Tag.BasicType, List<Tag>> tagsMap) {
        this.tagsMap = tagsMap;
    }

    public TagsPacket() {
        this(new HashMap<>());
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        this.packetAdapter.getTagsPacket().writePacket(writer, this);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.tagsMap = new HashMap<>();
        // Read amount of tag types
        final int typeCount = reader.readVarInt();
        for (int i = 0; i < typeCount; i++) {
            // Read tag type
            final Tag.BasicType tagType = Tag.BasicType.fromIdentifer(reader.readSizedString());
            if (tagType == null) {
                throw new IllegalArgumentException("Tag type could not be resolved");
            }

            final int tagCount = reader.readVarInt();
            for (int j = 0; j < tagCount; j++) {
                final String tagName = reader.readSizedString();
                final int[] entries = reader.readVarIntArray();
                // TODO convert
            }
        }
    }

    @Override
    public void setPacketAdapter(PacketAdapter packetAdapter) {
        this.packetAdapter = packetAdapter;
    }

    @Override
    public int getId() {
        return this.packetAdapter.getTagsPacket().getId();
    }
}
