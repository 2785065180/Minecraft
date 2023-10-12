package com.FoxSorrow.hubei.datahen;

import com.FoxSorrow.hubei.HuBei;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HuBei.MOD_ID,bus= Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();

        ExistingFileHelper helper = event.getExistingFileHelper();
        //  forge doc
        generator.addProvider(event.includeClient(),new ModItemModelGen(output, helper));
        generator.addProvider(event.includeClient(),new ModBlockModelGen(output, helper));
        generator.addProvider(event.includeClient(),new ModUSLangGen(output,"en_us"));
        generator.addProvider(event.includeClient(),new ModCNLangGen(output,"zh_cn"));
    }
}
