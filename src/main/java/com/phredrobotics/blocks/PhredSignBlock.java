package com.phredrobotics.blocks;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class PhredSignBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public PhredSignBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = VoxelShapes.combineAndSimplify(
        Block.createCuboidShape(7, 0, 7, 9, 32, 9), 
        Block.createCuboidShape(-2, 19, 6, 18, 32, 7), 
        BooleanBiFunction.OR);

    private static final VoxelShape SHAPE_E = VoxelShapes.combineAndSimplify(
        Block.createCuboidShape(7, 0, 7, 9, 32, 9), 
        Block.createCuboidShape(9, 19, -2, 10, 32, 18), 
        BooleanBiFunction.OR);

    private static final VoxelShape SHAPE_S = VoxelShapes.combineAndSimplify(
        Block.createCuboidShape(7, 0, 7, 9, 32, 9), 
        Block.createCuboidShape(-2, 19, 9, 18, 32, 10), 
        BooleanBiFunction.OR);

    private static final VoxelShape SHAPE_W = VoxelShapes.combineAndSimplify(
        Block.createCuboidShape(7, 0, 7, 9, 32, 9), 
        Block.createCuboidShape(6, 19, -2, 7, 32, 18), 
        BooleanBiFunction.OR);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST: 
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
    
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
