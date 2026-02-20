package com.dttyy.cropmod.registry;

import com.dttyy.cropmod.CropMod;
import com.dttyy.cropmod.data.CropType;
import com.dttyy.cropmod.item.CropSeedItem;
import com.dttyy.cropmod.block.BlockCropGeneric;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = CropMod.MODID)
public class ModItems {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> e) {

        for (CropType type : CropType.values()) {
            String name = type.getName();

            // 注册种子
            Item seed = new CropSeedItem(ModBlocks.CROPS.get(name));
            seed.setRegistryName(CropMod.MODID, name + "_seed");
            seed.setTranslationKey(CropMod.MODID + "." + name + "_seed");
            e.getRegistry().register(seed);

            // 注册食物
            Item food = new ItemFood(type.getHunger(), type.getSaturation(), false);
            food.setRegistryName(CropMod.MODID, name + "_food");
            food.setTranslationKey(CropMod.MODID + "." + name + "_food");
            e.getRegistry().register(food);

            // 注册作物方块物品
            ItemBlock cropItem = new ItemBlock(ModBlocks.CROPS.get(name));
            cropItem.setRegistryName(ModBlocks.CROPS.get(name).getRegistryName());
            cropItem.setTranslationKey(CropMod.MODID + ".crop_" + name);
            e.getRegistry().register(cropItem);
        }
    }
}
