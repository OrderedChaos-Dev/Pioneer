package pioneer.core.registry.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import pioneer.common.world.BasicBiomeModifier;
import pioneer.core.Pioneer;

public class PioneerBiomeModifiers {

  public static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Pioneer.MOD_ID);

  public static RegistryObject<Codec<BasicBiomeModifier>> BASIC_BIOME_MODIFIER = BIOME_MODIFIERS.register("basic_biome_modifier",
    () -> RecordCodecBuilder.create(builder -> builder.group(
      Biome.LIST_CODEC.fieldOf("biomes").forGetter(BasicBiomeModifier::biomes),
      PlacedFeature.CODEC.fieldOf("feature").forGetter(BasicBiomeModifier::feature),
      PrimitiveCodec.STRING.fieldOf("configOption").forGetter(BasicBiomeModifier::configOption)
    ).apply(builder, BasicBiomeModifier::new)));
}
