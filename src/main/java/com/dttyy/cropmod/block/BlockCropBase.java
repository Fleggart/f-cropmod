package com.dttyy.cropmod.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
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
        return ModItems.FOODS.get(cropName);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, net.minecraft.util.math.BlockPos pos,
                         net.minecraft.block.state.IBlockState state, int fortune) {

        super.getDrops(drops, world, pos, state, fortune);

        if (ModItems.MATERIALS.containsKey(cropName)) {
            drops.add(new ItemStack(ModItems.MATERIALS.get(cropName)));
        }
    }
}
