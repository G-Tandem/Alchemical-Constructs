package elisis.alchemicalconstructs.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import elisis.alchemicalconstructs.AlchemicalConstructs;
import elisis.alchemicalconstructs.crop.RecipeBlockCrops;
import elisis.alchemicalconstructs.item.ACItems;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;


//Probably not going to use as is, but probably will use as a template for something else.
public class BlockBlueberry extends RecipeBlockCrops {
	
	public BlockBlueberry() {
		
		setBlockName("blueberries");
		setBlockTextureName(AlchemicalConstructs.MODID + ":blueberries_stage_0");
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random rand) {
		return(meta/2);
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		//DEBUG
		System.out.println("Blockberry getItemDropped()");
		return(ACItems.blueberry);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		
		iIcon = new IIcon[maxGrowthStage + 1];
		
		iIcon[0] = icon.registerIcon(AlchemicalConstructs.MODID + ":blueberries_stage_0");
		iIcon[1] = icon.registerIcon(AlchemicalConstructs.MODID + ":blueberries_stage_0");
		iIcon[2] = icon.registerIcon(AlchemicalConstructs.MODID + ":blueberries_stage_1");
		iIcon[3] = icon.registerIcon(AlchemicalConstructs.MODID + ":blueberries_stage_1");
		iIcon[4] = icon.registerIcon(AlchemicalConstructs.MODID + ":blueberries_stage_2");
		iIcon[5] = icon.registerIcon(AlchemicalConstructs.MODID + ":blueberries_stage_2");
		iIcon[6] = icon.registerIcon(AlchemicalConstructs.MODID + ":blueberries_stage_3");
		iIcon[7] = icon.registerIcon(AlchemicalConstructs.MODID + ":blueberries_stage_3");
	}

}
