package com.dttyy.cropmod.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCropGeneric extends BlockCrops {

    private final Item seed;
    private final Item crop;

    public BlockCropGeneric(Item seed, Item crop) {
        this.seed = seed;
        this.crop = crop;
    }

    @Override
    protected Item getSeed() {
        return seed;
    }

    @Override
    protected Item getCrop() {
        return crop;
    }
}
