package com.FoxSorrow.hubei;


import com.FoxSorrow.hubei.block.ModBlocks;
import com.FoxSorrow.hubei.item.ModCreativeModeTab;
import com.FoxSorrow.hubei.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(HuBei.MOD_ID)
public class HuBei {
    public static final String MOD_ID = "hubei";
    //public static final Logger LOGGER = LogUtils.getLogger();

    public HuBei() {
        //发送一条信息
        MinecraftForge.EVENT_BUS.addListener(PlayerLoggedInHandler::onLivingHurt);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // item
        ModItems.register(modEventBus);
        //block
        ModBlocks.register(modEventBus);
        ModCreativeModeTab.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

    }

    public static class PlayerLoggedInHandler {
        public static void onLivingHurt(LivingHurtEvent event) {
            if (event.getEntity() instanceof Sheep) {
                if (event.getSource().getEntity() instanceof Player player) {
                    if (player.getMainHandItem().getItem() == Items.BEEF) {
                        player.sendSystemMessage(Component.literal(player.getName().getString() + " 使用牛肉攻击了羊"));
                    } else {
                        player.sendSystemMessage(Component.literal(player.getName().getString() + " 攻击了羊!"));
                    }
                }
            }
        }
    }
}