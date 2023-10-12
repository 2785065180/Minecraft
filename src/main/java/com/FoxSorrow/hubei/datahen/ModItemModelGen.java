package com.FoxSorrow.hubei.datahen;

import com.FoxSorrow.hubei.HuBei;
import com.FoxSorrow.hubei.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItemModelGen  extends ItemModelProvider {
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";
    public static final String EGG_TEMPLATE = "item/template_spawn_egg";

    public ModItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HuBei.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemGeneratedModel(ModItems.ZIRCON.get(), resourceItem(itemName(ModItems.ZIRCON.get())));
        itemGeneratedModel(ModItems.RAW_ZIRCON.get(), resourceItem(itemName(ModItems.RAW_ZIRCON.get())));
    }

    private void saplingItem(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item),
                GENERATED).texture("layer0", texture);
    }
    private void eggItem(Item item) {
        withExistingParent(itemName(item),
                EGG_TEMPLATE);
    }

    public void itemGeneratedModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }

    private String itemName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(HuBei.MOD_ID, "block/" + path);
    }

    public ResourceLocation resourceItem(String path) {
        return new ResourceLocation(HuBei.MOD_ID, "item/" + path);
    }
}