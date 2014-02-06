package net.minetrek.blocks.machines;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RadioisotopicGeneratorItemRenderer implements IItemRenderer {

	private final RadioisotopicGeneratorModel model;

	public RadioisotopicGeneratorItemRenderer() {
		model = new RadioisotopicGeneratorModel();
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
		TileEntityRenderer.instance.renderTileEntityAt(new RadioisotopicGeneratorTileEntity(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}
