package com.fakegermano.exmobs.handler;

import com.fakegermano.exmobs.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by richard on 10/08/14.
 */
public class ChatHandler {
    public void register() {
        FMLCommonHandler.instance().bus().register(this);
    }
    @SubscribeEvent
    public void onPlayerLoginModMessage(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = (EntityPlayer) event.player;
        player.addChatComponentMessage(new ChatComponentText(
                String.format("Exploding Mobs installed on version %s", Reference.VERSION)).
                setChatStyle(new ChatStyle().setColor(EnumChatFormatting.AQUA)));
        player.addChatComponentMessage(new ChatComponentText("Carefull, hostile mobs may explode when killed!").
                setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_RED)));
    }
}
