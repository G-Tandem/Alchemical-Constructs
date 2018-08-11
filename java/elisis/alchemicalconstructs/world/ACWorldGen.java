package elisis.alchemicalconstructs.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import elisis.alchemicalconstructs.block.ACBlocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ACWorldGen implements IWorldGenerator {
	
	private WorldGenerator gen_gypsum;
	
	public ACWorldGen() {
		this.gen_gypsum = new WorldGenMinable(ACBlocks.gypsum_block, 20);
			
	}
	
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch (world.provider.dimensionId) {
		
		case 0: //Overworld
			
			this.runGenerator(this.gen_gypsum, world, rand, chunkX, chunkZ, 20, 25, 90);
			break;
			
		case -1: //Nether
			
			break;
			
		case 1: //End
			
			break;
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int spawnChances, int minHeight, int maxHeight) {
		
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal height arguments for world generator");
		
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < spawnChances; i++) {
			
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight  + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			gen.generate(world, rand, x, y, z);
		}
	}

}
