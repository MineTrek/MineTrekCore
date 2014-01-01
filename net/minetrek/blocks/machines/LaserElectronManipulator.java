package net.minetrek.blocks.machines;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LaserElectronManipulator extends BlockContainer {

	public LaserElectronManipulator(int par1) {
		super(par1, Material.iron);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("laserElectronManipulator");
		LanguageRegistry.addName(this, "Laser Electron Manipulator");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 1);
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new LaserElectronManipulatorTileEntity();
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
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase player, ItemStack is) {
		int dir = MathHelper.floor_double((player.rotationYaw * 4F) / 360F + 0.5D) & 3;
		w.setBlockMetadataWithNotify(x, y, z, dir, 0);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new LaserElectronManipulatorTileEntity();
	}

}
