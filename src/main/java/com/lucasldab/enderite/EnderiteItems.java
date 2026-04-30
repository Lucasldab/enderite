package com.lucasldab.enderite;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.EnumMap;
import java.util.List;

public class EnderiteItems {

    // One tier above netherite: durability 3500 vs 2031, speed 12 vs 9, atk bonus 5 vs 4, ench 18 vs 15
    public static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(
        TagKey.of(Registries.BLOCK, Identifier.fromNamespaceAndPath("enderite", "incorrect_for_enderite_tool")),
        3500,
        12.0f,
        5.0f,
        18,
        TagKey.of(Registries.ITEM, Identifier.fromNamespaceAndPath("enderite", "enderite_ingots"))
    );

    public static final Item RAW_ENDERITE = Registry.register(
        BuiltInRegistries.ITEM,
        Identifier.fromNamespaceAndPath("enderite", "raw_enderite"),
        new Item(new Item.Properties())
    );

    public static final Item ENDERITE_INGOT = Registry.register(
        BuiltInRegistries.ITEM,
        Identifier.fromNamespaceAndPath("enderite", "enderite_ingot"),
        new Item(new Item.Properties())
    );

    // Armor texture key — see ASSETS.md for the required equipment asset JSON path
    public static final ResourceKey<EquipmentAsset> ENDERITE_EQUIPMENT_ASSET = ResourceKey.create(
        EquipmentAssets.ROOT_ID,
        Identifier.fromNamespaceAndPath("enderite", "enderite")
    );

    // Armor: defense H:4/C:9/L:7/B:4 vs netherite H:3/C:8/L:6/B:3; toughness 4.0 vs 3.0; KBR 0.15 vs 0.1
    // Durability base 45 vs netherite 37; enchantability 18 vs 15
    public static final ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(
        45,
        Util.make(new EnumMap<>(ArmorType.class), map -> {
            map.put(ArmorType.HELMET, 4);
            map.put(ArmorType.CHESTPLATE, 9);
            map.put(ArmorType.LEGGINGS, 7);
            map.put(ArmorType.BOOTS, 4);
        }),
        18,
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        4.0f,
        0.15f,
        TagKey.of(Registries.ITEM, Identifier.fromNamespaceAndPath("enderite", "enderite_ingots")),
        ENDERITE_EQUIPMENT_ASSET
    );

    public static final SmithingTemplateItem ENDERITE_UPGRADE_SMITHING_TEMPLATE = Registry.register(
        BuiltInRegistries.ITEM,
        Identifier.fromNamespaceAndPath("enderite", "enderite_upgrade_smithing_template"),
        new SmithingTemplateItem(
            Component.translatable("item.enderite.smithing_template.enderite_upgrade.applies_to"),
            Component.translatable("item.enderite.smithing_template.enderite_upgrade.ingredient_slot"),
            Component.translatable("item.enderite.smithing_template.enderite_upgrade.base_slot_description"),
            Component.translatable("item.enderite.smithing_template.enderite_upgrade.additions_slot_description"),
            List.of(
                Identifier.withDefaultNamespace("item/empty_slot_helmet"),
                Identifier.withDefaultNamespace("item/empty_slot_chestplate"),
                Identifier.withDefaultNamespace("item/empty_slot_leggings"),
                Identifier.withDefaultNamespace("item/empty_slot_boots"),
                Identifier.withDefaultNamespace("item/empty_slot_sword"),
                Identifier.withDefaultNamespace("item/empty_slot_pickaxe")
            ),
            List.of(Identifier.withDefaultNamespace("item/empty_slot_ingot")),
            new Item.Properties()
        )
    );

    // Tools — all stats strictly greater than netherite equivalents
    // Sword: 9 atk dmg (vs 8), 1.6 atk spd (same)
    public static final Item ENDERITE_SWORD = Registry.register(
        BuiltInRegistries.ITEM,
        Identifier.fromNamespaceAndPath("enderite", "enderite_sword"),
        new Item(new Item.Properties().sword(TOOL_MATERIAL, 3.0f, -2.4f))
    );

    // Pickaxe: 7 atk dmg (vs 6), 1.2 atk spd (same)
    public static final Item ENDERITE_PICKAXE = Registry.register(
        BuiltInRegistries.ITEM,
        Identifier.fromNamespaceAndPath("enderite", "enderite_pickaxe"),
        new Item(new Item.Properties().pickaxe(TOOL_MATERIAL, 1.0f, -2.8f))
    );

    // Axe: 11 atk dmg (vs 10), 1.0 atk spd (same); strips logs
    public static final Item ENDERITE_AXE = Registry.register(
        BuiltInRegistries.ITEM,
        Identifier.fromNamespaceAndPath("enderite", "enderite_axe"),
        new AxeItem(TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties())
    );

    // Shovel: 7.5 atk dmg (vs 6.5), 1.0 atk spd (same); creates dirt paths
    public static final Item ENDERITE_SHOVEL = Registry.register(
        BuiltInRegistries.ITEM,
        Identifier.fromNamespaceAndPath("enderite", "enderite_shovel"),
        new ShovelItem(TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties())
    );

    // Hoe: 2 atk dmg (vs 1), 4.0 atk spd (same); tills farmland
    public static final Item ENDERITE_HOE = Registry.register(
        BuiltInRegistries.ITEM,
        Identifier.fromNamespaceAndPath("enderite", "enderite_hoe"),
        new HoeItem(TOOL_MATERIAL, -4.0f, 0.0f, new Item.Properties())
    );

    // Armor — all slots better than netherite; base durability 45 vs netherite 37
    public static final Item ENDERITE_HELMET = Registry.register(
        BuiltInRegistries.ITEM,
        Identifier.fromNamespaceAndPath("enderite", "enderite_helmet"),
        new Item(new Item.Properties().humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET)
            .maxDamage(ArmorType.HELMET.getDurability(45)))
    );

    public static final Item ENDERITE_CHESTPLATE = Registry.register(
        BuiltInRegistries.ITEM,
        Identifier.fromNamespaceAndPath("enderite", "enderite_chestplate"),
        new Item(new Item.Properties().humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE)
            .maxDamage(ArmorType.CHESTPLATE.getDurability(45)))
    );

    public static final Item ENDERITE_LEGGINGS = Registry.register(
        BuiltInRegistries.ITEM,
        Identifier.fromNamespaceAndPath("enderite", "enderite_leggings"),
        new Item(new Item.Properties().humanoidArmor(ARMOR_MATERIAL, ArmorType.LEGGINGS)
            .maxDamage(ArmorType.LEGGINGS.getDurability(45)))
    );

    public static final Item ENDERITE_BOOTS = Registry.register(
        BuiltInRegistries.ITEM,
        Identifier.fromNamespaceAndPath("enderite", "enderite_boots"),
        new Item(new Item.Properties().humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS)
            .maxDamage(ArmorType.BOOTS.getDurability(45)))
    );

    public static void register() {
        Enderite.LOGGER.info("Registering Enderite items");
    }
}
