package com.lucasldab.enderite;

import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class EnderiteItems {

    public static final Item RAW_ENDERITE = Registry.register(
        Registries.ITEM,
        Identifier.of("enderite", "raw_enderite"),
        new Item(new Item.Settings())
    );

    public static final Item ENDERITE_INGOT = Registry.register(
        Registries.ITEM,
        Identifier.of("enderite", "enderite_ingot"),
        new Item(new Item.Settings())
    );

    public static final SmithingTemplateItem ENDERITE_UPGRADE_SMITHING_TEMPLATE = Registry.register(
        Registries.ITEM,
        Identifier.of("enderite", "enderite_upgrade_smithing_template"),
        new SmithingTemplateItem(
            Text.translatable("item.enderite.smithing_template.enderite_upgrade.applies_to"),
            Text.translatable("item.enderite.smithing_template.enderite_upgrade.ingredient_slot"),
            Text.translatable("upgrade.enderite.enderite_upgrade"),
            Text.translatable("item.enderite.smithing_template.enderite_upgrade.base_slot_description"),
            Text.translatable("item.enderite.smithing_template.enderite_upgrade.additions_slot_description"),
            List.of(
                Identifier.of("item/empty_slot_helmet"),
                Identifier.of("item/empty_slot_chestplate"),
                Identifier.of("item/empty_slot_leggings"),
                Identifier.of("item/empty_slot_boots"),
                Identifier.of("item/empty_slot_sword"),
                Identifier.of("item/empty_slot_pickaxe")
            ),
            List.of(Identifier.of("item/empty_slot_ingot"))
        )
    );

    public static void register() {
        Enderite.LOGGER.info("Registering Enderite items");
    }
}
