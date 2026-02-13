package com.dttyy.cropmod.registry;

import com.dttyy.cropmod.ModConstants;
import com.dttyy.cropmod.block.*;
import com.dttyy.cropmod.data.*;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.*;

@Mod.EventBusSubscriber(modid = ModConstants.MODID)
public class ModBlocks {

    public static final Map<String, BlockCropGeneric> CROPS = new HashMap<>();
    public static final Map<String, BlockStemGeneric> STEMS = new HashMap<>();
    public static final Map<String, BlockFruitGeneric> FRUITS = new HashMap<>();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> e) {

        for (CropType type : CropType.values()) {
            BlockCropGeneric crop = new BlockCropGeneric();
            crop.setRegistryName(ModConstants.MODID, "crop_" + type.getName());
            CROPS.put(type.getName(), crop);
            e.getRegistry().register(crop);
        }

        for (StemCropType type : StemCropType.values()) {

            BlockFruitGeneric fruit = new BlockFruitGeneric();
            fruit.setRegistryName(ModConstants.MODID, type.getName());
            FRUITS.put(type.getName(), fruit);
            e.getRegistry().register(fruit);

            CropSeedItem seed = new CropSeedItem(ModBlocks.CROPS.get(type.getName()));
seed.setRegistryName(ModConstants.MODID, type.getName() + "_seed");
seed.setTranslationKey(ModConstants.MODID + "." + type.getName() + "_seed");
event.getRegistry().register(seed);
SEEDS.put(type.getName(), seed);

            CropFoodItem food = new CropFoodItem(type.getHunger(), type.getSaturation());
food.setRegistryName(ModConstants.MODID, type.getName() + "_food");
food.setTranslationKey(ModConstants.MODID + "." + type.getName() + "_food");
event.getRegistry().register(food);
FOODS.put(type.getName(), food);
            
            BlockStemGeneric stem = new BlockStemGeneric(fruit);
            stem.setRegistryName(ModConstants.MODID, type.getName() + "_stem");
            STEMS.put(type.getName(), stem);
            e.getRegistry().register(stem);
        }
    }
}
