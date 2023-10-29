package pioneer.core.registry;

import java.util.List;
import java.util.function.Supplier;

import com.teamabnormals.blueprint.core.util.BlockUtil;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.grower.MangroveTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import pioneer.common.blocks.BerriedJuniperLeavesBlock;
import pioneer.common.blocks.CoconutBlock;
import pioneer.common.blocks.CustomSubstrateSaplingBlock;
import pioneer.common.blocks.DesertBushBlock;
import pioneer.common.blocks.DesertDoubleHighPlantBlock;
import pioneer.common.blocks.DryGrassBlock;
import pioneer.common.blocks.FallenLeavesBlock;
import pioneer.common.blocks.PrairieGrassBlock;
import pioneer.common.blocks.grower.AspenTreeGrower;
import pioneer.common.blocks.grower.BaobabTreeGrower;
import pioneer.common.blocks.grower.CottonwoodTreeGrower;
import pioneer.common.blocks.grower.FirTreeGrower;
import pioneer.common.blocks.grower.JoshuaTreeGrower;
import pioneer.common.blocks.grower.JuniperTreeGrower;
import pioneer.common.blocks.grower.OrangeMapleTreeGrower;
import pioneer.common.blocks.grower.PalmTreeGrower;
import pioneer.common.blocks.grower.PineTreeGrower;
import pioneer.common.blocks.grower.PinkSakuraTreeGrower;
import pioneer.common.blocks.grower.PurpleMapleTreeGrower;
import pioneer.common.blocks.grower.RedMapleTreeGrower;
import pioneer.common.blocks.grower.RedwoodTreeGrower;
import pioneer.common.blocks.grower.TamarackTreeGrower;
import pioneer.common.blocks.grower.WhiteSakuraTreeGrower;
import pioneer.common.blocks.grower.WillowTreeGrower;
import pioneer.core.Pioneer;

@EventBusSubscriber(modid = Pioneer.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PioneerBlocks {
	public static final BlockSubRegistryHelper HELPER = Pioneer.REGISTRY_HELPER.getBlockSubHelper();
	
	public static final Block[] TERRACOTTA_BLOCKS = {
			Blocks.TERRACOTTA, Blocks.WHITE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA,
			Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.PINK_TERRACOTTA,
			Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA,
			Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA,
			Blocks.BLACK_TERRACOTTA
	};
	
	public static final RegistryObject<Block> DESERT_SAGE = HELPER.createBlock("desert_sage", () -> new DesertBushBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> DESERT_AGAVE = HELPER.createBlock("desert_agave", () -> new DesertBushBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BLOOMING_DESERT_AGAVE = HELPER.createBlock("blooming_desert_agave", () -> new DesertDoubleHighPlantBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PRAIRIE_GRASS = HELPER.createBlock("prairie_grass", () -> new PrairieGrassBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> DRY_GRASS = HELPER.createBlock("dry_grass", () -> new DryGrassBlock(), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> ASPEN_FALLEN_LEAVES = HELPER.createBlock("aspen_fallen_leaves", () -> new FallenLeavesBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> RED_MAPLE_FALLEN_LEAVES = HELPER.createBlock("red_maple_fallen_leaves", () -> new FallenLeavesBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ORANGE_MAPLE_FALLEN_LEAVES = HELPER.createBlock("orange_maple_fallen_leaves", () -> new FallenLeavesBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PURPLE_MAPLE_FALLEN_LEAVES = HELPER.createBlock("purple_maple_fallen_leaves", () -> new FallenLeavesBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINK_SAKURA_FALLEN_LEAVES = HELPER.createBlock("pink_sakura_fallen_leaves", () -> new FallenLeavesBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WHITE_SAKURA_FALLEN_LEAVES = HELPER.createBlock("white_sakura_fallen_leaves", () -> new FallenLeavesBlock(), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> COCONUT = HELPER.createBlock("coconut", () -> new CoconutBlock(), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_FIR_LOG = HELPER.createBlock("stripped_fir_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> STRIPPED_FIR_WOOD = HELPER.createBlock("stripped_fir_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_SAPLING = HELPER.createBlock("fir_sapling", () -> new SaplingBlock(new FirTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_LOG = HELPER.createBlock("fir_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, STRIPPED_FIR_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_LEAVES = HELPER.createBlock("fir_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_WOOD = HELPER.createBlock("fir_wood", () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, STRIPPED_FIR_WOOD), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_PLANKS = HELPER.createBlock("fir_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_PRESSURE_PLATE = HELPER.createBlock("fir_pressure_plate", () -> createPressurePlate(FIR_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_TRAPDOOR = HELPER.createBlock("fir_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_BUTTON = HELPER.createBlock("fir_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_SLAB = HELPER.createBlock("fir_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_FENCE_GATE = HELPER.createBlock("fir_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_FENCE = HELPER.createBlock("fir_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_DOOR = HELPER.createBlock("fir_door", () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> FIR_STAIRS = HELPER.createBlock("fir_stairs", () -> new StairBlock(() -> FIR_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_PINE_LOG = HELPER.createBlock("stripped_pine_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> STRIPPED_PINE_WOOD = HELPER.createBlock("stripped_pine_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINE_SAPLING = HELPER.createBlock("pine_sapling", () -> new SaplingBlock(new PineTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINE_LOG = HELPER.createBlock("pine_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, STRIPPED_PINE_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINE_LEAVES = HELPER.createBlock("pine_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> pine_wood = HELPER.createBlock("pine_wood", () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, STRIPPED_PINE_WOOD), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINE_PLANKS = HELPER.createBlock("pine_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINE_PRESSURE_PLATE = HELPER.createBlock("pine_pressure_plate", () -> createPressurePlate(PINE_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINE_TRAPDOOR = HELPER.createBlock("pine_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINE_BUTTON = HELPER.createBlock("pine_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINE_SLAB = HELPER.createBlock("pine_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINE_FENCE_GATE = HELPER.createBlock("pine_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINE_FENCE = HELPER.createBlock("pine_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINE_DOOR = HELPER.createBlock("pine_door", () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINE_STAIRS = HELPER.createBlock("pine_stairs", () -> new StairBlock(() -> PINE_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = HELPER.createBlock("stripped_redwood_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> STRIPPED_REDWOOD_WOOD = HELPER.createBlock("stripped_redwood_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_SAPLING = HELPER.createBlock("redwood_sapling", () -> new SaplingBlock(new RedwoodTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_LOG = HELPER.createBlock("redwood_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, STRIPPED_REDWOOD_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_LEAVES = HELPER.createBlock("redwood_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_WOOD = HELPER.createBlock("redwood_wood", () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, STRIPPED_REDWOOD_WOOD), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_PLANKS = HELPER.createBlock("redwood_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_PRESSURE_PLATE = HELPER.createBlock("redwood_pressure_plate", () -> createPressurePlate(REDWOOD_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_TRAPDOOR = HELPER.createBlock("redwood_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_BUTTON = HELPER.createBlock("redwood_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_SLAB = HELPER.createBlock("redwood_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_FENCE_GATE = HELPER.createBlock("redwood_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_FENCE = HELPER.createBlock("redwood_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_DOOR = HELPER.createBlock("redwood_door", () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> REDWOOD_STAIRS = HELPER.createBlock("redwood_stairs", () -> new StairBlock(() -> REDWOOD_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_WILLOW_LOG = HELPER.createBlock("stripped_willow_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> STRIPPED_WILLOW_WOOD = HELPER.createBlock("stripped_willow_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_SAPLING = HELPER.createBlock("willow_sapling", () -> new CustomSubstrateSaplingBlock(new WillowTreeGrower(), List.of(Tags.Blocks.SAND)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_LOG = HELPER.createBlock("willow_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, STRIPPED_WILLOW_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_LEAVES = HELPER.createBlock("willow_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_WOOD = HELPER.createBlock("willow_wood", () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, STRIPPED_WILLOW_WOOD), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_PLANKS = HELPER.createBlock("willow_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_PRESSURE_PLATE = HELPER.createBlock("willow_pressure_plate", () -> createPressurePlate(WILLOW_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_TRAPDOOR = HELPER.createBlock("willow_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_BUTTON = HELPER.createBlock("willow_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_SLAB = HELPER.createBlock("willow_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_FENCE_GATE = HELPER.createBlock("willow_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_FENCE = HELPER.createBlock("willow_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_DOOR = HELPER.createBlock("willow_door", () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WILLOW_STAIRS = HELPER.createBlock("willow_stairs", () -> new StairBlock(() -> WILLOW_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_PALM_LOG = HELPER.createBlock("stripped_palm_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> STRIPPED_PALM_WOOD = HELPER.createBlock("stripped_palm_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_SAPLING = HELPER.createBlock("palm_sapling", () -> new CustomSubstrateSaplingBlock(new PalmTreeGrower(), List.of(Tags.Blocks.SAND)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_LOG = HELPER.createBlock("palm_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, STRIPPED_PALM_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_LEAVES = HELPER.createBlock("palm_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_WOOD = HELPER.createBlock("palm_wood", () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, STRIPPED_PALM_WOOD), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_PLANKS = HELPER.createBlock("palm_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_PRESSURE_PLATE = HELPER.createBlock("palm_pressure_plate", () -> createPressurePlate(PALM_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_TRAPDOOR = HELPER.createBlock("palm_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_BUTTON = HELPER.createBlock("palm_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_SLAB = HELPER.createBlock("palm_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_FENCE_GATE = HELPER.createBlock("palm_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_FENCE = HELPER.createBlock("palm_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_DOOR = HELPER.createBlock("palm_door",  () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PALM_STAIRS = HELPER.createBlock("palm_stairs", () -> new StairBlock(() -> PALM_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_COTTONWOOD_LOG = HELPER.createBlock("stripped_cottonwood_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> STRIPPED_COTTONWOOD_WOOD = HELPER.createBlock("stripped_cottonwood_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_SAPLING = HELPER.createBlock("cottonwood_sapling", () -> new SaplingBlock(new CottonwoodTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_LOG = HELPER.createBlock("cottonwood_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, STRIPPED_COTTONWOOD_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_LEAVES = HELPER.createBlock("cottonwood_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_WOOD = HELPER.createBlock("cottonwood_wood", () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, STRIPPED_COTTONWOOD_WOOD), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_PLANKS = HELPER.createBlock("cottonwood_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_PRESSURE_PLATE = HELPER.createBlock("cottonwood_pressure_plate", () -> createPressurePlate(COTTONWOOD_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_TRAPDOOR = HELPER.createBlock("cottonwood_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_BUTTON = HELPER.createBlock("cottonwood_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_SLAB = HELPER.createBlock("cottonwood_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_FENCE_GATE = HELPER.createBlock("cottonwood_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_FENCE = HELPER.createBlock("cottonwood_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_DOOR = HELPER.createBlock("cottonwood_door", () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> COTTONWOOD_STAIRS = HELPER.createBlock("cottonwood_stairs", () -> new StairBlock(() -> COTTONWOOD_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_ASPEN_LOG = HELPER.createBlock("stripped_aspen_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> STRIPPED_ASPEN_WOOD = HELPER.createBlock("stripped_aspen_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_SAPLING = HELPER.createBlock("aspen_sapling", () -> new SaplingBlock(new AspenTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_LOG = HELPER.createBlock("aspen_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, STRIPPED_ASPEN_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_LEAVES = HELPER.createBlock("aspen_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_WOOD = HELPER.createBlock("aspen_wood", () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, STRIPPED_ASPEN_WOOD), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_PLANKS = HELPER.createBlock("aspen_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_PRESSURE_PLATE = HELPER.createBlock("aspen_pressure_plate", () -> createPressurePlate(ASPEN_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_TRAPDOOR = HELPER.createBlock("aspen_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_BUTTON = HELPER.createBlock("aspen_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_SLAB = HELPER.createBlock("aspen_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_FENCE_GATE = HELPER.createBlock("aspen_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_FENCE = HELPER.createBlock("aspen_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_DOOR = HELPER.createBlock("aspen_door", () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ASPEN_STAIRS = HELPER.createBlock("aspen_stairs", () -> new StairBlock(() -> ASPEN_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_JUNIPER_LOG = HELPER.createBlock("stripped_juniper_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> stripped_juniper_wood = HELPER.createBlock("stripped_juniper_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_SAPLING = HELPER.createBlock("juniper_sapling", () -> new CustomSubstrateSaplingBlock(new JuniperTreeGrower(), List.of(Tags.Blocks.SAND), TERRACOTTA_BLOCKS), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_LOG = HELPER.createBlock("juniper_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, STRIPPED_JUNIPER_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BERRIED_JUNIPER_LEAVES = HELPER.createBlock("berried_juniper_leaves", () -> new BerriedJuniperLeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_LEAVES = HELPER.createBlock("juniper_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_WOOD = HELPER.createBlock("juniper_wood", () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_juniper_wood.get()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_PLANKS = HELPER.createBlock("juniper_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_PRESSURE_PLATE = HELPER.createBlock("juniper_pressure_plate", () -> createPressurePlate(JUNIPER_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_TRAPDOOR = HELPER.createBlock("juniper_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_BUTTON = HELPER.createBlock("juniper_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_SLAB = HELPER.createBlock("juniper_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_FENCE_GATE = HELPER.createBlock("juniper_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_FENCE = HELPER.createBlock("juniper_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_DOOR = HELPER.createBlock("juniper_door", () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JUNIPER_STAIRS = HELPER.createBlock("juniper_stairs", () -> new StairBlock(() -> JUNIPER_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_BAOBAB_LOG = HELPER.createBlock("stripped_baobab_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> STRIPPED_BAOBAB_WOOD = HELPER.createBlock("stripped_baobab_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_SAPLING = HELPER.createBlock("baobab_sapling", () -> new SaplingBlock(new BaobabTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_LOG = HELPER.createBlock("baobab_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, STRIPPED_BAOBAB_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_LEAVES = HELPER.createBlock("baobab_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_WOOD = HELPER.createBlock("baobab_wood", () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, STRIPPED_BAOBAB_WOOD), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_PLANKS = HELPER.createBlock("baobab_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_PRESSURE_PLATE = HELPER.createBlock("baobab_pressure_plate", () -> createPressurePlate(BAOBAB_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_TRAPDOOR = HELPER.createBlock("baobab_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_BUTTON = HELPER.createBlock("baobab_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_SLAB = HELPER.createBlock("baobab_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_FENCE_GATE = HELPER.createBlock("baobab_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_FENCE = HELPER.createBlock("baobab_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_DOOR = HELPER.createBlock("baobab_door", () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> BAOBAB_STAIRS = HELPER.createBlock("baobab_stairs", () -> new StairBlock(() -> BAOBAB_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = HELPER.createBlock("stripped_maple_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = HELPER.createBlock("stripped_maple_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> RED_MAPLE_SAPLING = HELPER.createBlock("red_maple_sapling", () -> new SaplingBlock(new RedMapleTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ORANGE_MAPLE_SAPLING = HELPER.createBlock("orange_maple_sapling", () -> new SaplingBlock(new OrangeMapleTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PURPLE_MAPLE_SAPLING = HELPER.createBlock("purple_maple_sapling", () -> new SaplingBlock(new PurpleMapleTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> MAPLE_LOG = HELPER.createBlock("maple_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, STRIPPED_MAPLE_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> RED_MAPLE_LEAVES = HELPER.createBlock("red_maple_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)) { public MaterialColor defaultMaterialColor() { return MaterialColor.COLOR_RED; } }, PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> ORANGE_MAPLE_LEAVES = HELPER.createBlock("orange_maple_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)) { public MaterialColor defaultMaterialColor() { return MaterialColor.COLOR_ORANGE; } }, PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PURPLE_MAPLE_LEAVES = HELPER.createBlock("purple_maple_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)) { public MaterialColor defaultMaterialColor() { return MaterialColor.COLOR_PURPLE; } }, PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> MAPLE_WOOD = HELPER.createBlock("maple_wood", () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, STRIPPED_MAPLE_WOOD), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> MAPLE_PLANKS = HELPER.createBlock("maple_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = HELPER.createBlock("maple_pressure_plate", () -> createPressurePlate(MAPLE_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> MAPLE_TRAPDOOR = HELPER.createBlock("maple_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> MAPLE_BUTTON = HELPER.createBlock("maple_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> MAPLE_SLAB = HELPER.createBlock("maple_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> MAPLE_FENCE_GATE = HELPER.createBlock("maple_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> MAPLE_FENCE = HELPER.createBlock("maple_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> MAPLE_DOOR = HELPER.createBlock("maple_door", () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> MAPLE_STAIRS = HELPER.createBlock("maple_stairs", () -> new StairBlock(() -> MAPLE_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_SAKURA_LOG = HELPER.createBlock("stripped_sakura_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_RED, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> STRIPPED_SAKURA_WOOD = HELPER.createBlock("stripped_sakura_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_RED, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINK_SAKURA_SAPLING = HELPER.createBlock("pink_sakura_sapling", () -> new SaplingBlock(new PinkSakuraTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WHITE_SAKURA_SAPLING = HELPER.createBlock("white_sakura_sapling", () -> new SaplingBlock(new WhiteSakuraTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> SAKURA_LOG = HELPER.createBlock("sakura_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_RED, STRIPPED_SAKURA_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> PINK_SAKURA_LEAVES = HELPER.createBlock("pink_sakura_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> WHITE_SAKURA_LEAVES = HELPER.createBlock("white_sakura_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> SAKURA_WOOD = HELPER.createBlock("sakura_wood", () -> createLogBlock(MaterialColor.COLOR_RED, MaterialColor.COLOR_RED, STRIPPED_SAKURA_WOOD), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> SAKURA_PLANKS = HELPER.createBlock("sakura_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> SAKURA_PRESSURE_PLATE = HELPER.createBlock("sakura_pressure_plate", () -> createPressurePlate(SAKURA_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> SAKURA_TRAPDOOR = HELPER.createBlock("sakura_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> SAKURA_BUTTON = HELPER.createBlock("sakura_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> SAKURA_SLAB = HELPER.createBlock("sakura_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> SAKURA_FENCE_GATE = HELPER.createBlock("sakura_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> SAKURA_FENCE = HELPER.createBlock("sakura_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> SAKURA_DOOR = HELPER.createBlock("sakura_door", () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> SAKURA_STAIRS = HELPER.createBlock("sakura_stairs", () -> new StairBlock(() -> SAKURA_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_TAMARACK_LOG = HELPER.createBlock("stripped_tamarack_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> STRIPPED_TAMARACK_WOOD = HELPER.createBlock("stripped_tamarack_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_SAPLING = HELPER.createBlock("tamarack_sapling", () -> new SaplingBlock(new TamarackTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_LOG = HELPER.createBlock("tamarack_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, STRIPPED_TAMARACK_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_LEAVES = HELPER.createBlock("tamarack_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_WOOD = HELPER.createBlock("tamarack_wood", () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, STRIPPED_TAMARACK_WOOD), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_PLANKS = HELPER.createBlock("tamarack_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_PRESSURE_PLATE = HELPER.createBlock("tamarack_pressure_plate", () -> createPressurePlate(TAMARACK_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_TRAPDOOR = HELPER.createBlock("tamarack_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_BUTTON = HELPER.createBlock("tamarack_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_SLAB = HELPER.createBlock("tamarack_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_FENCE_GATE = HELPER.createBlock("tamarack_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_FENCE = HELPER.createBlock( "tamarack_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_DOOR = HELPER.createBlock("tamarack_door", () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> TAMARACK_STAIRS = HELPER.createBlock("tamarack_stairs", () -> new StairBlock(() -> TAMARACK_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> STRIPPED_JOSHUA_LOG = HELPER.createBlock("stripped_joshua_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> STRIPPED_JOSHUA_WOOD = HELPER.createBlock("stripped_joshua_wood", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_SAPLING = HELPER.createBlock("joshua_sapling", () -> new CustomSubstrateSaplingBlock(new JoshuaTreeGrower(), List.of(Tags.Blocks.SAND)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_LOG = HELPER.createBlock("joshua_log", () -> createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, STRIPPED_JOSHUA_LOG), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_LEAVES = HELPER.createBlock("joshua_leaves", () -> new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_WOOD = HELPER.createBlock("joshua_wood", () -> createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, STRIPPED_JOSHUA_WOOD), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_PLANKS = HELPER.createBlock("joshua_planks", () -> createPlanksBlock(), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_PRESSURE_PLATE = HELPER.createBlock("joshua_pressure_plate", () -> createPressurePlate(JOSHUA_PLANKS.get().defaultMaterialColor()), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_TRAPDOOR = HELPER.createBlock("joshua_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_BUTTON = HELPER.createBlock("joshua_button", () -> new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_SLAB = HELPER.createBlock("joshua_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_FENCE_GATE = HELPER.createBlock("joshua_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_FENCE = HELPER.createBlock("joshua_fence", () -> new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_DOOR = HELPER.createBlock("joshua_door", () -> new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), PioneerCreativeModeTab.INSTANCE);
	public static final RegistryObject<Block> JOSHUA_STAIRS = HELPER.createBlock("joshua_stairs", () -> new StairBlock(() -> JOSHUA_PLANKS.get().defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), PioneerCreativeModeTab.INSTANCE);
	
	public static final RegistryObject<Block> POTTED_PALM_SAPLING = HELPER.createBlockNoItem("potted_palm_sapling", () -> createFlowerPot(PALM_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_REDWOOD_SAPLING = HELPER.createBlockNoItem("potted_redwood_sapling", () -> createFlowerPot(REDWOOD_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_FIR_SAPLING = HELPER.createBlockNoItem("potted_fir_sapling", () -> createFlowerPot(FIR_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_PINE_SAPLING = HELPER.createBlockNoItem("potted_pine_sapling", () -> createFlowerPot(PINE_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_WILLOW_SAPLING = HELPER.createBlockNoItem("potted_willow_sapling", () -> createFlowerPot(WILLOW_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_BAOBAB_SAPLING = HELPER.createBlockNoItem("potted_baobab_sapling", () -> createFlowerPot(BAOBAB_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_JUNIPER_SAPLING = HELPER.createBlockNoItem("potted_juniper_sapling", () -> createFlowerPot(JUNIPER_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_COTTONWOOD_SAPLING = HELPER.createBlockNoItem("potted_cottonwood_sapling", () -> createFlowerPot(COTTONWOOD_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_ASPEN_SAPLING = HELPER.createBlockNoItem("potted_aspen_sapling", () -> createFlowerPot(ASPEN_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_RED_MAPLE_SAPLING = HELPER.createBlockNoItem("potted_red_maple_sapling", () -> createFlowerPot(RED_MAPLE_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_ORANGE_MAPLE_SAPLING = HELPER.createBlockNoItem("potted_orange_maple_sapling", () -> createFlowerPot(ORANGE_MAPLE_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_PURPLE_MAPLE_SAPLING = HELPER.createBlockNoItem("potted_purple_maple_sapling", () -> createFlowerPot(PURPLE_MAPLE_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_PINK_SAKURA_SAPLING = HELPER.createBlockNoItem("potted_pink_sakura_sapling", () -> createFlowerPot(PINK_SAKURA_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_WHITE_SAKURA_SAPLING = HELPER.createBlockNoItem("potted_white_sakura_sapling", () -> createFlowerPot(WHITE_SAKURA_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_TAMARACK_SAPLING = HELPER.createBlockNoItem("potted_tamarack_sapling", () -> createFlowerPot(TAMARACK_SAPLING.get()));
	public static final RegistryObject<Block> POTTED_JOSHUA_SAPLING = HELPER.createBlockNoItem("potted_joshua_sapling", () -> createFlowerPot(JOSHUA_SAPLING.get()));
	
	
	public static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor barkColor, Supplier<Block> stripped) {
		return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) -> {
			return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
		}).strength(2.0F).sound(SoundType.WOOD)) {
			@Override
			public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction action, boolean simulate) {
				if(action == ToolActions.AXE_STRIP)
					return stripped != null ? BlockUtil.transferAllBlockStates(state, stripped.get().defaultBlockState()) : null;
				return super.getToolModifiedState(state, context, action, simulate);
			}
		};
	}
	
	public static PressurePlateBlock createPressurePlate(MaterialColor color) {
		return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
				BlockBehaviour.Properties.of(Material.WOOD, color).noCollission()
				.strength(0.5F).sound(SoundType.WOOD));
	}

	public static Block createPlanksBlock() {
		return new Block(Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F)
				.sound(SoundType.WOOD));
	}
	
	public static Block createFlowerPot(Block plant) {
		Block block = new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ()-> plant, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT));
		((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ForgeRegistries.BLOCKS.getKey(plant), () -> block);
		return block;
	}
}
