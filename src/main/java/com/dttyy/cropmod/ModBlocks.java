package com.dttyy.cropmod;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.dttyy.cropmod.block.BlockCropBase;

import java.util.Map;

@Mod.EventBusSubscriber(modid = CropMod.MODID)
public class ModItems {

    public static final Map<String, Item> SEEDS = new java.util.HashMap<>();
    public static final Map<String, Item> CROPS = new java.util.HashMap<>();

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
}