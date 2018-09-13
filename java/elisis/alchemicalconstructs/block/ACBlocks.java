package elisis.alchemicalconstructs.block;

import cpw.mods.fml.common.registry.GameRegistry;
import elisis.alchemicalconstructs.item.ACItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

public class ACBlocks {
	
	public static Block copper_inlay;
	
	public static Block copper_ore;
	
	public static Block lead_block;
	
	public static Block gypsum_block;
	
	public static Block tin_ore;
	
	public static Block silver_ore;
	
	public static void init() {		
		
		gypsum_block = new CustomDropBlock("gypsum_block", Material.rock, ACItems.gypsum_dust, 
				2, 4, 0, 0.5f, 2.5f, "pickaxe", 1, Block.soundTypeStone);
		GameRegistry.registerBlock(gypsum_block, gypsum_block.getUnlocalizedName());
		OreDictionary.registerOre("blockGypsum", gypsum_block);
		
		copper_inlay = new CopperInlay();
		GameRegistry.registerBlock(copper_inlay, copper_inlay.getUnlocalizedName());
		
		//Needs a separate constructor for multiblock ;-;
		lead_block = new BlockLead(Material.iron);
		GameRegistry.registerBlock(lead_block, lead_block.getUnlocalizedName());
		OreDictionary.registerOre("blockLead", lead_block);
		
		copper_ore = new BasicBlock("copper_ore", Material.rock, 0.5f, 2.5f, "pickaxe", 2, Block.soundTypeStone);
		GameRegistry.registerBlock(copper_ore, copper_ore.getUnlocalizedName());
		OreDictionary.registerOre("oreCopper", copper_ore);
		
		tin_ore = new BasicBlock("tin_ore", Material.rock, 0.5f, 2.5f, "pickaxe", 2, Block.soundTypeStone);
		GameRegistry.registerBlock(tin_ore, tin_ore.getUnlocalizedName());
		OreDictionary.registerOre("oreTin", tin_ore);
		
		
		
	}
	
	

}
