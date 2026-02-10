package com.dttyy.cropmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CropMod.MODID, name = CropMod.NAME, version = CropMod.VERSION)
public class CropMod {
    public static final String MODID = "cropmod";
    public static final String NAME = "Crop Mod";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "com.dttyy.cropmod.ClientProxy",
                serverSide = "com.dttyy.cropmod.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.registerModels();
    }
}
