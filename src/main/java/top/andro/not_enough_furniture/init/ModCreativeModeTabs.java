package top.andro.not_enough_furniture.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.andro.not_enough_furniture.NotEnoughFurniture;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NotEnoughFurniture.MOD_ID);

    public static final Supplier<CreativeModeTab> NOT_ENOUGH_FURNITURE_TAB = CREATIVE_MODE_TAB.register("not_enough_furniture",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.OAK_CHAIR.get()))
                    .title(Component.translatable("creativetab.not_enough_furniture.not_enough_furniture"))
                    .displayItems((itemDisplayParameters, output) -> {
                    output.accept(ModBlocks.OAK_CHAIR);
                    output.accept(ModBlocks.SPRUCE_CHAIR);
                    output.accept(ModBlocks.BIRCH_CHAIR);
                    output.accept(ModBlocks.JUNGLE_CHAIR);
                    output.accept(ModBlocks.ACACIA_CHAIR);
                    output.accept(ModBlocks.DARK_OAK_CHAIR);
                    output.accept(ModBlocks.MANGROVE_CHAIR);
                    output.accept(ModBlocks.CHERRY_CHAIR);
                    output.accept(ModBlocks.CRIMSON_CHAIR);
                    output.accept(ModBlocks.WARPED_CHAIR);

                    })
                    .build());
    
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
