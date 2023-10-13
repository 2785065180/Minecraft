package com.FoxSorrow.hubei.datahen;

import com.FoxSorrow.hubei.HuBei;
import com.FoxSorrow.hubei.block.ModBlocks;
import com.FoxSorrow.hubei.block.custom.ZirconLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;


public class ModBlockModelGen extends BlockStateProvider {

    public ModBlockModelGen(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HuBei.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.registerBlockModelAndItem(ModBlocks.DEEPSLATE_ZIRCON_ORE.get());
        this.registerBlockModelAndItem(ModBlocks.ZIRCON_ORE.get());
        this.registerBlockModelAndItem(ModBlocks.Jumpy_Block.get());
        registerProcessor(ModBlocks.ZIRCON_LAMP.get());
    }

    public void registerBlockModelAndItem(Block block) {
        this.simpleBlockWithItem(block, this.cubeAll(block));
    }

    private void registerProcessor(Block block) {
        ModelFile offModel = models().cubeAll(name(block) + "_off", blockTextureSuffix(block, "_off"));
        ModelFile onModel = models().cubeAll(name(block) + "_on", blockTextureSuffix(block, "_on"));

        getVariantBuilder(block).partialState().with(ZirconLampBlock.LIT, true).modelForState().modelFile(onModel).addModel()
                .partialState().with(ZirconLampBlock.LIT, false).modelForState().modelFile(offModel).addModel();

        simpleBlockItem(block, offModel);
    }
    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    public ResourceLocation blockTextureSuffix(Block block, String suffix) {
        ResourceLocation name = key(block);
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath() + suffix);
    }

    private String name(Block block) {
        return key(block).getPath();
    }
}