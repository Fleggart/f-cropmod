package com.dttyy.cropmod;
import com.dttyy.cropmod.item.ItemCornSeed;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = "cropmod")
public class ModItems {

    public static ItemCornSeed cornSeed;
    public static Item corn;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        cornSeed = new ItemCornSeed();

        corn = new Item()
                .setRegistryName("cropmod", "corn")
                .setTranslationKey("cropmod.corn");

        event.getRegistry().registerAll(cornSeed, corn);
    }
}
