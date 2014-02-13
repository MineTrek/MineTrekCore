package net.minetrek.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAntimatter extends BlockFluidClassic {

	public BlockAntimatter() {
		super(MineTrekBlocks.antimatter_fluid, Material.water);

		this.setLightLevel(1.0f);
		this.setBlockTextureName("minetrek:antimatter");
	}

	@Override
	public int colorMultiplier(IBlockAccess iblockaccess, int x, int y, int z) {
		return 0x66FF00;
	}

}
