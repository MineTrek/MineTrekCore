package net.minetrek.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minetrek.CommonProxy;
import net.minetrek.blocks.MineTrekBlocks;
import net.minetrek.blocks.machines.LaserElectronManipulatorItemRenderer;
import net.minetrek.blocks.machines.LaserElectronManipulatorTileEntity;
import net.minetrek.blocks.machines.LaserElectronManipulatorTileEntityRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(LaserElectronManipulatorTileEntity.class,
				new LaserElectronManipulatorTileEntityRenderer());

		MinecraftForgeClient.registerItemRenderer(MineTrekBlocks.laser_electron_manipulator.blockID,
				new LaserElectronManipulatorItemRenderer());
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity != null) {
			switch (ID) {
			case 0:

			}
		}

		return null;
	}

}