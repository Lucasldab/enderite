package com.lucasldab.enderite;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class EnderiteLoot {

    private static final Identifier END_CITY_TREASURE =
        Identifier.of("minecraft", "chests/end_city_treasure");

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && key.getValue().equals(END_CITY_TREASURE)) {
                tableBuilder.pool(
                    LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f))
                        .with(ItemEntry.builder(EnderiteItems.RAW_ENDERITE)
                            .apply(SetCountLootFunction.builder(
                                UniformLootNumberProvider.create(1, 2))))
                );
            }
        });
    }
}
