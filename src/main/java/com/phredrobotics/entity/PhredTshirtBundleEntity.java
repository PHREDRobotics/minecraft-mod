package com.phredrobotics.entity;

import com.phredrobotics.PhredArmorMaterials;
import com.phredrobotics.PhredItems;
import com.phredrobotics.items.PhredTshirt;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class PhredTshirtBundleEntity extends ThrownItemEntity {
	public PhredTshirtBundleEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

 
	public PhredTshirtBundleEntity(World world, LivingEntity owner) {
		super(PhredItems.PHRED_ENTITY_TYPE, owner, world);
	}
 
	public PhredTshirtBundleEntity(World world, double x, double y, double z) {
		super(PhredItems.PHRED_ENTITY_TYPE, x, y, z, world);
	}
 
	@Override
	protected Item getDefaultItem() {
		return PhredItems.PHRED_TSHIRT_BUNDLE;
	}

	@Override
 
	protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
		super.onEntityHit(entityHitResult);
		net.minecraft.entity.Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
		int i = entity instanceof BlazeEntity ? 3 : 0; // sets i to 3 if the Entity instance is an instance of BlazeEntity

 
		
 
		if (entity instanceof PlayerEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
			entity.equipStack(EquipmentSlot.CHEST, new ItemStack(new PhredTshirt(PhredArmorMaterials.PHREDTSHIRT, ArmorItem.Type.CHESTPLATE, new Item.Settings())));
		}
}

	protected void onCollision(HitResult hitResult) { // called on collision with a block
		super.onCollision(hitResult);
		
		if (!this.world.isClient) { // checks if the world is client
			this.world.sendEntityStatus(this, (byte)3); // particle?
			this.kill(); // kills the projectile
		}


	}

	}

