package net.minetrek.blocks.power;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.util.ForgeDirection;

public class ElectricCableModel extends ModelBase {

	// fields
	ModelRenderer WireCenter;
	ModelRenderer Front;
	ModelRenderer Back;
	ModelRenderer Down;
	ModelRenderer Top;
	ModelRenderer Left;
	ModelRenderer Right;

	public ElectricCableModel() {
		textureWidth = 64;
		textureHeight = 32;

		WireCenter = new ModelRenderer(this, 0, 0);
		WireCenter.addBox(0F, 0F, 0F, 6, 6, 6);
		WireCenter.setRotationPoint(-3F, 13F, -3F);
		WireCenter.setTextureSize(64, 32);
		WireCenter.mirror = true;
		setRotation(WireCenter, 0F, 0F, 0F);
		WireCenter.mirror = false;
		Front = new ModelRenderer(this, 0, 0);
		Front.addBox(0F, 0F, 0F, 6, 6, 6);
		Front.setRotationPoint(-3F, 13F, -8F);
		Front.setTextureSize(64, 32);
		Front.mirror = true;
		setRotation(Front, 0F, 0F, 0F);
		Back = new ModelRenderer(this, 0, 0);
		Back.addBox(0F, 0F, 0F, 6, 6, 6);
		Back.setRotationPoint(-3F, 13F, 3F);
		Back.setTextureSize(64, 32);
		Back.mirror = true;
		setRotation(Back, 0F, 0F, 0F);
		Down = new ModelRenderer(this, 0, 0);
		Down.addBox(0F, 0F, 0F, 6, 5, 6);
		Down.setRotationPoint(-3F, 19F, -3F);
		Down.setTextureSize(64, 32);
		Down.mirror = true;
		setRotation(Down, 0F, 0F, 0F);
		Top = new ModelRenderer(this, 0, 0);
		Top.addBox(0F, 0F, 0F, 6, 6, 6);
		Top.setRotationPoint(-3F, 8F, -3F);
		Top.setTextureSize(64, 32);
		Top.mirror = true;
		setRotation(Top, 0F, 0F, 0F);
		Left = new ModelRenderer(this, 0, 0);
		Left.addBox(0F, 0F, 0F, 6, 6, 6);
		Left.setRotationPoint(3F, 13F, -3F);
		Left.setTextureSize(64, 32);
		Left.mirror = true;
		setRotation(Left, 0F, 0F, 0F);
		Right = new ModelRenderer(this, 0, 0);
		Right.addBox(0F, 0F, 0F, 6, 6, 6);
		Right.setRotationPoint(-8F, 13F, -3F);
		Right.setTextureSize(64, 32);
		Right.mirror = true;
		setRotation(Right, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		WireCenter.render(f5);
		Front.render(f5);
		Back.render(f5);
		Down.render(f5);
		Top.render(f5);
		Left.render(f5);
		Right.render(f5);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, ArrayList<ForgeDirection> dirs) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		WireCenter.render(f5);

		for (ForgeDirection fd : dirs) {
			switch (fd) {
			case UP:
				Top.render(f5);
				break;
			case DOWN:
				Down.render(f5);
				break;
			case EAST:
				Right.render(f5);
				break;
			case WEST:
				Left.render(f5);
				break;
			case SOUTH:
				Back.render(f5);
				break;
			case NORTH:
				Front.render(f5);
				break;
			default:
				break;
			}
		}
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