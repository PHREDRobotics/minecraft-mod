package com.phredrobotics;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PhredToolMaterials implements ToolMaterial {
    public static final PhredToolMaterials SIGN = new PhredToolMaterials();
    @Override
    public int getDurability() {
        return 500;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return 0.0F;
    }
    @Override
    public float getAttackDamage() {
        return 11.0F;
    }
    @Override
    public int getMiningLevel() {
        return 0;
    }
    @Override
    public int getEnchantability() {
        return 30;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(PhredItems.PHRED_ITEM_5);
    }
}