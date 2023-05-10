package com.phredrobotics;

import com.phredrobotics.items.PhredItem5;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PhredItems {
    public static final Item PHRED_ITEM_5 = new PhredItem5(new FabricItemSettings().maxCount(5));
    private static final ItemGroup PHRED_ITEM_GROUP = FabricItemGroup.builder(new Identifier("phred", "phred"))
	.icon(() -> new ItemStack(PHRED_ITEM_5))
    .displayName(Text.translatable("Phred"))
	.build();
    public static void register(){
        
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_item_5"), PHRED_ITEM_5);
        ItemGroupEvents.modifyEntriesEvent(PHRED_ITEM_GROUP).register(content -> {
            content.add(PHRED_ITEM_5);
        });
    }
}
