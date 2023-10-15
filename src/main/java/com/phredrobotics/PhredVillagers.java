package com.phredrobotics;

import com.google.common.collect.ImmutableSet;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class PhredVillagers {
    public static final RegistryKey<PointOfInterestType> PHRED_POI_KEY = poiKey("phredpoi");
    public static final PointOfInterestType PHRED_POI = registerPOI("phredpoi", PhredBlocks.MENTOR_JONATHAN_BLOCK);

    public static final VillagerProfession PHRED_MEMBER = registerProfession("phred_member", PHRED_POI_KEY);


    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type){
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(PhredMod.MOD_ID, name),
        new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.BLOCK_ANVIL_USE));
    }

    public static PointOfInterestType registerPOI(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(PhredMod.MOD_ID, name),
        1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }


    private static RegistryKey<PointOfInterestType> poiKey(String name){
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(PhredMod.MOD_ID, name));
    }

    public static void registerVillagers(){
        PhredMod.LOGGER.debug("Registering Villagers for " + PhredMod.MOD_ID);
    }
    public static void registerTrades(){
        PhredMod.LOGGER.debug("Registering Trades for " + PhredMod.MOD_ID);
        TradeOfferHelper.registerVillagerOffers(PHRED_MEMBER, 1,
        factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                new ItemStack(PhredItems.PHRED_ITEM_5, 1),
                new ItemStack(Items.EMERALD, 1),
                5, 2, 0.02f
            )));
            factories.add(((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD, 3),
                new ItemStack(PhredItems.PHRED_ROBOT_FRAME, 1),
                6, 2, 0.02f
            )));
        });
    }
}
