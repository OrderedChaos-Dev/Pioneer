package pioneer.core.registry;

import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;
import pioneer.core.Pioneer;

@EventBusSubscriber(modid = Pioneer.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PioneerItems {
	
	public static final ItemSubRegistryHelper HELPER = Pioneer.REGISTRY_HELPER.getItemSubHelper();
	
	public static final RegistryObject<Item> JUNIPER_BERRIES = HELPER.createItem("juniper_berries", () -> new Item(new Item.Properties().tab(PioneerCreativeModeTab.INSTANCE).food(Food.JUNIPER_BERRIES)));
	public static final RegistryObject<Item> CRACKED_COCONUT = HELPER.createItem("cracked_coconut", () -> new Item(new Item.Properties().tab(PioneerCreativeModeTab.INSTANCE).food(Food.CRACKED_COCONUT)));
	public static final RegistryObject<Item> COCONUT_MILK = HELPER.createItem("coconut_milk", () -> new Item(new Item.Properties().tab(PioneerCreativeModeTab.INSTANCE).food(Food.COCONUT_MILK)));
    
    public static class Food {
    	public static final FoodProperties CRACKED_COCONUT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.35F).build();
    	public static final FoodProperties COCONUT_MILK = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.25F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 0), 1.0F).alwaysEat().build();
    	public static final FoodProperties JUNIPER_BERRIES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).alwaysEat().build();
    }
}
