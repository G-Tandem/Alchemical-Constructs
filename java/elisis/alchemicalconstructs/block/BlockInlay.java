package elisis.alchemicalconstructs.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInlay extends Block {

	protected BlockInlay(Material mat, String name, ) {
		super(mat);
		GameRegistry.registerBlock(this, name)
	}
	
	

}
