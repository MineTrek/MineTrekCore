package net.minetrek.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class TransparentAlmuninum extends Block {

	public TransparentAlmuninum() {
		super(Material.glass);

		setHardness(20.0F); // 33% harder than diamond
		setStepSound(Block.soundTypeMetal);
		setUnlocalizedName("transparentAluminum");
		setBlockTextureName("minetrek:transparentAluminumBlock");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 3);
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
