package net.minetrek.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPhaserBolt extends EntityThrowable {

	private int ticksInAir;

	public EntityPhaserBolt(World par1World) {
		super(par1World);

		init();
	}

	public EntityPhaserBolt(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
		init();
	}

	public EntityPhaserBolt(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
		init();
	}

	private void init() {

		setVelocity(this.motionX *= 2, this.motionY *= 2, this.motionZ *= 2);

	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if (mop.entityHit != null)
			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 5);
		else {
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

		double lastX = this.posX;
		double lastY = this.posY;
		double lastZ = this.posZ;

		double x = motionX, y = motionY, z = motionZ;

		super.onUpdate();

		setVelocity(z, y, z);

		this.posX = lastX + x;
		this.posY = lastY + y;
		this.posZ = lastZ + z;

		this.setPosition(this.posX, this.posY, this.posZ);

		if (this.ticksExisted > 200) {
			this.setDead();
		}
	}
}
