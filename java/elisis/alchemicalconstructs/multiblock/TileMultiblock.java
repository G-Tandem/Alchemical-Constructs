package elisis.alchemicalconstructs.multiblock;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public abstract class TileMultiblock extends TileEntity {
	
	private boolean hasMaster, isMaster;
	private int masterX, masterY, masterZ;
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		
		if (!worldObj.isRemote) {
			if (hasMaster()) {
				if (isMaster()) {
					//Put multiblock actions here
				}
			
			} else {
				
				//Constantly check if structure is formed until it is
				if (checkMultiblockForm())
					setupStructure();
			}
		}
		
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
	
	public abstract boolean checkMultiblockForm();
	
	public void setupStructure() {

	}
	
	//Resets method to be run when the master is gone or tells them to
	public void reset() {
		
		masterX = 0;
		masterY = 0;
		masterZ = 0;
		isMaster = false;
		hasMaster = false;
	}
	
	public boolean checkForMaster() {
		
		TileEntity tile = worldObj.getTileEntity(masterX, masterY, masterZ);
		return (tile != null && (tile instanceof TileMultiblock));
	}
	
	public void resetStructure() {
		
		for (int x = xCoord - 1; x < xCoord + 2; x++)
			for (int y = yCoord; y < yCoord + 3; y++)
				for (int z = zCoord - 1; z < zCoord + 2; z++) {
					
					TileEntity tile = worldObj.getTileEntity(x, y, z);
					if (tile != null && (tile instanceof TileMultiblock))
						((TileMultiblock) tile).reset();
			}
	}

	public void masterWriteToNBT() {
		
	}

	public void masterReadFromNBT() {
		
	}

	public void doMultiblockStuff() {
		
	}
	

}
