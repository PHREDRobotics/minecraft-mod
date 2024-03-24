package com.phredrobotics.items.client;

import com.phredrobotics.PhredMod;
import com.phredrobotics.items.PhredConeHat;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class PhredConeHatModel extends GeoModel<PhredConeHat> {

    @Override
    public Identifier getModelResource(PhredConeHat animatable) {
        return new Identifier(PhredMod.MOD_ID, "geo/phred_cone_hat.geo.json");
    }

    @Override
    public Identifier getTextureResource(PhredConeHat animatable) {
        return new Identifier(PhredMod.MOD_ID, "textures/armor/phred_cone_hat.png");
    }

    @Override
    public Identifier getAnimationResource(PhredConeHat animatable) {
        return new Identifier(PhredMod.MOD_ID, "animations/phred_cone_hat.animation.json");
    }
    
}
