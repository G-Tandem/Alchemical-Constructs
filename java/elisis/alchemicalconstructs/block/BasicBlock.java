package elisis.alchemicalconstructs.block;

import elisis.alchemicalconstructs.AlchemicalConstructs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BasicBlock extends Block {
	
	protected BasicBlock(String unlocalizedName, Material mat, float hardness, float resistance, String tool, int level, SoundType sound) {
		
		super(mat);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(AlchemicalConstructs.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(sound);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setHarvestLevel(tool, level);
	}

}
