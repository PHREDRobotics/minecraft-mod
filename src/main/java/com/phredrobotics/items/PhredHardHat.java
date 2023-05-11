package com.phredrobotics.items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class PhredHardHat extends ArmorItem{
    public PhredHardHat(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
 
        // default white text
        tooltip.add(Text.translatable("Everyone knows hard hats prevent death!"));
     
    }
}
