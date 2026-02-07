package com.dttyy.cropmod;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = "cropmod")
public class ModItems {

    public static Item cornSeed;
    public static Item corn;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        cornSeed = new Item()
                .setRegistryName("cropmod", "corn_seed")
                .setUnlocalizedName("corn_seed");

        corn = new Item()
                .setRegistryName("cropmod", "corn")
                .setUnlocalizedName("corn");

        event.getRegistry().registerAll(cornSeed, corn);
    }
}
