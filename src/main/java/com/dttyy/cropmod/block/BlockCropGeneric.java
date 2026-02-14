package com.dttyy.cropmod.block;

import com.dttyy.cropmod.ModConstants;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCropGeneric extends BlockCrops {

    private final String name;

    public BlockCropGeneric(String name) {
        this.name = name;

        // 不要在这里设置 registryName
        setTranslationKey(ModConstants.MODID + ".crop_" + name);
    }

    @Override
    protected Item getSeed() {
        return Item.getByNameOrId(ModConstants.MODID + ":" + name + "_seed");
    }

    @Override
    protected Item getCrop() {
        return Item.getByNameOrId(ModConstants.MODID + ":" + name + "_food");
    }
}
