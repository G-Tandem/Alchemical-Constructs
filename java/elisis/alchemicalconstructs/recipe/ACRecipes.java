package elisis.alchemicalconstructs.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import elisis.alchemicalconstructs.item.ACItems;
import net.minecraft.item.ItemStack;

public class ACRecipes {
	
	public static void init() {
		
		GameRegistry.addSmelting(ACItems.gypsum_dust, new ItemStack(ACItems.chalk), 0);
	
	}
	
	

}
