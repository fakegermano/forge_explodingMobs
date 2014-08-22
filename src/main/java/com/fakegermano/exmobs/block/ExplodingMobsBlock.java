package com.fakegermano.exmobs.block;


import com.fakegermano.exmobs.ExplodingMobs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by richard on 09/08/14.
 */
public class ExplodingMobsBlock extends Block {

    protected ExplodingMobsBlock(Material material) {
        super(material);
    }

    public ExplodingMobsBlock() {
        super(Material.rock);
    }
}
