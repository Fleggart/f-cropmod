package com.dttyy.cropmod.item;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class StemSeedItem extends ItemSeeds {
    public StemSeedItem(Block stem) {
        super(stem, Blocks.FARMLAND);
    }
}
