package net.minetrek.blocks.machines;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class LaserElectronManipulatorGui extends GuiContainer {

	public static final ResourceLocation texture = new ResourceLocation("minetrek", "textures/gui/LaserElectronManipulator.png");

	public LaserElectronManipulatorGui(Container par1Container) {
		super(par1Container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		// TODO Auto-generated method stub

	}

}
