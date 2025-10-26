package top.andro.not_enough_furniture.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.level.block.state.properties.DirectionProperty;
import top.andro.not_enough_furniture.entity.SeatEntity;
import top.andro.not_enough_furniture.init.ModEntities;

import java.util.List;

public class WoodenChairBlock extends RotatedFurnitureBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected MapCodec<WoodenChairBlock> CODEC = simpleCodec(WoodenChairBlock::new);

    public WoodenChairBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return null;
    }

    private static final VoxelShape SHAPE_SEAT = Block.box(2, 0, 2, 14, 10, 14);
    private static final VoxelShape SHAPE_BACKREST = Block.box(2, 10, 12, 14, 22, 14);
    public static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(2, 0, 2, 14, 10, 14),
            Block.box(12, 10, 2, 14, 22, 14)
    );
    public static final VoxelShape SHAPE_NORTH = Shapes.or(
            Block.box(2, 0, 2, 14, 10, 14),
            Block.box(2, 10, 12, 14, 22, 14)
    );
    public static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(2, 0, 2, 14, 10, 14),
            Block.box(2, 10, 2, 4, 22, 14)
    );
    public static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(2, 0, 2, 14, 10, 14),
            Block.box(2, 10, 2, 14, 22, 4)
    );

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide()) {
            Entity entity = null;
            List<SeatEntity> entities = level.getEntities(ModEntities.SEAT.get(), new AABB(pos), chair -> true);
            if(entities.isEmpty()) {
                entity = ModEntities.SEAT.get().spawn(((ServerLevel) level), pos, MobSpawnType.TRIGGERED);
            } else {
                entity = entities.get(0);
            }

            player.startRiding(entity);
        }

        return InteractionResult.SUCCESS;
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

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch ((Direction) state.getValue(FACING)) {
            case NORTH:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
            case EAST:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE_NORTH;
        }
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
}

