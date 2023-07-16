package com.phredrobotics.items;

import com.phredrobotics.PhredBlocks;
import com.phredrobotics.PhredSounds;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.MinecraftClient;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class PhredSign extends AxeItem {
    public PhredSign(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState blockstate = world.getBlockState(pos);
        Material material = blockstate.getMaterial();
        boolean materialIsReplaceable = material.isReplaceable();
        Direction side = context.getSide();
        if (!materialIsReplaceable) {
            if (side == Direction.UP){
                pos = pos.add(0, 1, 0);
            } else if (side == Direction.DOWN) {
                pos = pos.add(0, -1, 0);                
            } else if (side == Direction.WEST) {
                pos = pos.add(-1, 0, 0);
            } else if (side == Direction.EAST) {
                pos = pos.add(1, 0, 0);
            } else if (side == Direction.NORTH) {
                pos = pos.add(0, 0, -1);
            } else if (side == Direction.SOUTH) {
                pos = pos.add(0, 0, 1);
            }
        }
        blockstate = world.getBlockState(pos);
        material = blockstate.getMaterial();
        materialIsReplaceable = material.isReplaceable();
        Block block = world.getBlockState(pos).getBlock();
        if (materialIsReplaceable) {
            if (!world.isClient()) {
                // Update block + item
                world.setBlockState(pos, PhredBlocks.PHRED_SIGN_BLOCK.getDefaultState()
                    .with(Properties.HORIZONTAL_FACING, context.getHorizontalPlayerFacing().getOpposite())
                    .with(Properties.WATERLOGGED, context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER));
                context.getPlayer().getStackInHand(context.getHand()).decrement(1);
                MinecraftClient.getInstance().player.swingHand(context.getHand());

            } else {
                // Play Sound
                context.getPlayer().playSound(PhredSounds.SIGNEVENT, 1.0f, 1.0f);
            }

            return super.useOnBlock(context);
        }
        return ActionResult.PASS;
    }
}
