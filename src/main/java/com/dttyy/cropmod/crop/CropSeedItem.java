package com.dttyy.cropmod.crop;

import net.minecraft.block.Block; import net.minecraft.init.Blocks; import net.minecraft.item.ItemSeeds;

public class CropSeedItem extends ItemSeeds { public CropSeedItem(Block crop) { super(crop, Blocks.FARMLAND); } }
