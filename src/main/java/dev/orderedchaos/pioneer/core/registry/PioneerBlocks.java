package dev.orderedchaos.pioneer.core.registry;

import com.teamabnormals.blueprint.core.api.BlockSetTypeRegistryHelper;
import com.teamabnormals.blueprint.core.api.WoodTypeRegistryHelper;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import dev.orderedchaos.pioneer.common.blocks.*;
import dev.orderedchaos.pioneer.common.blocks.treegrowers.PioneerTreeGrowers;
import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.util.WoodTypeUtil;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Pioneer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PioneerBlocks {
  public static final BlockSubRegistryHelper BLOCK_HELPER = Pioneer.REGISTRY_HELPER.getBlockSubHelper();

  protected static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

  public static final WoodTypeUtil.StandardWoodBlockSet ASPEN = WoodTypeUtil.registerStandardWood("aspen", WoodTypes.ASPEN, BlockSetTypes.ASPEN, WoodSets.ASPEN, PioneerTreeGrowers.ASPEN, NORMAL_LEAVES_SAPLING_CHANCES);
  public static final WoodTypeUtil.StandardWoodBlockSet BAOBAB = WoodTypeUtil.registerStandardWood("baobab", WoodTypes.BAOBAB, BlockSetTypes.BAOBAB, WoodSets.BAOBAB, PioneerTreeGrowers.BAOBAB, NORMAL_LEAVES_SAPLING_CHANCES);
  public static final WoodTypeUtil.StandardWoodBlockSet COTTONWOOD = WoodTypeUtil.registerStandardWood("cottonwood", WoodTypes.COTTONWOOD, BlockSetTypes.COTTONWOOD, WoodSets.COTTONWOOD, PioneerTreeGrowers.COTTONWOOD, NORMAL_LEAVES_SAPLING_CHANCES);
  public static final WoodTypeUtil.StandardWoodBlockSet FIR = WoodTypeUtil.registerStandardWood("fir", WoodTypes.FIR, BlockSetTypes.FIR, WoodSets.FIR, PioneerTreeGrowers.FIR, NORMAL_LEAVES_SAPLING_CHANCES);
  public static final WoodTypeUtil.StandardWoodBlockSet JOSHUA = WoodTypeUtil.registerStandardWood("joshua", WoodTypes.JOSHUA, BlockSetTypes.JOSHUA, WoodSets.JOSHUA, PioneerTreeGrowers.JOSHUA, NORMAL_LEAVES_SAPLING_CHANCES, DesertSaplingBlock::new);
  public static final WoodTypeUtil.StandardWoodBlockSet JUNIPER = WoodTypeUtil.registerStandardWood("juniper", WoodTypes.JUNIPER, BlockSetTypes.JUNIPER, WoodSets.JUNIPER, PioneerTreeGrowers.JUNIPER, NORMAL_LEAVES_SAPLING_CHANCES, JuniperSaplingBlock::new);
  public static final WoodTypeUtil.StandardWoodBlockSet MAPLE = WoodTypeUtil.registerStandardWood("maple", WoodTypes.MAPLE, BlockSetTypes.MAPLE, WoodSets.MAPLE, PioneerTreeGrowers.RED_MAPLE, NORMAL_LEAVES_SAPLING_CHANCES);
  public static final WoodTypeUtil.StandardWoodBlockSet PALM = WoodTypeUtil.registerStandardWood("palm", WoodTypes.PALM, BlockSetTypes.PALM, WoodSets.PALM, PioneerTreeGrowers.PALM, NORMAL_LEAVES_SAPLING_CHANCES, DesertSaplingBlock::new);
  public static final WoodTypeUtil.StandardWoodBlockSet PINE = WoodTypeUtil.registerStandardWood("pine", WoodTypes.PINE, BlockSetTypes.PINE, WoodSets.PINE, PioneerTreeGrowers.PINE, NORMAL_LEAVES_SAPLING_CHANCES);
  public static final WoodTypeUtil.StandardWoodBlockSet REDWOOD = WoodTypeUtil.registerStandardWood("redwood", WoodTypes.REDWOOD, BlockSetTypes.REDWOOD, WoodSets.REDWOOD, PioneerTreeGrowers.REDWOOD, NORMAL_LEAVES_SAPLING_CHANCES);
  public static final WoodTypeUtil.StandardWoodBlockSet TAMARACK = WoodTypeUtil.registerStandardWood("tamarack", WoodTypes.TAMARACK, BlockSetTypes.TAMARACK, WoodSets.TAMARACK, PioneerTreeGrowers.TAMARACK, NORMAL_LEAVES_SAPLING_CHANCES);
  public static final WoodTypeUtil.StandardWoodBlockSet WILLOW = WoodTypeUtil.registerStandardWood("willow", WoodTypes.WILLOW, BlockSetTypes.WILLOW, WoodSets.WILLOW, PioneerTreeGrowers.WILLOW, NORMAL_LEAVES_SAPLING_CHANCES, DesertSaplingBlock::new);

  public static final RegistryObject<Block> BERRIED_JUNIPER_LEAVES = BLOCK_HELPER.createBlock("berried_juniper_leaves", () -> new BerriedJuniperLeavesBlock(WoodSets.JUNIPER.leaves()));
  public static final RegistryObject<Block> ORANGE_MAPLE_LEAVES = BLOCK_HELPER.createBlock("orange_maple_leaves", () -> new LeavesBlock(WoodSets.MAPLE.leaves()));
  public static final RegistryObject<Block> PURPLE_MAPLE_LEAVES = BLOCK_HELPER.createBlock("purple_maple_leaves", () -> new LeavesBlock(WoodSets.MAPLE.leaves()));

  public static final RegistryObject<Block> ORANGE_MAPLE_SAPLING = BLOCK_HELPER.createBlock("orange_maple_sapling", () -> new SaplingBlock(PioneerTreeGrowers.ORANGE_MAPLE, WoodSets.MAPLE.sapling()));
  public static final RegistryObject<Block> PURPLE_MAPLE_SAPLING = BLOCK_HELPER.createBlock("purple_maple_sapling", () -> new SaplingBlock(PioneerTreeGrowers.PURPLE_MAPLE, WoodSets.MAPLE.sapling()));

  public static final RegistryObject<Block> POTTED_ORANGE_MAPLE_SAPLING = flowerPot("potted_orange_maple_sapling", ORANGE_MAPLE_SAPLING);
  public static final RegistryObject<Block> POTTED_PURPLE_MAPLE_SAPLING = flowerPot("potted_purple_maple_sapling", PURPLE_MAPLE_SAPLING);

  public static final RegistryObject<Block> COCONUT = BLOCK_HELPER.createBlock("coconut", () -> new CoconutBlock(Block.Properties.of().strength(0.4F, 0.7F).sound(SoundType.WOOD)));

  public static final RegistryObject<Block> PRAIRIE_GRASS = BLOCK_HELPER.createBlock("prairie_grass", () -> new PrairieGrassBlock(Block.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ).replaceable()));
  public static final RegistryObject<Block> DRY_GRASS = BLOCK_HELPER.createBlock("dry_grass", () -> new DryGrassBlock(Block.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ).replaceable()));
  public static final RegistryObject<Block> DESERT_SAGE = BLOCK_HELPER.createBlock("desert_sage", () -> new DesertBushBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)));
  public static final RegistryObject<Block> DESERT_AGAVE = BLOCK_HELPER.createBlock("desert_agave", () -> new DesertBushBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)));
  public static final RegistryObject<Block> BLOOMING_DESERT_AGAVE  = BLOCK_HELPER.createBlock("blooming_desert_agave", () -> new DesertDoubleHighPlantBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)));

  public static final RegistryObject<Block> ASPEN_FALLEN_LEAVES = BLOCK_HELPER.createBlock("aspen_fallen_leaves", () -> new FallenLeavesBlock(Block.Properties.of().strength(0.1F, 0.0F).sound(SoundType.GRASS).mapColor(MapColor.COLOR_YELLOW).noOcclusion()));
  public static final RegistryObject<Block> RED_MAPLE_FALLEN_LEAVES = BLOCK_HELPER.createBlock("red_maple_fallen_leaves", () -> new FallenLeavesBlock(Block.Properties.of().strength(0.1F, 0.0F).sound(SoundType.GRASS).mapColor(MapColor.COLOR_RED).noOcclusion()));
  public static final RegistryObject<Block> ORANGE_MAPLE_FALLEN_LEAVES = BLOCK_HELPER.createBlock("orange_maple_fallen_leaves", () -> new FallenLeavesBlock(Block.Properties.of().strength(0.1F, 0.0F).sound(SoundType.GRASS).mapColor(MapColor.COLOR_ORANGE).noOcclusion()));
  public static final RegistryObject<Block> PURPLE_MAPLE_FALLEN_LEAVES = BLOCK_HELPER.createBlock("purple_maple_fallen_leaves", () -> new FallenLeavesBlock(Block.Properties.of().strength(0.1F, 0.0F).sound(SoundType.GRASS).mapColor(MapColor.COLOR_PURPLE).noOcclusion()));

  private static RegistryObject<Block> flowerPot(String name, RegistryObject<Block> sapling) {
    RegistryObject<Block> pot = BLOCK_HELPER.createBlockNoItem(name, () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, sapling, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(sapling.getId(), pot);
    return pot;
  }

  public static class BlockSetTypes {

    public static final BlockSetType ASPEN = register("aspen");
    public static final BlockSetType BAOBAB = register("baobab");
    public static final BlockSetType COTTONWOOD = register("cottonwood");
    public static final BlockSetType FIR = register("fir");
    public static final BlockSetType JOSHUA = register("joshua");
    public static final BlockSetType JUNIPER = register("juniper");
    public static final BlockSetType MAPLE = register("maple");
    public static final BlockSetType PALM = register("palm");
    public static final BlockSetType PINE = register("pine");
    public static final BlockSetType REDWOOD = register("redwood");
    public static final BlockSetType TAMARACK = register("tamarack");
    public static final BlockSetType WILLOW = register("willow");

    private static BlockSetType register(String name) {
      return BlockSetTypeRegistryHelper.register(new BlockSetType(Pioneer.MOD_ID + ":" + name));
    }
  }

  public static class WoodTypes {
    public static final WoodType ASPEN = register("aspen", BlockSetTypes.ASPEN);
    public static final WoodType BAOBAB = register("baobab", BlockSetTypes.BAOBAB);
    public static final WoodType COTTONWOOD = register("cottonwood", BlockSetTypes.COTTONWOOD);
    public static final WoodType FIR = register("fir", BlockSetTypes.FIR);
    public static final WoodType JOSHUA = register("joshua", BlockSetTypes.JOSHUA);
    public static final WoodType JUNIPER = register("juniper", BlockSetTypes.JUNIPER);
    public static final WoodType MAPLE = register("maple", BlockSetTypes.MAPLE);
    public static final WoodType PALM = register("palm", BlockSetTypes.PALM);
    public static final WoodType PINE = register("pine", BlockSetTypes.PINE);
    public static final WoodType REDWOOD = register("redwood", BlockSetTypes.REDWOOD);
    public static final WoodType TAMARACK = register("tamarack", BlockSetTypes.TAMARACK);
    public static final WoodType WILLOW = register("willow", BlockSetTypes.WILLOW);

    private static WoodType register(String name, BlockSetType blockSetType) {
      return WoodTypeRegistryHelper.registerWoodType(new WoodType(Pioneer.MOD_ID + ":" + name, blockSetType));
    }
  }

  public static class WoodSets {
    public static final PropertyUtil.WoodSetProperties ASPEN = register(MapColor.WOOD);
    public static final PropertyUtil.WoodSetProperties BAOBAB = register(MapColor.WOOD);
    public static final PropertyUtil.WoodSetProperties COTTONWOOD = register(MapColor.WOOD);
    public static final PropertyUtil.WoodSetProperties FIR = register(MapColor.WOOD);
    public static final PropertyUtil.WoodSetProperties JOSHUA = register(MapColor.WOOD);
    public static final PropertyUtil.WoodSetProperties JUNIPER = register(MapColor.WOOD);
    public static final PropertyUtil.WoodSetProperties MAPLE = register(MapColor.WOOD);
    public static final PropertyUtil.WoodSetProperties PALM = register(MapColor.WOOD);
    public static final PropertyUtil.WoodSetProperties PINE = register(MapColor.WOOD);
    public static final PropertyUtil.WoodSetProperties REDWOOD = register(MapColor.WOOD);
    public static final PropertyUtil.WoodSetProperties TAMARACK = register(MapColor.WOOD);
    public static final PropertyUtil.WoodSetProperties WILLOW = register(MapColor.WOOD);

    private static PropertyUtil.WoodSetProperties register(MapColor woodColor) {
      return PropertyUtil.WoodSetProperties.builder(woodColor).build();
    }
  }
}
