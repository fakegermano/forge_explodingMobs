package com.fakegermano.exmobs.creativetab;

import com.fakegermano.exmobs.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by richard on 09/08/14.
 */
public class CreativeTabExplodingMobs {
    public static final CreativeTabs tabExplodingMobs = new CreativeTabs(Reference.MODID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return null;
        }
    };
}
