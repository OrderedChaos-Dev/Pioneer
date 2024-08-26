package dev.orderedchaos.pioneer.data.server;

import com.teamabnormals.blueprint.core.data.server.tags.BlueprintBlockTagsProvider;
import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.PioneerBlocks;
import dev.orderedchaos.pioneer.core.registry.util.WoodTypeUtil;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PioneerBlockTagsProvider extends BlueprintBlockTagsProvider {
  public PioneerBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
    super(Pioneer.MOD_ID, output, lookupProvider, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    WoodTypeUtil.WOOD_BLOCK_SETS.forEach((name, blockSet) -> {
      this.tag(BlockTags.LOGS_THAT_BURN).add(blockSet.log().get(), blockSet.wood().get(), blockSet.strippedLog().get(), blockSet.strippedWood().get());
      this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(blockSet.log().get());
      this.tag(BlockTags.LEAVES).add(blockSet.leaves().get());
      this.tag(BlockTags.SAPLINGS).add(blockSet.sapling().get());
      this.tag(BlockTags.PLANKS).add(blockSet.planks().get());
      this.tag(BlockTags.WOODEN_STAIRS).add(blockSet.stairs().get());
      this.tag(BlockTags.WOODEN_SLABS).add(blockSet.slab().get());
      this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(blockSet.pressurePlate().get());
      this.tag(BlockTags.WOODEN_BUTTONS).add(blockSet.button().get());
      this.tag(BlockTags.WOODEN_DOORS).add(blockSet.door().get());
      this.tag(BlockTags.WOODEN_TRAPDOORS).add(blockSet.trapdoor().get());
      this.tag(BlockTags.STANDING_SIGNS).add(blockSet.signs().getFirst().get());
      this.tag(BlockTags.WALL_SIGNS).add(blockSet.signs().getSecond().get());
      this.tag(BlockTags.WOODEN_FENCES).add(blockSet.fence().get());
      this.tag(Tags.Blocks.FENCES_WOODEN).add(blockSet.fence().get());
      this.tag(BlockTags.FENCE_GATES).add(blockSet.fenceGate().get());
      this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(blockSet.fenceGate().get());
      this.tag(BlockTags.CEILING_HANGING_SIGNS).add(blockSet.hangingSigns().getFirst().get());
      this.tag(BlockTags.WALL_HANGING_SIGNS).add(blockSet.hangingSigns().getSecond().get());
      this.tag(BlockTags.FLOWER_POTS).add(blockSet.pottedSapling().get());

      this.tag(blockSet.logTags().getFirst()).add(blockSet.log().get(), blockSet.wood().get(), blockSet.strippedLog().get(), blockSet.strippedWood().get());
    });

    this.tag(BlockTags.LEAVES).add(PioneerBlocks.ORANGE_MAPLE_LEAVES.get(), PioneerBlocks.PURPLE_MAPLE_LEAVES.get(), PioneerBlocks.BERRIED_JUNIPER_LEAVES.get());
    this.tag(BlockTags.SAPLINGS).add(PioneerBlocks.ORANGE_MAPLE_SAPLING.get(), PioneerBlocks.PURPLE_MAPLE_SAPLING.get());
    this.tag(BlockTags.FLOWER_POTS).add(PioneerBlocks.POTTED_ORANGE_MAPLE_SAPLING.get(), PioneerBlocks.POTTED_PURPLE_MAPLE_SAPLING.get());
  }
}
