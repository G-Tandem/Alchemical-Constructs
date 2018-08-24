package elisis.alchemicalconstructs.block;

import java.util.Random;

import elisis.alchemicalconstructs.AlchemicalConstructs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CustomDropBlock extends Block {
	
	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	
	
	//*Probably* won't need this, but it's good to be organized ;)
	/**
	 * An instance of a block with a custom drop.
	 * @author Elisis
	 * 
	 * @param unlocalizedName The name the block will be registered under
	 * @param mat The material of the block
	 * @param drop The item the block drops
	 * @param meta Damage of the item dropped (don't need to worry about this, unless you're working with something like dye)
	 * @param least_quantity The least amount of the item that the block will drop
	 * @param most_quantity The most amount of the item that the block will drop
	 * @param hardness The hardness of the block
	 * @param resistance The resistance of the block
	 * @param tool The tool of which is effective against the block
	 * @param level The tool level required
	 * @param sound The step sound
	 */
	
	//Creates a block with a specified drop (including ores)
	protected CustomDropBlock(String unlocalizedName, Material mat, Item drop, int meta, int least_quantity, int most_quantity, float hardness, float resistance, String tool, int level, SoundType sound) {
		
		super(mat);
		this.drop = drop;
		this.meta = meta;
		this.least_quantity = least_quantity;
		this.most_quantity = most_quantity;
		
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(AlchemicalConstructs.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(soundTypeStone);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setHarvestLevel(tool, level);
		
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		return this.drop;
	}
	
	@Override
	public int damageDropped(int metadata) {
		return this.meta;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		
		if (this.least_quantity >= this.most_quantity)
			return this.least_quantity;
		
		return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	}

}
