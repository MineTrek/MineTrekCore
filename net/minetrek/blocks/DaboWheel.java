package MineTrekCore.net.minetrek.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class DaboWheel extends Block
{
	
	Random rand;
	private World worldObj;

	public DaboWheel(int par1, World par1World) {
		super(par1, Material.iron);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("DaboWheel");
		setTextureName("minetrek:DaboWheel");
		LanguageRegistry.addName(this, "DaboWheel");
		this.setResistance(500.0F);
		this.worldObj = par1World;
		}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{ 
		this.ejectLatinum();
		return true;
	}
	
	public void ejectLatinum()
	{
		this.worldObj.spawnEntityInWorld(entitylatinum);
	}
	

}
