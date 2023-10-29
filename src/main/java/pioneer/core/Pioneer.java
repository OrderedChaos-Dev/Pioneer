package pioneer.core;

import net.minecraftforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import pioneer.common.PioneerCompostables;
import pioneer.core.registry.world.*;
import pioneer.data.server.PioneerBiomeTagsProvider;
import pioneer.data.server.PioneerBlockTagsProvider;
import pioneer.data.server.PioneerChunkGeneratorModifiersProvider;
import pioneer.data.server.PioneerItemTagsProvider;
import pioneer.data.server.PioneerModdedBiomeSlicesProvider;

@Mod(Pioneer.MOD_ID)
public class Pioneer
{
	public static final String MOD_ID = "pioneer";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public Pioneer() {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	bus.addListener(this::setup);
    	bus.addListener(this::data);
    	
    	ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PioneerConfig.COMMON_CONFIG);
 
      REGISTRY_HELPER.register(bus);
			PioneerSurfaceRules.CONDITIONS.register(bus);
      PioneerFeatures.FEATURES.register(bus);
      PioneerTreePlacers.Trunk.TRUNK_PLACERS.register(bus);
      PioneerTreePlacers.Foliage.PLACERS.register(bus);
      PioneerTreePlacers.Decorator.DECORATORS.register(bus);
      PioneerConfiguredFeatures.CONFIGURED_FEATURES.register(bus);
      PioneerPlacements.PLACED_FEATURES.register(bus);
			PioneerBiomeModifiers.BIOME_MODIFIERS.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {
    	event.enqueueWork(() -> {
    		PioneerCompostables.init();
    	});
    }

    private void data(GatherDataEvent event) {
    	DataGenerator gen = event.getGenerator();
    	ExistingFileHelper helper = event.getExistingFileHelper();

			gen.addProvider(event.includeServer(), new PioneerBiomeTagsProvider(gen, helper));
			gen.addProvider(event.includeServer(), new PioneerChunkGeneratorModifiersProvider(gen));
			gen.addProvider(event.includeServer(), new PioneerModdedBiomeSlicesProvider(gen));
			PioneerBlockTagsProvider blockTags = new PioneerBlockTagsProvider(gen, helper);
			gen.addProvider(event.includeServer(), blockTags);
			gen.addProvider(event.includeServer(), new PioneerItemTagsProvider(gen, blockTags, helper));
    }

}
