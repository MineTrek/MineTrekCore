package net.minetrek.blocks.power;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ElectricCable extends BlockContainer {

	public ElectricCable(int par1) {
		super(par1, Material.circuits);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("electricCable");
		LanguageRegistry.addName(this, "Electric Cable");
		setTextureName("minetrek:electricCable");

		this.setBlockBounds(0, 0, 0, 1.0F, 0.2F, 1.0F);

		GameRegistry.registerTileEntity(ElectricCableTileEntity.class, "electricCableTileEntity");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new ElectricCableTileEntity();
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
	public int onBlockPlaced(World w, int x, int y, int z, int side, float xLox, float yLoc, float zLoc, int meta) {
		TileEntity te = w.getBlockTileEntity(x, y, z);

		if (te != null && te instanceof ElectricCableTileEntity) {
			((ElectricCableTileEntity) te).setAttachedSide(side, true);
		}
		return side;
	}

	@Override
	public void onBlockAdded(World w, int x, int y, int z) {
		super.onBlockAdded(w, x, y, z);
		TileEntity te = w.getBlockTileEntity(x, y, z);

		if (te != null && te instanceof ElectricCableTileEntity) {
			((ElectricCableTileEntity) te).setAttachedSide(w.getBlockMetadata(x, y, z), true);
			((ElectricCableTileEntity) te).checkConnections(w, x, y, z);
		}
	}

	@Override
	public void onNeighborBlockChange(World w, int x, int y, int z, int id) {
		TileEntity te = w.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof ElectricCableTileEntity) {
			((ElectricCableTileEntity) te).checkConnections(w, x, y, z);
		}
	}

	@Override
	public boolean canPlaceBlockOnSide(World w, int x, int y, int z, int side) {

		// TODO:

		return canPlaceBlockAt(w, x, y, z);
	}

	/*
	 * public AxisAlignedBB getSelectedBoundingBoxFromPool(World w, int x, int
	 * y, int z){ TileEntity te = w.getBlockTileEntity(x, y, z);
	 * 
	 * if (te != null && te instanceof ElectricCableTileEntity) { for(int side =
	 * 0; y < 6; y++) if(((ElectricCableTileEntity) te).isAttached(side)) return
	 * new AxisAlignedBB(); } }
	 */

}
