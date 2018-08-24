package elisis.alchemicalconstructs.item;

import elisis.alchemicalconstructs.AlchemicalConstructs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemChalk extends Item {
	
	/**
	 * Register new Chalk item.
	 */
	
	protected ItemChalk(String type) {
		if (type == "gypsum") {
			
			this.setUnlocalizedName("chalk");
			this.setTextureName(AlchemicalConstructs.MODID + ":chalk");
			this.setCreativeTab(CreativeTabs.tabTools);
			this.setMaxDamage(255);
			
		} else if (type == "gold") {
			
			this.setUnlocalizedName("golden_chalk");
			this.setTextureName(AlchemicalConstructs.MODID + ":golden_chalk");
			this.setCreativeTab(CreativeTabs.tabTools);
			this.setMaxDamage(512);
		}
			
	}
}
	
	

