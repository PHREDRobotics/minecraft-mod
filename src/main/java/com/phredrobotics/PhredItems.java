package com.phredrobotics;

import com.phredrobotics.items.PhredAxe;
import com.phredrobotics.items.PhredItem5;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PhredItems {
    public static final Item PHRED_ITEM_5 = new PhredItem5(new FabricItemSettings().maxCount(5));
    public static ToolItem PHRED_AXE = new PhredAxe(PhredToolMaterial.INSTANCE, 0, -3.2F, new Item.Settings());
   
    /* 
     public static final ArmorMaterial PHRED_ARMOR_MATERIAL = new ArmorMaterial();
    public static final Item PHRED_HELMET = new ArmorItem(PHRED_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings());
    public static final Item PHRED_CHESTPLATE = new ArmorItem(PHRED_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings());
    public static final Item PHRED_LEGGINGS = new ArmorItem(PHRED_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings());
    public static final Item PHRED_BOOTS = new ArmorItem(PHRED_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()); */
    private static final ItemGroup PHRED_ITEM_GROUP = FabricItemGroup.builder(new Identifier("phred", "phred"))
    .icon(() -> new ItemStack(PHRED_ITEM_5))
    .displayName(Text.translatable("Phred"))
    .build();
    public static void register(){

        Registry.register(Registries.ITEM, new Identifier("phred", "phred_axe"), PHRED_AXE);
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_item_5"), PHRED_ITEM_5);
        /* 
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_helmet"), PHRED_HELMET);
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_chestplate"), PHRED_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_leggings"), PHRED_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_boots"), PHRED_BOOTS); */
     
        ItemGroupEvents.modifyEntriesEvent(PHRED_ITEM_GROUP).register(content -> {
            content.add(PHRED_ITEM_5);
            content.add(PHRED_AXE);
            /* 
            content.add(PHRED_HELMET);
            content.add(PHRED_CHESTPLATE);
            content.add(PHRED_LEGGINGS);
            content.add(PHRED_BOOTS); */
        });
    }
}
