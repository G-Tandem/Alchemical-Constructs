package elisis.alchemicalconstructs.multiblock;

import elisis.alchemicalconstructs.block.ACBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

public class TileLeadMultiblock extends TileMultiblock {
	
	@Override
	public void doMultiblockStuff() {
		
	}
	
	@Override
	public boolean checkMultiblockForm() {
		//Checks to see if surrounded by lead
		int i = 0;
		
		for (int x = xCoord - 1; x < xCoord + 2; x++)
			for (int y = yCoord - 1; y < yCoord + 2; y++)
				for (int z = zCoord - 1; z < zCoord + 2; z++) {
					if (worldObj.getBlock(x, y, z) == ACBlocks.lead_block)
						i++;
				}
		return i == 26;
	}
	
	@Override
	public void setupStructure() {
		//Replaces lead with gold blocks
		
		for (int x = xCoord - 1; x < xCoord + 2; x++)
			for (int y = yCoord - 1; y < yCoord + 2; y++)
				for (int z = zCoord - 1; z < zCoord + 2; z++) {
					if (worldObj.getBlock(x, y, z) == ACBlocks.lead_block)
						worldObj.setBlock(x, y, z, Blocks.gold_block);
				}
	}
	
	@Override
	public void resetStructure() {
		
		for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    if (tile != null && (tile instanceof TileMultiblock))
                        ((TileMultiblock) tile).reset();
                }
		
	}
	
	@Override
	public void masterWriteToNBT() {
		
	}
	
	@Override
	public void masterReadFromNBT() {
		
	}

}
