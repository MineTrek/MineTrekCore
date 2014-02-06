package net.minetrek.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minetrek.MineTrek;
import net.minetrek.blocks.machines.LaserElectronManipulatorContainer;
import net.minetrek.blocks.machines.LaserElectronManipulatorGui;
import net.minetrek.blocks.machines.LaserElectronManipulatorTileEntity;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {

	public static final int LASER_ELECTRON_MANIPULATOR_GUI = 0;
	public static final int RADIOISOTROPIC_GENERATOR_GUI = 1;

	public GuiHandler() {
		NetworkRegistry.instance().registerGuiHandler(MineTrek.instance, this);
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		switch (id) {
		case LASER_ELECTRON_MANIPULATOR_GUI:
			if (entity != null && entity instanceof LaserElectronManipulatorTileEntity)
				return new LaserElectronManipulatorContainer(player.inventory, (LaserElectronManipulatorTileEntity) entity);
			break;
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		switch (id) {
		case LASER_ELECTRON_MANIPULATOR_GUI:
			if (entity != null && entity instanceof LaserElectronManipulatorTileEntity)
				return new LaserElectronManipulatorGui(player.inventory, (LaserElectronManipulatorTileEntity) entity);
			break;
		}

		return null;
	}

}
