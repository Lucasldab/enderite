# Enderite

A Fabric mod for Minecraft 26.1.2 that adds an **enderite** material tier — stronger than netherite, obtained deep in the End dimension.

## What it adds

| Item | Description |
|------|-------------|
| Enderite Scrap | Raw material smelted from ancient End debris |
| Enderite Ingot | Crafted from Enderite Scraps + Gold Ingots |
| Enderite tools & armor | Full tool/armor set surpassing netherite stats |

## Upgrade flow (smithing template)

Enderite gear uses the **smithing-template upgrade flow**, identical to how netherite upgrades work:

1. Obtain an **Enderite Upgrade Smithing Template** (found in End City chests).
2. Place your netherite item + the template + an Enderite Ingot in a Smithing Table.
3. Receive the enderite-tier item.

This mirrors the Minecraft 1.20+ smithing pattern so the upgrade feels native and requires meaningful progression through the End.

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
  main/java/com/lucasldab/enderite/   — shared (server + client) code
  main/resources/                     — fabric.mod.json, assets, data
  client/                             — client-only code (empty placeholder)
```
