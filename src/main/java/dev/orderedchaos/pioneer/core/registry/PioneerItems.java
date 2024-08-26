package dev.orderedchaos.pioneer.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import dev.orderedchaos.pioneer.common.blocks.DesertSaplingBlock;
import dev.orderedchaos.pioneer.common.blocks.JuniperSaplingBlock;
import dev.orderedchaos.pioneer.common.blocks.treegrowers.PioneerTreeGrowers;
import dev.orderedchaos.pioneer.core.Pioneer;
import dev.orderedchaos.pioneer.core.registry.util.WoodTypeUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;

@Mod.EventBusSubscriber(modid = Pioneer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PioneerItems {
  public static final ItemSubRegistryHelper ITEM_HELPER = Pioneer.REGISTRY_HELPER.getItemSubHelper();

  public static final RegistryObject<Item> JUNIPER_BERRIES = ITEM_HELPER.createItem("juniper_berries", () -> new Item(new Item.Properties()));

  public static final HashMap<String, Pair<RegistryObject<Item>, RegistryObject<Item>>> BOATS = new HashMap<>();

  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> ASPEN = boat("aspen", PioneerBlocks.ASPEN.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> BAOBAB = boat("baobab", PioneerBlocks.BAOBAB.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> COTTONWOOD = boat("cottonwood", PioneerBlocks.COTTONWOOD.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> FIR = boat("fir", PioneerBlocks.FIR.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> JOSHUA = boat("joshua", PioneerBlocks.JOSHUA.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> JUNIPER = boat("juniper", PioneerBlocks.JUNIPER.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> MAPLE = boat("maple", PioneerBlocks.MAPLE.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> PALM = boat("palm", PioneerBlocks.PALM.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> PINE = boat("pine", PioneerBlocks.PINE.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> REDWOOD = boat("redwood", PioneerBlocks.REDWOOD.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> TAMARACK = boat("tamarack", PioneerBlocks.TAMARACK.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> WILLOW = boat("willow", PioneerBlocks.WILLOW.planks());

  public static Pair<RegistryObject<Item>, RegistryObject<Item>> boat(String name, RegistryObject<Block> planks) {
    Pair<RegistryObject<Item>, RegistryObject<Item>> boats = ITEM_HELPER.createBoatAndChestBoatItem(name, planks);
    BOATS.put(name, boats);
    return boats;
  }
}
