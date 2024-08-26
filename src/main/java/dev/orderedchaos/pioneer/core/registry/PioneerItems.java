package dev.orderedchaos.pioneer.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import dev.orderedchaos.pioneer.core.Pioneer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;

@Mod.EventBusSubscriber(modid = Pioneer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PioneerItems {
  public static final ItemSubRegistryHelper ITEM_HELPER = Pioneer.REGISTRY_HELPER.getItemSubHelper();

  public static final RegistryObject<Item> JUNIPER_BERRIES = ITEM_HELPER.createItem("juniper_berries", () -> new Item(new Item.Properties().food(Food.JUNIPER_BERRIES)));
  public static final RegistryObject<Item> CRACKED_COCONUT = ITEM_HELPER.createItem("cracked_coconut", () -> new Item(new Item.Properties().food(Food.CRACKED_COCONUT)));
  public static final RegistryObject<Item> COCONUT_MILK = ITEM_HELPER.createItem("coconut_milk", () -> new Item(new Item.Properties().food(Food.COCONUT_MILK)));

  public static final HashMap<String, Pair<RegistryObject<Item>, RegistryObject<Item>>> BOATS = new HashMap<>();

  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> ASPEN_BOATS = boat("aspen", PioneerBlocks.ASPEN.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> BAOBAB_BOATS = boat("baobab", PioneerBlocks.BAOBAB.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> COTTONWOOD_BOATS = boat("cottonwood", PioneerBlocks.COTTONWOOD.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> FIR_BOATS = boat("fir", PioneerBlocks.FIR.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> JOSHUA_BOATS = boat("joshua", PioneerBlocks.JOSHUA.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> JUNIPER_BOATS = boat("juniper", PioneerBlocks.JUNIPER.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> MAPLE_BOATS = boat("maple", PioneerBlocks.MAPLE.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> PALM_BOATS = boat("palm", PioneerBlocks.PALM.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> PINE_BOATS = boat("pine", PioneerBlocks.PINE.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> REDWOOD_BOATS = boat("redwood", PioneerBlocks.REDWOOD.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> TAMARACK_BOATS = boat("tamarack", PioneerBlocks.TAMARACK.planks());
  public static final Pair<RegistryObject<Item>, RegistryObject<Item>> WILLOW_BOATS = boat("willow", PioneerBlocks.WILLOW.planks());

  public static Pair<RegistryObject<Item>, RegistryObject<Item>> boat(String name, RegistryObject<Block> planks) {
    Pair<RegistryObject<Item>, RegistryObject<Item>> boats = ITEM_HELPER.createBoatAndChestBoatItem(name, planks);
    BOATS.put(name, boats);
    return boats;
  }

  public static class Food {
    public static final FoodProperties CRACKED_COCONUT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.35F).build();
    public static final FoodProperties COCONUT_MILK = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.25F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties JUNIPER_BERRIES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).alwaysEat().build();
  }
}
