package dev.orderedchaos.pioneer.data.server;

import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.PioneerBlocks;
import dev.orderedchaos.pioneer.core.registry.PioneerItems;
import dev.orderedchaos.pioneer.core.registry.util.WoodTypeUtil;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class PioneerBlockLoot extends BlockLootSubProvider {

  public PioneerBlockLoot() {
    super(Set.of(), FeatureFlags.REGISTRY.allFlags());
  }

  @Override
  public void generate() {
    WoodTypeUtil.WOOD_BLOCK_SETS.forEach((name, blockSet) -> {
      this.dropSelf(blockSet.strippedLog().get());
      this.dropSelf(blockSet.strippedWood().get());
      this.dropSelf(blockSet.log().get());
      this.dropSelf(blockSet.wood().get());
      this.dropSelf(blockSet.sapling().get());
      this.dropSelf(blockSet.planks().get());
      this.dropSelf(blockSet.pressurePlate().get());
      this.dropSelf(blockSet.button().get());
      this.dropSelf(blockSet.stairs().get());
      this.dropSelf(blockSet.fence().get());
      this.dropSelf(blockSet.fenceGate().get());
      this.dropSelf(blockSet.trapdoor().get());
      this.dropSelf(blockSet.signs().getFirst().get());
      this.dropSelf(blockSet.signs().getSecond().get());
      this.dropSelf(blockSet.hangingSigns().getFirst().get());
      this.dropSelf(blockSet.hangingSigns().getSecond().get());
      this.add(blockSet.door().get(), this::createDoorTable);
      this.add(blockSet.slab().get(), this::createSlabItemTable);
      this.add(blockSet.leaves().get(), block -> this.createLeavesDrops(block, blockSet.sapling().get(), blockSet.saplingChances()));
      this.dropPottedContents(blockSet.pottedSapling().get());
    });

    this.add(PioneerBlocks.BERRIED_JUNIPER_LEAVES.get(),
      block -> this.createLeavesDrops(block, PioneerBlocks.JUNIPER.sapling().get(), NORMAL_LEAVES_SAPLING_CHANCES)
        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(PioneerItems.JUNIPER_BERRIES.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))));

    this.dropSelf(PioneerBlocks.ORANGE_MAPLE_SAPLING.get());
    this.dropSelf(PioneerBlocks.PURPLE_MAPLE_SAPLING.get());

    this.add(PioneerBlocks.ORANGE_MAPLE_LEAVES.get(), block -> this.createLeavesDrops(block, PioneerBlocks.ORANGE_MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    this.add(PioneerBlocks.PURPLE_MAPLE_LEAVES.get(), block -> this.createLeavesDrops(block, PioneerBlocks.PURPLE_MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    this.dropPottedContents(PioneerBlocks.POTTED_ORANGE_MAPLE_SAPLING.get());
    this.dropPottedContents(PioneerBlocks.POTTED_PURPLE_MAPLE_SAPLING.get());

    this.dropSelf(PioneerBlocks.COCONUT.get());

    this.add(PioneerBlocks.PRAIRIE_GRASS.get(), this::createGrassDrops);
    this.add(PioneerBlocks.DRY_GRASS.get(), this::createGrassDrops);

    this.add(PioneerBlocks.ASPEN_FALLEN_LEAVES.get(), BlockLootSubProvider::createShearsOnlyDrop);
    this.add(PioneerBlocks.RED_MAPLE_FALLEN_LEAVES.get(), BlockLootSubProvider::createShearsOnlyDrop);
    this.add(PioneerBlocks.ORANGE_MAPLE_FALLEN_LEAVES.get(), BlockLootSubProvider::createShearsOnlyDrop);
    this.add(PioneerBlocks.PURPLE_MAPLE_FALLEN_LEAVES.get(), BlockLootSubProvider::createShearsOnlyDrop);

    this.dropSelf(PioneerBlocks.DESERT_AGAVE.get());
    this.dropSelf(PioneerBlocks.DESERT_SAGE.get());
    this.add(PioneerBlocks.BLOOMING_DESERT_AGAVE.get(), block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
  }

  @Override
  protected Iterable<Block> getKnownBlocks() {
    return Pioneer.REGISTRY_HELPER.getBlockSubHelper().getDeferredRegister().getEntries().stream().map(RegistryObject::get).collect(Collectors.toSet());
  }
}
