package net.minetrek.blocks.machines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minetrek.MineTrek;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Refinery extends Block {

	public Refinery(int par1) {
		super(par1, Material.iron);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("refinery");
		setTextureName("minetrek:refinery");
		LanguageRegistry.addName(this, "Refinery");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 1);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float a, float b, float c) {
		player.openGui(MineTrek.instance, 0, world, x, y, z);
		return true;
	}

}
