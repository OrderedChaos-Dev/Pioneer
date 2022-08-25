package pioneer.core;

import com.teamabnormals.blueprint.core.annotations.ConfigKey;

import net.minecraftforge.common.ForgeConfigSpec;

public class PioneerConfig {
	
	/* Used for DataUtil.registerConfigCondition because it looks for declared fields in this class */
	public static final PioneerConfig INSTANCE = new PioneerConfig();
	
	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
	public static ForgeConfigSpec COMMON_CONFIG;
	
	public static ForgeConfigSpec.ConfigValue<Boolean> palmTrees;
	public static ForgeConfigSpec.ConfigValue<Boolean> juniperTrees;
	
	static {
		COMMON_BUILDER.push("Pioneer Settings");
		palmTrees = COMMON_BUILDER.define("Enable palm trees in vanilla biomes", true);
		juniperTrees = COMMON_BUILDER.define("Enable juniper trees in vanilla biomes", true);
//		aspenGrove = COMMON_BUILDER.define("aspenGrove", true);
//		autumnalConiferousForest = COMMON_BUILDER.define("autumnalConiferousForest", true);
//		verdantSands = COMMON_BUILDER.define("verdantSands", true);
//		pineMeadows = COMMON_BUILDER.define("pineMeadows", true);
//		borealForest = COMMON_BUILDER.define("borealForest", true);
//		snowyBorealForest = COMMON_BUILDER.define("snowyBorealForest", true);
//		redwoods = COMMON_BUILDER.define("redwoods", true);
//		snowyRedwoods = COMMON_BUILDER.define("snowyRedwoods", true);
//		overgrownSpires = COMMON_BUILDER.define("overgrownSpires", true);
//		baobabFields = COMMON_BUILDER.define("baobabFields", true);
//		crystalLakes = COMMON_BUILDER.define("crystalLakes", true);
//		prairie = COMMON_BUILDER.comment("Aspen Grove").define("prairie", true);
//		blossomingFields = COMMON_BUILDER.define("blossomingFields", true);
//		desertShrubland = COMMON_BUILDER.define("desertShrubland", true);
//		redRockCanyon = COMMON_BUILDER.define("redRockCanyon", true);
		COMMON_BUILDER.pop();
		
		COMMON_CONFIG = COMMON_BUILDER.build();
	}
}