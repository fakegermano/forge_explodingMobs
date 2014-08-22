package com.fakegermano.exmobs.handler;

import com.fakegermano.exmobs.reference.Reference;
import com.fakegermano.exmobs.utility.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by richard on 08/08/14.
 */
public class ConfigurationHandler
{
    public static Configuration configuration;
    public static boolean isExplodable = true;
    public static float explodingForce = 2.0F;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            syncConfiguration();
        }
    }
    private static void syncConfiguration()
    {
        isExplodable= configuration.getBoolean("isExplodable", Configuration.CATEGORY_GENERAL,
                isExplodable, "By setting this to true you enable mob on death explosion");
        explodingForce = configuration.getFloat("explosingForce", Configuration.CATEGORY_GENERAL,
                explodingForce, 2.0F, 10.0F, "By setting this you alter the explosion blast force");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MODID))
        {
            syncConfiguration();
        }
    }
}