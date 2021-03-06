package net.minetrek.blocks.machines.generators;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minetrek.MineTrek;
import net.minetrek.blocks.MineTrekBlocks;
import net.minetrek.client.gui.GuiHandler;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class RadioisotopicGenerator extends BlockContainer {

	public RadioisotopicGenerator() {
		super(Material.iron);
		setStepSound(Block.soundTypeMetal);
		setBlockName("radioisotopicGenerator");
		setBlockTextureName("minetrek:radioisotopicGeneratorOff");

		setBlockBounds(0F, 0F, 0F, 1.0F, 2.0F, 1.0F);

		GameRegistry.registerTileEntity(RadioisotopicGeneratorTileEntity.class, "radioisotopticGeneratorTileEntity");
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
		if (w.isRemote)
			return;
		w.setBlock(x, y + 1, z, MineTrekBlocks.radioisotopic_generator_helper);
		int dir = MathHelper.floor_double((player.rotationYaw * 4F) / 360F + 0.5D) & 3;
		w.setBlockMetadataWithNotify(x, y, z, dir, 0);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, MineTrek.instance, GuiHandler.RADIOISOTOPIC_GENERATOR_GUI, world, x, y, z);
			RadioisotopicGeneratorTileEntity te = ((RadioisotopicGeneratorTileEntity) world.getTileEntity(x, y, z));

			te.setStatus(!te.isOn());
			world.markBlockForUpdate(x, y, z);
		}

		return true;

	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new RadioisotopicGeneratorTileEntity();
	}

	@Override
	public void onBlockDestroyedByPlayer(World w, int x, int y, int z, int meta) {
		if (w.isRemote)
			return;
		w.setBlock(x, y + 1, z, Blocks.air);
	}
}