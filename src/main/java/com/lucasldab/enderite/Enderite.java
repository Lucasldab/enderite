package com.lucasldab.enderite;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Enderite implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("enderite");

    @Override
    public void onInitialize() {
        EnderiteBlocks.register();
        EnderiteItems.register();
        LOGGER.info("Enderite mod initialized");
    }
}
