package com.phredrobotics.items;

import org.spongepowered.asm.mixin.MixinEnvironment.Side;

import com.phredrobotics.PhredBlocks;
import com.phredrobotics.PhredSounds;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.data.client.VariantSettings.Rotation;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.State;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
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
        boolean materialIsReplaceable = world.getBlockState(pos).getMaterial().isReplaceable();
        if(!materialIsReplaceable) {
            pos.add(0, 1, 0);
        }
        Block block = world.getBlockState(pos).getBlock();
        if ((context.getSide() == Direction.UP && block == Blocks.AIR) || materialIsReplaceable){
            if (!world.isClient()) {
                // Update block + item
                world.setBlockState(pos, PhredBlocks.PHRED_SIGN_BLOCK.getDefaultState().with(Properties.HORIZONTAL_FACING, context.getHorizontalPlayerFacing().getOpposite()));
                context.getPlayer().getStackInHand(context.getHand()).decrement(1);
                MinecraftClient.getInstance().player.swingHand(context.getHand());
                
                
            } else {
                // Place Sound
                context.getPlayer().playSound(PhredSounds.SIGNEVENT, 1.0f, 1.0f);
            }
            
            return super.useOnBlock(context);
        }
        return ActionResult.PASS;
    }
}
