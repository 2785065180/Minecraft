package com.FoxSorrow.hubei.datahen;

import com.FoxSorrow.hubei.HuBei;
import com.FoxSorrow.hubei.block.ModBlocks;
import com.FoxSorrow.hubei.item.ModItems;
import com.FoxSorrow.hubei.item.ModCreativeModeTab;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModCNLangGen extends LanguageProvider {
    public ModCNLangGen(PackOutput output, String locale) {
        super(output, HuBei.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.ZIRCON.get(), "可以吃的黑曜石锭");
        add(ModItems.RAW_ZIRCON.get(), "黑曜石锭");
        add(ModBlocks.DEEPSLATE_ZIRCON_ORE.get(),"DEEPSLATE_ZIRCON_ORE");
        add(ModBlocks.ZIRCON_ORE.get(),"ZIRCON_ORE");
        add(ModBlocks.ZIRCON_BLOCK.get(),"ZIRCON_BLOCK");
        add(ModCreativeModeTab.TUTORIAL_TAB_STRING,"我的工具栏");
    }
}