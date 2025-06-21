package top.andro.not_enough_furniture.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class WoodenChairBlock extends SittableBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_NORTH = Shapes.or(
            Block.box(2, 0, 2, 4, 8, 4),
            Block.box(2, 0, 12, 4, 8, 14),
            Block.box(12, 0, 2, 14, 8, 4),
            Block.box(12, 0, 12, 14, 8, 14),
            Block.box(2, 8, 2, 14, 10, 14),
            Block.box(2, 10, 12, 14, 22, 14)
    );

    private static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(2, 0, 2, 4, 8, 4),
            Block.box(2, 0, 12, 4, 8, 14),
            Block.box(12, 0, 2, 14, 8, 4),
            Block.box(12, 0, 12, 14, 8, 14),
            Block.box(2, 8, 2, 14, 10, 14),
            Block.box(2, 10, 2, 14, 22, 4)
    );

    private static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(2, 0, 2, 4, 8, 4),
            Block.box(2, 0, 12, 4, 8, 14),
            Block.box(12, 0, 2, 14, 8, 4),
            Block.box(12, 0, 12, 14, 8, 14),
            Block.box(2, 8, 2, 14, 10, 14),
            Block.box(2, 10, 2, 4, 22, 14)
    );

    private static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(2, 0, 2, 4, 8, 4),
            Block.box(2, 0, 12, 4, 8, 14),
            Block.box(12, 0, 2, 14, 8, 4),
            Block.box(12, 0, 12, 14, 8, 14),
            Block.box(2, 8, 2, 14, 10, 14),
            Block.box(12, 10, 2, 14, 22, 14)
    );


    public WoodenChairBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH: return SHAPE_NORTH;
            case EAST: return SHAPE_EAST;
            case SOUTH: return SHAPE_SOUTH;
            case WEST: return SHAPE_WEST;
            default: return SHAPE_NORTH;
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}

