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

@Mod.EventBusSubscriber(modid = Pioneer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PioneerItems {
  public static final ItemSubRegistryHelper ITEM_HELPER = Pioneer.REGISTRY_HELPER.getItemSubHelper();

  public static final RegistryObject<Item> JUNIPER_BERRIES = ITEM_HELPER.createItem("juniper_berries", () -> new Item(new Item.Properties()));


    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> ASPEN = ITEM_HELPER.createBoatAndChestBoatItem("aspen", PioneerBlocks.ASPEN.planks());
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> BAOBAB = ITEM_HELPER.createBoatAndChestBoatItem("baobab", PioneerBlocks.BAOBAB.planks());
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> COTTONWOOD = ITEM_HELPER.createBoatAndChestBoatItem("cottonwood", PioneerBlocks.COTTONWOOD.planks());
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> FIR = ITEM_HELPER.createBoatAndChestBoatItem("fir", PioneerBlocks.FIR.planks());
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> JOSHUA = ITEM_HELPER.createBoatAndChestBoatItem("joshua", PioneerBlocks.JOSHUA.planks());
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> JUNIPER = ITEM_HELPER.createBoatAndChestBoatItem("juniper", PioneerBlocks.JUNIPER.planks());
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> MAPLE = ITEM_HELPER.createBoatAndChestBoatItem("maple", PioneerBlocks.MAPLE.planks());
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> PALM = ITEM_HELPER.createBoatAndChestBoatItem("palm", PioneerBlocks.PALM.planks());
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> PINE = ITEM_HELPER.createBoatAndChestBoatItem("pine", PioneerBlocks.PINE.planks());
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> REDWOOD = ITEM_HELPER.createBoatAndChestBoatItem("redwood", PioneerBlocks.REDWOOD.planks());
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> TAMARACK = ITEM_HELPER.createBoatAndChestBoatItem("tamarack", PioneerBlocks.TAMARACK.planks());
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> WILLOW = ITEM_HELPER.createBoatAndChestBoatItem("willow", PioneerBlocks.WILLOW.planks());
}
