package dev.orderedchaos.pioneer.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import dev.orderedchaos.pioneer.common.blocks.DesertDoubleHighPlantBlock;
import dev.orderedchaos.pioneer.common.blocks.DryGrassBlock;
import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.PioneerBlocks;
import dev.orderedchaos.pioneer.core.registry.util.WoodTypeUtil;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class PioneerBlockStateProvider extends BlueprintBlockStateProvider {

  public PioneerBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
    super(output, Pioneer.MOD_ID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    WoodTypeUtil.WOOD_BLOCK_SETS.forEach((name, blockSet) -> {
      this.logBlocks(blockSet.strippedLog(), blockSet.strippedWood());
      this.logBlocks(blockSet.log(), blockSet.wood());
      this.leavesBlock(blockSet.leaves());
      this.cubeAll(blockSet.planks().get());
      this.fenceBlocks(blockSet.planks().get(), blockSet.fence().get(), blockSet.fenceGate().get());
      this.pressurePlateBlock(blockSet.planks().get(), blockSet.pressurePlate().get());
      this.buttonBlock(blockSet.planks().get(), blockSet.button().get());
      this.doorBlocks(blockSet.door().get(), blockSet.trapdoor().get());
      this.baseBlocks(blockSet.planks().get(), blockSet.stairs().get(), blockSet.slab().get());
      this.signBlocks(blockSet.planks(), blockSet.signs());
      this.hangingSignBlocks(blockSet.strippedLog(), blockSet.hangingSigns());
      this.crossBlockWithPot(blockSet.sapling(), blockSet.pottedSapling());
    });

    this.leavesBlock(PioneerBlocks.BERRIED_JUNIPER_LEAVES);
    this.leavesBlock(PioneerBlocks.ORANGE_MAPLE_LEAVES);
    this.leavesBlock(PioneerBlocks.PURPLE_MAPLE_LEAVES);
    this.crossBlockWithPot(PioneerBlocks.ORANGE_MAPLE_SAPLING, PioneerBlocks.POTTED_ORANGE_MAPLE_SAPLING);
    this.crossBlockWithPot(PioneerBlocks.PURPLE_MAPLE_SAPLING, PioneerBlocks.POTTED_PURPLE_MAPLE_SAPLING);

    this.crossBlock(PioneerBlocks.PRAIRIE_GRASS);

    ResourceLocation dryGrassTexture = blockTexture(PioneerBlocks.DRY_GRASS.get());
    ModelFile dryGrass0 = this.models().cross(name(PioneerBlocks.DRY_GRASS.get()) + "_0", suffix(dryGrassTexture, "_0")).renderType("cutout");
    ModelFile dryGrass1 = this.models().cross(name(PioneerBlocks.DRY_GRASS.get()) + "_1", suffix(dryGrassTexture, "_1")).renderType("cutout");
    this.getVariantBuilder(PioneerBlocks.DRY_GRASS.get())
      .partialState().with(DryGrassBlock.MODEL, 0).addModels(new ConfiguredModel(dryGrass0))
      .partialState().with(DryGrassBlock.MODEL, 1).addModels(new ConfiguredModel(dryGrass1));
    this.generatedItem(PioneerBlocks.DRY_GRASS.get(), suffix(dryGrassTexture, "_0"));

    this.crossBlock(PioneerBlocks.DESERT_SAGE);
    this.crossBlock(PioneerBlocks.DESERT_AGAVE);

    ResourceLocation blockTexture = blockTexture(PioneerBlocks.BLOOMING_DESERT_AGAVE.get());
    ModelFile agaveUpper = this.models().cross(name(PioneerBlocks.BLOOMING_DESERT_AGAVE.get()) + "_upper", suffix(blockTexture, "_upper")).renderType("cutout");
    ModelFile agaveLower = this.models().cross(name(PioneerBlocks.BLOOMING_DESERT_AGAVE.get()) + "_lower", suffix(blockTexture, "_lower")).renderType("cutout");
    this.getVariantBuilder(PioneerBlocks.BLOOMING_DESERT_AGAVE.get())
      .partialState().with(DesertDoubleHighPlantBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(agaveUpper))
      .partialState().with(DesertDoubleHighPlantBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(agaveLower));
    this.generatedItem(PioneerBlocks.BLOOMING_DESERT_AGAVE.get(), suffix(blockTexture, "_upper"));
  }

  @Override
  public void crossBlock(RegistryObject<Block> cross) {
    this.simpleBlock(cross.get(), models().cross(name(cross.get()), blockTexture(cross.get())).renderType("cutout"));
    this.generatedItem(cross.get(), "block");
  }

  @Override
  public void crossBlockWithPot(RegistryObject<Block> cross, RegistryObject<Block> flowerPot, ResourceLocation potTexture) {
    this.crossBlock(cross);
    this.simpleBlock(flowerPot.get(), models().singleTexture(name(flowerPot.get()), new ResourceLocation("block/flower_pot_cross"), "plant", potTexture).renderType("cutout"));
  }
}
