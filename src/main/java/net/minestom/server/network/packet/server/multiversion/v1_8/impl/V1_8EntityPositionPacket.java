package net.minestom.server.network.packet.server.multiversion.v1_8.impl;

import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.V1_8ServerPacketIdentifier;
import net.minestom.server.network.packet.server.play.EntityPositionPacket;
import net.minestom.server.utils.binary.BinaryWriter;

public class V1_8EntityPositionPacket implements VersionedPacket {

    private static final float SHORT_MAX = (float) Short.MAX_VALUE/2;
    private static final float SHORT_MIN = (float) Short.MIN_VALUE/2;
    private static final float BYTE_MAX = Byte.MAX_VALUE;
    private static final float BYTE_MIN = Byte.MIN_VALUE;

    //https://wiki.vg/index.php?title=Protocol&oldid=7368#Entity_Relative_Move
    @Override
    public void writePacket(BinaryWriter writer, ServerPacket packet) {

        EntityPositionPacket packet_ = (EntityPositionPacket) packet;

        writer.writeVarInt(packet_.entityId); //Entity ID

        //check if movement was greater than 4 blocks
        if(packet_.deltaX > SHORT_MAX || packet_.deltaX < SHORT_MIN
            || packet_.deltaY > SHORT_MAX || packet_.deltaY < SHORT_MIN
            || packet_.deltaZ > SHORT_MAX || packet_.deltaZ < SHORT_MIN) {

            //set deltas to 0
            writer.writeByte((byte) 0);
            writer.writeByte((byte) 0);
            writer.writeByte((byte) 0);

            //TODO calculate the entities new position based on the deltas & find a way to send a EntityTeleportPacket here

        } else {

            writer.writeByte(this.remapDelta(packet_.deltaX)); //Delta X
            writer.writeByte(this.remapDelta(packet_.deltaY)); //Delta Y
            writer.writeByte(this.remapDelta(packet_.deltaZ)); //Delta Z

        }

        writer.writeBoolean(packet_.onGround); //On Ground

    }

    @Override
    public int getId() {
        return V1_8ServerPacketIdentifier.ENTITY_POSITION;
    }

    private byte remapDelta(float value) {
        return (byte) (BYTE_MIN + (BYTE_MAX - BYTE_MIN) * ((value - SHORT_MIN) / (SHORT_MAX - SHORT_MIN)));
    }

}