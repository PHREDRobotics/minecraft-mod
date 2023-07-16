package com.phredrobotics;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class PhredSounds{

    public static final Identifier SIGN = new Identifier("phred:sign");
    public static SoundEvent SIGNEVENT = SoundEvent.of(SIGN);
public static void register(){
    Registry.register(Registries.SOUND_EVENT, PhredSounds.SIGN, SIGNEVENT);
}


}