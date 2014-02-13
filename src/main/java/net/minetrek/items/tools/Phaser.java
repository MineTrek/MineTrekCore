package net.minetrek.items.tools;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minetrek.entities.projectiles.EntityPhaserBolt;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Phaser extends Item {

	public Phaser(int par1) {
		super(par1);
		setMaxStackSize(1);
		setUnlocalizedName("phaser");
		setTextureName("minetrek:phaserDefault");
		setMaxDamage(100);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack onItemRightClick(ItemStack is, World par2World, EntityPlayer par3EntityPlayer) {

		if (par3EntityPlayer.capabilities.isCreativeMode || is.getItemDamage() < this.getMaxDamage()) {
			is.attemptDamageItem(2, new Random());
			par2World.playSoundAtEntity(par3EntityPlayer, "minetrek:phaser", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!par2World.isRemote) {
				par2World.spawnEntityInWorld(new EntityPhaserBolt(par2World, par3EntityPlayer));
			}
		}
		return is;
	}

}
