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

	public ElectricCable() {
		super(Material.circuits);
		setStepSound(Block.soundTypeMetal);
		setBlockName("electricCable");
		setBlockTextureName("minetrek:electricCable");

		this.setBlockBounds(0, 0, 0, 1.0F, 0.2F, 1.0F);

		GameRegistry.registerTileEntity(ElectricCableTileEntity.class, "electricCableTileEntity");
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
		TileEntity te = w.getTileEntity(x, y, z);

		if (te != null && te instanceof ElectricCableTileEntity) {
			((ElectricCableTileEntity) te).setAttachedSide(side, true);
		}
		return side;
	}

	@Override
	public void onBlockAdded(World w, int x, int y, int z) {
		super.onBlockAdded(w, x, y, z);
		TileEntity te = w.getTileEntity(x, y, z);

		if (te != null && te instanceof ElectricCableTileEntity) {
			((ElectricCableTileEntity) te).setAttachedSide(w.getBlockMetadata(x, y, z), true);
			((ElectricCableTileEntity) te).checkConnections(w, x, y, z);
		}
	}

	@Override
	public void onNeighborBlockChange(World w, int x, int y, int z, Block b) {
		TileEntity te = w.getTileEntity(x, y, z);
		if (te != null && te instanceof ElectricCableTileEntity) {
			((ElectricCableTileEntity) te).checkConnections(w, x, y, z);
		}
	}

	@Override
	public boolean canPlaceBlockOnSide(World w, int x, int y, int z, int side) {

		// TODO:

		return canPlaceBlockAt(w, x, y, z);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new ElectricCableTileEntity();
	}

}
