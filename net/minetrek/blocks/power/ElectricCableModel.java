package net.minetrek.blocks.power;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ElectricCableModel extends ModelBase {

	// fields
	ModelRenderer Main_connector;
	ModelRenderer Side1;
	ModelRenderer Side2;
	ModelRenderer Side3;
	ModelRenderer Side4;

	public ElectricCableModel() {
		textureWidth = 64;
		textureHeight = 32;

		Main_connector = new ModelRenderer(this, 0, 0);
		Main_connector.addBox(0F, 0F, 0F, 8, 3, 8);
		Main_connector.setRotationPoint(-4F, 0F, -4F);
		Main_connector.setTextureSize(64, 32);
		Main_connector.mirror = true;
		setRotation(Main_connector, 0F, 0F, 0F);
		Side2 = new ModelRenderer(this, 32, 0);
		Side2.addBox(0F, 0F, 0F, 4, 3, 8);
		Side2.setRotationPoint(-8F, 0F, -4F);
		Side2.setTextureSize(64, 32);
		Side2.mirror = true;
		setRotation(Side2, 0F, 0F, 0F);
		Side4 = new ModelRenderer(this, 32, 0);
		Side4.addBox(0F, 0F, 0F, 4, 3, 8);
		Side4.setRotationPoint(4F, 0F, -4F);
		Side4.setTextureSize(64, 32);
		Side4.mirror = true;
		setRotation(Side4, 0F, 0F, 0F);
		Side3 = new ModelRenderer(this, 0, 11);
		Side3.addBox(0F, 0F, 0F, 8, 3, 4);
		Side3.setRotationPoint(-4F, 0F, 4F);
		Side3.setTextureSize(64, 32);
		Side3.mirror = true;
		setRotation(Side3, 0F, 0F, 0F);
		Side1 = new ModelRenderer(this, 0, 11);
		Side1.addBox(0F, 0F, 0F, 8, 3, 4);
		Side1.setRotationPoint(-4F, 0F, -8F);
		Side1.setTextureSize(64, 32);
		Side1.mirror = true;
		setRotation(Side1, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Main_connector.render(f5);
		Side1.render(f5);
		Side2.render(f5);
		Side3.render(f5);
		Side4.render(f5);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean s1, boolean s2, boolean s3,
			boolean s4) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Main_connector.render(f5);
		if (s1)
			Side1.render(f5);
		if (s2)
			Side2.render(f5);
		if (s3)
			Side3.render(f5);
		if (s4)
			Side4.render(f5);
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