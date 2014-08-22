package com.fakegermano.exmobs;

import com.fakegermano.exmobs.block.ExplodingMobsBlock;
import com.fakegermano.exmobs.handler.ChatHandler;
import com.fakegermano.exmobs.handler.ConfigurationHandler;
import com.fakegermano.exmobs.handler.EventHandler;
import com.fakegermano.exmobs.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MODID, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY)
public class ExplodingMobs
{
    public static EventHandler eventHandler;
    public static ChatHandler chatHandler;
    @Mod.Instance(Reference.MODID)
    public static ExplodingMobs instance;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

        eventHandler = new EventHandler();
        eventHandler.register();

    }
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        chatHandler = new ChatHandler();
        chatHandler.register();
    }
}
