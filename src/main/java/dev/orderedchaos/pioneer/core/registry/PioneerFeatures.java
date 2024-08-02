package dev.orderedchaos.pioneer.core.registry;

import dev.orderedchaos.pioneer.common.world.features.WindsweptSpikeFeature;
import dev.orderedchaos.pioneer.core.Pioneer;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PioneerFeatures {

  public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Pioneer.MOD_ID);

//  public static final RegistryObject<Feature<SimpleBlockConfiguration>> SIMPLE_BLOCK_MATCH_WATER = registerFeature("simple_block_match_water", new SimpleBlockMatchWaterFeature(SimpleBlockConfiguration.CODEC));
  public static final RegistryObject<Feature<NoneFeatureConfiguration>> WINDSWEPT_SPIKE = registerFeature("windswept_spike", new WindsweptSpikeFeature(NoneFeatureConfiguration.CODEC));

  private static<FC extends FeatureConfiguration> RegistryObject<Feature<FC>> registerFeature(String name, Feature<FC> feature) {
    return FEATURES.register(name, () -> feature);
  }

}