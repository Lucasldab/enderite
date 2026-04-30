package com.lucasldab.enderite;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class EnderiteBlocks {

    public static final Block ENDERITE_BLOCK = Registry.register(
        BuiltInRegistries.BLOCK,
        Identifier.fromNamespaceAndPath("enderite", "enderite_block"),
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).strength(50.0f, 1200.0f))
    );

    public static final Block RAW_ENDERITE_BLOCK = Registry.register(
        BuiltInRegistries.BLOCK,
        Identifier.fromNamespaceAndPath("enderite", "raw_enderite_block"),
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK).strength(5.0f, 6.0f))
    );

    // End dimension ore — stone/generic substrate, placed in the End
    public static final Block ENDERITE_ORE = Registry.register(
        BuiltInRegistries.BLOCK,
        Identifier.fromNamespaceAndPath("enderite", "enderite_ore"),
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).strength(3.5f, 3.0f).requiresCorrectToolForDrops())
    );

    // Overworld rare variant — deepslate substrate, extremely rare below y=-32
    public static final Block DEEPSLATE_ENDERITE_ORE = Registry.register(
        BuiltInRegistries.BLOCK,
        Identifier.fromNamespaceAndPath("enderite", "deepslate_enderite_ore"),
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE).strength(4.5f, 3.0f))
    );

    // End dimension ore — end_stone substrate (primary spawn in the End)
    public static final Block END_ENDERITE_ORE = Registry.register(
        BuiltInRegistries.BLOCK,
        Identifier.fromNamespaceAndPath("enderite", "end_enderite_ore"),
        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops())
    );

    private static void registerBlockItem(String name, Block block) {
        Registry.register(
            BuiltInRegistries.ITEM,
            Identifier.fromNamespaceAndPath("enderite", name),
            new BlockItem(block, new Item.Properties())
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
