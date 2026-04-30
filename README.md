# Enderite

A Fabric mod for Minecraft 26.1.2 that adds an **enderite** material tier — stronger than netherite, obtained deep in the End dimension.

## What it adds

### Items

| Item | Description |
|------|-------------|
| Raw Enderite | Raw ore dropped by enderite ore blocks |
| Enderite Ingot | Smelted from Raw Enderite |
| Enderite Upgrade Smithing Template | Found in End City chests; required to upgrade netherite gear |

### Blocks

| Block | Description |
|-------|-------------|
| End Enderite Ore | Primary ore, spawns in the End (end stone substrate) |
| Enderite Ore | Generic ore block (stone substrate, End dimension) |
| Deepslate Enderite Ore | Extremely rare overworld variant below y=-32 |
| Block of Enderite | Compact storage block (9 ingots) |
| Block of Raw Enderite | Compact storage block (9 raw enderite) |

## Spawn design decision: End, not Nether

Enderite is an **End-first material**. The primary ore (`end_enderite_ore`) spawns in
the End dimension replacing end stone. The secondary ore (`enderite_ore`) also lives in
the End as a stone-substrate variant for mod-compatibility placement.

Rationale:
- The End is harder to reach and sustain than the Nether, matching the tier above netherite.
- Thematically, "enderite" belongs in the End — the name, the colour palette, and the
  lore all point there.
- The overworld `deepslate_enderite_ore` is an **optional rare bonus** (think: ancient
  debris in overworld deepslate) for players who want an alternative grind or for modpacks
  that disable End access. It is intentionally so rare that it does not trivialise the
  End-based progression.

> Worldgen feature files (ore placement, veins per chunk, Y-range) are **not included
> in this PR**. That is a separate phase. Block registration is the prerequisite.

## Smelting (faster than netherite)

| Recipe | Input | Output | Time | XP |
|--------|-------|--------|------|----|
| Furnace | Raw Enderite | Enderite Ingot | 150 ticks (7.5 s) | 2.0 |
| Blast Furnace | Raw Enderite | Enderite Ingot | 75 ticks (3.75 s) | 2.0 |

Ancient debris smelts at 200/100 ticks; enderite is 25% faster, rewarding the extra
difficulty of reaching the End.

## Upgrade flow (smithing template)

Enderite gear uses the **smithing-template upgrade flow**:

1. Obtain an **Enderite Upgrade Smithing Template** (End City chest loot — worldgen phase).
2. Place your netherite item + the template + an Enderite Ingot in a Smithing Table.
3. Receive the enderite-tier item.

This mirrors the Minecraft 1.20+ smithing pattern so the upgrade feels native and
requires meaningful End progression.

## Mining requirements

All enderite blocks require a **diamond-tier pickaxe** or better
(`minecraft:needs_diamond_tool` tag). They are also in `minecraft:mineable/pickaxe`.

## Textures

No PNG textures are included. Minecraft displays the pink/black fallback until you add
them. See [TEXTURES.md](TEXTURES.md) for the complete list of expected paths.

## Requirements

- Java 25+
- Minecraft 26.1.2
- Fabric Loader 0.19.2+
- Fabric API 0.146.1+26.1.2

## How to build

```bash
./gradlew build
```

The output JAR is placed in `build/libs/`.

## Run the game in development

```bash
# Launch Minecraft client with the mod loaded
./gradlew runClient

# Launch a local server
./gradlew runServer
```

Gradle will download Minecraft, Fabric Loader, and Fabric API automatically on first run.

## Project structure

```
src/
  main/java/com/lucasldab/enderite/
    Enderite.java                    — mod entry point
    EnderiteItems.java               — item registry
    EnderiteBlocks.java              — block + block-item registry
  main/resources/
    assets/enderite/
      blockstates/                   — blockstate JSONs
      lang/en_us.json                — English translations
      models/block/                  — block models
      models/item/                   — item models
    data/enderite/
      loot_table/blocks/             — ore and storage block drops
      recipe/                        — smelting recipes
      tags/block/                    — enderite_blocks tag
      tags/item/                     — enderite_ingots tag
    data/minecraft/tags/block/
      mineable/pickaxe.json          — declares all blocks pickaxe-mineable
      needs_diamond_tool.json        — requires diamond+ tier
  client/                            — client-only code (empty placeholder)
```
