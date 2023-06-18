package com.phredrobotics.entity;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

public class PhredEntityModel extends EntityModel<PhredEntity> {
 
    private final ModelPart bb_main;
 
    public PhredEntityModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
    }
 
 
    // You can use BlockBench, make your model and export it to get this method for your entity model.
    public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -8.0F, 8.0F, 8.0F, 16.0F, new Dilation(0.0F))
		.uv(32, 32).cuboid(4.0F, -4.0F, -8.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(32, 0).cuboid(-4.0F, -16.0F, -8.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 24).cuboid(-4.0F, -24.0F, 0.0F, 8.0F, 16.0F, 8.0F, new Dilation(0.0F))
		.uv(24, 24).cuboid(4.0F, -4.0F, 4.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(-8.0F, -4.0F, 4.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-8.0F, -4.0F, -8.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);

    }

    @Override
    public void setAngles(PhredEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }
 
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        bb_main.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}