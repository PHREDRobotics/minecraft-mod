package com.phredrobotics;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;



public class PhredToolMaterials {

    public static final ToolMaterial CONE = new ToolMaterial(){
@Override
public int getDurability() {
    return 1000;
}
@Override
public float getMiningSpeedMultiplier() {
    return 3.8F;
}
@Override
public float getAttackDamage() {
    return 25.0F;
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
    };
    public static final ToolMaterial SIGN = new ToolMaterial(){
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
    };
    

        public static final ToolMaterial CANNON = new ToolMaterial(){
@Override
public int getDurability() {
    return 1500;
}
@Override
public float getMiningSpeedMultiplier() {
    return 0.0F;
}
@Override
public float getAttackDamage() {
    return 0F;
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
    };
}