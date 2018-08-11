package elisis.alchemicalconstructs;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import elisis.alchemicalconstructs.block.ACBlocks;
import elisis.alchemicalconstructs.item.ACItems;

@Mod(modid = AlchemicalConstructs.MODID, name = AlchemicalConstructs.NAME, version = AlchemicalConstructs.VERSION)
public class AlchemicalConstructs {
	
	public static final String MODID = "alchemicalconstructs";
	public static final String NAME = "Alchemical Constructs";
	public static final String VERSION = "1.7.10a0.1";
	
	//Not needed *right* now, but will be useful to have in the future. 
	@Instance
	public static AlchemicalConstructs instance = new AlchemicalConstructs(); 
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) { 
		ACItems.init();
		ACBlocks.init();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}

//Test