package net.minetrek.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class TransparentAluminum extends Block {

	public TransparentAluminum() {
		super(Material.glass);

		setHardness(20.0F); // 33% harder than diamond
		setStepSound(Block.soundTypeMetal);
		setBlockName("transparentAluminum");
		setBlockTextureName("minetrek:transparentAluminum");
		this.setResistance(500.0F);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
		return !iblockaccess.getBlock(i, j, k).equals(this);
	}

}
