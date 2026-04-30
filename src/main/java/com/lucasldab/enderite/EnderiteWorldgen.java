package com.lucasldab.enderite;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class EnderiteWorldgen {

    public static final RegistryKey<PlacedFeature> END_ENDERITE_ORE = RegistryKey.of(
        RegistryKeys.PLACED_FEATURE,
        Identifier.of("enderite", "end_enderite_ore")
    );

    public static void register() {
        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(
                BiomeKeys.END_HIGHLANDS,
                BiomeKeys.END_MIDLANDS,
                BiomeKeys.SMALL_END_ISLANDS,
                BiomeKeys.END_BARRENS
            ),
            GenerationStep.Feature.UNDERGROUND_ORES,
            END_ENDERITE_ORE
        );
    }
}
