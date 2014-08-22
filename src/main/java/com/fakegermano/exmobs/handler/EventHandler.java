package com.fakegermano.exmobs.handler;


import com.fakegermano.exmobs.entity.ExplosionStat;
import com.fakegermano.exmobs.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.Random;


/**
 * Created by richard on 10/08/14.
 */
public class EventHandler {
    public static Random random = new Random();

    public void register() {
        MinecraftForge.EVENT_BUS.register(this);

    }

    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event){
        if (event.entity instanceof EntityMob) {
            ExplosionStat.init(event.entity);
        }
    }

    @SubscribeEvent
    public void onEntityDeath(LivingDeathEvent event) {
        if (event.entity instanceof EntityMob) {
            ExplosionStat stat = ExplosionStat.getExplosionStat(event.entity);
            if (stat.isExplodableValue()) {
                // int trololo = random.nextInt();
                explode(event.entity, stat.getExplosionForce());
            }
        }
    }

    private void explode(Entity entity, float force) {
        entity.worldObj.createExplosion(entity, entity.posX, entity.posY, entity.posZ, force, true);
    }




}
