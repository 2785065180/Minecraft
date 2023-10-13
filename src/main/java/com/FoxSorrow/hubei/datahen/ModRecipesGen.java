package com.FoxSorrow.hubei.datahen;

import com.FoxSorrow.hubei.block.ModBlocks;
import com.FoxSorrow.hubei.item.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipesGen extends RecipeProvider {
    public ModRecipesGen(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZIRCON_ORE.get())
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .define('#', ModItems.ZIRCON.get())
                .define('X', ModItems.RAW_ZIRCON.get())
                .group("hubeimod")
                .unlockedBy("has_hubei", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ModItems.ZIRCON.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.ZIRCON.get(),9)
                .requires(ModBlocks.ZIRCON_ORE.get())
                .group("hubeimod")
                .unlockedBy("has_hubei", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ModItems.ZIRCON.get()).build()))
                .save(pWriter);

        //熔炉配方 -输入-输出
        oreSmelting(pWriter, List.of(ModItems.RAW_ZIRCON.get()),RecipeCategory.MISC,ModItems.ZIRCON.get(),0.7f,200,"hubeimod");
        //高卢配方-输入-输出
        oreBlasting(pWriter, List.of(ModItems.RAW_ZIRCON.get()),RecipeCategory.MISC,ModItems.ZIRCON.get(),0.7f,100,"hubeimod");
    }
}