package net.minetrek.items.ingots;

import net.minecraft.item.Item;

public class InvisibleIngot extends Item {

	public InvisibleIngot(int par1) {
		super(par1);
		setMaxStackSize(64);
		setUnlocalizedName("InvisibleIngot");
		setTextureName("minetrek:ingotInvisible");
	}

}
