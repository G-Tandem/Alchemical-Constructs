package elisis.alchemicalconstructs.crop;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class RecipeBlockCrops extends BlockBush implements IGrowable {
	
	protected int maxGrowthStage = 7;
	
	@SideOnly(Side.CLIENT)
	protected IIcon[] iIcon;
	
	public RecipeBlockCrops() {
		
		setTickRandomly(true);
		float f = 0.5f;
		setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
		setCreativeTab((CreativeTabs)null);
		setHardness(0.0f);
		setStepSound(soundTypeGrass);
		disableStats();
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block block) {
		return block == Blocks.farmland;
	}
	
	public void incrementGrowthStage(World world, Random rand, int posX, int posY, int posZ) {
		
		int growthStage = world.getBlockMetadata(posX, posY, posZ) +
				MathHelper.getRandomIntegerInRange(rand, 2, 5);
		
		if (growthStage > maxGrowthStage)
			growthStage = maxGrowthStage;
		
		world.setBlockMetadataWithNotify(posX, posY, posZ, growthStage, 2);
		
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return Item.getItemFromBlock(this);	
	}
	
	@Override
	public int getRenderType() {
		return 1; //Cross like flowers
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int growthStage) {
		return iIcon[growthStage];
	}
	
	@Override //Checks if finished growing (stage 7 is the final stage)
	public boolean func_149851_a(World world, int posX, int posY, int posZ, boolean p_149851_5_) {
		return world.getBlockMetadata(posX, posY, posZ) != 7;
	}
	
	@Override
	public boolean func_149852_a(World world, Random rand, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return true;
	}
	
	@Override
	public void func_149853_b(World world, Random rand, int posX, int posY, int posZ) {
		incrementGrowthStage(world, rand, posX, posY, posZ);
	}
	
	@Override
	public void updateTick(World world, int posX, int posY, int posZ, Random rand) {
		
		super.updateTick(world, posX, posY, posZ, rand);
		int growthStage = world.getBlockMetadata(posX, posY, posZ) + 1;
		
		if (growthStage > 7) {
			growthStage = 7;
		}
		
		world.setBlockMetadataWithNotify(posX, posY, posZ, growthStage, 2);
	}
	

}
