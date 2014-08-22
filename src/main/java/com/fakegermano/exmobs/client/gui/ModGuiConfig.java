package com.fakegermano.exmobs.client.gui;

import com.fakegermano.exmobs.handler.ConfigurationHandler;
import com.fakegermano.exmobs.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by richard on 09/08/14.
 */
public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig(GuiScreen parentScreen) {
        super(parentScreen, new ConfigElement(ConfigurationHandler.configuration.getCategory(
                        Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.MODID, false, false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
