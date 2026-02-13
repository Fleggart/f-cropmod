package com.dttyy.cropmod.registry;

import net.minecraftforge.client.event.ModelRegistryEvent; import net.minecraftforge.fml.common.Mod; import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = "cropmod", value = net.minecraftforge.fml.relauncher.Side.CLIENT) public class ModelRegistration {

@SubscribeEvent
public static void registerModels(ModelRegistryEvent event) {
    // 自行按需要注册模型
}

}
