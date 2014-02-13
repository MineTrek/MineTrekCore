package net.minetrek.entities.projectiles;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPhaserBolt extends EntityThrowable {

	public Entity throwe;

	public EntityPhaserBolt(World world) {
		super(world);

		init();
		System.out.println("Called1");

	}

	public EntityPhaserBolt(World par1World, EntityLivingBase entity) {
		super(par1World, entity);
		throwe = entity;
		init();
		System.out.println("Called2");
	}

	public EntityPhaserBolt(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
		System.out.println("Called3");
		init();
	}

	private void init() {

		setVelocity(this.motionX * 3, this.motionY * 3, this.motionZ * 3);
		this.throwableShake = 0;
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if (mop.entityHit != null)
			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 10);
		else {
			float hd = Blocks.blocksList[worldObj.getBlockId(mop.blockX, mop.blockY, mop.blockZ)].getBlockHardness(worldObj, mop.blockX,
					mop.blockY, mop.blockZ);
			if (hd < 4.0F && hd > -1)
				worldObj.destroyBlock(mop.blockX, mop.blockY, mop.blockZ, true);
		}
		this.setDead();
	}

	@Override
	protected float getGravityVelocity() {
		return 0.0f;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if (super.ticksExisted > 30)
			this.setDead();
	}

	@Override
	public void setLocationAndAngles(double d1, double d2, double d3, float f1, float f2) {
		super.setPositionAndRotation(d1, d2, d3, f1, f2);
		System.out.println("Called");
		float closest = 5.0F;
		Entity thisOne = null;
		for (int i = 0; i < worldObj.loadedEntityList.size(); i++) {
			if (((Entity) worldObj.loadedEntityList.get(i)).getDistanceToEntity(this) < closest) {
				closest = ((Entity) worldObj.loadedEntityList.get(i)).getDistanceToEntity(this);
				thisOne = ((Entity) worldObj.loadedEntityList.get(i));
			}
		}

		if (thisOne != null) {
			throwe = thisOne;
		}
	}

}
