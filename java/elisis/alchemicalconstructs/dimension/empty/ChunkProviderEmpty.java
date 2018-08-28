package elisis.alchemicalconstructs.dimension.empty;

import java.util.List;
import java.util.Random;

import elisis.alchemicalconstructs.AlchemicalConstructs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;

public class ChunkProviderEmpty implements IChunkProvider {
	
	//The following is shoddy code not written by me, and I can't be bothered to change it.
	
	//A NoiseGeneratorOctaves used in generating terrain (probably won't be used, for obvious reasons)
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorPerlin noisePerl;
	
	public NoiseGeneratorOctaves noiseGen5;
	
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	
	//Reference to World object
	private World worldObj;
	
	//Whether map features are to be generated, e.g strongholds (no)
	private final boolean mapFeaturesEnabled;
	
	
	private WorldType worldType;
	private final double[] noiseArray;
	private final float[] parabolicField;
	private double[] stoneNoise = new double[256]; //??
	private MapGenBase caveGenerator = new MapGenCaves(); //Probably won't be used.
	
	private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature(); //Probably won't be used.
	
	//Holds ravine generator. Again, probably won't be used.
	private MapGenBase ravineGenerator = new MapGenRavine();
	
	//The biomes used to generate the chunk
	private BiomeGenBase[] biomesForGeneration;
	
	//Double array(s?) to hold terrain noise
	double[] noise1;
	double[] noise2;
	double[] noise3;
	double[] noise5;
	int[][] field_73219_j = new int[32][32]; //???
	

	private Random rand;
	
	public ChunkProviderEmpty(World world, long seed, boolean features) {
		
		AlchemicalConstructs.logger.info("<--ALCHEMICAL CONSTRUCTS-->:Loading chunk provider for empty dimension.");
		
		this.worldObj = world;
		this.mapFeaturesEnabled = features;
		this.worldType = world.getWorldInfo().getTerrainType();
		this.rand = new Random(seed);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noisePerl = new NoiseGeneratorPerlin(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
		
		this.noiseArray = new double[825];
		this.parabolicField = new float[25];
		
		for 
		
		
	}
	
	@Override
	public boolean chunkExists(int p_73149_1_, int p_73149_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Chunk provideChunk(int p_73154_1_, int p_73154_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chunk loadChunk(int p_73158_1_, int p_73158_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadQueuedChunks() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSave() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String makeString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_,
			int p_147416_5_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void recreateStructures(int p_82695_1_, int p_82695_2_) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveExtraData() {
		// TODO Auto-generated method stub

	}

}
//https://github.com/Jimmy04Creeper/Minecraft_Tutorial_1.7.10/blob/master/src/jimmy/tutorial/world/ChunkProviderForest.java