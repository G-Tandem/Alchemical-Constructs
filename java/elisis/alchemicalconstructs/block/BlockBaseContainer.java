package elisis.alchemicalconstructs.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockBaseContainer extends BlockContainer {
	
	protected boolean registerBlockName;
	protected boolean registerTileEntity;
	protected boolean registerWithCreateTab;
	protected final Class classTile;
	protected final Class classItem;
	
	public BlockBaseContainer(Material material, Class classTile) {
		this(material, classTile, (Class)null);
	
	}
	
	public BlockBaseContainer(Material material, Class classTile, Class, classItem) {
		
		super(material);
		this.registerBlockName = true;
		this.registerTileEntity = true;
		this.registerWithCreateTab = true;
		this.classTile = classTile;
		this.classItem = classItem;
		
	}
	
	public Block setBlockName(String blockName) {
		
		if (this.registerWithCreateTab) {
			this.setCreativeTab(CreativeTabs.tabBlock);
		}
		
		if (this.registerBlockName) {
			
			if (this.classItem == null) {
				
				GameRegistry.registerBlock(this, blockName);
			
			} else {
				GameRegistry.registerBlock(this, this.classItem, blockName);
			}
			
		}
		
		if (this.registerTileEntity) {
			GameRegistry.registerTileEntity(this.classTile, blockName);
		}
		
		return super.setBlockName(blockName);
		
	}
	
	public TileEntity createNewTileEntity(World world, int meta) {
		
		try {
			
			return (TileEntity) this.classTile.newInstance();
		
		} catch (Throwable var4) {
			return null;
		}
	}
	
	
	

}
