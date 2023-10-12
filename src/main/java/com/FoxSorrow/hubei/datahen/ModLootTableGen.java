package com.FoxSorrow.hubei.datahen;

import com.FoxSorrow.hubei.block.ModBlocks;
import com.FoxSorrow.hubei.item.ModItems;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModLootTableGen extends VanillaBlockLoot {

    @Override
    protected void generate() {
        //掉落自己
        dropSelf(ModBlocks.ZIRCON_BLOCK.get());
        //掉落矿物
        add(ModBlocks.ZIRCON_ORE.get(), this::createZirconOreDrops);
        add(ModBlocks.DEEPSLATE_ZIRCON_ORE.get(), this::createZirconOreDrops);
    }


    protected LootTable.Builder createZirconOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.ZIRCON.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 9.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
}
