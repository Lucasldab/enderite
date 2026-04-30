# Textures needed

All paths are relative to `src/main/resources/`. Supply 16×16 PNG files.
Until textures exist Minecraft renders the pink/black missing-texture fallback.

## Item textures

| File path | Used by |
|-----------|---------|
| `assets/enderite/textures/item/raw_enderite.png` | Raw Enderite item |
| `assets/enderite/textures/item/enderite_ingot.png` | Enderite Ingot item |
| `assets/enderite/textures/item/enderite_upgrade_smithing_template.png` | Enderite Upgrade Smithing Template item |
| `assets/enderite/textures/item/enderite_sword.png` | Enderite Sword |
| `assets/enderite/textures/item/enderite_pickaxe.png` | Enderite Pickaxe |
| `assets/enderite/textures/item/enderite_axe.png` | Enderite Axe |
| `assets/enderite/textures/item/enderite_shovel.png` | Enderite Shovel |
| `assets/enderite/textures/item/enderite_hoe.png` | Enderite Hoe |

## Block textures

| File path | Used by |
|-----------|---------|
| `assets/enderite/textures/block/enderite_block.png` | Block of Enderite (all six faces) |
| `assets/enderite/textures/block/raw_enderite_block.png` | Block of Raw Enderite (all six faces) |
| `assets/enderite/textures/block/enderite_ore.png` | Enderite Ore (stone substrate variant) |
| `assets/enderite/textures/block/deepslate_enderite_ore.png` | Deepslate Enderite Ore |
| `assets/enderite/textures/block/end_enderite_ore.png` | End Enderite Ore (end_stone substrate) |

## Notes

- Block models use `minecraft:block/cube_all`, so each block needs only one texture applied to all six faces.
  If you later want a different top/side/bottom, swap the model parent to `minecraft:block/cube_column` or similar and split the texture.
- The smithing template item model uses `minecraft:item/generated` (flat 2-D sprite, same as ingots and raw materials).
- Deepslate Enderite Ore should visually echo `deepslate_iron_ore` (grey substrate + glowing veins).
  End Enderite Ore should echo `end_stone` (yellowish substrate + contrasting ore veins).
