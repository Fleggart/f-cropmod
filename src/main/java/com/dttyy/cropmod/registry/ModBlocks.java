package com.dttyy.cropmod.registry;

import com.dttyy.cropmod.ModConstants;
import com.dttyy.cropmod.block.BlockCropGeneric;
import com.dttyy.cropmod.block.BlockStemGeneric;
import com.dttyy.cropmod.block.BlockFruitGeneric;
import com.dttyy.cropmod.data.CropType;
import com.dttyy.cropmod.data.StemCropType;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = ModConstants.MODID)
public class ModBlocks {

    public static final Map<String, BlockCropGeneric> CROPS = new HashMap<>();
    public static final Map<String, BlockStemGeneric> STEMS = new HashMap<>();
    public static final Map<String, BlockFruitGeneric> FRUITS = new HashMap<>();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        // 注册普通作物方块
        for (CropType type : CropType.values()) {
            String name = type.getName();

            BlockCropGeneric crop = new BlockCropGeneric(name);
            crop.setRegistryName(ModConstants.MODID, "crop_" + name);
            // translationKey 用于翻译，在 lang 文件中定义 tile.cropmod.crop_xxx.name
            crop.setTranslationKey(ModConstants.MODID + ".crop_" + name);
            crop.setCreativeTab(CreativeTabs.MATERIALS);

            CROPS.put(name, crop);
            event.getRegistry().register(crop);
        }

        // 注册藤类作物（果实 + 茎）
        for (StemCropType type : StemCropType.values()) {
            String name = type.getName();

            // 果实方块
            BlockFruitGeneric fruit = new BlockFruitGeneric();
            fruit.setRegistryName(ModConstants.MODID, name + "_fruit");
            fruit.setTranslationKey(ModConstants.MODID + ".fruit_" + name);
            fruit.setCreativeTab(CreativeTabs.MATERIALS);

            FRUITS.put(name, fruit);
            event.getRegistry().register(fruit);

            // 茎方块
            BlockStemGeneric stem = new BlockStemGeneric(fruit);
            stem.setRegistryName(ModConstants.MODID, name + "_stem");
            stem.setTranslationKey(ModConstants.MODID + ".stem_" + name);
            stem.setCreativeTab(CreativeTabs.MATERIALS);

            STEMS.put(name, stem);
            event.getRegistry().register(stem);
        }
    }
}
