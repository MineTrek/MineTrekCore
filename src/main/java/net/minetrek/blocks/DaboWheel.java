package net.minetrek.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class DaboWheel extends Block {

	Random rand;
	private World worldObj;

	public DaboWheel() {
		super(Material.iron);
		setStepSound(Block.soundTypeMetal);
		setBlockName("daboWheel");
		setBlockTextureName("minetrek:daboWheel");
		this.setResistance(500.0F);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		this.ejectLatinum();
		return true;
	}

	public void ejectLatinum() {
		// this.worldObj.spawnEntityInWorld(MineTrekItems.latinum);
	}
}
