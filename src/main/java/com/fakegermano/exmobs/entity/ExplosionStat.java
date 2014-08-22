package com.fakegermano.exmobs.entity;

import com.fakegermano.exmobs.handler.ConfigurationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

/**
 * Created by richard on 10/08/14.
 */
public class ExplosionStat implements IExtendedEntityProperties {

    private boolean isExplodable = ConfigurationHandler.isExplodable;
    private float explodingForce = ConfigurationHandler.explodingForce;
    public static final String IDENTIFIER = "ExplosionStat";
    public static final String NBT_IDENTIFIER = "explosionStat";

    public static void init(Entity entity) {
        entity.registerExtendedProperties(IDENTIFIER, new ExplosionStat());
    }

    public static ExplosionStat getExplosionStat(Entity entity) {
        return entity != null ? (ExplosionStat) entity.getExtendedProperties(IDENTIFIER) : null;
    }

    public boolean isExplodableValue() {
        return this.isExplodable;
    }
    public float getExplosionForce() { return  this.explodingForce; }
    @Override
    public void saveNBTData(NBTTagCompound compound) {
        compound.setBoolean(NBT_IDENTIFIER, isExplodable);
        compound.setFloat(NBT_IDENTIFIER, explodingForce);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        isExplodable = compound.getBoolean(NBT_IDENTIFIER);
        explodingForce = compound.getFloat(NBT_IDENTIFIER);
    }

    @Override
    public void init(Entity entity, World world) {
        /*
         * onEntityConstructing handles this.. Thanks hotelc for that insight =P
         */
    }
}
