package top.andro.not_enough_furniture.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import top.andro.not_enough_furniture.NotEnoughFurniture;
import top.andro.not_enough_furniture.Reference;
import top.andro.not_enough_furniture.init.ModBlocks;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }

    public void wallItem(DeferredBlock<?> wallBlock, DeferredBlock<?> baseBlock) {
        this.withExistingParent(wallBlock.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", modLoc("block/" + baseBlock.getId().getPath()));
    }
}
