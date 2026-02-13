package com.dttyy.cropmod.registry;

import com.dttyy.cropmod.ModConstants;
import com.dttyy.cropmod.data.*;
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

            BlockCropGeneric crop = ModBlocks.CROPS.get(type.getName());

            Item seed = new CropSeedItem(crop)
                    .setRegistryName(ModConstants.MODID, type.getName() + "_seed");

            Item food = new ItemFood(3, 0.6f, false)
                    .setRegistryName(ModConstants.MODID, type.getName());

            crop.setItems(seed, food);

            e.getRegistry().register(seed);
            e.getRegistry().register(food);
        }

        for (StemCropType type : StemCropType.values()) {

            BlockStemGeneric stem = ModBlocks.STEMS.get(type.getName());

            Item seed = new StemSeedItem(stem)
                    .setRegistryName(ModConstants.MODID, type.getName() + "_seed");

            stem.setSeed(seed);

            e.getRegistry().register(seed);
        }
    }
}
