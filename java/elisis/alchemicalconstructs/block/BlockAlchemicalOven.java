package elisis.alchemicalconstructs.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockAlchemicalOven extends BlockBaseContainer {
	
	private final Random furnaceRand = new Random();
	private final boolean isActive;
	private static boolean keepFurnaceInventory;
	
	public BlockAlchemicalOven(boolean burning) {
		
		super(Material.iron, BlockAlchemicalOven.TileEntityAlchemicalOven.class);
		super.registerTileEntity = !burning;
		super.registerWithCreateTab = !burning;
		this.isActive = burning;
		this.setHardness(3.5f);
		this.setStepSound(Block.soundTypeMetal);
		
		if (this.isActive) {
			this.setLightLevel(0.875f)
		}
		
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
	}
	
	public boolean isOpaqueCube() {
		return true;
	}
	
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return true;
	}

}
