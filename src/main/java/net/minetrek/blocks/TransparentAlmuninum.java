package net.minetrek.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TransparentAlmuninum extends Block {

	public TransparentAlmuninum() {
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

}
