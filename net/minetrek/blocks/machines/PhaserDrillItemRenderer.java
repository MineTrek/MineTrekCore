package net.minetrek.blocks.machines;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class PhaserDrillItemRenderer implements IItemRenderer {

	private final PhaserDrillModel model;

	public PhaserDrillItemRenderer() {
		model = new PhaserDrillModel();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRenderer.instance.renderTileEntityAt(new PhaserDrillTileEntity(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}
