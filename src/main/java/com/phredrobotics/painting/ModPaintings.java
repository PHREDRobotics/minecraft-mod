package com.phredrobotics.painting;
import com.phredrobotics.PhredMod;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;

public class ModPaintings {
    public static final PaintingVariant vlc = registerPainting("vlc", new PaintingVariant(16, 16));
    public static final PaintingVariant pingu = registerPainting("pingu", new PaintingVariant(64, 32));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(PhredMod.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings() {
        PhredMod.LOGGER.debug("Registering Paintings for " + PhredMod.MOD_ID);
    }
}
