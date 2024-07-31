package dev.orderedchaos.pioneer.core.registry;

import dev.orderedchaos.pioneer.common.world.features.tree.decorators.CoconutDecorator;
import dev.orderedchaos.pioneer.common.world.features.tree.decorators.JuniperBerriesDecorator;
import dev.orderedchaos.pioneer.common.world.features.tree.foliageplacers.AspenFoliagePlacer;
import dev.orderedchaos.pioneer.common.world.features.tree.foliageplacers.BaobabFoliagePlacer;
import dev.orderedchaos.pioneer.common.world.features.tree.foliageplacers.DesertJuniperFoliagePlacer;
import dev.orderedchaos.pioneer.common.world.features.tree.foliageplacers.PalmFoliagePlacer;
import dev.orderedchaos.pioneer.common.world.features.tree.trunkplacers.*;
import dev.orderedchaos.pioneer.core.Pioneer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class PioneerTreePlacers {

  public static class Trunk {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Pioneer.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<AspenTrunkPlacer>> ASPEN_TRUNK_PLACER  = registerTrunkPlacer("aspen_trunk_placer", () -> new TrunkPlacerType<>(AspenTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<BaobabTrunkPlacer>> BAOBAB_TRUNK_PLACER    = registerTrunkPlacer("baobab_trunk_placer", () -> new TrunkPlacerType<>(BaobabTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<DesertJuniperTrunkPlacer>> DESERT_JUNIPER_TRUNK_PLACER  = registerTrunkPlacer("desert_juniper_trunk_placer", () -> new TrunkPlacerType<>(DesertJuniperTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<PalmTrunkPlacer>> PALM_TRUNK_PLACER  = registerTrunkPlacer("palm_trunk_placer", () -> new TrunkPlacerType<>(PalmTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<RedwoodTrunkPlacer>> REDWOOD_TRUNK_PLACER  = registerTrunkPlacer("redwood_trunk_placer", () -> new TrunkPlacerType<>(RedwoodTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<SmallRedwoodTrunkPlacer>> SMALL_REDWOOD_TRUNK_PLACER  = registerTrunkPlacer("small_redwood_trunk_placer", () -> new TrunkPlacerType<>(SmallRedwoodTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<TwistedTrunkPlacer>> TWISTED_TRUNK_PLACER  = registerTrunkPlacer("twisted_trunk_placer", () -> new TrunkPlacerType<>(TwistedTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<WillowTrunkPlacer>> WILLOW_TRUNK_PLACER = registerTrunkPlacer("willow_trunk_placer", () -> new TrunkPlacerType<>(WillowTrunkPlacer.CODEC));

    private static <T extends TrunkPlacer> RegistryObject<TrunkPlacerType<T>> registerTrunkPlacer(String name, Supplier<TrunkPlacerType<T>> type) {
      return TRUNK_PLACERS.register(name, type);
    }
  }

  public static class Foliage {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, Pioneer.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<PalmFoliagePlacer>> PALM_FOLIAGE_PLACER = registerFoliagePlacer("palm_foliage_placer", () -> new FoliagePlacerType<>(PalmFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<AspenFoliagePlacer>> ASPEN_FOLIAGE_PLACER = registerFoliagePlacer("aspen_foliage_placer", () -> new FoliagePlacerType<>(AspenFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<BaobabFoliagePlacer>> BAOBAB_FOLIAGE_PLACER = registerFoliagePlacer("baobab_foliage_placer", () -> new FoliagePlacerType<>(BaobabFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<DesertJuniperFoliagePlacer>> DESERT_JUNIPER_FOLIAGE_PLACER = registerFoliagePlacer("desert_juniper_foliage_placer", () -> new FoliagePlacerType<>(DesertJuniperFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<SpruceFoliagePlacer>> PINE_FOLIAGE_PLACER = registerFoliagePlacer("pioneer_pine_foliage_placer", () -> new FoliagePlacerType<>(SpruceFoliagePlacer.CODEC));

    private static <T extends FoliagePlacer> RegistryObject<FoliagePlacerType<T>> registerFoliagePlacer(String name, Supplier<FoliagePlacerType<T>> type) {
      return FOLIAGE_PLACERS.register(name, type);
    }
  }

  public static class Decorator {
    public static final DeferredRegister<TreeDecoratorType<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, Pioneer.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<CoconutDecorator>> COCONUT_DECORATOR = registerTreeDecorator("coconut_decorator", () -> new TreeDecoratorType<>(CoconutDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<JuniperBerriesDecorator>> JUNIPER_BERRIES_DECORATOR = registerTreeDecorator("juniper_berries_decorator", () -> new TreeDecoratorType<>(JuniperBerriesDecorator.CODEC));

    private static <T extends TreeDecorator> RegistryObject<TreeDecoratorType<T>> registerTreeDecorator(String name, Supplier<TreeDecoratorType<T>> type) {
      return DECORATORS.register(name, type);
    }
  }
}
