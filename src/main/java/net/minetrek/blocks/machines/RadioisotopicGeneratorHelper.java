package net.minetrek.blocks.machines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RadioisotopicGeneratorHelper extends Block {

	public RadioisotopicGeneratorHelper() {
		super(Material.iron);
		setStepSound(Block.soundTypeMetal);
		setBlockName("radioisotopicGeneratorHelper");
		setBlockTextureName("minetrek:radioisotopicGeneratorOff");

		setBlockBounds(0F, -1.0F, 0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		return world.getBlock(x, y - 1, z).onBlockActivated(world, x, y - 1, z, player, side, hitX, hitY, hitZ);
	}

	@Override
	public void onBlockDestroyedByPlayer(World w, int x, int y, int z, int meta) {
		w.func_147480_a(x, y - 1, z, true);
	}

}
