package com.dttyy.cropmod.registry;

import com.dttyy.cropmod.ModConstants;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = ModConstants.MODID, value = Side.CLIENT)
public class ModelRegistration {

ModelLoader.setCustomModelResourceLocation(
    seed, 0,
    new ModelResourceLocation("cropmod:" + type.getName() + "_seed", "inventory")
);
    
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent e) {
    }
}
