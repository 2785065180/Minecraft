package com.FoxSorrow.hubei.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class MySwordItem extends SwordItem {

    public MySwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        // 发送消息给被攻击者（自己）
        if (pTarget instanceof Player player) {
            player.sendSystemMessage(Component.nullToEmpty("你被攻击了！" + player.getName()));
        }

        // 发送消息给攻击者
        if (pAttacker instanceof Player attacker) {
            attacker.sendSystemMessage(Component.nullToEmpty("你攻击了！"+attacker.getName()));
        }

        return true;
    }

}
