package top.andro.not_enough_furniture.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.andro.not_enough_furniture.Reference;
import top.andro.not_enough_furniture.block.WoodenChairBlock;
import top.andro.not_enough_furniture.block.WoodenTableBlock;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.*;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Reference.MOD_ID);

    public static final DeferredBlock<Block> OAK_CHAIR = registerBlock("oak_chair",  () -> new WoodenChairBlock(BlockBehaviour.Properties.ofFullCopy(OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_CHAIR = registerBlock("spruce_chair",  () -> new WoodenChairBlock(BlockBehaviour.Properties.ofFullCopy(SPRUCE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_CHAIR = registerBlock("birch_chair",  () -> new WoodenChairBlock(BlockBehaviour.Properties.ofFullCopy(BIRCH_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_CHAIR = registerBlock("jungle_chair",  () -> new WoodenChairBlock(BlockBehaviour.Properties.ofFullCopy(JUNGLE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_CHAIR = registerBlock("acacia_chair",  () -> new WoodenChairBlock(BlockBehaviour.Properties.ofFullCopy(ACACIA_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_CHAIR = registerBlock("dark_oak_chair",  () -> new WoodenChairBlock(BlockBehaviour.Properties.ofFullCopy(DARK_OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_CHAIR = registerBlock("mangrove_chair",  () -> new WoodenChairBlock(BlockBehaviour.Properties.ofFullCopy(MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_CHAIR = registerBlock("cherry_chair",  () -> new WoodenChairBlock(BlockBehaviour.Properties.ofFullCopy(CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_CHAIR = registerBlock("crimson_chair",  () -> new WoodenChairBlock(BlockBehaviour.Properties.ofFullCopy(CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_CHAIR = registerBlock("warped_chair",  () -> new WoodenChairBlock(BlockBehaviour.Properties.ofFullCopy(WARPED_PLANKS).noOcclusion()));

    public static final DeferredBlock<Block> OAK_TABLE = registerBlock("oak_table",  () -> new WoodenTableBlock(BlockBehaviour.Properties.ofFullCopy(OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_TABLE = registerBlock("spruce_table",  () -> new WoodenTableBlock(BlockBehaviour.Properties.ofFullCopy(SPRUCE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_TABLE = registerBlock("birch_table",  () -> new WoodenTableBlock(BlockBehaviour.Properties.ofFullCopy(BIRCH_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_TABLE = registerBlock("jungle_table",  () -> new WoodenTableBlock(BlockBehaviour.Properties.ofFullCopy(JUNGLE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_TABLE = registerBlock("acacia_table",  () -> new WoodenTableBlock(BlockBehaviour.Properties.ofFullCopy(ACACIA_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_TABLE = registerBlock("dark_oak_table",  () -> new WoodenTableBlock(BlockBehaviour.Properties.ofFullCopy(DARK_OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_TABLE = registerBlock("mangrove_table",  () -> new WoodenTableBlock(BlockBehaviour.Properties.ofFullCopy(MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_TABLE = registerBlock("cherry_table",  () -> new WoodenTableBlock(BlockBehaviour.Properties.ofFullCopy(CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_TABLE = registerBlock("crimson_table",  () -> new WoodenTableBlock(BlockBehaviour.Properties.ofFullCopy(CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_TABLE = registerBlock("warped_table",  () -> new WoodenTableBlock(BlockBehaviour.Properties.ofFullCopy(WARPED_PLANKS).noOcclusion()));





    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
