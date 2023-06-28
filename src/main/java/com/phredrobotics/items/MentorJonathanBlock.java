package com.phredrobotics.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;

import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class MentorJonathanBlock extends BlockItem {

    public MentorJonathanBlock(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
 
    // default white text
    tooltip.add(Text.translatable("May the Mentors be with you..."));
 
}
}