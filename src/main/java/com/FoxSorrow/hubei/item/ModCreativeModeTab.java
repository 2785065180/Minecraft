package com.FoxSorrow.hubei.item;

import com.FoxSorrow.hubei.HuBei;
import com.FoxSorrow.hubei.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {

    public static final String TUTORIAL_TAB_STRING = "creativetab." + HuBei.MOD_ID + "_tab";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HuBei.MOD_ID);
    public static final RegistryObject<CreativeModeTab> HuBei_TAB = CREATIVE_MODE_TABS.register(HuBei.MOD_ID + "_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ZIRCON.get())).title(Component.translatable(TUTORIAL_TAB_STRING)).displayItems((pParameters, pOutput) -> {
        // 物品
        pOutput.accept(ModItems.ZIRCON.get());
        pOutput.accept(ModItems.RAW_ZIRCON.get());
        pOutput.accept(ModItems.EIGHT_BALL.get());
        //方块
        pOutput.accept(ModBlocks.DEEPSLATE_ZIRCON_ORE.get());
        pOutput.accept(ModBlocks.Jumpy_Block.get());
        pOutput.accept(ModBlocks.ZIRCON_ORE.get());
        pOutput.accept(ModBlocks.Jumpy_Block.get());
        // 原版-砖石
        pOutput.accept(Items.DIAMOND);
    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
