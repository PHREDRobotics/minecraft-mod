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

    public static final Item PHRED_ITEM_5 = registerItem("phred_item_5", 
    new PhredItem5(new FabricItemSettings().maxCount(5)));

    public static final Item PHRED_SIGN = registerItem("phred_sign", 
    new PhredSign(PhredToolMaterials.SIGN, 0, -3.2F, new Item.Settings()));

    public static final Item PHRED_HAT_UPGRADE = registerItem("googly_eyes", 
    new Item(new FabricItemSettings().maxCount(1)))
;
    public static final Item PHRED_HARD_HAT = registerItem("phred_hard_hat",
    new PhredHardHat(PhredArmorMaterials.PHREDHARDHAT, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item PHRED_HARD_HAT_UPGRADED = registerItem("phred_hard_hat_upgraded",
    new PhredHardHat(PhredArmorMaterials.PHREDHARDHATUPGRADED, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item PHRED_VEST = registerItem("phred_vest", 
    new PhredVest(PhredArmorMaterials.PHRED, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item PHRED_LEGGINGS = registerItem("phred_leggings", 
    new PhredArmorItem(PhredArmorMaterials.PHRED, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item PHRED_BOOTS = registerItem("phred_boots", 
    new PhredArmorItem(PhredArmorMaterials.PHRED, ArmorItem.Type.BOOTS, new Item.Settings()));
    
    private static final ItemGroup PHRED_ITEM_GROUP = FabricItemGroup.builder(new Identifier("phred", "phred"))
    .icon(() -> new ItemStack(PHRED_ITEM_5))
    .displayName(Text.translatable("Phred"))
    .build();
    
    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void addItemsToItemGroup(){
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, PHRED_HARD_HAT);
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, PHRED_HARD_HAT_UPGRADED);
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, PHRED_VEST);
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, PHRED_LEGGINGS);
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, PHRED_BOOTS);
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, PHRED_ITEM_5);
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, PHRED_SIGN);
        addToItemGroup(PhredItems.PHRED_ITEM_GROUP, PHRED_HAT_UPGRADE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PhredMod.MOD_ID, name), item);
    } 
    public static void register() {
        PhredMod.LOGGER.info("Registering Mod Items for " + PhredMod.MOD_ID);
        addItemsToItemGroup();
    }
}
