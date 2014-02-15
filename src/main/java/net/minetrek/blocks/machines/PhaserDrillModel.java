package net.minetrek.blocks.machines;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PhaserDrillModel extends ModelBase {

	// fields
	ModelRenderer Stand;
	ModelRenderer Stand_Base;
	ModelRenderer Phaser_Housing;
	ModelRenderer Phaser_Emitter_p1;
	ModelRenderer Phaser_Emitter_p2_Top;
	ModelRenderer Phaser_Emitter_p2_Bottom;

	public PhaserDrillModel() {
		textureWidth = 64;
		textureHeight = 32;

		Stand = new ModelRenderer(this, 40, 1);
		Stand.addBox(0F, 0F, 0F, 2, 22, 2);
		Stand.setRotationPoint(-1F, -2F, -1F);
		Stand.setTextureSize(64, 32);
		Stand.mirror = true;
		setRotation(Stand, 0F, 0F, 0F);
		Stand_Base = new ModelRenderer(this, 0, 13);
		Stand_Base.addBox(0F, 0F, 0F, 16, 4, 16);
		Stand_Base.setRotationPoint(-8F, 20F, -8F);
		Stand_Base.setTextureSize(64, 32);
		Stand_Base.mirror = true;
		setRotation(Stand_Base, 0F, 0F, 0F);
		Phaser_Housing = new ModelRenderer(this, 16, 17);
		Phaser_Housing.addBox(0F, 0F, 0F, 8, 4, 7);
		Phaser_Housing.setRotationPoint(-4F, -6F, -3F);
		Phaser_Housing.setTextureSize(64, 32);
		Phaser_Housing.mirror = true;
		setRotation(Phaser_Housing, 0F, 0F, 0F);
		Phaser_Emitter_p1 = new ModelRenderer(this, 0, 4);
		Phaser_Emitter_p1.addBox(0F, 0F, 0F, 6, 3, 2);
		Phaser_Emitter_p1.setRotationPoint(-3F, -5F, -5F);
		Phaser_Emitter_p1.setTextureSize(64, 32);
		Phaser_Emitter_p1.mirror = true;
		setRotation(Phaser_Emitter_p1, 0F, 0F, 0F);
		Phaser_Emitter_p2_Top = new ModelRenderer(this, 0, 9);
		Phaser_Emitter_p2_Top.addBox(0F, 0F, 0F, 6, 1, 1);
		Phaser_Emitter_p2_Top.setRotationPoint(-3F, -5F, -6F);
		Phaser_Emitter_p2_Top.setTextureSize(64, 32);
		Phaser_Emitter_p2_Top.mirror = true;
		setRotation(Phaser_Emitter_p2_Top, 0F, 0F, 0F);
		Phaser_Emitter_p2_Bottom = new ModelRenderer(this, 0, 11);
		Phaser_Emitter_p2_Bottom.addBox(0F, 0F, 0F, 6, 1, 1);
		Phaser_Emitter_p2_Bottom.setRotationPoint(-3F, -3F, -6F);
		Phaser_Emitter_p2_Bottom.setTextureSize(64, 32);
		Phaser_Emitter_p2_Bottom.mirror = true;
		setRotation(Phaser_Emitter_p2_Bottom, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Stand.render(f5);
		Stand_Base.render(f5);
		Phaser_Housing.render(f5);
		Phaser_Emitter_p1.render(f5);
		Phaser_Emitter_p2_Top.render(f5);
		Phaser_Emitter_p2_Bottom.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}