package net.minestom.server.network.packet.server.multiversion.v1_8;

import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_8.impl.*;

public class V1_8PacketAdapter implements PacketAdapter {

    private static final V1_8ChatMessagePacket CHAT_MESSAGE_PACKET = new V1_8ChatMessagePacket();
    private static final V1_8CollectItemPacket COLLECT_ITEM_PACKET = new V1_8CollectItemPacket();
    private static final V1_8EntityAnimationPacket ENTITY_ANIMATION_PACKET = new V1_8EntityAnimationPacket();
    private static final V1_8EntityEquipmentPacket ENTITY_EQUIPMENT_PACKET = new V1_8EntityEquipmentPacket();
    private static final V1_8HeldItemChangePacket HELD_ITEM_CHANGE_PACKET = new V1_8HeldItemChangePacket();
    private static final V1_8JoinGamePacket JOIN_GAME_PACKET = new V1_8JoinGamePacket();
    private static final V1_8KeepAlivePacket KEEP_ALIVE_PACKET = new V1_8KeepAlivePacket();
    private static final V1_8PlayerPositionAndLookPacket PLAYER_POSITION_AND_LOOK_PACKET = new V1_8PlayerPositionAndLookPacket();
    private static final V1_8RespawnPacket RESPAWN_PACKET = new V1_8RespawnPacket();
    private static final V1_8SpawnPlayerPacket SPAWN_PLAYER_PACKET = new V1_8SpawnPlayerPacket();
    private static final V1_8SpawnPositionPacket SPAWN_POSITION_PACKET = new V1_8SpawnPositionPacket();
    private static final V1_8TimeUpdatePacket TIME_UPDATE_PACKET = new V1_8TimeUpdatePacket();
    private static final V1_8UpdateHealthPacket UPDATE_HEALTH_PACKET = new V1_8UpdateHealthPacket();
    private static final V1_8DisconnectPacket DISCONNECT_PACKET = new V1_8DisconnectPacket();
    private static final V1_8SpawnEntityPacket SPAWN_ENTITY_PACKET = new V1_8SpawnEntityPacket();
    
    @Override
    public VersionedPacket getAcknowledgePlayerDiggingPacket() {
        return null;
    }

    @Override
    public VersionedPacket getActionBarPacket() {
        return null;
    }

    @Override
    public VersionedPacket getAdvancementsPacket() {
        return null;
    }

    @Override
    public VersionedPacket getAttachEntityPacket() {
        return null;
    }

    @Override
    public VersionedPacket getBlockActionPacket() {
        return null;
    }

    @Override
    public VersionedPacket getBlockBreakAnimationPacket() {
        return null;
    }

    @Override
    public VersionedPacket getBlockChangePacket() {
        return null;
    }

    @Override
    public VersionedPacket getBlockEntityDataPacket() {
        return null;
    }

    @Override
    public VersionedPacket getBossBarPacket() {
        return null;
    }

    @Override
    public VersionedPacket getCameraPacket() {
        return null;
    }

    @Override
    public VersionedPacket getChangeGameStatePacket() {
        return null;
    }

    @Override
    public VersionedPacket getChatMessagePacket() {
        return CHAT_MESSAGE_PACKET;
    }

    @Override
    public VersionedPacket getChunkDataPacket() {
        return null;
    }

    @Override
    public VersionedPacket getClearTitlesPacket() {
        return null;
    }

    @Override
    public VersionedPacket getCloseWindowPacket() {
        return null;
    }

    @Override
    public VersionedPacket getCollectItemPacket() {
        return COLLECT_ITEM_PACKET;
    }

    @Override
    public VersionedPacket getCraftRecipeResponsePacket() {
        return null;
    }

    @Override
    public VersionedPacket getDeathCombatEventPacket() {
        return null;
    }

    @Override
    public VersionedPacket getDeclareCommandsPacket() {
        return null;
    }

    @Override
    public VersionedPacket getDeclareRecipesPacket() {
        return null;
    }

    @Override
    public VersionedPacket getDestroyEntitiesPacket() {
        return null;
    }

    @Override
    public VersionedPacket getDisconnectPacket() {
        return DISCONNECT_PACKET;
    }

    @Override
    public VersionedPacket getDisplayScoreboardPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEffectPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEndCombatEventPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEnterCombatEventPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEntityAnimationPacket() {
        return ENTITY_ANIMATION_PACKET;
    }

    @Override
    public VersionedPacket getEntityEffectPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEntityEquipmentPacket() {
        return ENTITY_EQUIPMENT_PACKET;
    }

    @Override
    public VersionedPacket getEntityHeadLookPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEntityMetaDataPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEntityPositionAndRotationPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEntityPositionPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEntityPropertiesPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEntityRotationPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEntitySoundEffectPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEntityStatusPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEntityTeleportPacket() {
        return null;
    }

    @Override
    public VersionedPacket getEntityVelocityPacket() {
        return null;
    }

    @Override
    public VersionedPacket getExplosionPacket() {
        return null;
    }

    @Override
    public VersionedPacket getFacePlayerPacket() {
        return null;
    }

    @Override
    public VersionedPacket getHeldItemChangePacket() {
        return HELD_ITEM_CHANGE_PACKET;
    }

    @Override
    public VersionedPacket getInitializeWorldBorderPacket() {
        return null;
    }

    @Override
    public VersionedPacket getJoinGamePacket() {
        return JOIN_GAME_PACKET;
    }

    @Override
    public VersionedPacket getKeepAlivePacket() {
        return KEEP_ALIVE_PACKET;
    }

    @Override
    public VersionedPacket getMapDataPacket() {
        return null;
    }

    @Override
    public VersionedPacket getMultiBlockChangePacket() {
        return null;
    }

    @Override
    public VersionedPacket getNamedSoundEffectPacket() {
        return null;
    }

    @Override
    public VersionedPacket getNbtQueryResponsePacket() {
        return null;
    }

    @Override
    public VersionedPacket getOpenBookPacket() {
        return null;
    }

    @Override
    public VersionedPacket getOpenHorseWindowPacket() {
        return null;
    }

    @Override
    public VersionedPacket getOpenSignEditorPacket() {
        return null;
    }

    @Override
    public VersionedPacket getOpenWindowPacket() {
        return null;
    }

    @Override
    public VersionedPacket getParticlePacket() {
        return null;
    }

    @Override
    public VersionedPacket getPingPacket() {
        return null;
    }

    @Override
    public VersionedPacket getPlayerAbilitiesPacket() {
        return null;
    }

    @Override
    public VersionedPacket getPlayerInfoPacket() {
        return null;
    }

    @Override
    public VersionedPacket getPlayerListHeaderAndFooterPacket() {
        return null;
    }

    @Override
    public VersionedPacket getPlayerPositionAndLookPacket() {
        return PLAYER_POSITION_AND_LOOK_PACKET;
    }

    @Override
    public VersionedPacket getPluginMessagePacket() {
        return null;
    }

    @Override
    public VersionedPacket getRemoveEntityEffectPacket() {
        return null;
    }

    @Override
    public VersionedPacket getResourcePackSendPacket() {
        return null;
    }

    @Override
    public VersionedPacket getRespawnPacket() {
        return RESPAWN_PACKET;
    }

    @Override
    public VersionedPacket getScoreboardObjectivePacket() {
        return null;
    }

    @Override
    public VersionedPacket getSculkVibrationSignalPacket() {
        return null;
    }

    @Override
    public VersionedPacket getSelectAdvancementTabPacket() {
        return null;
    }

    @Override
    public VersionedPacket getServerDifficultyPacket() {
        return null;
    }

    @Override
    public VersionedPacket getSetCooldownPacket() {
        return null;
    }

    @Override
    public VersionedPacket getSetExperiencePacket() {
        return null;
    }

    @Override
    public VersionedPacket getSetPassengersPacket() {
        return null;
    }

    @Override
    public VersionedPacket getSetSlotPacket() {
        return null;
    }

    @Override
    public VersionedPacket getSetTitleSubTitlePacket() {
        return null;
    }

    @Override
    public VersionedPacket getSetTitleTextPacket() {
        return null;
    }

    @Override
    public VersionedPacket getSetTitleTimePacket() {
        return null;
    }

    @Override
    public VersionedPacket getSoundEffectPacket() {
        return null;
    }

    @Override
    public VersionedPacket getSpawnEntityPacket() {
        return SPAWN_ENTITY_PACKET;
    }

    @Override
    public VersionedPacket getSpawnExperienceOrbPacket() {
        return null;
    }

    @Override
    public VersionedPacket getSpawnLivingEntityPacket() {
        return null;
    }

    @Override
    public VersionedPacket getSpawnPaintingPacket() {
        return null;
    }

    @Override
    public VersionedPacket getSpawnPlayerPacket() {
        return SPAWN_PLAYER_PACKET;
    }

    @Override
    public VersionedPacket getSpawnPositionPacket() {
        return SPAWN_POSITION_PACKET;
    }

    @Override
    public VersionedPacket getStatisticsPacket() {
        return null;
    }

    @Override
    public VersionedPacket getStopSoundPacket() {
        return null;
    }

    @Override
    public VersionedPacket getTabCompletePacket() {
        return null;
    }

    @Override
    public VersionedPacket getTagsPacket() {
        return null;
    }

    @Override
    public VersionedPacket getTeamsPacket() {
        return null;
    }

    @Override
    public VersionedPacket getTimeUpdatePacket() {
        return TIME_UPDATE_PACKET;
    }

    @Override
    public VersionedPacket getTradeListPacket() {
        return null;
    }

    @Override
    public VersionedPacket getUnloadChunkPacket() {
        return null;
    }

    @Override
    public VersionedPacket getUnlockRecipesPacket() {
        return null;
    }

    @Override
    public VersionedPacket getUpdateHealthPacket() {
        return UPDATE_HEALTH_PACKET;
    }

    @Override
    public VersionedPacket getUpdateLightPacket() {
        return null;
    }

    @Override
    public VersionedPacket getUpdateScorePacket() {
        return null;
    }

    @Override
    public VersionedPacket getUpdateViewDistancePacket() {
        return null;
    }

    @Override
    public VersionedPacket getUpdateViewPositionPacket() {
        return null;
    }

    @Override
    public VersionedPacket getVehicleMovePacket() {
        return null;
    }

    @Override
    public VersionedPacket getWindowItemsPacket() {
        return null;
    }

    @Override
    public VersionedPacket getWindowPropertyPacket() {
        return null;
    }

    @Override
    public VersionedPacket getWorldBorderCenterPacket() {
        return null;
    }

    @Override
    public VersionedPacket getWorldBorderLerpSizePacket() {
        return null;
    }

    @Override
    public VersionedPacket getWorldBorderSizePacket() {
        return null;
    }

    @Override
    public VersionedPacket getWorldBorderWarningDelayPacket() {
        return null;
    }

    @Override
    public VersionedPacket getWorldBorderWarningReachPacket() {
        return null;
    }

}
