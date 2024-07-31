package dev.orderedchaos.pioneer.data.client;

import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.PioneerItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class PioneerItemModelProvider extends ItemModelProvider  {

  public PioneerItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
    super(output, Pioneer.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    this.basicItem(PioneerItems.JUNIPER_BERRIES.get());
  }
}
