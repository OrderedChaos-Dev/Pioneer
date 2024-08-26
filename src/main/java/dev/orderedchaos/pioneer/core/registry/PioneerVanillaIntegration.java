package dev.orderedchaos.pioneer.core.registry;

import com.teamabnormals.blueprint.core.util.DataUtil;
import dev.orderedchaos.pioneer.core.registry.util.WoodTypeUtil;

public class PioneerVanillaIntegration {

  public static void registerCompostables() {
    WoodTypeUtil.WOOD_BLOCK_SETS.forEach((name, woodSet) -> {
      DataUtil.registerCompostable(woodSet.leaves().get(), 0.3F);
      DataUtil.registerCompostable(woodSet.sapling().get(), 0.3F);
    });

    DataUtil.registerCompostable(PioneerBlocks.ORANGE_MAPLE_LEAVES.get(), 0.3F);
    DataUtil.registerCompostable(PioneerBlocks.PURPLE_MAPLE_LEAVES.get(), 0.3F);

    DataUtil.registerCompostable(PioneerBlocks.DESERT_SAGE.get(), 0.5F);
    DataUtil.registerCompostable(PioneerBlocks.DESERT_AGAVE.get(), 0.65F);
    DataUtil.registerCompostable(PioneerBlocks.BLOOMING_DESERT_AGAVE.get(), 0.65F);
    DataUtil.registerCompostable(PioneerBlocks.PRAIRIE_GRASS.get(), 0.25F);
    DataUtil.registerCompostable(PioneerBlocks.DRY_GRASS.get(), 0.25F);
    DataUtil.registerCompostable(PioneerBlocks.ASPEN_FALLEN_LEAVES.get(), 0.1F);
    DataUtil.registerCompostable(PioneerBlocks.RED_MAPLE_FALLEN_LEAVES.get(), 0.1F);
    DataUtil.registerCompostable(PioneerBlocks.ORANGE_MAPLE_FALLEN_LEAVES.get(), 0.1F);
    DataUtil.registerCompostable(PioneerBlocks.PURPLE_MAPLE_FALLEN_LEAVES.get(), 0.1F);

    DataUtil.registerCompostable(PioneerBlocks.COCONUT.get(), 0.2F);
    DataUtil.registerCompostable(PioneerItems.JUNIPER_BERRIES.get(), 0.1F);
  }

  public static void registerFlammables() {
    WoodTypeUtil.WOOD_BLOCK_SETS.forEach((name, woodSet) -> {
      DataUtil.registerFlammable(woodSet.planks().get(), 5, 20);
      DataUtil.registerFlammable(woodSet.slab().get(), 5, 20);
      DataUtil.registerFlammable(woodSet.stairs().get(), 5, 20);
      DataUtil.registerFlammable(woodSet.fence().get(), 5, 20);
      DataUtil.registerFlammable(woodSet.fenceGate().get(), 5, 20);
      DataUtil.registerFlammable(woodSet.log().get(), 5, 5);
      DataUtil.registerFlammable(woodSet.strippedLog().get(), 5, 5);
      DataUtil.registerFlammable(woodSet.strippedWood().get(), 5, 5);
      DataUtil.registerFlammable(woodSet.wood().get(), 5, 5);
      DataUtil.registerFlammable(woodSet.leaves().get(), 30, 60);
    });

    DataUtil.registerFlammable(PioneerBlocks.ORANGE_MAPLE_LEAVES.get(), 30, 60);
    DataUtil.registerFlammable(PioneerBlocks.PURPLE_MAPLE_LEAVES.get(), 30, 60);

    DataUtil.registerFlammable(PioneerBlocks.PURPLE_MAPLE_FALLEN_LEAVES.get(), 30, 60);
    DataUtil.registerFlammable(PioneerBlocks.RED_MAPLE_FALLEN_LEAVES.get(), 30, 60);
    DataUtil.registerFlammable(PioneerBlocks.ORANGE_MAPLE_FALLEN_LEAVES.get(), 30, 60);
    DataUtil.registerFlammable(PioneerBlocks.ASPEN_FALLEN_LEAVES.get(), 30, 60);

    DataUtil.registerFlammable(PioneerBlocks.DESERT_SAGE.get(), 60, 100);
    DataUtil.registerFlammable(PioneerBlocks.DESERT_AGAVE.get(), 60, 100);
    DataUtil.registerFlammable(PioneerBlocks.BLOOMING_DESERT_AGAVE.get(), 60, 100);
    DataUtil.registerFlammable(PioneerBlocks.PRAIRIE_GRASS.get(), 60, 100);
    DataUtil.registerFlammable(PioneerBlocks.DRY_GRASS.get(), 60, 100);
  }
}
