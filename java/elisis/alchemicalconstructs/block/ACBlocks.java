package elisis.alchemicalconstructs.block;

import cpw.mods.fml.common.registry.GameRegistry;
import elisis.alchemicalconstructs.item.ACItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ACBlocks {
	
	/*unlocalizedName, material, drop, least_quantity, most_quantity, hardness, resistance, tool, level*/
	public static Block gypsum_block = new CustomDropBlock("gypsum_block",
			Material.rock, ACItems.gypsum_dust, 2, 4, 0, 
			0.5f, 2.5f, "pickaxe", 1); 
	
	public static Block blockBlueberry;
	
	public static void init() {
		
		blockBlueberry = new BlockBlueberry();
		
		GameRegistry.registerBlock(gypsum_block, gypsum_block.getUnlocalizedName());
		
	}
	

}
