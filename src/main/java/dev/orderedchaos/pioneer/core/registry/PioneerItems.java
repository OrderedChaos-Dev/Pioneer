package dev.orderedchaos.pioneer.core.registry;

import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import dev.orderedchaos.pioneer.core.Pioneer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Pioneer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PioneerItems {
  public static final ItemSubRegistryHelper ITEM_HELPER = Pioneer.REGISTRY_HELPER.getItemSubHelper();

  public static final RegistryObject<Item> JUNIPER_BERRIES = ITEM_HELPER.createItem("juniper_berries", () -> new Item(new Item.Properties()));
}
