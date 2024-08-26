package dev.orderedchaos.pioneer.core;

import com.mojang.logging.LogUtils;
import com.teamabnormals.blueprint.core.registry.BlueprintDataPackRegistries;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import dev.orderedchaos.pioneer.Config;
import dev.orderedchaos.pioneer.core.registry.*;
import dev.orderedchaos.pioneer.data.client.PioneerBlockStateProvider;
import dev.orderedchaos.pioneer.data.client.PioneerItemModelProvider;
import dev.orderedchaos.pioneer.data.server.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod(Pioneer.MOD_ID)
public class Pioneer {
  public static final String MOD_ID = "pioneer";
  public static final Logger LOGGER = LogUtils.getLogger();
  public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

  public static final RegistryObject<CreativeModeTab> PIONEER_TAB = CREATIVE_MODE_TABS.register(MOD_ID, () -> CreativeModeTab.builder()
    .icon(PioneerBlocks.FIR.sapling().get().asItem()::getDefaultInstance)
    .title(Component.translatable("itemGroup." + MOD_ID))
    .displayItems((parameters, output) -> {
      REGISTRY_HELPER.getItemSubHelper().getDeferredRegister().getEntries().forEach(item -> output.accept(item.get()));
    }).build());

  public Pioneer() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    REGISTRY_HELPER.register(modEventBus);
    CREATIVE_MODE_TABS.register(modEventBus);

    PioneerFeatures.FEATURES.register(modEventBus);
    PioneerSurfaceRules.CONDITIONS.register(modEventBus);
    PioneerTreePlacers.Trunk.TRUNK_PLACERS.register(modEventBus);
    PioneerTreePlacers.Foliage.FOLIAGE_PLACERS.register(modEventBus);
    PioneerTreePlacers.Decorator.DECORATORS.register(modEventBus);
    PioneerConfiguredFeatures.CONFIGURED_FEATURES.register(modEventBus);

    modEventBus.addListener(this::commonSetup);
    modEventBus.addListener(this::dataSetup);

    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {

  }

  private void dataSetup(final GatherDataEvent event) {
    final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
      .add(Registries.CONFIGURED_FEATURE, PioneerConfiguredFeatures::bootstrap)
      .add(Registries.PLACED_FEATURE, PioneerPlacedFeatures::bootstrap)
      .add(Registries.BIOME, PioneerBiomes::bootstrap)
      .add(BlueprintDataPackRegistries.MODDED_BIOME_SLICES, PioneerModdedBiomeSlices::bootstrap);
    DataGenerator generator = event.getGenerator();
    PackOutput packOutput = generator.getPackOutput();
    ExistingFileHelper fileHelper = event.getExistingFileHelper();
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

    boolean server = event.includeServer();
    generator.addProvider(server, new LootTableProvider(packOutput, Set.of(), List.of(new LootTableProvider.SubProviderEntry(PioneerBlockLoot::new, LootContextParamSets.BLOCK))));

    DatapackBuiltinEntriesProvider datapackBuiltinEntriesProvider = new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, BUILDER, Set.of(Pioneer.MOD_ID));
    generator.addProvider(server, datapackBuiltinEntriesProvider);
    PioneerBlockTagsProvider blockTagsProvider =  new PioneerBlockTagsProvider(packOutput, lookupProvider, fileHelper);
    generator.addProvider(server, blockTagsProvider);
    generator.addProvider(server, new PioneerItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), fileHelper));
    generator.addProvider(server, new PioneerChunkGeneratorModifierProvider(packOutput, lookupProvider));
    generator.addProvider(server, new PioneerBiomeTagsProvider(packOutput, datapackBuiltinEntriesProvider.getRegistryProvider(), fileHelper));

    boolean client = event.includeClient();
    generator.addProvider(client, new PioneerBlockStateProvider(packOutput, fileHelper));
    generator.addProvider(client, new PioneerItemModelProvider(packOutput, fileHelper));
  }
}
