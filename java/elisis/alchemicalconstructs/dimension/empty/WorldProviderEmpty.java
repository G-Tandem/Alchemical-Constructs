package elisis.alchemicalconstructs.dimension.empty;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderEmpty extends WorldProvider {
	
	private static BiomeGenBase waterBiome;
	
	private static int waterID = 97;
	
	@Override
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(waterBiome, 0.8f);
		this.dimensionId = waterID;
		
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderEmpty
	}

}
//https://github.com/Eternaldoom/Realms-of-Chaos/blob/master/com/eternaldoom/realmsofchaos/water/gen/ChunkProviderWater.java