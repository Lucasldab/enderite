package com.lucasldab.enderite;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class EnderiteWorldgen {

    public static final ResourceKey<PlacedFeature> END_ENDERITE_ORE = ResourceKey.create(
        Registries.PLACED_FEATURE,
        Identifier.fromNamespaceAndPath("enderite", "end_enderite_ore")
    );

    public static void register() {
        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(
                Biomes.END_HIGHLANDS,
                Biomes.END_MIDLANDS,
                Biomes.SMALL_END_ISLANDS,
                Biomes.END_BARRENS
            ),
            GenerationStep.Decoration.UNDERGROUND_ORES,
            END_ENDERITE_ORE
        );
    }
}
