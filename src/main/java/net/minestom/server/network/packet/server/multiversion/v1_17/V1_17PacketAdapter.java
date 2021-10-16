package net.minestom.server.network.packet.server.multiversion.v1_17;

import net.minestom.server.network.packet.server.multiversion.PacketAdapter;
import net.minestom.server.network.packet.server.multiversion.VersionedPacket;
import net.minestom.server.network.packet.server.multiversion.v1_17.impl.*;

public final class V1_17PacketAdapter implements PacketAdapter {

    private static final V1_17AcknowledgePlayerDiggingPacket ACKNOWLEDGE_PLAYER_DIGGING_PACKET = new V1_17AcknowledgePlayerDiggingPacket();
    private static final V1_17ActionBarPacket ACTION_BAR_PACKET = new V1_17ActionBarPacket();
    private static final V1_17AdvancementsPacket ADVANCEMENTS_PACKET = new V1_17AdvancementsPacket();
    private static final V1_17AttachEntityPacket ATTACH_ENTITY_PACKET = new V1_17AttachEntityPacket();
    private static final V1_17BlockActionPacket BLOCK_ACTION_PACKET = new V1_17BlockActionPacket();
    private static final V1_17BlockBreakAnimationPacket BLOCK_BREAK_ANIMATION_PACKET = new V1_17BlockBreakAnimationPacket();
    private static final V1_17BlockChangePacket BLOCK_CHANGE_PACKET = new V1_17BlockChangePacket();
    private static final V1_17BlockEntityDataPacket BLOCK_ENTITY_DATA_PACKET = new V1_17BlockEntityDataPacket();
    private static final V1_17BossBarPacket BOSS_BAR_PACKET = new V1_17BossBarPacket();
    private static final V1_17CameraPacket CAMERA_PACKET = new V1_17CameraPacket();
    private static final V1_17ChangeGameStatePacket CHANGE_GAME_STATE_PACKET = new V1_17ChangeGameStatePacket();
    private static final V1_17ChatMessagePacket CHAT_MESSAGE_PACKET = new V1_17ChatMessagePacket();
    private static final V1_17ChunkDataPacket CHUNK_DATA_PACKET = new V1_17ChunkDataPacket();
    private static final V1_17ClearTitlesPacket CLEAR_TITLES_PACKET = new V1_17ClearTitlesPacket();
    private static final V1_17CloseWindowPacket CLOSE_WINDOW_PACKET = new V1_17CloseWindowPacket();
    private static final V1_17CollectItemPacket COLLECT_ITEM_PACKET = new V1_17CollectItemPacket();
    private static final V1_17CraftRecipeResponse CRAFT_RECIPE_RESPONSE_PACKET = new V1_17CraftRecipeResponse();
    private static final V1_17DeathCombatEventPacket DEATH_COMBAT_EVENT_PACKET = new V1_17DeathCombatEventPacket();
    private static final V1_17DeclareCommandsPacket DECLARE_COMMANDS_PACKET = new V1_17DeclareCommandsPacket();
    private static final V1_17DeclareRecipesPacket DECLARE_RECIPES_PACKET = new V1_17DeclareRecipesPacket();
    private static final V1_17DestroyEntitiesPacket DESTROY_ENTITIES_PACKET = new V1_17DestroyEntitiesPacket();
    private static final V1_17DisconnectPacket DISCONNECT_PACKET = new V1_17DisconnectPacket();
    private static final V1_17DisplayScoreboardPacket DISPLAY_SCOREBOARD_PACKET = new V1_17DisplayScoreboardPacket();
    private static final V1_17EffectPacket EFFECT_PACKET = new V1_17EffectPacket();
    private static final V1_17EndCombatEventPacket END_COMBAT_EVENT_PACKET = new V1_17EndCombatEventPacket();
    private static final V1_17EnterCombatEventPacket ENTER_COMBAT_EVENT_PACKET = new V1_17EnterCombatEventPacket();
    private static final V1_17EntityAnimationPacket ENTITY_ANIMATION_PACKET = new V1_17EntityAnimationPacket();
    private static final V1_17EntityEffectPacket ENTITY_EFFECT_PACKET = new V1_17EntityEffectPacket();
    private static final V1_17EntityEquipmentPacket ENTITY_EQUIPMENT_PACKET = new V1_17EntityEquipmentPacket();
    private static final V1_17EntityHeadLookPacket ENTITY_HEAD_LOOK_PACKET = new V1_17EntityHeadLookPacket();
    private static final V1_17EntityMetaDataPacket ENTITY_META_DATA_PACKET = new V1_17EntityMetaDataPacket();
    private static final V1_17EntityPositionAndRotationPacket ENTITY_POSITION_AND_ROTATION_PACKET = new V1_17EntityPositionAndRotationPacket();
    private static final V1_17EntityPositionPacket ENTITY_POSITION_PACKET = new V1_17EntityPositionPacket();
    private static final V1_17EntityPropertiesPacket ENTITY_PROPERTIES_PACKET = new V1_17EntityPropertiesPacket();
    private static final V1_17EntityRotationPacket ENTITY_ROTATION_PACKET = new V1_17EntityRotationPacket();
    private static final V1_17EntitySoundEffectPacket ENTITY_SOUND_EFFECT_PACKET = new V1_17EntitySoundEffectPacket();
    private static final V1_17EntityStatusPacket ENTITY_STATUS_PACKET = new V1_17EntityStatusPacket();
    private static final V1_17EntityTeleportPacket ENTITY_TELEPORT_PACKET = new V1_17EntityTeleportPacket();
    private static final V1_17EntityVelocityPacket ENTITY_VELOCITY_PACKET = new V1_17EntityVelocityPacket();
    private static final V1_17ExplosionPacket EXPLOSION_PACKET = new V1_17ExplosionPacket();
    private static final V1_17FacePlayerPacket FACE_PLAYER_PACKET = new V1_17FacePlayerPacket();
    private static final V1_17HeldItemChangePacket HELD_ITEM_CHANGE_PACKET = new V1_17HeldItemChangePacket();
    private static final V1_17InitializeWorldBorderPacket INITIALIZE_WORLD_BORDER_PACKET = new V1_17InitializeWorldBorderPacket();
    private static final V1_17JoinGamePacket JOIN_GAME_PACKET = new V1_17JoinGamePacket();
    private static final V1_17KeepAlivePacket KEEP_ALIVE_PACKET = new V1_17KeepAlivePacket();
    private static final V1_17MapDataPacket MAP_DATA_PACKET = new V1_17MapDataPacket();
    private static final V1_17MultiBlockChangePacket MULTI_BLOCK_CHANGE_PACKET = new V1_17MultiBlockChangePacket();
    private static final V1_17NamedSoundEffectPacket NAMED_SOUND_EFFECT_PACKET = new V1_17NamedSoundEffectPacket();
    private static final V1_17NbtQueryResponsePacket NBT_QUERY_RESPONSE_PACKET = new V1_17NbtQueryResponsePacket();
    private static final V1_17OpenBookPacket OPEN_BOOK_PACKET = new V1_17OpenBookPacket();
    private static final V1_17OpenHorseWindowPacket OPEN_HORSE_WINDOW_PACKET = new V1_17OpenHorseWindowPacket();
    private static final V1_17OpenSignEditorPacket OPEN_SIGN_EDITOR_PACKET = new V1_17OpenSignEditorPacket();
    private static final V1_17OpenWindowPacket OPEN_WINDOW_PACKET = new V1_17OpenWindowPacket();
    private static final V1_17ParticlePacket PARTICLE_PACKET = new V1_17ParticlePacket();
    private static final V1_17PingPacket PING_PACKET = new V1_17PingPacket();
    private static final V1_17PlayerAbilitiesPacket PLAYER_ABILITIES_PACKET = new V1_17PlayerAbilitiesPacket();
    private static final V1_17PlayerInfoPacket PLAYER_INFO_PACKET = new V1_17PlayerInfoPacket();
    private static final V1_17PlayerListHeaderAndFooterPacket PLAYER_LIST_HEADER_AND_FOOTER_PACKET = new V1_17PlayerListHeaderAndFooterPacket();
    private static final V1_17PlayerPositionAndLookPacket PLAYER_POSITION_AND_LOOK_PACKET = new V1_17PlayerPositionAndLookPacket();
    private static final V1_17PluginMessagePacket PLUGIN_MESSAGE_PACKET = new V1_17PluginMessagePacket();
    private static final V1_17RemoveEntityEffectPacket REMOVE_ENTITY_EFFECT_PACKET = new V1_17RemoveEntityEffectPacket();
    private static final V1_17ResourcePackSendPacket RESOURCE_PACK_SEND_PACKET = new V1_17ResourcePackSendPacket();
    private static final V1_17RespawnPacket RESPAWN_PACKET = new V1_17RespawnPacket();
    private static final V1_17ScoreboardObjectivePacket SCOREBOARD_OBJECTIVE_PACKET = new V1_17ScoreboardObjectivePacket();
    private static final V1_17SculkVibrationSignal SCULK_VIBRATION_SIGNAL_PACKET = new V1_17SculkVibrationSignal();
    private static final V1_17SelectAdvancementTabPacket SELECT_ADVANCEMENT_TAB_PACKET = new V1_17SelectAdvancementTabPacket();
    private static final V1_17ServerDifficultyPacket SERVER_DIFFICULTY_PACKET = new V1_17ServerDifficultyPacket();
    private static final V1_17SetCooldownPacket SET_COOLDOWN_PACKET = new V1_17SetCooldownPacket();
    private static final V1_17SetExperiencePacket SET_EXPERIENCE_PACKET = new V1_17SetExperiencePacket();
    private static final V1_17SetPassengersPacket SET_PASSENGERS_PACKET = new V1_17SetPassengersPacket();
    private static final V1_17SetSlotPacket SET_SLOT_PACKET = new V1_17SetSlotPacket();
    private static final V1_17SetTitleSubTitlePacket SET_TITLE_SUB_TITLE_PACKET = new V1_17SetTitleSubTitlePacket();
    private static final V1_17SetTitleTextPacket SET_TITLE_TEXT_PACKET = new V1_17SetTitleTextPacket();
    private static final V1_17SetTitleTimePacket SET_TITLE_TIME_PACKET = new V1_17SetTitleTimePacket();
    private static final V1_17SoundEffectPacket SOUND_EFFECT_PACKET = new V1_17SoundEffectPacket();
    private static final V1_17SpawnEntityPacket SPAWN_ENTITY_PACKET = new V1_17SpawnEntityPacket();
    private static final V1_17SpawnExperienceOrbPacket SPAWN_EXPERIENCE_ORB_PACKET = new V1_17SpawnExperienceOrbPacket();
    private static final V1_17SpawnLivingEntityPacket SPAWN_LIVING_ENTITY_PACKET = new V1_17SpawnLivingEntityPacket();
    private static final V1_17SpawnPaintingPacket SPAWN_PAINTING_PACKET = new V1_17SpawnPaintingPacket();
    private static final V1_17SpawnPlayerPacket SPAWN_PLAYER_PACKET = new V1_17SpawnPlayerPacket();
    private static final V1_17SpawnPositionPacket SPAWN_POSITION_PACKET = new V1_17SpawnPositionPacket();
    private static final V1_17StatisticsPacket STATISTICS_PACKET = new V1_17StatisticsPacket();
    private static final V1_17StopSoundPacket STOP_SOUND_PACKET = new V1_17StopSoundPacket();
    private static final V1_17TabCompletePacket TAB_COMPLETE_PACKET = new V1_17TabCompletePacket();
    private static final V1_17TagsPacket TAGS_PACKET = new V1_17TagsPacket();
    private static final V1_17TeamsPacket TEAMS_PACKET = new V1_17TeamsPacket();
    private static final V1_17TimeUpdatePacket TIME_UPDATE_PACKET = new V1_17TimeUpdatePacket();
    private static final V1_17TradeListPacket TRADE_LIST_PACKET = new V1_17TradeListPacket();
    private static final V1_17UnloadChunkPacket UNLOAD_CHUNK_PACKET = new V1_17UnloadChunkPacket();
    private static final V1_17UnlockRecipesPacket UNLOCK_RECIPES_PACKET = new V1_17UnlockRecipesPacket();
    private static final V1_17UpdateHealthPacket UPDATE_HEALTH_PACKET = new V1_17UpdateHealthPacket();
    private static final V1_17UpdateLightPacket UPDATE_LIGHT_PACKET = new V1_17UpdateLightPacket();
    private static final V1_17UpdateScorePacket UPDATE_SCORE_PACKET = new V1_17UpdateScorePacket();
    private static final V1_17UpdateViewDistancePacket UPDATE_VIEW_DISTANCE_PACKET = new V1_17UpdateViewDistancePacket();
    private static final V1_17UpdateViewPositionPacket UPDATE_VIEW_POSITION_PACKET = new V1_17UpdateViewPositionPacket();
    private static final V1_17VehicleMovePacket VEHICLE_MOVE_PACKET = new V1_17VehicleMovePacket();
    private static final V1_17WindowItemsPacket WINDOW_ITEMS_PACKET = new V1_17WindowItemsPacket();
    private static final V1_17WindowPropertyPacket WINDOW_PROPERTY_PACKET = new V1_17WindowPropertyPacket();
    private static final V1_17WorldBorderCenterPacket WORLD_BORDER_CENTER_PACKET = new V1_17WorldBorderCenterPacket();
    private static final V1_17WorldBorderLerpSizePacket WORLD_BORDER_LERP_SIZE_PACKET = new V1_17WorldBorderLerpSizePacket();
    private static final V1_17WorldBorderSizePacket WORLD_BORDER_SIZE_PACKET = new V1_17WorldBorderSizePacket();
    private static final V1_17WorldBorderWarningDelayPacket WORLD_BORDER_WARNING_DELAY_PACKET = new V1_17WorldBorderWarningDelayPacket();
    private static final V1_17WorldBorderWarningReachPacket WORLD_BORDER_WARNING_REACH_PACKET = new V1_17WorldBorderWarningReachPacket();

    @Override
    public VersionedPacket getAcknowledgePlayerDiggingPacket() {
        return ACKNOWLEDGE_PLAYER_DIGGING_PACKET;
    }

    @Override
    public VersionedPacket getActionBarPacket() {
        return ACTION_BAR_PACKET;
    }

    @Override
    public VersionedPacket getAdvancementsPacket() {
        return ADVANCEMENTS_PACKET;
    }

    @Override
    public VersionedPacket getAttachEntityPacket() {
        return ATTACH_ENTITY_PACKET;
    }

    @Override
    public VersionedPacket getBlockActionPacket() {
        return BLOCK_ACTION_PACKET;
    }

    @Override
    public VersionedPacket getBlockBreakAnimationPacket() {
        return BLOCK_BREAK_ANIMATION_PACKET;
    }

    @Override
    public VersionedPacket getBlockChangePacket() {
        return BLOCK_CHANGE_PACKET;
    }

    @Override
    public VersionedPacket getBlockEntityDataPacket() {
        return BLOCK_ENTITY_DATA_PACKET;
    }

    @Override
    public VersionedPacket getBossBarPacket() {
        return BOSS_BAR_PACKET;
    }

    @Override
    public VersionedPacket getCameraPacket() {
        return CAMERA_PACKET;
    }

    @Override
    public VersionedPacket getChangeGameStatePacket() {
        return CHANGE_GAME_STATE_PACKET;
    }

    @Override
    public VersionedPacket getChatMessagePacket() {
        return CHAT_MESSAGE_PACKET;
    }

    @Override
    public VersionedPacket getChunkDataPacket() {
        return CHUNK_DATA_PACKET;
    }

    @Override
    public VersionedPacket getClearTitlesPacket() {
        return CLEAR_TITLES_PACKET;
    }

    @Override
    public VersionedPacket getCloseWindowPacket() {
        return CLOSE_WINDOW_PACKET;
    }

    @Override
    public VersionedPacket getCollectItemPacket() {
        return COLLECT_ITEM_PACKET;
    }

    @Override
    public VersionedPacket getCraftRecipeResponsePacket() {
        return CRAFT_RECIPE_RESPONSE_PACKET;
    }

    @Override
    public VersionedPacket getDeathCombatEventPacket() {
        return DEATH_COMBAT_EVENT_PACKET;
    }

    @Override
    public VersionedPacket getDeclareCommandsPacket() {
        return DECLARE_COMMANDS_PACKET;
    }

    @Override
    public VersionedPacket getDeclareRecipesPacket() {
        return DECLARE_RECIPES_PACKET;
    }

    @Override
    public VersionedPacket getDestroyEntitiesPacket() {
        return DESTROY_ENTITIES_PACKET;
    }

    @Override
    public VersionedPacket getDisconnectPacket() {
        return DISCONNECT_PACKET;
    }

    @Override
    public VersionedPacket getDisplayScoreboardPacket() {
        return DISPLAY_SCOREBOARD_PACKET;
    }

    @Override
    public VersionedPacket getEffectPacket() {
        return EFFECT_PACKET;
    }

    @Override
    public VersionedPacket getEndCombatEventPacket() {
        return END_COMBAT_EVENT_PACKET;
    }

    @Override
    public VersionedPacket getEnterCombatEventPacket() {
        return ENTER_COMBAT_EVENT_PACKET;
    }

    @Override
    public VersionedPacket getEntityAnimationPacket() {
        return ENTITY_ANIMATION_PACKET;
    }

    @Override
    public VersionedPacket getEntityEffectPacket() {
        return ENTITY_EFFECT_PACKET;
    }

    @Override
    public VersionedPacket getEntityEquipmentPacket() {
        return ENTITY_EQUIPMENT_PACKET;
    }

    @Override
    public VersionedPacket getEntityHeadLookPacket() {
        return ENTITY_HEAD_LOOK_PACKET;
    }

    @Override
    public VersionedPacket getEntityMetaDataPacket() {
        return ENTITY_META_DATA_PACKET;
    }

    @Override
    public VersionedPacket getEntityPositionAndRotationPacket() {
        return ENTITY_POSITION_AND_ROTATION_PACKET;
    }

    @Override
    public VersionedPacket getEntityPositionPacket() {
        return ENTITY_POSITION_PACKET;
    }

    @Override
    public VersionedPacket getEntityPropertiesPacket() {
        return ENTITY_PROPERTIES_PACKET;
    }

    @Override
    public VersionedPacket getEntityRotationPacket() {
        return ENTITY_ROTATION_PACKET;
    }

    @Override
    public VersionedPacket getEntitySoundEffectPacket() {
        return ENTITY_SOUND_EFFECT_PACKET;
    }

    @Override
    public VersionedPacket getEntityStatusPacket() {
        return ENTITY_STATUS_PACKET;
    }

    @Override
    public VersionedPacket getEntityTeleportPacket() {
        return ENTITY_TELEPORT_PACKET;
    }

    @Override
    public VersionedPacket getEntityVelocityPacket() {
        return ENTITY_VELOCITY_PACKET;
    }

    @Override
    public VersionedPacket getExplosionPacket() {
        return EXPLOSION_PACKET;
    }

    @Override
    public VersionedPacket getFacePlayerPacket() {
        return FACE_PLAYER_PACKET;
    }

    @Override
    public VersionedPacket getHeldItemChangePacket() {
        return HELD_ITEM_CHANGE_PACKET;
    }

    @Override
    public VersionedPacket getInitializeWorldBorderPacket() {
        return INITIALIZE_WORLD_BORDER_PACKET;
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
        return MAP_DATA_PACKET;
    }

    @Override
    public VersionedPacket getMultiBlockChangePacket() {
        return MULTI_BLOCK_CHANGE_PACKET;
    }

    @Override
    public VersionedPacket getNamedSoundEffectPacket() {
        return NAMED_SOUND_EFFECT_PACKET;
    }

    @Override
    public VersionedPacket getNbtQueryResponsePacket() {
        return NBT_QUERY_RESPONSE_PACKET;
    }

    @Override
    public VersionedPacket getOpenBookPacket() {
        return OPEN_BOOK_PACKET;
    }

    @Override
    public VersionedPacket getOpenHorseWindowPacket() {
        return OPEN_HORSE_WINDOW_PACKET;
    }

    @Override
    public VersionedPacket getOpenSignEditorPacket() {
        return OPEN_SIGN_EDITOR_PACKET;
    }

    @Override
    public VersionedPacket getOpenWindowPacket() {
        return OPEN_WINDOW_PACKET;
    }

    @Override
    public VersionedPacket getParticlePacket() {
        return PARTICLE_PACKET;
    }

    @Override
    public VersionedPacket getPingPacket() {
        return PING_PACKET;
    }

    @Override
    public VersionedPacket getPlayerAbilitiesPacket() {
        return PLAYER_ABILITIES_PACKET;
    }

    @Override
    public VersionedPacket getPlayerInfoPacket() {
        return PLAYER_INFO_PACKET;
    }

    @Override
    public VersionedPacket getPlayerListHeaderAndFooterPacket() {
        return PLAYER_LIST_HEADER_AND_FOOTER_PACKET;
    }

    @Override
    public VersionedPacket getPlayerPositionAndLookPacket() {
        return PLAYER_POSITION_AND_LOOK_PACKET;
    }

    @Override
    public VersionedPacket getPluginMessagePacket() {
        return PLUGIN_MESSAGE_PACKET;
    }

    @Override
    public VersionedPacket getRemoveEntityEffectPacket() {
        return REMOVE_ENTITY_EFFECT_PACKET;
    }

    @Override
    public VersionedPacket getResourcePackSendPacket() {
        return RESOURCE_PACK_SEND_PACKET;
    }

    @Override
    public VersionedPacket getRespawnPacket() {
        return RESPAWN_PACKET;
    }

    @Override
    public VersionedPacket getScoreboardObjectivePacket() {
        return SCOREBOARD_OBJECTIVE_PACKET;
    }

    @Override
    public VersionedPacket getSculkVibrationSignalPacket() {
        return SCULK_VIBRATION_SIGNAL_PACKET;
    }

    @Override
    public VersionedPacket getSelectAdvancementTabPacket() {
        return SELECT_ADVANCEMENT_TAB_PACKET;
    }

    @Override
    public VersionedPacket getServerDifficultyPacket() {
        return SERVER_DIFFICULTY_PACKET;
    }

    @Override
    public VersionedPacket getSetCooldownPacket() {
        return SET_COOLDOWN_PACKET;
    }

    @Override
    public VersionedPacket getSetExperiencePacket() {
        return SET_EXPERIENCE_PACKET;
    }

    @Override
    public VersionedPacket getSetPassengersPacket() {
        return SET_PASSENGERS_PACKET;
    }

    @Override
    public VersionedPacket getSetSlotPacket() {
        return SET_SLOT_PACKET;
    }

    @Override
    public VersionedPacket getSetTitleSubTitlePacket() {
        return SET_TITLE_SUB_TITLE_PACKET;
    }

    @Override
    public VersionedPacket getSetTitleTextPacket() {
        return SET_TITLE_TEXT_PACKET;
    }

    @Override
    public VersionedPacket getSetTitleTimePacket() {
        return SET_TITLE_TIME_PACKET;
    }

    @Override
    public VersionedPacket getSoundEffectPacket() {
        return SOUND_EFFECT_PACKET;
    }

    @Override
    public VersionedPacket getSpawnEntityPacket() {
        return SPAWN_ENTITY_PACKET;
    }

    @Override
    public VersionedPacket getSpawnExperienceOrbPacket() {
        return SPAWN_EXPERIENCE_ORB_PACKET;
    }

    @Override
    public VersionedPacket getSpawnLivingEntityPacket() {
        return SPAWN_LIVING_ENTITY_PACKET;
    }

    @Override
    public VersionedPacket getSpawnPaintingPacket() {
        return SPAWN_PAINTING_PACKET;
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
        return STATISTICS_PACKET;
    }

    @Override
    public VersionedPacket getStopSoundPacket() {
        return STOP_SOUND_PACKET;
    }

    @Override
    public VersionedPacket getTabCompletePacket() {
        return TAB_COMPLETE_PACKET;
    }

    @Override
    public VersionedPacket getTagsPacket() {
        return TAGS_PACKET;
    }

    @Override
    public VersionedPacket getTeamsPacket() {
        return TEAMS_PACKET;
    }

    @Override
    public VersionedPacket getTimeUpdatePacket() {
        return TIME_UPDATE_PACKET;
    }

    @Override
    public VersionedPacket getTradeListPacket() {
        return TRADE_LIST_PACKET;
    }

    @Override
    public VersionedPacket getUnloadChunkPacket() {
        return UNLOAD_CHUNK_PACKET;
    }

    @Override
    public VersionedPacket getUnlockRecipesPacket() {
        return UNLOCK_RECIPES_PACKET;
    }

    @Override
    public VersionedPacket getUpdateHealthPacket() {
        return UPDATE_HEALTH_PACKET;
    }

    @Override
    public VersionedPacket getUpdateLightPacket() {
        return UPDATE_LIGHT_PACKET;
    }

    @Override
    public VersionedPacket getUpdateScorePacket() {
        return UPDATE_SCORE_PACKET;
    }

    @Override
    public VersionedPacket getUpdateViewDistancePacket() {
        return UPDATE_VIEW_DISTANCE_PACKET;
    }

    @Override
    public VersionedPacket getUpdateViewPositionPacket() {
        return UPDATE_VIEW_POSITION_PACKET;
    }

    @Override
    public VersionedPacket getVehicleMovePacket() {
        return VEHICLE_MOVE_PACKET;
    }

    @Override
    public VersionedPacket getWindowItemsPacket() {
        return WINDOW_ITEMS_PACKET;
    }

    @Override
    public VersionedPacket getWindowPropertyPacket() {
        return WINDOW_PROPERTY_PACKET;
    }

    @Override
    public VersionedPacket getWorldBorderCenterPacket() {
        return WORLD_BORDER_CENTER_PACKET;
    }

    @Override
    public VersionedPacket getWorldBorderLerpSizePacket() {
        return WORLD_BORDER_LERP_SIZE_PACKET;
    }

    @Override
    public VersionedPacket getWorldBorderSizePacket() {
        return WORLD_BORDER_SIZE_PACKET;
    }

    @Override
    public VersionedPacket getWorldBorderWarningDelayPacket() {
        return WORLD_BORDER_WARNING_DELAY_PACKET;
    }

    @Override
    public VersionedPacket getWorldBorderWarningReachPacket() {
        return WORLD_BORDER_WARNING_REACH_PACKET;
    }

}
