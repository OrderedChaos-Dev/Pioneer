package dev.orderedchaos.pioneer.data.server;

import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.PioneerBlocks;
import dev.orderedchaos.pioneer.core.registry.PioneerItems;
import dev.orderedchaos.pioneer.core.registry.util.WoodTypeUtil;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class PioneerRecipeProvider extends BlueprintRecipeProvider {
  public PioneerRecipeProvider(PackOutput output) {
    super(Pioneer.MOD_ID, output);
  }

  @Override
  public void buildRecipes(Consumer<FinishedRecipe> consumer) {
    generateRecipes(consumer, WoodTypeUtil.getBlockFamily(PioneerBlocks.ASPEN));
    generateRecipes(consumer, WoodTypeUtil.getBlockFamily(PioneerBlocks.BAOBAB));
    generateRecipes(consumer, WoodTypeUtil.getBlockFamily(PioneerBlocks.COTTONWOOD));
    generateRecipes(consumer, WoodTypeUtil.getBlockFamily(PioneerBlocks.FIR));
    generateRecipes(consumer, WoodTypeUtil.getBlockFamily(PioneerBlocks.JOSHUA));
    generateRecipes(consumer, WoodTypeUtil.getBlockFamily(PioneerBlocks.JUNIPER));
    generateRecipes(consumer, WoodTypeUtil.getBlockFamily(PioneerBlocks.MAPLE));
    generateRecipes(consumer, WoodTypeUtil.getBlockFamily(PioneerBlocks.PALM));
    generateRecipes(consumer, WoodTypeUtil.getBlockFamily(PioneerBlocks.PINE));
    generateRecipes(consumer, WoodTypeUtil.getBlockFamily(PioneerBlocks.REDWOOD));
    generateRecipes(consumer, WoodTypeUtil.getBlockFamily(PioneerBlocks.TAMARACK));
    generateRecipes(consumer, WoodTypeUtil.getBlockFamily(PioneerBlocks.WILLOW));

    WoodTypeUtil.WOOD_BLOCK_SETS.forEach((name, blockSet) -> {
      planksFromLog(consumer, blockSet.planks().get(), blockSet.logTags().getSecond(), 4);
      woodFromLogs(consumer, blockSet.wood().get(), blockSet.log().get());
      woodFromLogs(consumer, blockSet.strippedWood().get(), blockSet.strippedLog().get());
      hangingSign(consumer, blockSet.hangingSigns().getFirst().get(), blockSet.strippedLog().get());
      woodenBoat(consumer, PioneerItems.BOATS.get(name).getFirst().get(), blockSet.planks().get());
      chestBoat(consumer, PioneerItems.BOATS.get(name).getSecond().get(), blockSet.planks().get());
    });
  }
}
