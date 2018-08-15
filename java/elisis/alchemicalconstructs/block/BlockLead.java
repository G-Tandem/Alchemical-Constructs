package elisis.alchemicalconstructs.block;

import elisis.alchemicalconstructs.AlchemicalConstructs;
import elisis.alchemicalconstructs.multiblock.BlockMultiblock;
import elisis.alchemicalconstructs.multiblock.TileLeadMultiblock;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLead extends BlockMultiblock {
	
	public BlockLead(Material mat) {
		
		super(mat);
		this.setBlockName("lead_block");
		this.setBlockTextureName(AlchemicalConstructs.MODID + ":lead_block");
		this.setResistance(10.0F);
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileLeadMultiblock();
	}

}
