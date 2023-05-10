package com.phredrobotics.items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class PhredItem5 extends Item {
 
    public PhredItem5(Settings settings) {
        super(settings);
    }
    @Override
public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
 
    // default white text
    tooltip.add(Text.translatable("phred 5 item"));
 
}
}