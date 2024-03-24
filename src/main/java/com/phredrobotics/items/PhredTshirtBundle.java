 package com.phredrobotics.items;


import com.phredrobotics.entity.PhredTshirtBundleEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
public class PhredTshirtBundle extends Item {
	public PhredTshirtBundle(Settings settings) {
        super(settings);
    }

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent
		/*
		user.getItemCooldownManager().set(this, 5);
		Optionally, you can add a cooldown to your item's right-click use, similar to Ender Pearls.
		*/
		if (!world.isClient) {
			PhredTshirtBundleEntity phredTshirtBundleEntity = new PhredTshirtBundleEntity(world, user);
			phredTshirtBundleEntity.setItem(itemStack);
			phredTshirtBundleEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0F);
                        /*
                        phredTshirtBundleEntity.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
                        In 1.17,we will use setProperties instead of setVelocity.
                        */
			world.spawnEntity(phredTshirtBundleEntity); // spawns entity
		}
 
		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.getAbilities().creativeMode) {
			itemStack.decrement(1); // decrements itemStack if user is not in creative mode
		}
 
		return TypedActionResult.success(itemStack, world.isClient());
	}
}