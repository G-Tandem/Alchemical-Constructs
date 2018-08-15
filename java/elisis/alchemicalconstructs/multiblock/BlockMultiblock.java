package elisis.alchemicalconstructs.multiblock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMultiblock extends BlockContainer {
	
	public BlockMultiblock(Material material) {
		super(material);
		
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		
		TileEntity tile = world.getTileEntity(x, y, z);
		
		if (tile != null && tile instanceof TileMultiblock) {
			TileMultiblock multiblock = (TileMultiblock) tile;
			
			if (multiblock.hasMaster()) {
				if (multiblock.isMaster()) {
					if (!multiblock.checkMultiblockForm())
						multiblock.resetStructure();
				
				} else {
					
					if (!multiblock.checkForMaster()) {
						multiblock.reset();
						world.markBlockForUpdate(x, y, z);
					}
				}
			}
		}
		
		super.onNeighborBlockChange(world, x, y, z, block);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return null;
	}

}
