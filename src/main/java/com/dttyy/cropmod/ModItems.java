package com.dttyy.cropmod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.dttyy.cropmod.block.BlockCropBase;
import com.dttyy.cropmod.item.CropSeedItem;
import com.dttyy.cropmod.item.CropFoodItem;
import com.dttyy.cropmod.item.CropMaterialItem;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = CropMod.MODID)
public class ModItems {

    public static final Map<String, Item> SEEDS = new HashMap<>();
    public static final Map<String, ItemFood> FOODS = new HashMap<>();
    public static final Map<String, Item> MATERIALS = new HashMap<>();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        for (CropType type : CropType.values()) {

            BlockCropBase cropBlock = ModBlocks.CROPS.get(type.getName());

            // 种子
            Item seed = new CropSeedItem(cropBlock)
                .setRegistryName(CropMod.MODID, type.getName() + "_seed")
                .setTranslationKey(CropMod.MODID + "." + type.getName() + "_seed");
            SEEDS.put(type.getName(), seed);
            event.getRegistry().register(seed);

            // 可食用果实
            ItemFood foodItem = new CropFoodItem(type.getHunger(), type.getSaturation(), false)
                .setRegistryName(CropMod.MODID, type.getName() + "_food")
                .setTranslationKey(CropMod.MODID + "." + type.getName() + "_food");
            FOODS.put(type.getName(), foodItem);
            event.getRegistry().register(foodItem);

            // 普通材料
            if (type.hasMaterial()) {
                Item materialItem = new CropMaterialItem()
                    .setRegistryName(CropMod.MODID, type.getName() + "_item")
                    .setTranslationKey(CropMod.MODID + "." + type.getName() + "_item");
                MATERIALS.put(type.getName(), materialItem);
                event.getRegistry().register(materialItem);
            }

            // 注册方块对应的 ItemBlock
            event.getRegistry().register(new ItemBlock(cropBlock)
                .setRegistryName(cropBlock.getRegistryName()));
        }
    }
}
