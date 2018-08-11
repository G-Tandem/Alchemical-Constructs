package elisis.alchemicalconstructs.crop;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemSeedFood extends ItemFood implements IPlantable {
	
	private final Block blockPlant;
	
	private final Block soilId;
	
	public ItemSeedFood(int healAmount, float saturationMod, Block parBlockPlant, Block parSoilId) {
		
		super(healAmount, saturationMod, false);
		blockPlant = parBlockPlant;
		soilId = parSoilId;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, 
			int posX, int posY, int posZ, int par7, float par8, float par9, float par10) {
		
		//Not sure what this parameter does, copied it from potato
		if (par7 != 1) {
			return false;
		}
		else if (player.canPlayerEdit(posX, posY + 1, posZ, par7, stack)) {
			
			if (world.getBlock(posX, posY, posZ).canSustainPlant(world,
					posX, posY, posZ, ForgeDirection.UP, this) && world
					.isAirBlock(posX, posY + 1, posZ)) {
				
				world.setBlock(posX, posY + 1, posZ, blockPlant);
				
				--stack.stackSize;
				return true;
			}
			else {
				
				return false;
			}
		}
		else {
			
			return false;
		}
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}
	
	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return blockPlant;
	}
	
	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return 0;
	}
	
	public Block getSoilId() {
		return soilId;
	}

}
