package elisis.alchemicalconstructs.item;

import elisis.alchemicalconstructs.AlchemicalConstructs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemChalk extends Item {
	
	protected ItemChalk() {
		this.setUnlocalizedName("chalk");
		this.setTextureName(AlchemicalConstructs.MODID + ":" + "chalk");
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setMaxDamage(255);
		
			
		}
	}
	
	

