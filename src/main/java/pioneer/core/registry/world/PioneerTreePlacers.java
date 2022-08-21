package pioneer.core.registry.world;

import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import pioneer.common.world.features.tree.decorators.CoconutDecorator;
import pioneer.common.world.features.tree.decorators.JuniperBerriesDecorator;
import pioneer.common.world.features.tree.foliageplacers.AspenFoliagePlacer;
import pioneer.common.world.features.tree.foliageplacers.BaobabFoliagePlacer;
import pioneer.common.world.features.tree.foliageplacers.DesertJuniperFoliagePlacer;
import pioneer.common.world.features.tree.foliageplacers.JacarandaFoliagePlacer;
import pioneer.common.world.features.tree.foliageplacers.PalmFoliagePlacer;
import pioneer.common.world.features.tree.trunkplacers.AspenTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.BaobabTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.DesertJuniperTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.MangroveTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.PalmTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.RedwoodTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.SmallRedwoodTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.TwistedTrunkPlacer;
import pioneer.common.world.features.tree.trunkplacers.WillowTrunkPlacer;
import pioneer.core.Pioneer;

public class PioneerTreePlacers {

	public static class Trunk {
		
		public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registry.TRUNK_PLACER_TYPE_REGISTRY, Pioneer.MOD_ID);
		
		public static final RegistryObject<TrunkPlacerType<PalmTrunkPlacer>> PALM_TRUNK_PLACER = registerTrunkPlacer("palm_trunk_placer", () -> new TrunkPlacerType<PalmTrunkPlacer>(PalmTrunkPlacer.CODEC));
		public static final RegistryObject<TrunkPlacerType<AspenTrunkPlacer>> ASPEN_TRUNK_PLACER = registerTrunkPlacer("aspen_trunk_placer", () -> new TrunkPlacerType<AspenTrunkPlacer>(AspenTrunkPlacer.CODEC));
		public static final RegistryObject<TrunkPlacerType<BaobabTrunkPlacer>> BAOBAB_TRUNK_PLACER = registerTrunkPlacer("baobab_trunk_placer", () -> new TrunkPlacerType<BaobabTrunkPlacer>(BaobabTrunkPlacer.CODEC));
		public static final RegistryObject<TrunkPlacerType<DesertJuniperTrunkPlacer>> DESERT_JUNIPER_TRUNK_PLACER = registerTrunkPlacer("desert_juniper_trunk_placer", () -> new TrunkPlacerType<DesertJuniperTrunkPlacer>(DesertJuniperTrunkPlacer.CODEC));
		public static final RegistryObject<TrunkPlacerType<MangroveTrunkPlacer>> MANGROVE_TRUNK_PLACER = registerTrunkPlacer("mangrove_trunk_placer", () -> new TrunkPlacerType<MangroveTrunkPlacer>(MangroveTrunkPlacer.CODEC));
		public static final RegistryObject<TrunkPlacerType<RedwoodTrunkPlacer>> REDWOOD_TRUNK_PLACER = registerTrunkPlacer("redwood_trunk_placer", () -> new TrunkPlacerType<RedwoodTrunkPlacer>(RedwoodTrunkPlacer.CODEC));
		public static final RegistryObject<TrunkPlacerType<SmallRedwoodTrunkPlacer>> SMALL_REDWOOD_TRUNK_PLACER = registerTrunkPlacer("small_redwood_trunk_placer", () -> new TrunkPlacerType<SmallRedwoodTrunkPlacer>(SmallRedwoodTrunkPlacer.CODEC));
		public static final RegistryObject<TrunkPlacerType<TwistedTrunkPlacer>> TWISTED_TRUNK_PLACER = registerTrunkPlacer("twisted_trunk_placer", () -> new TrunkPlacerType<TwistedTrunkPlacer>(TwistedTrunkPlacer.CODEC));
		public static final RegistryObject<TrunkPlacerType<WillowTrunkPlacer>> WILLOW_TRUNK_PLACER = registerTrunkPlacer("willow_trunk_placer", () -> new TrunkPlacerType<WillowTrunkPlacer>(WillowTrunkPlacer.CODEC));
		
		private static <T extends TrunkPlacer> RegistryObject<TrunkPlacerType<T>> registerTrunkPlacer(String name, Supplier<TrunkPlacerType<T>> type) {
			return TRUNK_PLACERS.register(name, type);
		}
	}
	
	public static class Foliage {
		
		public static final DeferredRegister<FoliagePlacerType<?>> PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, Pioneer.MOD_ID);
		
		public static final RegistryObject<FoliagePlacerType<PalmFoliagePlacer>> PALM_FOLIAGE_PLACER = registerFoliagePlacer("palm_foliage_placer", new FoliagePlacerType<PalmFoliagePlacer>(PalmFoliagePlacer.CODEC));
		public static final RegistryObject<FoliagePlacerType<AspenFoliagePlacer>> ASPEN_FOLIAGE_PLACER = registerFoliagePlacer("aspen_foliage_placer", new FoliagePlacerType<AspenFoliagePlacer>(AspenFoliagePlacer.CODEC));
		public static final RegistryObject<FoliagePlacerType<BaobabFoliagePlacer>> BAOBAB_FOLIAGE_PLACER = registerFoliagePlacer("baobab_foliage_placer", new FoliagePlacerType<BaobabFoliagePlacer>(BaobabFoliagePlacer.CODEC));
		public static final RegistryObject<FoliagePlacerType<DesertJuniperFoliagePlacer>> DESERT_JUNIPER_FOLIAGE_PLACER = registerFoliagePlacer("desert_juniper_foliage_placer", new FoliagePlacerType<DesertJuniperFoliagePlacer>(DesertJuniperFoliagePlacer.CODEC));
		public static final RegistryObject<FoliagePlacerType<JacarandaFoliagePlacer>> JACARANDA_FOLIAGE_PLACER = registerFoliagePlacer("jacaranda_foliage_placer", new FoliagePlacerType<JacarandaFoliagePlacer>(JacarandaFoliagePlacer.CODEC));
		public static final RegistryObject<FoliagePlacerType<PineFoliagePlacer>> PINE_FOLIAGE_PLACER = registerFoliagePlacer("pine_foliage_placer", new FoliagePlacerType<PineFoliagePlacer>(PineFoliagePlacer.CODEC));
		
		private static <T extends FoliagePlacer> RegistryObject<FoliagePlacerType<T>> registerFoliagePlacer(String name, FoliagePlacerType<T> type) {
			return PLACERS.register(name, () -> type);
		}
	}
	
	public static class Decorator {
		public static final DeferredRegister<TreeDecoratorType<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, Pioneer.MOD_ID);
		
		public static final RegistryObject<TreeDecoratorType<CoconutDecorator>> COCONUT_DECORATOR = registerTreeDecorator("coconut_decorator", new TreeDecoratorType<CoconutDecorator>(CoconutDecorator.CODEC));
		public static final RegistryObject<TreeDecoratorType<JuniperBerriesDecorator>> JUNIPER_BERRIES_DECORATOR = registerTreeDecorator("juniper_berries_decorator", new TreeDecoratorType<JuniperBerriesDecorator>(JuniperBerriesDecorator.CODEC));
		
		private static <T extends TreeDecorator> RegistryObject<TreeDecoratorType<T>> registerTreeDecorator(String name, TreeDecoratorType<T> type) {
			return DECORATORS.register(name, () -> type);
		}
	}
}
