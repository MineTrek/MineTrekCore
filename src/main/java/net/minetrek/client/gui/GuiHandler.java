package net.minetrek.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minetrek.MineTrek;
import net.minetrek.blocks.machines.LaserElectronManipulatorContainer;
import net.minetrek.blocks.machines.LaserElectronManipulatorGui;
import net.minetrek.blocks.machines.LaserElectronManipulatorTileEntity;
import net.minetrek.blocks.machines.generators.RadioisotopicGeneratorContainer;
import net.minetrek.blocks.machines.generators.RadioisotopicGeneratorGui;
import net.minetrek.blocks.machines.generators.RadioisotopicGeneratorTileEntity;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {

	public static final int LASER_ELECTRON_MANIPULATOR_GUI = 0;
	public static final int RADIOISOTOPIC_GENERATOR_GUI = 1;
	public static final int REPLICATOR_GUI = 2;
	public static final int DOLAMIDE_REACTOR_GUI = 3;

	public GuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(MineTrek.instance, this);
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		switch (id) {
		case LASER_ELECTRON_MANIPULATOR_GUI:
			if (entity != null && entity instanceof LaserElectronManipulatorTileEntity)
				return new LaserElectronManipulatorContainer(player.inventory, (LaserElectronManipulatorTileEntity) entity);
			break;
		case RADIOISOTOPIC_GENERATOR_GUI:
			if (entity != null && entity instanceof RadioisotopicGeneratorTileEntity)
				return new RadioisotopicGeneratorContainer(player.inventory, (RadioisotopicGeneratorTileEntity) entity);
			break;
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		switch (id) {
		case LASER_ELECTRON_MANIPULATOR_GUI:
			if (entity != null && entity instanceof LaserElectronManipulatorTileEntity)
				return new LaserElectronManipulatorGui(player.inventory, (LaserElectronManipulatorTileEntity) entity);
			break;
		case RADIOISOTOPIC_GENERATOR_GUI:
			if (entity != null && entity instanceof RadioisotopicGeneratorTileEntity)
				return new RadioisotopicGeneratorGui(player.inventory, (RadioisotopicGeneratorTileEntity) entity);
			break;
		}

		return null;
	}

}
