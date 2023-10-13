package com.FoxSorrow.hubei.datahen;

import com.FoxSorrow.hubei.HuBei;
import com.FoxSorrow.hubei.block.ModBlocks;
import com.FoxSorrow.hubei.item.ModCreativeModeTab;
import com.FoxSorrow.hubei.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModCNLangGen extends LanguageProvider {
    public ModCNLangGen(PackOutput output, String locale) {
        super(output, HuBei.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModCreativeModeTab.TUTORIAL_TAB_STRING,"我的工具栏");
        add(ModItems.ZIRCON.get(), "可以吃的黑曜石锭");
        add(ModItems.EIGHT_BALL .get(), "随机数物品");
        add(ModItems.RAW_ZIRCON.get(), "黑曜石锭");
        add(ModBlocks.DEEPSLATE_ZIRCON_ORE.get(),"继承石头的方块");
        add(ModBlocks.Jumpy_Block.get(),"效果方块");
        add(ModBlocks.ZIRCON_ORE.get(),"继承泥土的方块");
        add(ModBlocks.ZIRCON_LAMP.get(),"发光方块");

    }
}