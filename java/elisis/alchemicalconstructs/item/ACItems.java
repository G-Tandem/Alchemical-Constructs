package elisis.alchemicalconstructs.item;

import cpw.mods.fml.common.registry.GameRegistry;
import elisis.alchemicalconstructs.AlchemicalConstructs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ACItems {
	
	public static Item chalk;
	public static Item gypsum_dust;
	
	public static Item blueberry;
	
	
	
	public static void init() {
		
		chalk = new ItemChalk();
		GameRegistry.registerItem(chalk, chalk.getUnlocalizedName());
		
		gypsum_dust = new Item().setUnlocalizedName("gypsum_dust").setTextureName(AlchemicalConstructs.MODID + ":" + gypsum_dust.getUnlocalizedName()).setCreativeTab(CreativeTabs.tabMaterials);
		
		blueberry = new ItemFood(0, false).setUnlocalizedName("blueberry").setTextureName(AlchemicalConstructs.MODID + "" + blueberry.getUnlocalizedName()).setCreativeTab(CreativeTabs.tabFood);
	
	}

}
