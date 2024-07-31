package dev.orderedchaos.pioneer.data.server;

import com.teamabnormals.blueprint.core.data.server.tags.BlueprintItemTagsProvider;
import dev.orderedchaos.pioneer.core.Pioneer;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class PioneerItemTagsProvider extends BlueprintItemTagsProvider {
  public PioneerItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> tagLookup, ExistingFileHelper fileHelper) {
    super(Pioneer.MOD_ID, output, lookupProvider, tagLookup, fileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider lookupProvider) {
    this.copyWoodenTags();
    this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
    this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
    this.copy(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);
  }
}
