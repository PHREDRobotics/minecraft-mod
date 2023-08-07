package com.phredrobotics;

import com.phredrobotics.blocks.PhredSignBlock;
import com.phredrobotics.items.PhredSign;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PhredBlocks {
    public static final Block MENTOR_JONATHAN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block PHRED_SIGN = new PhredSignBlock(FabricBlockSettings.copyOf(Blocks.IRON_BARS));

    public static void register(){
        
		Registry.register(Registries.BLOCK, new Identifier("phred", "mentor_jonathan_block"), MENTOR_JONATHAN_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("phred", "mentor_jonathan_block"), new BlockItem(MENTOR_JONATHAN_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("phred", "phred_sign"), PHRED_SIGN);
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_sign"), new PhredSign(PHRED_SIGN, new FabricItemSettings()));
    }

    public static void addItemsToItemGroup(){
    addToItemGroup(PhredItems.PHRED_ITEM_GROUP, PHRED_SIGN);
    }

    private static void addToItemGroup(ItemGroup group, Block block){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
    }

    
}

