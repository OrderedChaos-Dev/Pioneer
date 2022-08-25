package pioneer.core;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import pioneer.client.BlockRendering;
import pioneer.common.PioneerCompostables;
import pioneer.common.PioneerWorldGenEvents;
import pioneer.common.world.placements.PioneerPlacements;
import pioneer.core.registry.world.PioneerBiomes;
import pioneer.core.registry.world.PioneerConfiguredFeatures;
import pioneer.core.registry.world.PioneerFeatures;
import pioneer.core.registry.world.PioneerTreePlacers;
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
    	bus.addListener(this::clientSetup);
    	bus.addListener(this::data);
    	
//    	ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PioneerConfig.COMMON_CONFIG);
 
        REGISTRY_HELPER.register(bus);
        PioneerFeatures.FEATURES.register(bus);
        PioneerTreePlacers.Trunk.TRUNK_PLACERS.register(bus);
        PioneerTreePlacers.Foliage.PLACERS.register(bus);
        PioneerTreePlacers.Decorator.DECORATORS.register(bus);
        PioneerConfiguredFeatures.CONFIGURED_FEATURES.register(bus);
        PioneerPlacements.PLACED_FEATURES.register(bus);
        
        bus.addGenericListener(Biome.class, this::registerConfigConditions);
        
        MinecraftForge.EVENT_BUS.register(new PioneerWorldGenEvents());
    }

    private void setup(final FMLCommonSetupEvent event) {
    	event.enqueueWork(() -> {
    		PioneerBiomes.registerBiomeTypes();
    		PioneerCompostables.init();
    	});
    }
    
    private void clientSetup(final FMLClientSetupEvent event) {
    	event.enqueueWork(() -> {
    		BlockRendering.registerRenderers();
    	});
    }
    
    private void registerConfigConditions(RegistryEvent.Register<Biome> event) {
    	DataUtil.registerConfigCondition(MOD_ID, PioneerConfig.INSTANCE);
    }

    private void data(GatherDataEvent event) {
    	DataGenerator gen = event.getGenerator();
    	ExistingFileHelper helper = event.getExistingFileHelper();
    	
    	if(event.includeServer()) {
    		gen.addProvider(new PioneerBiomeTagsProvider(gen, helper));
    		gen.addProvider(new PioneerChunkGeneratorModifiersProvider(gen));
    		gen.addProvider(new PioneerModdedBiomeSlicesProvider(gen));
    		PioneerBlockTagsProvider blockTags = new PioneerBlockTagsProvider(gen, helper);
    		gen.addProvider(blockTags);
    		gen.addProvider(new PioneerItemTagsProvider(gen, blockTags, helper));
    	}
    	
    	if(event.includeClient()) {

    	}
    }

}
