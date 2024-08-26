package dev.orderedchaos.pioneer.core.registry.util;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.LogBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintCeilingHangingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallHangingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.TagUtil;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import dev.orderedchaos.pioneer.core.Pioneer;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.function.TriFunction;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class WoodTypeUtil {

  public static final HashMap<String, StandardWoodBlockSet> WOOD_BLOCK_SETS = new HashMap<>();

  public record StandardWoodBlockSet(
    RegistryObject<Block> strippedLog,
    RegistryObject<Block> strippedWood,
    RegistryObject<Block> log,
    RegistryObject<Block> wood,
    RegistryObject<Block> leaves,
    RegistryObject<Block> sapling,
    RegistryObject<Block> planks,
    RegistryObject<Block> slab,
    RegistryObject<Block> stairs,
    RegistryObject<Block> fence,
    RegistryObject<Block> fenceGate,
    RegistryObject<Block> pressurePlate,
    RegistryObject<Block> button,
    RegistryObject<Block> door,
    RegistryObject<Block> trapdoor,
    Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> signs,
    Pair<RegistryObject<BlueprintCeilingHangingSignBlock>, RegistryObject<BlueprintWallHangingSignBlock>> hangingSigns,
    RegistryObject<Block> pottedSapling,
    Pair<TagKey<Block>, TagKey<Item>> logTags,
    float[] saplingChances
  ) {};

  public static StandardWoodBlockSet registerStandardWood(String name, WoodType woodType, BlockSetType blockSetType, PropertyUtil.WoodSetProperties woodSetProperties, AbstractTreeGrower treeGrower, float[] saplingChances, @Nullable BiFunction<AbstractTreeGrower, BlockBehaviour.Properties, SaplingBlock> saplingFactory) {
    final BlockSubRegistryHelper BLOCK_HELPER = Pioneer.REGISTRY_HELPER.getBlockSubHelper();

    final RegistryObject<Block> STRIPPED_LOG = BLOCK_HELPER.createFuelBlock(name + "_stripped_log", () -> new LogBlock(null, woodSetProperties.log()), 100);
    final RegistryObject<Block> STRIPPED_WOOD = BLOCK_HELPER.createFuelBlock(name + "_stripped_wood", () -> new LogBlock(null, woodSetProperties.log()), 100);
    final RegistryObject<Block> WOOD = BLOCK_HELPER.createFuelBlock(name + "_wood", () -> new LogBlock(STRIPPED_WOOD, woodSetProperties.log()), 100);
    final RegistryObject<Block> LOG = BLOCK_HELPER.createFuelBlock(name + "_log", () -> new LogBlock(STRIPPED_LOG, woodSetProperties.log()), 100);
    final RegistryObject<Block> LEAVES = BLOCK_HELPER.createBlock(name + "_leaves", () -> new LeavesBlock(woodSetProperties.leaves()));
    Supplier<SaplingBlock> sapling = saplingFactory != null ? () -> saplingFactory.apply(treeGrower, woodSetProperties.sapling()) : () -> new SaplingBlock(treeGrower, woodSetProperties.sapling());
    final RegistryObject<Block> SAPLING = BLOCK_HELPER.createBlock(name + "_sapling", sapling);
    final RegistryObject<Block> PLANKS = BLOCK_HELPER.createBlock(name + "_planks", () -> new Block(woodSetProperties.planks()));
    final RegistryObject<Block> SLAB = BLOCK_HELPER.createBlock(name + "_slab", () -> new SlabBlock(woodSetProperties.planks()));
    final RegistryObject<Block> STAIRS = BLOCK_HELPER.createBlock(name + "_stairs", () -> new StairBlock(() -> PLANKS.get().defaultBlockState() ,woodSetProperties.planks()));
    final RegistryObject<Block> FENCE = BLOCK_HELPER.createBlock(name + "_fence", () -> new FenceBlock(woodSetProperties.planks()));
    final RegistryObject<Block> FENCE_GATE = BLOCK_HELPER.createBlock(name + "_fence_gate", () -> new FenceGateBlock(woodSetProperties.planks(), woodType));
    final RegistryObject<Block> PRESSURE_PLATE = BLOCK_HELPER.createBlock(name + "_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, woodSetProperties.pressurePlate(), blockSetType));
    final RegistryObject<Block> BUTTON = BLOCK_HELPER.createBlock(name + "_button", () -> new ButtonBlock(woodSetProperties.button(), blockSetType, 30, true));
    final RegistryObject<Block> DOOR = BLOCK_HELPER.createBlock(name + "_door", () -> new DoorBlock(woodSetProperties.door(), blockSetType));
    final RegistryObject<Block> TRAPDOOR = BLOCK_HELPER.createBlock(name + "_trapdoor", () -> new TrapDoorBlock(woodSetProperties.trapdoor(), blockSetType));
    final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> SIGNS = BLOCK_HELPER.createSignBlock(name, woodType, woodSetProperties.sign());
    final Pair<RegistryObject<BlueprintCeilingHangingSignBlock>, RegistryObject<BlueprintWallHangingSignBlock>> HANGING_SIGNS = BLOCK_HELPER.createHangingSignBlock(name, woodType, woodSetProperties.sign());
    final RegistryObject<Block> POTTED_SAPLING = BLOCK_HELPER.createBlockNoItem("potted_" + name + "_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));

    ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SAPLING.getId() , POTTED_SAPLING);

    final TagKey<Block> LOGS_BLOCK_TAG = blockTag(name + "_logs");
    final TagKey<Item> LOGS_ITEM_TAG = itemTag(name + "_logs");

    StandardWoodBlockSet wood = new StandardWoodBlockSet(STRIPPED_LOG, STRIPPED_WOOD, LOG, WOOD, LEAVES, SAPLING, PLANKS, SLAB, STAIRS, FENCE, FENCE_GATE, PRESSURE_PLATE, BUTTON, DOOR, TRAPDOOR, SIGNS, HANGING_SIGNS, POTTED_SAPLING, Pair.of(LOGS_BLOCK_TAG, LOGS_ITEM_TAG), saplingChances);
    WOOD_BLOCK_SETS.put(name, wood);

    return wood;
  }

  public static StandardWoodBlockSet registerStandardWood(String name, WoodType woodType, BlockSetType blockSetType, PropertyUtil.WoodSetProperties woodSetProperties, AbstractTreeGrower treeGrower, float[] saplingChances) {
    return registerStandardWood(name, woodType, blockSetType, woodSetProperties, treeGrower, saplingChances, null);
  }

  private static final HashMap<StandardWoodBlockSet, BlockFamily> BLOCK_FAMILIES = new HashMap<>();

  public static BlockFamily getBlockFamily(StandardWoodBlockSet standardWoodBlockSet) {
    if (BLOCK_FAMILIES.containsKey(standardWoodBlockSet)) {
      return BLOCK_FAMILIES.get(standardWoodBlockSet);
    }

    final BlockFamily BLOCK_FAMILY = new BlockFamily.Builder(standardWoodBlockSet.planks().get())
      .button(standardWoodBlockSet.button().get())
      .sign(standardWoodBlockSet.signs().getFirst().get(), standardWoodBlockSet.signs().getSecond().get())
      .fence(standardWoodBlockSet.fence().get())
      .fenceGate(standardWoodBlockSet.fenceGate.get())
      .slab(standardWoodBlockSet.slab().get())
      .stairs(standardWoodBlockSet.stairs().get())
      .pressurePlate(standardWoodBlockSet.pressurePlate().get())
      .door(standardWoodBlockSet.door().get())
      .trapdoor(standardWoodBlockSet.trapdoor().get())
      .recipeUnlockedBy("has_planks")
      .getFamily();

    BLOCK_FAMILIES.put(standardWoodBlockSet, BLOCK_FAMILY);
    return BLOCK_FAMILY;
  }

  private static TagKey<Block> blockTag(String name) {
    return TagUtil.blockTag(Pioneer.MOD_ID, name);
  }

  private static TagKey<Item> itemTag(String name) {
    return TagUtil.itemTag(Pioneer.MOD_ID, name);
  }
}
