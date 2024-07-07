package com.phredrobotics.entity;

import com.phredrobotics.PhredItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class PhredTshirtBundleEntity extends ArrowEntity {
	public PhredTshirtBundleEntity(EntityType<? extends ArrowEntity> entityType, World world) {
		super(entityType, world);
	}

 
	public PhredTshirtBundleEntity(World world, LivingEntity owner) {
		super(PhredItems.PHRED_TSHIRT_BUNDLE_ENTITY_TYPE, world);
	}
 
	public PhredTshirtBundleEntity(World world, double x, double y, double z) {
		super(PhredItems.PHRED_TSHIRT_BUNDLE_ENTITY_TYPE, world);
	}
 //It is not buiding correctly and is using older code
 	/*@Override
	protected Item getDefaultItem() {
		return PhredItems.PHRED_TSHIRT_BUNDLE;
		}*/

	@Override
 
	protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
		super.onEntityHit(entityHitResult);
		net.minecraft.entity.Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
		if (entity instanceof PlayerEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
			entity.equipStack(EquipmentSlot.CHEST, new ItemStack(PhredItems.PHRED_TSHIRT));
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

