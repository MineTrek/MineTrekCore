package net.minetrek.blocks.machines.generators;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minetrek.MineTrek;
import net.minetrek.client.gui.GuiHandler;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class DolamideReactor extends BlockContainer {

	public DolamideReactor() {
		super(Material.iron);
		setStepSound(Block.soundTypeMetal);
		setBlockName("dolamideReactor");
		setBlockTextureName("minetrek:dolamideReactor");

		GameRegistry.registerTileEntity(DolamideReactorTileEntity.class, "dolamideReactorTileEntity");
	}

	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase player, ItemStack is) {
		if (w.isRemote)
			return;
		int dir = MathHelper.floor_double((player.rotationYaw * 4F) / 360F + 0.5D) & 3;
		w.setBlockMetadataWithNotify(x, y, z, dir, 0);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, MineTrek.instance, GuiHandler.DOLAMIDE_REACTOR_GUI, world, x, y, z);
		}

		return true;

	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new DolamideReactorTileEntity();
	}
}