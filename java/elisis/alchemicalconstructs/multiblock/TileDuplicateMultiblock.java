package elisis.alchemicalconstructs.multiblock;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileDuplicateMultiblock extends TileEntity {
	
	private boolean hasMaster, isMaster;
	private int masterX, masterY, masterZ;
	
	@Override
	public void updateEntity() {
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		
		super.writeToNBT(tag);
		tag.setInteger("masterX", masterX);
		tag.setInteger("masterY", masterY);
		tag.setInteger("masterZ", masterZ);
		tag.setBoolean("hasMaster", hasMaster);
		tag.setBoolean("isMaster", isMaster);
		
		if (hasMaster() && isMaster()) {
			//Any other values should ONLY BE SAVED TO THE MASTER
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		
		super.readFromNBT(tag);
		masterX = tag.getInteger("masterX");
		masterY = tag.getInteger("masterY");
		masterZ = tag.getInteger("masterZ");
		hasMaster = tag.getBoolean("hasMaster");
		isMaster = tag.getBoolean("isMaster");
		
		if (hasMaster() && isMaster()) {
			//Any other values should ONLY BE READ BY THE MASTER
		}
	}
	
	public boolean hasMaster() {
		return hasMaster;
	}
	
	public boolean isMaster() {
		return isMaster;
	}
	
	public int getMasterX() {
		return masterX;
	}
	
	public int getMasterY() {
		return masterY;
	}
	
	public int getMasterZ() {
		return masterZ;
	}
	
	public void setHasMaster(boolean bool) {
		hasMaster = bool;
	}
	
	public void setIsMaster(boolean bool) {
		isMaster = bool;
	}
	
	public void setMasterCoords(int x, int y, int z) {
		masterX = x;
		masterY = y;
		masterZ = z;
	}
	
	public boolean checkMultiblockForm() {
		
		int i = 0;
		
		for (int x = xCoord - 1; x < xCoord + 2; x++)
			for (int y = yCoord; y < yCoord + 3; y++)
				for (int z = zCoord - 1; z < zCoord + 2; z++) {
					TileEntity tile = worldObj.getTileEntity(x, y, z);
					//Make sure tile != null, is an instance of the same Tile, and isn't already a part of a multiblock
					
					if (tile != null && (tile instanceof TileDuplicateMultiblock)) {
						if (this.isMaster()) {
							if (((TileDuplicateMultiblock)tile).hasMaster())
								i++;
						
						} else if (!((TileDuplicateMultiblock)tile).hasMaster())
							i++;
					}
				}
		return i > 25 && worldObj.isAirBlock(xCoord, yCoord, zCoord);
		
	}
	
	public void setupStructure() {
		
		for (int x = xCoord - 1; x < xCoord + 2; x++)
			for (int y = yCoord; y < yCoord + 3; y++)
				for (int z = zCoord; z < zCoord + 2; z++) {
					TileEntity tile = worldObj.getTileEntity(x, y, z);
					
					//Check if block is bottom centre block
					boolean master = (x == xCoord && y == yCoord && z == zCoord);
					
					if (tile != null && (tile instanceof TileDuplicateMultiblock)) {
						((TileDuplicateMultiblock) tile).setMasterCoords(xCoord, yCoord, zCoord);
						((TileDuplicateMultiblock) tile).setHasMaster(true);
						((TileDuplicateMultiblock) tile).setIsMaster(master);
					}
				}
	}
	
	//Resets (3.)
	

}
