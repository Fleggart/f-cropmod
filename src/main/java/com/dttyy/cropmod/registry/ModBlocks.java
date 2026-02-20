package com.dttyy.cropmod.registry;

import com.dttyy.cropmod.CropMod;
import com.dttyy.cropmod.block.BlockCropGeneric;
import com.dttyy.cropmod.data.CropType;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = CropMod.MODID)
public class ModBlocks {

    public static final Map<String, BlockCropGeneric> CROPS = new HashMap<>();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        for (CropType type : CropType.values()) {
            String name = type.getName();

            BlockCropGeneric crop = new BlockCropGeneric(name);
            crop.setRegistryName(CropMod.MODID, "crop_" + name);
            crop.setTranslationKey(CropMod.MODID + ".crop_" + name);
            crop.setCreativeTab(CreativeTabs.MATERIALS);

            CROPS.put(name, crop);
            event.getRegistry().register(crop);
        }
    }
}
