package net.minetrek.blocks.power;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class ElectricCable extends BlockContainer {

	public ElectricCable() {
		super(Material.circuits);
		setStepSound(Block.soundTypeMetal);
		setBlockName("electricCable");
		setBlockTextureName("minetrek:electricCable");

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
	public void onBlockAdded(World w, int x, int y, int z) {
		super.onBlockAdded(w, x, y, z);
		TileEntity te = w.getTileEntity(x, y, z);

		if (te != null && te instanceof ElectricCableTileEntity) {
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
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new ElectricCableTileEntity();
	}

}
