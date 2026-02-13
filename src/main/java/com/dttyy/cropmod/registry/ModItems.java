package com.dttyy.cropmod.registry;

import com.dttyy.cropmod.ModConstants;
import com.dttyy.cropmod.data.CropType;
import com.dttyy.cropmod.data.StemCropType;
import com.dttyy.cropmod.item.*;
import com.dttyy.cropmod.block.*;

import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ModConstants.MODID)
public class ModItems {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> e) {

        for (CropType type : CropType.values()) {
            String name = type.getName();

            // 种子
            Item seed = new CropSeedItem(ModBlocks.CROPS.get(name));
            seed.setRegistryName(ModConstants.MODID, name + "_seed");
            seed.setTranslationKey(ModConstants.MODID + "." + name + "_seed");
            e.getRegistry().register(seed);

            // 食物
            Item food = new ItemFood(type.getHunger(), type.getSaturation(), false);
            food.setRegistryName(ModConstants.MODID, name + "_food");
            food.setTranslationKey(ModConstants.MODID + "." + name + "_food");
            e.getRegistry().register(food);

            // 作物方块的 Item
            ItemBlock cropItem = new ItemBlock(ModBlocks.CROPS.get(name));
            cropItem.setRegistryName(ModBlocks.CROPS.get(name).getRegistryName());
            cropItem.setTranslationKey(ModConstants.MODID + ".crop_" + name);
            e.getRegistry().register(cropItem);
        }

        for (StemCropType type : StemCropType.values()) {
            String name = type.getName();

            // 藤类种子
            Item stemSeed = new StemSeedItem(ModBlocks.STEMS.get(name));
            stemSeed.setRegistryName(ModConstants.MODID, name + "_seed");
            stemSeed.setTranslationKey(ModConstants.MODID + "." + name + "_seed");
            e.getRegistry().register(stemSeed);

            // 果实方块的 Item
            ItemBlock fruitItem = new ItemBlock(ModBlocks.FRUITS.get(name));
            fruitItem.setRegistryName(ModBlocks.FRUITS.get(name).getRegistryName());
            fruitItem.setTranslationKey(ModConstants.MODID + "." + name + "_fruit");
            e.getRegistry().register(fruitItem);
        }
    }
}
