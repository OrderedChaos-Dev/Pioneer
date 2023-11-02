package pioneer.core.mixin;

import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
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
import pioneer.core.registry.world.PioneerBiomes;

@Mixin(SurfaceSystem.class)
public abstract class SurfaceSystemMixin {

	@Shadow
	private NormalNoise badlandsPillarRoofNoise;

	@Shadow
	private NormalNoise badlandsPillarNoise;

	@Shadow
	private NormalNoise badlandsSurfaceNoise;

	@Shadow
	private BlockState defaultBlock;

	@Inject(method = "buildSurface", at = @At(value = "INVOKE", target="Lnet/minecraft/core/Holder;is(Lnet/minecraft/resources/ResourceKey;)Z", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
	public void buildSurface(RandomState random, BiomeManager manager, Registry<Biome> biome, boolean y0, WorldGenerationContext context,
													 final ChunkAccess level, NoiseChunk noiseChunk, SurfaceRules.RuleSource surfaceRules, CallbackInfo info,
													 BlockPos.MutableBlockPos pos1, ChunkPos chunkpos, int i, int j, BlockColumn blockcolumn,
													 SurfaceRules.Context surfacerulesContext, SurfaceRules.SurfaceRule surfaceRule, BlockPos.MutableBlockPos pos2,
													 int k, int l, int i1, int j1, int k1, Holder<Biome> holder) {

        if (holder.is(PioneerBiomes.RED_ROCK_CANYON.getKey()) || holder.is(PioneerBiomes.OVERGROWN_SPIRES.getKey())) {
        	this.overgrownHeightsExtension(blockcolumn, i1, j1, k1, level);
        }

	}
	
	@Shadow
	public abstract void erodedBadlandsExtension(BlockColumn blockColumn, int i, int j, int k, LevelHeightAccessor level);

	private void overgrownHeightsExtension(BlockColumn p_189955_, int p_189956_, int p_189957_, int p_189958_, LevelHeightAccessor p_189959_) {
		double d0 = 0.2D;
		double d1 = Math.min(Math.abs(this.badlandsSurfaceNoise.getValue((double)p_189956_, 0.0D, (double)p_189957_) * 8.25D), this.badlandsPillarNoise.getValue((double)p_189956_ * 0.2D, 0.0D, (double)p_189957_ * 0.2D) * 15.0D);
		if (!(d1 <= 0.0D)) {
			double d2 = 0.75D;
			double d3 = 1.5D;
			double d4 = Math.abs(this.badlandsPillarRoofNoise.getValue((double)p_189956_ * 0.75D, 0.0D, (double)p_189957_ * 0.75D) * 1.5D);
			double d5 = 64.0D + Math.min(d1 * d1 * 4.5D, Math.ceil(d4 * 50.0D) + 36.0D);
			int i = Mth.floor(d5);
			if (p_189958_ <= i) {
				for(int j = i; j >= p_189959_.getMinBuildHeight(); --j) {
					BlockState blockstate = p_189955_.getBlock(j);
					if (blockstate.is(this.defaultBlock.getBlock())) {
						break;
					}

					if (blockstate.is(Blocks.WATER)) {
						return;
					}
				}

				for(int k = i; k >= p_189959_.getMinBuildHeight() && p_189955_.getBlock(k).isAir(); --k) {
					p_189955_.setBlock(k, this.defaultBlock);
				}

			}
		}
	}
}
