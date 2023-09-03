package com.phredrobotics.items;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.phredrobotics.PhredArmorMaterials;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class PhredTshirt extends ArmorItem{
    public PhredTshirt(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
 
        // default white text
        tooltip.add(Text.translatable("Makes you more visible!"));
     
    }
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
    (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
            .put(PhredArmorMaterials.PHRED,
                    new StatusEffectInstance(StatusEffects.GLOWING, 100, 0)).build();

@Override
public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
if(!world.isClient()) {
    if(entity instanceof PlayerEntity) {
        PlayerEntity player = (PlayerEntity)entity;

        if(hasChestplateOn(player)) {
            evaluateArmorEffects(player);
        }
    }
}

super.inventoryTick(stack, world, entity, slot, selected);
}

private void evaluateArmorEffects(PlayerEntity player) {
for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
    ArmorMaterial mapArmorMaterial = entry.getKey();
    StatusEffectInstance mapStatusEffect = entry.getValue();

    if(hasCorrectArmorOn(mapArmorMaterial, player)) {
        addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
    }
}
}

private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect) {
boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
    player.addStatusEffect(new StatusEffectInstance(mapStatusEffect.getEffectType(),
            mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));

}
}

private boolean hasChestplateOn(PlayerEntity player) {
ItemStack chestplate = player.getInventory().getArmorStack(2);
return !chestplate.isEmpty() && !chestplate.isOf(Items.ELYTRA);
}

private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());

return chestplate.getMaterial() == material;
}
}
