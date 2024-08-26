package dev.orderedchaos.pioneer.data.server;

import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.PioneerBlocks;
import dev.orderedchaos.pioneer.core.registry.PioneerItems;
import dev.orderedchaos.pioneer.core.registry.util.WoodTypeUtil;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class PioneerRecipeProvider extends BlueprintRecipeProvider {
  public PioneerRecipeProvider(PackOutput output) {
    super(Pioneer.MOD_ID, output);
  }

  @Override
  public void buildRecipes(Consumer<FinishedRecipe> consumer) {
    WoodTypeUtil.WOOD_BLOCK_SETS.forEach((name, blockSet) -> {
      generateRecipes(consumer, WoodTypeUtil.getBlockFamily(blockSet));
      planksFromLog(consumer, blockSet.planks().get(), blockSet.logTags().getSecond(), 4);
      woodFromLogs(consumer, blockSet.wood().get(), blockSet.log().get());
      woodFromLogs(consumer, blockSet.strippedWood().get(), blockSet.strippedLog().get());
      hangingSign(consumer, blockSet.hangingSigns().getFirst().get(), blockSet.strippedLog().get());
      woodenBoat(consumer, PioneerItems.BOATS.get(name).getFirst().get(), blockSet.planks().get());
      chestBoat(consumer, PioneerItems.BOATS.get(name).getSecond().get(), blockSet.planks().get());
    });

    conversionRecipe(consumer, PioneerItems.CRACKED_COCONUT.get(), PioneerBlocks.COCONUT.get(), "coconut",2);

    ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, PioneerItems.COCONUT_MILK.get())
      .requires(PioneerItems.CRACKED_COCONUT.get(), 2)
      .requires(Items.GLASS_BOTTLE)
      .unlockedBy("has_coconut", has(PioneerItems.CRACKED_COCONUT.get()))
      .save(consumer, new ResourceLocation(Pioneer.MOD_ID, "coconut_milk"));
  }
}
