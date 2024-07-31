package dev.orderedchaos.pioneer.core.registry;

import dev.orderedchaos.pioneer.core.Pioneer;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;

public class PioneerPlacedFeatures {

  public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registries.PLACED_FEATURE, Pioneer.MOD_ID);

  public static final ResourceKey<PlacedFeature> PATCH_MANY_CACTUS  = createKey("patch_many_cactus");

  public static final ResourceKey<PlacedFeature> TREES_VERDANT_SANDS  = createKey("trees_verdant_sands");

  public static void bootstrap(BootstapContext<PlacedFeature> context) {
    HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);

    register(context, TREES_VERDANT_SANDS, holderGetter.getOrThrow(PioneerConfiguredFeatures.TREES_VERDANT_SANDS), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
    register(context, PATCH_MANY_CACTUS, holderGetter.getOrThrow(VegetationFeatures.PATCH_CACTUS), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
  }

  private static ResourceKey<PlacedFeature> createKey(String name) {
    return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Pioneer.MOD_ID, name));
  }

  private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder, List<PlacementModifier> modifiers) {
    PlacementUtils.register(context, key, configuredFeatureHolder, modifiers);
  }

  private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder, PlacementModifier... modifiers) {
    PlacementUtils.register(context, key, configuredFeatureHolder, modifiers);
  }
}
