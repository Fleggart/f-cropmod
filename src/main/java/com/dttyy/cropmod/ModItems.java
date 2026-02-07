package com.dttyy.cropmod;

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

    // 默认食物恢复值（统一）
    private static final int DEFAULT_HUNGER = 4;
    private static final float DEFAULT_SATURATION = 0.6F;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (CropType type : CropType.values()) {
            BlockCropBase cropBlock = ModBlocks.CROPS.get(type.getName());

            // 注册种子
            Item seed = new ItemCornSeed(cropBlock)
                .setRegistryName(CropMod.MODID, type.getName() + "_seed")
                .setTranslationKey(CropMod.MODID + "." + type.getName() + "_seed");
            SEEDS.put(type.getName(), seed);
            event.getRegistry().register(seed);

            // 决定饥饿/饱和度是 enum 给的还是默认
            int hunger = type.hasCustomFood() ? type.getHunger() : DEFAULT_HUNGER;
            float saturation = type.hasCustomFood() ? type.getSaturation() : DEFAULT_SATURATION;

            // 成熟物品（可吃）
            ItemFood cropFood = new ItemFood(hunger, saturation, false)
                .setRegistryName(CropMod.MODID, type.getName())
                .setTranslationKey(CropMod.MODID + "." + type.getName());

            CROPS.put(type.getName(), cropFood);
            event.getRegistry().register(cropFood);

            // 注册作物方块对应的 ItemBlock
            event.getRegistry().register(new ItemBlock(cropBlock)
                .setRegistryName(cropBlock.getRegistryName()));
        }
    }
}
