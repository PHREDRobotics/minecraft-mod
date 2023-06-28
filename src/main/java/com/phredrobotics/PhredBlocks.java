package com.phredrobotics;

import com.phredrobotics.blocks.AlBlock;
import com.phredrobotics.items.MentorJonathanBlock;

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

    public static final AlBlock ALBLOCK = new AlBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));

    public static final Block RAW_ALBLOCK = new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK));

    public static final Block STONE_ALORE = new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE));

    public static final Block DEEPSLATE_ALORE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE));

    public static void register(){
        
		Registry.register(Registries.BLOCK, new Identifier("phred", "mentor_jonathan_block"), MENTOR_JONATHAN_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("phred", "mentor_jonathan_block"), new MentorJonathanBlock(MENTOR_JONATHAN_BLOCK, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier("phred", "alblock"), ALBLOCK);
        Registry.register(Registries.ITEM, new Identifier("phred", "alblock"), new BlockItem(ALBLOCK, new FabricItemSettings()));
        
        Registry.register(Registries.BLOCK, new Identifier("phred", "raw_alblock"), RAW_ALBLOCK);
        Registry.register(Registries.ITEM, new Identifier("phred", "raw_alblock"), new BlockItem(RAW_ALBLOCK, new FabricItemSettings()));
        
        Registry.register(Registries.BLOCK, new Identifier("phred", "stone_alore"), STONE_ALORE);
        Registry.register(Registries.ITEM, new Identifier("phred", "stone_alore"), new BlockItem(STONE_ALORE, new FabricItemSettings()));
        
        Registry.register(Registries.BLOCK, new Identifier("phred", "deepslate_alore"), DEEPSLATE_ALORE);
        Registry.register(Registries.ITEM, new Identifier("phred", "deepslate_alore"), new BlockItem(DEEPSLATE_ALORE, new FabricItemSettings()));
        
        addItemsToItemGroup();
    }
        
    private static void addToItemGroup(ItemGroup group, Block block){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
    }

    public static void addItemsToItemGroup(){
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, ALBLOCK);
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, RAW_ALBLOCK);
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, STONE_ALORE);
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, DEEPSLATE_ALORE);
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, MENTOR_JONATHAN_BLOCK);
    }
}
