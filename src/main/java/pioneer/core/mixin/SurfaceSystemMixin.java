package pioneer.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.BlockColumn;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import pioneer.core.registry.world.PioneerBiomes;

@Mixin(SurfaceSystem.class)
public abstract class SurfaceSystemMixin {

	@Inject(at = @At("HEAD"), method="buildSurface")
	public void buildSurface(BiomeManager manager, Registry<Biome> biome, boolean y0, WorldGenerationContext context, final ChunkAccess level, NoiseChunk noiseChunk, SurfaceRules.RuleSource surfaceRules, CallbackInfo info) {
		final BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos();
		final ChunkPos chunkpos = level.getPos();
		int i = chunkpos.getMinBlockX();
		int j = chunkpos.getMinBlockZ();
		BlockColumn blockcolumn = new BlockColumn() {
			public BlockState getBlock(int i) {
				return level.getBlockState(blockpos.setY(i));
			}

			public void setBlock(int i, BlockState state) {
				LevelHeightAccessor levelheightaccessor = level.getHeightAccessorForGeneration();
				if (i >= levelheightaccessor.getMinBuildHeight() && i < levelheightaccessor.getMaxBuildHeight()) {
					level.setBlockState(blockpos.setY(i), state, false);
					if (!state.getFluidState().isEmpty()) {
						level.markPosForPostprocessing(blockpos);
					}
				}

			}

			public String toString() {
				return "ChunkBlockColumn " + chunkpos;
			}
		};
		
		BlockPos.MutableBlockPos blockpos1 = new BlockPos.MutableBlockPos();
		SurfaceRules.Context surfaceRulesContext = new SurfaceRules.Context(((SurfaceSystem) (Object) this), level, noiseChunk, manager::getBiome, biome, context);
		SurfaceRules.SurfaceRule surfacerules$surfacerule = surfaceRules.apply(surfaceRulesContext);
		boolean flag = false;
		for (int k = 0; k < 16; ++k) {
			for (int l = 0; l < 16; ++l) {
	            int i1 = i + k;
	            int j1 = j + l;
	            int k1 = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, k, l) + 1;
	            blockpos.setX(i1).setZ(j1);
	            Holder<Biome> holder = manager.getBiome(blockpos1.set(i1, y0 ? 0 : k1, j1));
	            if (holder.is(PioneerBiomes.RED_ROCK_CANYON.getKey())) {
	            	flag = true;
					this.erodedBadlandsExtension(blockcolumn, i1, j1, k1, level);
	               
		            int l1 = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, k, l) + 1;
		            surfaceRulesContext.updateXZ(i1, j1);
		            int i2 = 0;
		            int j2 = Integer.MIN_VALUE;
		            int k2 = Integer.MAX_VALUE;
		            int l2 = level.getMinBuildHeight();

		            for(int i3 = l1; i3 >= l2; --i3) {
		               BlockState blockstate = blockcolumn.getBlock(i3);
		               if (blockstate.isAir()) {
		                  i2 = 0;
		                  j2 = Integer.MIN_VALUE;
		               } else if (!blockstate.getFluidState().isEmpty()) {
		                  if (j2 == Integer.MIN_VALUE) {
		                     j2 = i3 + 1;
		                  }
		               } else {
		                  if (k2 >= i3) {
		                     k2 = DimensionType.WAY_BELOW_MIN_Y;

		                     for(int j3 = i3 - 1; j3 >= l2 - 1; --j3) {
		                        BlockState blockstate1 = blockcolumn.getBlock(j3);
		                        if (!this.isStone(blockstate1)) {
		                           k2 = j3 + 1;
		                           break;
		                        }
		                     }
		                  }

		                  ++i2;
		                  int k3 = i3 - k2 + 1;
		                  surfaceRulesContext.updateY(i2, k3, j2, i1, i3, j1);
		                  if (blockstate == Blocks.STONE.defaultBlockState()) {
		                     BlockState blockstate2 = surfacerules$surfacerule.tryApply(i1, i3, j1);
		                     if (blockstate2 != null) {
		                        blockcolumn.setBlock(i3, blockstate2);
		                     }
		                  }
		               }
		            }
	            }
			}
		}
		if(flag) {
			return;
		}
	}
	
	@Shadow
	public abstract void erodedBadlandsExtension(BlockColumn blockColumn, int i, int j, int k, LevelHeightAccessor level);
	
	@Shadow
	public abstract boolean isStone(BlockState state);
}
