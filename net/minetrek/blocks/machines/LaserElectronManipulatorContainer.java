package net.minetrek.blocks.machines;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class LaserElectronManipulatorContainer extends Container {

	private final LaserElectronManipulatorTileEntity entity;

	public LaserElectronManipulatorContainer(InventoryPlayer invPlayer, LaserElectronManipulatorTileEntity entity) {

		this.entity = entity;

	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return entity.isUseableByPlayer(entityplayer);
	}

}
