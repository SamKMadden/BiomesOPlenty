/*******************************************************************************
 * Copyright 2021, the Glitchfiend Team.
 * All rights reserved.
 ******************************************************************************/
package biomesoplenty.common.biome.overworld;

import biomesoplenty.api.enums.BOPClimates;
import biomesoplenty.common.biome.BiomeTemplate;
import biomesoplenty.common.world.gen.feature.BOPConfiguredFeatures;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class MysticGroveBiome extends BiomeTemplate
{
    public MysticGroveBiome()
    {
        this.addWeight(BOPClimates.WET_TEMPERATE, 1);
        this.setBeachBiome(null);
        this.setRiverBiome(null);
    }

    @Override
    protected void configureBiome(Biome.BiomeBuilder builder)
    {
        builder.precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).depth(0.1F).scale(0.1F).temperature(0.7F).downfall(0.8F);

        builder.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x9C3FE4).waterFogColor(0x2E0533).fogColor(0xFFC9DA).skyColor(0xAAEFFF).grassColorOverride(0x69CFDB).foliageColorOverride(0x70E0B5).ambientParticle(new AmbientParticleSettings(ParticleTypes.END_ROD, 0.00011532552F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build());
    }

    @Override
    protected void configureGeneration(BiomeGenerationSettings.Builder builder)
    {
        builder.surfaceBuilder(SurfaceBuilders.GRASS);

        // Structures
        builder.addStructureStart(StructureFeatures.WOODLAND_MANSION);
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(builder);

        // Underground
        BiomeDefaultFeatures.addDefaultCarvers(builder);

        builder.addFeature(GenerationStep.Decoration.LAKES, Features.LAKE_WATER);

        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);

        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.DISK_CLAY);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BOPConfiguredFeatures.WHITE_SAND_DISK);

        ////////////////////////////////////////////////////////////

        // Vegetation
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPConfiguredFeatures.MYSTIC_GROVE_TREES);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPConfiguredFeatures.MYSTIC_GROVE_FLOWERS);

        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPConfiguredFeatures.BLUE_HYDRANGEA_1);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPConfiguredFeatures.CLOVER_3);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPConfiguredFeatures.HUGE_RED_MUSHROOM_EXTRA);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPConfiguredFeatures.LILAC_1);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPConfiguredFeatures.SMALL_RED_MUSHROOM);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPConfiguredFeatures.SPROUTS_15);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPConfiguredFeatures.STANDARD_GRASS_12);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPConfiguredFeatures.WATERGRASS_10);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NORMAL);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_NORMAL);

        ////////////////////////////////////////////////////////////

        // Other Features
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    @Override
    protected void configureMobSpawns(MobSpawnSettings.Builder builder)
    {
        // Entities
        builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        builder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 10, 4, 6));
        builder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.AXOLOTL, 10, 4, 6));
        builder.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 20, 1, 1));
    }
}
