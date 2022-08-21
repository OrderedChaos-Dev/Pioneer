package pioneer.core;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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
import pioneer.data.tags.PioneerBiomeTagsProvider;
import pioneer.data.tags.PioneerBlockTagsProvider;
import pioneer.data.tags.PioneerChunkGeneratorModifiersProvider;
import pioneer.data.tags.PioneerItemTagsProvider;
import pioneer.data.tags.PioneerModdedBiomeSlicesProvider;

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

        REGISTRY_HELPER.register(bus);
        PioneerFeatures.FEATURES.register(bus);
        PioneerTreePlacers.Trunk.TRUNK_PLACERS.register(bus);
        PioneerTreePlacers.Foliage.PLACERS.register(bus);
        PioneerTreePlacers.Decorator.DECORATORS.register(bus);
        PioneerConfiguredFeatures.CONFIGURED_FEATURES.register(bus);
        PioneerPlacements.PLACED_FEATURES.register(bus);
        
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
