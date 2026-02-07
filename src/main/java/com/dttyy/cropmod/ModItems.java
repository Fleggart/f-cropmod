package com.dttyy.cropmod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.dttyy.cropmod.item.ItemCornSeed;
import com.dttyy.cropmod.block.BlockCropBase;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = CropMod.MODID)
public class ModItems {
    public static final Map<String, Item> SEEDS = new HashMap<>();
    public static final Map<String, Item> CROPS = new HashMap<>();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // 注册种子 & 可吃的 crop
        for (CropType type : CropType.values()) {
            BlockCropBase cropBlock = ModBlocks.CROPS.get(type.getName());

            // 种子
            Item seed = new ItemCornSeed(cropBlock)
                .setRegistryName(CropMod.MODID, type.getName() + "_seed")
                .setTranslationKey(CropMod.MODID + "." + type.getName() + "_seed");
            SEEDS.put(type.getName(), seed);
            event.getRegistry().register(seed);

            // 成熟后掉落物（可吃）
            ItemFood cropFood = new ItemFood(4, 0.6F, false) // 默认 4 饥饿值 + 0.6 饱和度
                .setRegistryName(CropMod.MODID, type.getName())
                .setTranslationKey(CropMod.MODID + "." + type.getName());
            CROPS.put(type.getName(), cropFood);
            event.getRegistry().register(cropFood);

            // Block 对应的 ItemBlock，方便在物品栏拿
            event.getRegistry().register(new ItemBlock(cropBlock)
                .setRegistryName(cropBlock.getRegistryName()));
        }
    }
}
