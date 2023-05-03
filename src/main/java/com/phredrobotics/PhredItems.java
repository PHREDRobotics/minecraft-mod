package com.phredrobotics;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PhredItems {
    public static final Item PHRED_ITEM_5 = new Item(new FabricItemSettings());

    public static void register(){
        
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_item_5"), PHRED_ITEM_5);
  
    }
}
