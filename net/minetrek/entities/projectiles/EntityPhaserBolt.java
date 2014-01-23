package net.minetrek.entities.projectiles;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPhaserBolt extends EntityThrowable {

	public EntityLivingBase throwe;

	public EntityPhaserBolt(World par1World) {
		super(par1World);

		init();
	}

	public EntityPhaserBolt(World par1World, EntityLivingBase entity) {
		super(par1World, entity);
		throwe = entity;
		init();
	}

	public EntityPhaserBolt(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
		init();
	}

	private void init() {

		System.out.println("Called");
		setVelocity(this.motionX * 3, this.motionY * 3, this.motionZ * 3);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if (mop.entityHit != null)
			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 10);
		else {
			float hd = Block.blocksList[worldObj.getBlockId(mop.blockX, mop.blockY, mop.blockZ)].getBlockHardness(worldObj, mop.blockX,
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
}
