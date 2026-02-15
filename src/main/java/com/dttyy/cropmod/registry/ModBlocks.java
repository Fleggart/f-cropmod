package com.dttyy.cropmod.registry;

import com.dttyy.cropmod.CropMod;
import com.dttyy.cropmod.block.BlockCropGeneric;
import com.dttyy.cropmod.block.BlockStemGeneric;
import com.dttyy.cropmod.block.BlockFruitGeneric;
import com.dttyy.cropmod.data.CropType;
import com.dttyy.cropmod.data.StemCropType;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = CropMod.MODID)
public class ModBlocks {

    public static final Map<String, BlockCropGeneric> CROPS = new HashMap<>();
    public static final Map<String, BlockStemGeneric> STEMS = new HashMap<>();
    public static final Map<String, BlockFruitGeneric> FRUITS = new HashMap<>();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        for (CropType type : CropType.values()) {
            String name = type.getName();

            BlockCropGeneric crop = new BlockCropGeneric(name);
            crop.setRegistryName(CropMod.MODID, "crop_" + name);
            crop.setTranslationKey(CropMod.MODID + ".crop_" + name);
            crop.setCreativeTab(CreativeTabs.MATERIALS);

            CROPS.put(name, crop);
            event.getRegistry().register(crop);
        }

        for (StemCropType type : StemCropType.values()) {
            String name = type.getName();

            BlockFruitGeneric fruit = new BlockFruitGeneric();
            fruit.setRegistryName(CropMod.MODID, name + "_fruit");
            fruit.setTranslationKey(CropMod.MODID + ".fruit_" + name);
            fruit.setCreativeTab(CreativeTabs.MATERIALS);

            FRUITS.put(name, fruit);
            event.getRegistry().register(fruit);

            BlockStemGeneric stem = new BlockStemGeneric(fruit);
            stem.setRegistryName(CropMod.MODID, name + "_stem");
            stem.setTranslationKey(CropMod.MODID + ".stem_" + name);
            stem.setCreativeTab(CreativeTabs.MATERIALS);

            STEMS.put(name, stem);
            event.getRegistry().register(stem);
        }
    }
}
