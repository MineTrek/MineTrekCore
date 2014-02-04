package net.minetrek.blocks.power;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minetrek.blocks.MineTrekBlocks;

import org.lwjgl.opengl.GL11;

public class ElectricCableTileEntityRenderer extends TileEntitySpecialRenderer {

	private final ElectricCableModel model;

	public ElectricCableTileEntityRenderer() {
		model = new ElectricCableModel();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double d, double d1, double d2, float f) {
		GL11.glPushMatrix();
		// This will move our renderer so that it will be on proper place in the
		// world
		GL11.glTranslatef((float) d, (float) d1, (float) d2);
		ElectricCableTileEntity tileEntityYour = (ElectricCableTileEntity) tileEntity;
		/*
		 * Note that true tile entity coordinates (tileEntity.xCoord, etc) do
		 * not match to render coordinates (d, etc) that are calculated as [true
		 * coordinates] - [player coordinates (camera coordinates)]
		 */
		renderBlock(tileEntityYour, tileEntity.worldObj, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord,
				MineTrekBlocks.electric_cable);
		GL11.glPopMatrix();

	}

	public void renderBlock(ElectricCableTileEntity tl, World world, int i, int j, int k, Block block) {

		if (world != null && world.blockExists(i, j, k)) {
			Tessellator tessellator = Tessellator.instance;
			// This will make your block brightness dependent from surroundings
			// lighting.
			float f = block.getBlockBrightness(world, i, j, k);
			int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
			int l1 = l % 65536;
			int l2 = l / 65536;
			tessellator.setColorOpaque_F(f, f, f);
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, l1, l2);

			for (int side = 0; i < 6; i++) {

				if (tl.isAttached(side)) {

					GL11.glPushMatrix();
					GL11.glTranslatef(0.5F, 0.18F, 0.5F);

					if (side == 1)
						GL11.glRotatef(-180F, 0F, 0F, 1F);

					if (side > 1 || side < 6) {
						GL11.glRotatef(-90F, 1.0F, 0F, 0F);
						GL11.glRotatef((side - 2) * -90F, 0F, 0F, 1F);
					}

					this.bindTexture(new ResourceLocation("minetrek", "textures/blocks/electricCable.png"));
					model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

					GL11.glPopMatrix();

				}

			}

		} else {
			GL11.glPushMatrix();
			GL11.glTranslatef(0.5F, 0.18F, 0.5F);

			GL11.glRotatef(-180F, 0F, 0F, 1F);

			this.bindTexture(new ResourceLocation("minetrek", "textures/blocks/electricCable.png"));
			model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

			GL11.glPopMatrix();
		}

	}

}
