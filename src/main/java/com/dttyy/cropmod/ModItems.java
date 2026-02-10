package com.dttyy.cropmod;

import com.dttyy.cropmod.block.BlockCropBase;
import com.dttyy.cropmod.item.CropFoodItem;
import com.dttyy.cropmod.item.CropMaterialItem;
import com.dttyy.cropmod.item.CropSeedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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

            CropSeedItem seed = new CropSeedItem(cropBlock);
            seed.setRegistryName(CropMod.MODID, type.getName() + "_seed");
            seed.setTranslationKey(CropMod.MODID + "." + type.getName() + "_seed");
            SEEDS.put(type.getName(), seed);
            event.getRegistry().register(seed);

            CropFoodItem foodItem = new CropFoodItem(type.getHunger(), type.getSaturation(), false);
            foodItem.setRegistryName(CropMod.MODID, type.getName() + "_food");
            foodItem.setTranslationKey(CropMod.MODID + "." + type.getName() + "_food");
            FOODS.put(type.getName(), foodItem);
            event.getRegistry().register(foodItem);

            if (type.hasMaterial()) {
                CropMaterialItem item = new CropMaterialItem();
                item.setRegistryName(CropMod.MODID, type.getName() + "_item");
                item.setTranslationKey(CropMod.MODID + "." + type.getName() + "_item");
                MATERIALS.put(type.getName(), item);
                event.getRegistry().register(item);
            }

            ItemBlock ib = new ItemBlock(cropBlock);
            ib.setRegistryName(cropBlock.getRegistryName());
            event.getRegistry().register(ib);
        }
    }
}
