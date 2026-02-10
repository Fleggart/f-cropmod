package com.dttyy.cropmod.client;

import com.dttyy.cropmod.CropMod;
import com.dttyy.cropmod.CropType;
import com.dttyy.cropmod.ModBlocks;
import com.dttyy.cropmod.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = CropMod.MODID, value = Side.CLIENT)
public class ModelRegistration {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {

        for (CropType type : CropType.values()) {

            // 注册种子模型
            Item seed = ModItems.SEEDS.get(type.getName());
            ModelLoader.setCustomModelResourceLocation(
                    seed, 0,
                    new ModelResourceLocation(CropMod.MODID + ":" + type.getName() + "_seed", "inventory")
            );

            // 注册食物模型
            Item food = ModItems.FOODS.get(type.getName());
            ModelLoader.setCustomModelResourceLocation(
                    food, 0,
                    new ModelResourceLocation(CropMod.MODID + ":" + type.getName() + "_food", "inventory")
            );

            // 注册材料模型（如果有）
            if (ModItems.MATERIALS.containsKey(type.getName())) {
                Item mat = ModItems.MATERIALS.get(type.getName());
                ModelLoader.setCustomModelResourceLocation(
                        mat, 0,
                        new ModelResourceLocation(CropMod.MODID + ":" + type.getName() + "_item", "inventory")
                );
            }

            // 注册方块的 Item 模型
            Item cropItem = Item.getItemFromBlock(ModBlocks.CROPS.get(type.getName()));
            ModelLoader.setCustomModelResourceLocation(
                    cropItem, 0,
                    new ModelResourceLocation(CropMod.MODID + ":crop_" + type.getName(), "inventory")
            );
        }
    }
}
