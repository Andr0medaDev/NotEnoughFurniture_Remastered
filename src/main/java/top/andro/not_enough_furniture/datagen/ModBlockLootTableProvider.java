package top.andro.not_enough_furniture.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Holder;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import top.andro.not_enough_furniture.init.ModBlocks;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.OAK_CHAIR.get());
        this.dropSelf(ModBlocks.SPRUCE_CHAIR.get());
        this.dropSelf(ModBlocks.BIRCH_CHAIR.get());
        this.dropSelf(ModBlocks.JUNGLE_CHAIR.get());
        this.dropSelf(ModBlocks.ACACIA_CHAIR.get());
        this.dropSelf(ModBlocks.DARK_OAK_CHAIR.get());
        this.dropSelf(ModBlocks.MANGROVE_CHAIR.get());
        this.dropSelf(ModBlocks.CHERRY_CHAIR.get());
        this.dropSelf(ModBlocks.CRIMSON_CHAIR.get());
        this.dropSelf(ModBlocks.WARPED_CHAIR.get());

        this.dropSelf(ModBlocks.OAK_TABLE.get());
        this.dropSelf(ModBlocks.SPRUCE_TABLE.get());
        this.dropSelf(ModBlocks.BIRCH_TABLE.get());
        this.dropSelf(ModBlocks.JUNGLE_TABLE.get());
        this.dropSelf(ModBlocks.ACACIA_TABLE.get());
        this.dropSelf(ModBlocks.DARK_OAK_TABLE.get());
        this.dropSelf(ModBlocks.MANGROVE_TABLE.get());
        this.dropSelf(ModBlocks.CHERRY_TABLE.get());
        this.dropSelf(ModBlocks.CRIMSON_TABLE.get());
        this.dropSelf(ModBlocks.WARPED_TABLE.get());
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
