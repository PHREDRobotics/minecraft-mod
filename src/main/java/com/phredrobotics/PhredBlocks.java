package com.phredrobotics;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PhredBlocks {
    public static final Block MENTOR_JONATHAN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));

    public static void register(){
        
		Registry.register(Registries.BLOCK, new Identifier("phred", "mentor_jonathan_block"), MENTOR_JONATHAN_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("phred", "mentor_jonathan_block"), new BlockItem(MENTOR_JONATHAN_BLOCK, new FabricItemSettings()));
    }
}
