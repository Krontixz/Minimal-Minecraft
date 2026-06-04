package com.krontixz.minimalminecraft;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

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
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Minimal Minecraft Initialization Started");
        Minecraft.getMinecraft().gameSettings.mipmapLevels = 0;
        Minecraft.getMinecraft().gameSettings.fancyGraphics = false;
        Minecraft.getMinecraft().gameSettings.ambientOcclusion = 0;
        Minecraft.getMinecraft().gameSettings.clouds = 0;
        Minecraft.getMinecraft().gameSettings.enableVsync = false;
        Minecraft.getMinecraft().gameSettings.particleSetting = 2;
        Minecraft.getMinecraft().gameSettings.renderDistanceChunks = 2;
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("Minimal Minecraft Post-Initialization Started");
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (Minecraft.getMinecraft().gameSettings.renderDistanceChunks != 2) {
            Minecraft.getMinecraft().gameSettings.renderDistanceChunks = 2;
        }
    }

    @SubscribeEvent
    public void onRenderBlockOverlay(RenderBlockOverlayEvent event) {
        event.setCanceled(true);
    }

    @SubscribeEvent
    public void onRenderLiving(RenderLivingEvent.Pre event) {
        if (event.getEntity().getDistanceSq(event.getRenderer().getRenderManager().viewerPosX, event.getRenderer().getRenderManager().viewerPosY, event.getRenderer().getRenderManager().viewerPosZ) > 64.0) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onFogRender(EntityViewRenderEvent.FogDensity event) {
        event.setDensity(0.0F);
        event.setCanceled(true);
    }

    @SubscribeEvent
    public void onFogColors(EntityViewRenderEvent.FogColors event) {
        event.setRed(0.0F);
        event.setGreen(0.0F);
        event.setBlue(0.0F);
    }
}
