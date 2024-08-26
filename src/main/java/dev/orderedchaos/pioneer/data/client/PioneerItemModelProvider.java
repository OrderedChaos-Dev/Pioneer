package dev.orderedchaos.pioneer.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintItemModelProvider;
import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.PioneerItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class PioneerItemModelProvider extends BlueprintItemModelProvider {

  public PioneerItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
    super(output, Pioneer.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    this.generatedItem(PioneerItems.JUNIPER_BERRIES);
    this.generatedItem(PioneerItems.ASPEN.getFirst(), PioneerItems.ASPEN.getSecond());
    this.generatedItem(PioneerItems.BAOBAB.getFirst(), PioneerItems.BAOBAB.getSecond());
    this.generatedItem(PioneerItems.COTTONWOOD.getFirst(), PioneerItems.COTTONWOOD.getSecond());
    this.generatedItem(PioneerItems.FIR.getFirst(), PioneerItems.FIR.getSecond());
    this.generatedItem(PioneerItems.JOSHUA.getFirst(), PioneerItems.JOSHUA.getSecond());
    this.generatedItem(PioneerItems.JUNIPER.getFirst(), PioneerItems.JUNIPER.getSecond());
    this.generatedItem(PioneerItems.MAPLE.getFirst(), PioneerItems.MAPLE.getSecond());
    this.generatedItem(PioneerItems.PALM.getFirst(), PioneerItems.PALM.getSecond());
    this.generatedItem(PioneerItems.PINE.getFirst(), PioneerItems.PINE.getSecond());
    this.generatedItem(PioneerItems.REDWOOD.getFirst(), PioneerItems.REDWOOD.getSecond());
    this.generatedItem(PioneerItems.TAMARACK.getFirst(), PioneerItems.TAMARACK.getSecond());
    this.generatedItem(PioneerItems.WILLOW.getFirst(), PioneerItems.WILLOW.getSecond());
  }
}
