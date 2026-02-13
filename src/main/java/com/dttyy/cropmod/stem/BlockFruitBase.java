package com.dttyy.cropmod.stem;

import net.minecraft.block.Block; import net.minecraft.block.material.Material;

public class BlockFruitBase extends Block {

public BlockFruitBase(String name) {
    super(Material.GOURD);
    setRegistryName("cropmod", name);
    setTranslationKey("cropmod." + name);
    setHardness(1.0F);
}

}
