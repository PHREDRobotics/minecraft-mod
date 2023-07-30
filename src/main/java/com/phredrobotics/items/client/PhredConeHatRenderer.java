package com.phredrobotics.items.client;

import com.phredrobotics.items.PhredConeHat;

import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PhredConeHatRenderer extends GeoArmorRenderer<PhredConeHat> {

    public PhredConeHatRenderer() {
        super(new PhredConeHatModel());
    }
    
}
