package com.phredrobotics.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class PhredSign extends BlockItem {
     public static final float ATTACK_DAMAGE = 8.0F;
     private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public PhredSign(Block block, Settings settings) {
        super(block, settings);
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 8.0, Operation.ADDITION));
            builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -3.0, Operation.ADDITION));
            this.attributeModifiers = builder.build();
         
        //TODO Auto-generated constructor stub
    }
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      stack.damage(1, attacker, (e) -> {
         e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
      });
      return true;
   }
     public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
      return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
   }

   

}
