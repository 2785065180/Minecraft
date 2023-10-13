package com.FoxSorrow.hubei.item;

import com.FoxSorrow.hubei.HuBei;
import com.FoxSorrow.hubei.item.custom.EightBallItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HuBei.MOD_ID);

    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)                // 设置营养价值3
                    .saturationMod(0.01f)// 设置饱食度
                    .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 20*30, 1), 1f)//添加药水效果
                    .build())));
    public static final RegistryObject<Item> EIGHT_BALL  = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties().stacksTo(1)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
