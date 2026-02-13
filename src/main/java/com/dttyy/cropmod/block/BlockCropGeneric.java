package com.dttyy.cropmod.block;

import com.dttyy.cropmod.registry.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCropGeneric extends BlockCrops {

    private final String name;

    public BlockCropGeneric(String name) {
        this.name = name;

        setRegistryName("cropmod", "crop_" + name);
        setTranslationKey("cropmod.crop_" + name);
    }

    @Override
    protected Item getSeed() {
        return ModItems.SEEDS.get(name);
    }

    @Override
    protected Item getCrop() {
        return ModItems.FOODS.get(name);
    }
}
