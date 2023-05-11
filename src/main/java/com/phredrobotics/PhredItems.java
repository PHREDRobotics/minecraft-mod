package com.phredrobotics;

import com.phredrobotics.items.*;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PhredItems {

    public static final Item PHRED_ITEM_5 = new PhredItem5(new FabricItemSettings().maxCount(5));

    public static ToolItem PHRED_SIGN = new PhredSign(PhredToolMaterials.SIGN, 0, -3.2F, new Item.Settings());
;
    public static final Item PHRED_HARD_HAT = new PhredHardHat(PhredArmorMaterials.PHREDHARDHAT, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item PHRED_VEST = new PhredVest(PhredArmorMaterials.PHRED, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item PHRED_LEGGINGS = new PhredArmorItem(PhredArmorMaterials.PHRED, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item PHRED_BOOTS = new PhredArmorItem(PhredArmorMaterials.PHRED, ArmorItem.Type.BOOTS, new Item.Settings());
    
    private static final ItemGroup PHRED_ITEM_GROUP = FabricItemGroup.builder(new Identifier("phred", "phred"))

    .icon(() -> new ItemStack(PHRED_ITEM_5))
    .displayName(Text.translatable("Phred"))
    .build();

    public static void register(){

        Registry.register(Registries.ITEM, new Identifier("phred", "phred_sign"), PHRED_SIGN);
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_item_5"), PHRED_ITEM_5);
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_hard_hat"), PHRED_HARD_HAT);
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_vest"), PHRED_VEST);
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_leggings"), PHRED_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier("phred", "phred_boots"), PHRED_BOOTS);
     
        ItemGroupEvents.modifyEntriesEvent(PHRED_ITEM_GROUP).register(content -> {
            content.add(PHRED_ITEM_5);
            content.add(PHRED_SIGN);
            content.add(PHRED_HARD_HAT);
            content.add(PHRED_VEST);
            content.add(PHRED_LEGGINGS);
            content.add(PHRED_BOOTS);
        });
    }
}
