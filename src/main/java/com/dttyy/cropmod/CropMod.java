package com.dttyy.cropmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CropMod.MODID, name = CropMod.NAME, version = CropMod.VERSION)
public class CropMod {

    public static final String MODID = "cropmod";
    public static final String NAME = "Crop Mod";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // 不需要主动注册块或物品
        // 注册已由 ModBlocks 与 ModItems 自动完成
    }
}
