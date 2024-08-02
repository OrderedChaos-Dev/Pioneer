package dev.orderedchaos.pioneer.core.registry;

import com.mojang.serialization.Codec;
import dev.orderedchaos.pioneer.common.world.surfacerules.RandomThresholdConditionSource;
import dev.orderedchaos.pioneer.core.Pioneer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PioneerSurfaceRules {

  public static final DeferredRegister<Codec<? extends SurfaceRules.ConditionSource>> CONDITIONS = DeferredRegister.create(Registries.MATERIAL_CONDITION, Pioneer.MOD_ID);

  public static final RegistryObject<Codec<? extends SurfaceRules.ConditionSource>> RANDOM_THRESHOLD = CONDITIONS.register("random_threshold", RandomThresholdConditionSource.CODEC::codec);
}