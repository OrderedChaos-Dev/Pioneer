package pioneer.common.world;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import pioneer.core.PioneerConfig;
import pioneer.core.registry.world.PioneerBiomeModifiers;

public record BasicBiomeModifier(HolderSet<Biome> biomes, Holder<PlacedFeature> feature, String configOption) implements BiomeModifier {
  @Override
  public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
    if(phase == Phase.ADD) {
      if(PioneerConfig.CONFIG_OPTIONS.get(configOption).get() && biomes.contains(biome)) {
        builder
          .getGenerationSettings()
          .getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION)
          .add(feature);
      }
    }
  }

  @Override
  public Codec<? extends BiomeModifier> codec() {
    return PioneerBiomeModifiers.BASIC_BIOME_MODIFIER.get();
  }

}
