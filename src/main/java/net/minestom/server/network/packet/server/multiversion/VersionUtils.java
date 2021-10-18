package net.minestom.server.network.packet.server.multiversion;

import net.minestom.server.network.packet.server.multiversion.v1_17.V1_17PacketAdapter;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8PacketAdapter;
import net.minestom.server.network.player.PlayerSocketConnection;

import java.util.Arrays;
import java.util.List;

public class VersionUtils {

    public static final V1_8PacketAdapter V1_8_PACKET_ADAPTER = new V1_8PacketAdapter();
    public static final V1_17PacketAdapter V1_17_PACKET_ADAPTER = new V1_17PacketAdapter();

    private static final int V1_8 = 47;
    private static final int V1_9 = 107;
    private static final int V1_9_1 = 108;
    private static final int V1_9_2 = 109;
    private static final int V1_9_3 = 110;
    private static final int V1_9_4 = 110;
    private static final int V1_10 = 210;
    private static final int V1_11 = 315;
    private static final int V1_11_1 = 316;
    private static final int V1_11_2 = 316;
    private static final int V1_12 = 335;
    private static final int V1_12_1 = 338;
    private static final int V1_12_2 = 340;
    private static final int V1_13 = 393;
    private static final int V1_13_1 = 401;
    private static final int V1_13_2 = 404;
    private static final int V1_14 = 477;
    private static final int V1_14_1 = 480;
    private static final int V1_14_2 = 485;
    private static final int V1_14_3 = 490;
    private static final int V1_14_4 = 498;
    private static final int V1_15 = 573;
    private static final int V1_15_1 = 575;
    private static final int V1_15_2 = 578;
    private static final int V1_16 = 735;
    private static final int V1_16_1 = 736;
    private static final int V1_16_2 = 751;
    private static final int V1_16_3 = 753;
    private static final int V1_16_4 = 754;
    private static final int V1_16_5 = 754;
    private static final int V1_17 = 755;
    private static final int V1_17_1 = 756;

    public static final List<Integer> SUPPORTED_VERSIONS = Arrays.asList(V1_8, V1_17, V1_17_1);

    public static boolean isVersionSupported(int protocolVersion) {
        return SUPPORTED_VERSIONS.contains(protocolVersion);
    }

    public static void setPacketAdapter(PlayerSocketConnection connection) {

        switch (connection.getProtocolVersion()) {

            case V1_8:
                connection.setPacketAdapter(V1_8_PACKET_ADAPTER);
                break;
            case V1_17:
            case V1_17_1:
            default:
                connection.setPacketAdapter(V1_17_PACKET_ADAPTER);
                break;

        }

    }

}
