package com.lucasldab.enderite;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class EnderiteLoot {

    private static final Identifier END_CITY_TREASURE =
        Identifier.fromNamespaceAndPath("minecraft", "chests/end_city_treasure");

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && key.identifier().equals(END_CITY_TREASURE)) {
                tableBuilder.withPool(
                    LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.10f))
                        .add(LootItem.lootTableItem(EnderiteItems.RAW_ENDERITE)
                            .apply(SetItemCountFunction.setCount(
                                UniformGenerator.between(1, 2))))
                );
            }
        });
    }
}
