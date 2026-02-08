package com.dttyy.cropmod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.dttyy.cropmod.block.BlockCropBase;
import com.dttyy.cropmod.item.ItemCornSeed;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = CropMod.MODID)
public class ModItems {
    public static final Map<String, Item> SEEDS = new HashMap<>();
    public static final Map<String, ItemFood> FOODS = new HashMap<>();
    public static final Map<String, Item> NORMALS = new HashMap<>();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (CropType type : CropType.values()) {
            BlockCropBase cropBlock = ModBlocks.CROPS.get(type.getName());

            // 种子
            Item seed = new ItemCornSeed(cropBlock)
                .setRegistryName(CropMod.MODID, type.getName() + "_seed")
                .setTranslationKey(CropMod.MODID + "." + type.getName() + "_seed");
            SEEDS.put(type.getName(), seed);
            event.getRegistry().register(seed);

            // 可食用果实
            ItemFood food = new ItemFood(type.getHunger(), type.getSaturation(), false);
            food.setRegistryName(CropMod.MODID, type.getName() + "_food");
            food.setTranslationKey(CropMod.MODID + "." + type.getName() + "_food");
            FOODS.put(type.getName(), food);
            event.getRegistry().register(food);

            // 普通果实（材料/工具用途）
            Item normal = new Item()
                .setRegistryName(CropMod.MODID, type.getName() + "_item")
                .setTranslationKey(CropMod.MODID + "." + type.getName() + "_item");
            NORMALS.put(type.getName(), normal);
            event.getRegistry().register(normal);

            // 注册 ItemBlock 使作物方块显示正常
            event.getRegistry().register(new ItemBlock(cropBlock)
                .setRegistryName(cropBlock.getRegistryName()));
        }
    }
}
