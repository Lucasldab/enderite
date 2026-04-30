package com.lucasldab.enderite;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EnderiteBlocks {

    // Storage blocks
    public static final Block ENDERITE_BLOCK = Registry.register(
        Registries.BLOCK,
        Identifier.of("enderite", "enderite_block"),
        new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).strength(50.0f, 1200.0f))
    );

    public static final Block RAW_ENDERITE_BLOCK = Registry.register(
        Registries.BLOCK,
        Identifier.of("enderite", "raw_enderite_block"),
        new Block(AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK).strength(5.0f, 6.0f))
    );

    // End dimension ore — stone/generic substrate, placed in the End
    public static final Block ENDERITE_ORE = Registry.register(
        Registries.BLOCK,
        Identifier.of("enderite", "enderite_ore"),
        new Block(AbstractBlock.Settings.copy(Blocks.END_STONE).strength(3.5f, 3.0f).requiresTool())
    );

    // Overworld rare variant — deepslate substrate, extremely rare below y=-32
    public static final Block DEEPSLATE_ENDERITE_ORE = Registry.register(
        Registries.BLOCK,
        Identifier.of("enderite", "deepslate_enderite_ore"),
        new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).strength(4.5f, 3.0f))
    );

    // End dimension ore — end_stone substrate (primary spawn in the End)
    public static final Block END_ENDERITE_ORE = Registry.register(
        Registries.BLOCK,
        Identifier.of("enderite", "end_enderite_ore"),
        new Block(AbstractBlock.Settings.copy(Blocks.END_STONE).strength(3.0f, 3.0f).requiresTool())
    );

    private static void registerBlockItem(String name, Block block) {
        Registry.register(
            Registries.ITEM,
            Identifier.of("enderite", name),
            new BlockItem(block, new Item.Settings())
        );
    }

    public static void register() {
        registerBlockItem("enderite_block", ENDERITE_BLOCK);
        registerBlockItem("raw_enderite_block", RAW_ENDERITE_BLOCK);
        registerBlockItem("enderite_ore", ENDERITE_ORE);
        registerBlockItem("deepslate_enderite_ore", DEEPSLATE_ENDERITE_ORE);
        registerBlockItem("end_enderite_ore", END_ENDERITE_ORE);
        Enderite.LOGGER.info("Registering Enderite blocks");
    }
}
