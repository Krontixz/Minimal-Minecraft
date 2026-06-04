package com.krontixz.minimalminecraft;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = "minimal-minecraft", name = "Minimal Minecraft", version = "1.0.0", acceptedMinecraftVersions = "")
public class MinimalMinecraft {

    public static final String MODID = "minimal-minecraft";
    public static final String NAME = "Minimal Minecraft";
    public static final String VERSION = "1.0.0";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @Mod.Instance("minimal-minecraft")
    public static MinimalMinecraft instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Minimal Minecraft Pre-Initialization Started");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Minimal Minecraft Initialization Started");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("Minimal Minecraft Post-Initialization Started");
    }
}
