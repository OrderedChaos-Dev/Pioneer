package pioneer.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.chunk.BlockColumn;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import pioneer.core.registry.world.PioneerBiomes;

@Mixin(SurfaceSystem.class)
public abstract class SurfaceSystemMixin {

	@Inject(method = "buildSurface", at = @At(value = "INVOKE", target="Lnet/minecraft/core/Holder;is(Lnet/minecraft/resources/ResourceKey;)Z", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
	public void buildSurface(BiomeManager manager, Registry<Biome> biome, boolean y0, WorldGenerationContext context,
			final ChunkAccess level, NoiseChunk noiseChunk, SurfaceRules.RuleSource surfaceRules, CallbackInfo info,
			BlockPos.MutableBlockPos pos1, ChunkPos chunkpos, int i, int j, BlockColumn blockcolumn,
			SurfaceRules.Context surfacerulesContext, SurfaceRules.SurfaceRule surfaceRule, BlockPos.MutableBlockPos pos2,
			int k, int l, int i1, int j1, int k1, Holder<Biome> holder) {
		
        if (holder.is(PioneerBiomes.RED_ROCK_CANYON.getKey()) || holder.is(PioneerBiomes.OVERGROWN_SPIRES.getKey())) {
        	this.erodedBadlandsExtension(blockcolumn, i1, j1, k1, level);
        }

	}
	
	@Shadow
	public abstract void erodedBadlandsExtension(BlockColumn blockColumn, int i, int j, int k, LevelHeightAccessor level);

}
