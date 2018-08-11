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
	
	//Creates a block with a specified drop (including ores)
	protected CustomDropBlock(String unlocalizedName, Material mat, Item drop, int meta, int least_quantity, int most_quantity, float hardness, float resistance, String tool, int level) {
		
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
