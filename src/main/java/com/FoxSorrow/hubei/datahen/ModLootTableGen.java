package com.FoxSorrow.hubei.datahen;

import com.FoxSorrow.hubei.HuBei;
import com.FoxSorrow.hubei.block.ModBlocks;
import com.FoxSorrow.hubei.item.ModItems;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.stream.Collectors;


public class ModLootTableGen extends VanillaBlockLoot {


    @Override
    protected void generate() {
        //掉落自己
        dropSelf(ModBlocks.Jumpy_Block.get());
        dropSelf(ModBlocks.ZIRCON_LAMP.get());
        //掉落设置的方块

        add(ModBlocks.ZIRCON_ORE.get(), createZirconOreDrops(ModBlocks.ZIRCON_ORE.get(), ModItems.RAW_ZIRCON.get()));
        add(ModBlocks.DEEPSLATE_ZIRCON_ORE.get(), createZirconOreDrops(ModBlocks.DEEPSLATE_ZIRCON_ORE.get(), ModItems.ZIRCON.get()));
    }

    protected LootTable.Builder createZirconOreDrops(Block pBlock, Item ModName) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModName).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 9.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream().filter(e -> e.getKey().location().getNamespace().equals(HuBei.MOD_ID)).map(Map.Entry::getValue).collect(Collectors.toList());
    }

}