package net.minetrek.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAntimatter extends BlockFluidClassic {

	public BlockAntimatter(int id) {
		super(id, MineTrekBlocks.antimatter_fluid, Material.water);

		this.setLightValue(1.0f);
		this.setTextureName("minetrek:antimatter");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return Block.waterMoving.getIcon(side, meta);
	}

	@Override
	public int colorMultiplier(IBlockAccess iblockaccess, int x, int y, int z) {
		return 0x66FF00;
	}

}
