package com.FoxSorrow.hubei.datahen;

import com.FoxSorrow.hubei.HuBei;
import com.FoxSorrow.hubei.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockModelGen  extends BlockStateProvider {

    public ModBlockModelGen(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HuBei.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.registerBlockModelAndItem(ModBlocks.DEEPSLATE_ZIRCON_ORE.get());
        this.registerBlockModelAndItem(ModBlocks.ZIRCON_ORE.get());
        this.registerBlockModelAndItem(ModBlocks.Jumpy_Block.get());
    }

    public void registerBlockModelAndItem(Block block) {
        this.simpleBlockWithItem(block, this.cubeAll(block));
    }
}