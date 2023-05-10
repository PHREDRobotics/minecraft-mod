package com.phredrobotics;

// import org.jetbrains.annotations.ApiStatus.OverrideOnly;

// import com.phredrobotics.PhredItems;
// import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class PhredArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {4, 7, 9, 4};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 40;
    }
    
    @Override
    public int getProtection(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }
    @Override
    public int getEnchantability() {
        return 30;
    }
 
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }
 
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(PhredItems.PHRED_ITEM_5);;
    }
 
    @Override
    public String getName() {
        // Must be all lowercase
        return "phred_item_5";
    }
 
    @Override
    public float getToughness() {
        return 4.0F;
    }
 
    @Override
    public float getKnockbackResistance() {
        return 0.0F;
    }
}