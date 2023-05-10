package com.phredrobotics;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PhredToolMaterial implements ToolMaterial {
    public static final PhredToolMaterial INSTANCE = new PhredToolMaterial();
    @Override
    public int getDurability() {
        return 500;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0F;
    }
    @Override
    public float getAttackDamage() {
        return 11.0F;
    }
    @Override
    public int getMiningLevel() {
        return 3;
    }
    @Override
    public int getEnchantability() {
        return 30;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.POTATO);
    }
}