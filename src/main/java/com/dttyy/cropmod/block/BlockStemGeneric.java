package com.dttyy.cropmod.block;

import net.minecraft.block.BlockStem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class BlockStemGeneric extends BlockStem {

    private Item seed;

    public BlockStemGeneric(Block fruit) {
        super(fruit);
    }

    public void setSeed(Item seed) {
        this.seed = seed;
    }

    @Override
    protected Item getSeedItem() {
        return seed;
    }
}
