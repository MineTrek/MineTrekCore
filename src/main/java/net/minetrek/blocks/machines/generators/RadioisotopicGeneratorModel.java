package net.minetrek.blocks.machines.generators;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class RadioisotopicGeneratorModel extends ModelBase {
	// fields
	ModelRenderer Core;
	ModelRenderer Lip_R;
	ModelRenderer Lip_L;
	ModelRenderer Lip_F;
	ModelRenderer Lip_B;

	public RadioisotopicGeneratorModel() {
		textureWidth = 64;
		textureHeight = 64;

		Core = new ModelRenderer(this, 0, 0);
		Core.addBox(0F, 0F, 0F, 8, 32, 8);
		Core.setRotationPoint(-4F, -8F, -4F);
		Core.setTextureSize(64, 32);
		Core.mirror = true;
		setRotation(Core, 0F, 0F, 0F);
		Lip_R = new ModelRenderer(this, 53, 10);
		Lip_R.addBox(0F, 0F, 0F, 1, 32, 4);
		Lip_R.setRotationPoint(-5F, -8F, -2F);
		Lip_R.setTextureSize(64, 32);
		Lip_R.mirror = true;
		setRotation(Lip_R, 0F, 0F, 0F);
		Lip_L = new ModelRenderer(this, 53, 10);
		Lip_L.addBox(0F, 0F, 0F, 1, 32, 4);
		Lip_L.setRotationPoint(4F, -8F, -2F);
		Lip_L.setTextureSize(64, 32);
		Lip_L.mirror = true;
		setRotation(Lip_L, 0F, 0F, 0F);
		Lip_F = new ModelRenderer(this, 53, 13);
		Lip_F.addBox(0F, 0F, 0F, 4, 32, 1);
		Lip_F.setRotationPoint(-2F, -8F, -5F);
		Lip_F.setTextureSize(64, 32);
		Lip_F.mirror = true;
		setRotation(Lip_F, 0F, 0F, 0F);
		Lip_B = new ModelRenderer(this, 53, 13);
		Lip_B.addBox(0F, 0F, 0F, 4, 32, 1);
		Lip_B.setRotationPoint(-2F, -8F, 4F);
		Lip_B.setTextureSize(64, 32);
		Lip_B.mirror = true;
		setRotation(Lip_B, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Core.render(f5);
		Lip_R.render(f5);
		Lip_L.render(f5);
		Lip_F.render(f5);
		Lip_B.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}

}