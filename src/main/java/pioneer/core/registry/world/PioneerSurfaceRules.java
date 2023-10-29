package pioneer.core.registry.world;

import com.mojang.serialization.Codec;
import com.teamabnormals.blueprint.core.Blueprint;
import com.teamabnormals.blueprint.core.registry.BlueprintSurfaceRules;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import pioneer.common.world.surfacerules.RandomThresholdConditionSource;
import pioneer.core.Pioneer;

public class PioneerSurfaceRules {

  public static final DeferredRegister<Codec<? extends SurfaceRules.ConditionSource>> CONDITIONS = DeferredRegister.create(Registry.CONDITION_REGISTRY, Pioneer.MOD_ID);

  public static final RegistryObject<Codec<? extends SurfaceRules.ConditionSource>> RANDOM_THRESHOLD = CONDITIONS.register("random_threshold", RandomThresholdConditionSource.CODEC::codec);
}
