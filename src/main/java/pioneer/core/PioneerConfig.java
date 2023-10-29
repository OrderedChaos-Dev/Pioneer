package pioneer.core;

import com.teamabnormals.blueprint.core.annotations.ConfigKey;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.HashMap;
import java.util.Map;

public class PioneerConfig {
	
	/* Used for DataUtil.registerConfigCondition because it looks for declared fields in this class */
	public static final PioneerConfig INSTANCE = new PioneerConfig();
	
	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
	public static ForgeConfigSpec COMMON_CONFIG;
	
	public static ForgeConfigSpec.ConfigValue<Boolean> palmTrees;
	public static ForgeConfigSpec.ConfigValue<Boolean> juniperTrees;

	public static final Map<String, ForgeConfigSpec.ConfigValue<Boolean>> CONFIG_OPTIONS = new HashMap<>();
	
	static {
		COMMON_BUILDER.push("Pioneer Settings");
		palmTrees = COMMON_BUILDER.define("Enable palm trees in vanilla biomes", true);
		juniperTrees = COMMON_BUILDER.define("Enable juniper trees in vanilla biomes", true);
		COMMON_BUILDER.pop();
		
		COMMON_CONFIG = COMMON_BUILDER.build();

		CONFIG_OPTIONS.put("palmTrees", palmTrees);
		CONFIG_OPTIONS.put("juniperTrees", juniperTrees);
	}
}