package com.lucasldab.enderite;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class EnderiteItems {

    // One tier above netherite: durability 3500 vs 2031, speed 12 vs 9, atk bonus 5 vs 4, ench 18 vs 15
    public static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(
        TagKey.of(RegistryKeys.BLOCK, Identifier.of("enderite", "incorrect_for_enderite_tool")),
        3500,
        12.0f,
        5.0f,
        18,
        TagKey.of(RegistryKeys.ITEM, Identifier.of("enderite", "enderite_ingots"))
    );

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

    // Tools — all stats strictly greater than netherite equivalents
    // Sword: 9 atk dmg (vs 8), 1.6 atk spd (same)
    public static final Item ENDERITE_SWORD = Registry.register(
        Registries.ITEM,
        Identifier.of("enderite", "enderite_sword"),
        new Item(new Item.Settings().sword(TOOL_MATERIAL, 3.0f, -2.4f))
    );

    // Pickaxe: 7 atk dmg (vs 6), 1.2 atk spd (same)
    public static final Item ENDERITE_PICKAXE = Registry.register(
        Registries.ITEM,
        Identifier.of("enderite", "enderite_pickaxe"),
        new Item(new Item.Settings().pickaxe(TOOL_MATERIAL, 1.0f, -2.8f))
    );

    // Axe: 11 atk dmg (vs 10), 1.0 atk spd (same); strips logs
    public static final Item ENDERITE_AXE = Registry.register(
        Registries.ITEM,
        Identifier.of("enderite", "enderite_axe"),
        new AxeItem(TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings())
    );

    // Shovel: 7.5 atk dmg (vs 6.5), 1.0 atk spd (same); creates dirt paths
    public static final Item ENDERITE_SHOVEL = Registry.register(
        Registries.ITEM,
        Identifier.of("enderite", "enderite_shovel"),
        new ShovelItem(TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings())
    );

    // Hoe: 2 atk dmg (vs 1), 4.0 atk spd (same); tills farmland
    public static final Item ENDERITE_HOE = Registry.register(
        Registries.ITEM,
        Identifier.of("enderite", "enderite_hoe"),
        new HoeItem(TOOL_MATERIAL, -4.0f, 0.0f, new Item.Settings())
    );

    public static void register() {
        Enderite.LOGGER.info("Registering Enderite items");
    }
}
