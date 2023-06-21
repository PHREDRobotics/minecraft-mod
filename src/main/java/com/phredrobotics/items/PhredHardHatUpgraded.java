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
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class PhredHardHatUpgraded extends ArmorItem{
    public PhredHardHatUpgraded(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
 
        // default white text
        tooltip.add(Text.translatable("Googly eyes are proven to increase safety."));
     
    }
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
    (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
            .put(PhredArmorMaterials.PHREDHARDHATUPGRADED,
                    new StatusEffectInstance(StatusEffects.RESISTANCE, 20, 1)).build();

@Override
public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
if(!world.isClient()) {
    if(entity instanceof PlayerEntity) {
        PlayerEntity player = (PlayerEntity)entity;

        if(hasHelmetOn(player)) {
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

    // if(new Random().nextFloat() > 0.6f) { // 40% of damaging the armor! Possibly!
    //     player.getInventory().damageArmor(DamageSource.MAGIC, 1f, new int[]{0, 1, 2, 3});
    // }
}
}

private boolean hasHelmetOn(PlayerEntity player) {
ItemStack helmet = player.getInventory().getArmorStack(3);

return !helmet.isEmpty();
}

private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

return helmet.getMaterial() == material;
}
}
