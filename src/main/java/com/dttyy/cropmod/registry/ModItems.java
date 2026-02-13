package com.dttyy.cropmod.registry;

import com.dttyy.cropmod.data.CropType; import com.dttyy.cropmod.data.StemCropType; import com.dttyy.cropmod.crop.; import com.dttyy.cropmod.stem.;

import net.minecraft.item.Item; import net.minecraft.item.ItemBlock; import net.minecraftforge.event.RegistryEvent; import net.minecraftforge.fml.common.Mod; import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap; import java.util.Map;

@Mod.EventBusSubscriber(modid = "cropmod") public class ModItems {

public static final Map<String, Item> SEEDS = new HashMap<>();
public static final Map<String, Item> FOODS = new HashMap<>();
public static final Map<String, Item> STEM_SEEDS = new HashMap<>();

@SubscribeEvent
public static void registerItems(RegistryEvent.Register<Item> event) {

    for (CropType type : CropType.values()) {

        CropSeedItem seed = new CropSeedItem(ModBlocks.CROPS.get(type.getName()));
        seed.setRegistryName("cropmod", type.getName() + "_seed");
        SEEDS.put(type.getName(), seed);
        event.getRegistry().register(seed);

        CropFoodItem food = new CropFoodItem(type.getHunger(), type.getSaturation());
        food.setRegistryName("cropmod", type.getName() + "_food");
        FOODS.put(type.getName(), food);
        event.getRegistry().register(food);

        ItemBlock cropItem = new ItemBlock(ModBlocks.CROPS.get(type.getName()));
        cropItem.setRegistryName(ModBlocks.CROPS.get(type.getName()).getRegistryName());
        event.getRegistry().register(cropItem);
    }

    for (StemCropType type : StemCropType.values()) {

        StemSeedItem seed = new StemSeedItem(ModBlocks.STEMS.get(type.getName()));
        seed.setRegistryName("cropmod", type.getName() + "_seed");
        STEM_SEEDS.put(type.getName(), seed);
        event.getRegistry().register(seed);

        ItemBlock fruitItem = new ItemBlock(ModBlocks.FRUITS.get(type.getName()));
        fruitItem.setRegistryName(ModBlocks.FRUITS.get(type.getName()).getRegistryName());
        event.getRegistry().register(fruitItem);
    }
}

}
