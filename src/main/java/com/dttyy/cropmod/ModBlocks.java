package com.dttyy.cropmod;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.dttyy.cropmod.block.BlockCropBase;
import java.util.HashMap;
import java.util.Map;

@SubscribeEvent
public static void registerItems(RegistryEvent.Register<Item> event) {

    for (CropType type : CropType.values()) {
        BlockCropBase cropBlock = ModBlocks.CROPS.get(type.getName());

        Item seed = new ItemCornSeed(cropBlock);

        Item cropItem = new Item()
            .setRegistryName("cropmod", type.getName())
            .setTranslationKey("cropmod." + type.getName());

        SEEDS.put(type.getName(), seed);
        CROPS.put(type.getName(), cropItem);

        event.getRegistry().register(seed);
        event.getRegistry().register(cropItem);
    }
}