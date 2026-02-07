package com.dttyy.cropmod;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.dttyy.cropmod.item.ItemCornSeed;
import com.dttyy.cropmod.block.BlockCropBase;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = CropMod.MODID)
public class ModItems {   // ← 必须有类声明

    public static final Map<String, Item> SEEDS = new HashMap<>();
    public static final Map<String, Item> CROPS = new HashMap<>();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (CropType type : CropType.values()) {

            BlockCropBase cropBlock = ModBlocks.CROPS.get(type.getName());

            Item seed = new ItemCornSeed(cropBlock)
                .setRegistryName(CropMod.MODID, type.getName() + "_seed")
                .setTranslationKey(CropMod.MODID + "." + type.getName() + "_seed");

            Item cropItem = new Item()
                .setRegistryName(CropMod.MODID, type.getName())
                .setTranslationKey(CropMod.MODID + "." + type.getName());

            SEEDS.put(type.getName(), seed);
            CROPS.put(type.getName(), cropItem);

            event.getRegistry().register(seed);
            event.getRegistry().register(cropItem);
        }
    }
}