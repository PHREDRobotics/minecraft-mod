package com.phredrobotics.items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class PhredWire extends Item{
   
 
    public PhredWire(Settings settings) {
    super(settings);
    }
public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
 
    // default white text
    tooltip.add(Text.translatable("Wire for crafting PHRED"));
 
}
}
