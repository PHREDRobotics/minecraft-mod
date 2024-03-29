package com.phredrobotics.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class PhredCone extends SwordItem {
    public PhredCone(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
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
        //blockstate = world.getBlockState(pos);
       // material = blockstate.getMaterial();
        materialIsReplaceable = material.isReplaceable();
       // Block block = world.getBlockState(pos).getBlock();
        if (materialIsReplaceable) {
                return super.useOnBlock(context);
        }
        return ActionResult.PASS;
    } 
}
