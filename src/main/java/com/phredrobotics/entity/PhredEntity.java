package com.phredrobotics.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

/*
 * Our Cube Entity extends PathAwareEntity, which extends MobEntity, which extends LivingEntity.
 *
 * LivingEntity has health and can deal damage.
 * MobEntity has movement controls and AI capabilities.
 * PathAwareEntity has pathfinding favor and slightly tweaked leash behavior.
 */
public class PhredEntity extends PathAwareEntity {
 
    public PhredEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public static final EntityType<PhredEntity> CUBE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("phred", "phred"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PhredEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );
    public static void register(){

        FabricDefaultAttributeRegistry.register(CUBE, PhredEntity.createMobAttributes());
    }


}