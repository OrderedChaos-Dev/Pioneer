package dev.orderedchaos.pioneer.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintItemModelProvider;
import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.PioneerItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

public class PioneerItemModelProvider extends BlueprintItemModelProvider {

  public PioneerItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
    super(output, Pioneer.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    this.generatedItem(PioneerItems.JUNIPER_BERRIES);
    this.generatedItem(PioneerItems.CRACKED_COCONUT, PioneerItems.COCONUT_MILK);
    this.generatedItem(PioneerItems.ASPEN_BOATS.getFirst(), PioneerItems.ASPEN_BOATS.getSecond());
    this.generatedItem(PioneerItems.BAOBAB_BOATS.getFirst(), PioneerItems.BAOBAB_BOATS.getSecond());
    this.generatedItem(PioneerItems.COTTONWOOD_BOATS.getFirst(), PioneerItems.COTTONWOOD_BOATS.getSecond());
    this.generatedItem(PioneerItems.FIR_BOATS.getFirst(), PioneerItems.FIR_BOATS.getSecond());
    this.generatedItem(PioneerItems.JOSHUA_BOATS.getFirst(), PioneerItems.JOSHUA_BOATS.getSecond());
    this.generatedItem(PioneerItems.JUNIPER_BOATS.getFirst(), PioneerItems.JUNIPER_BOATS.getSecond());
    this.generatedItem(PioneerItems.MAPLE_BOATS.getFirst(), PioneerItems.MAPLE_BOATS.getSecond());
    this.generatedItem(PioneerItems.PALM_BOATS.getFirst(), PioneerItems.PALM_BOATS.getSecond());
    this.generatedItem(PioneerItems.PINE_BOATS.getFirst(), PioneerItems.PINE_BOATS.getSecond());
    this.generatedItem(PioneerItems.REDWOOD_BOATS.getFirst(), PioneerItems.REDWOOD_BOATS.getSecond());
    this.generatedItem(PioneerItems.TAMARACK_BOATS.getFirst(), PioneerItems.TAMARACK_BOATS.getSecond());
    this.generatedItem(PioneerItems.WILLOW_BOATS.getFirst(), PioneerItems.WILLOW_BOATS.getSecond());
  }
}
