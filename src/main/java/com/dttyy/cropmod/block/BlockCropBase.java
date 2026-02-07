package com.dttyy.cropmod.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import com.dttyy.cropmod.ModItems;

public class BlockCropBase extends BlockCrops {

    private final String cropName;

    public BlockCropBase(String name) {
        this.cropName = name;
        setRegistryName("cropmod", "crop_" + name);
        setTranslationKey("cropmod.crop_" + name);
    }

    @Override
    protected Item getSeed() {
        return ModItems.SEEDS.get(cropName);
    }

    @Override
    protected Item getCrop() {
        return ModItems.CROPS.get(cropName);
    }
}