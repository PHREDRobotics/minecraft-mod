package com.phredrobotics.entity;

import com.phredrobotics.PhredClient;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class PhredEntityRenderer extends MobEntityRenderer<PhredEntity, PhredEntityModel> {
 
    public PhredEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PhredEntityModel(context.getPart(PhredClient.MODEL_CUBE_LAYER)), 0.5f);
    }
    
 
    @Override
    public Identifier getTexture(PhredEntity entity) {
        return new Identifier("phred", "textures/entity/phred/phred2023.png");
    }


    }
