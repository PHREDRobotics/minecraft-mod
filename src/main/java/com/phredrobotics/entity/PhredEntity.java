package com.phredrobotics.entity;

import javax.annotation.Nullable;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/*
 * Our Cube Entity extends PathAwareEntity, which extends MobEntity, which extends LivingEntity.
 *
 * LivingEntity has health and can deal damage.
 * MobEntity has movement controls and AI capabilities.
 * PathAwareEntity has pathfinding favor and slightly tweaked leash behavior.
 */
public class PhredEntity extends AnimalEntity {
	public PhredEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
		this.setStepHeight(1);
        this.ignoreCameraFrustum = true;
    }
    // Let the player ride the entity
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (!this.hasPassengers()) {
			player.startRiding(this);

			return super.interactMob(player, hand);
		}

		return super.interactMob(player, hand);
	}
    // Apply player-controlled movement
    @Override
	public void travel(Vec3d pos) {
		if (this.isAlive()) {
			if (this.hasPassengers()) {
				LivingEntity passenger = (LivingEntity)getPrimaryPassenger();
				this.prevYaw = getYaw();
				this.prevPitch = getPitch();

				setYaw(passenger.getYaw());
				setPitch(passenger.getPitch() * 0.5f);
				setRotation(getYaw(), getPitch());

				this.bodyYaw = this.getYaw();
				this.headYaw = this.bodyYaw;
				float x = passenger.sidewaysSpeed * 0.5F;
				float z = passenger.forwardSpeed;

				if (z <= 0)
					z *= 0.25f;

				this.setMovementSpeed(0.3f);
				super.travel(new Vec3d(x, pos.y, z));
			} else {
				super.travel(pos);
			}
		}
	}
    @Nullable
	public LivingEntity getPrimaryPassenger() {
		return getFirstPassenger() instanceof LivingEntity entity ? entity : null;
	}
    public static final EntityType<PhredEntity> PHRED = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("phred", "phred"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PhredEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );
    public static void register(){

        FabricDefaultAttributeRegistry.register(PHRED, PhredEntity.createMobAttributes());
    }
	@Override
	public PassiveEntity createChild(ServerWorld arg0, PassiveEntity arg1) {
		return null;
	}

}