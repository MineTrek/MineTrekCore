package net.minetrek.items.ingots;

import net.minecraft.item.Item;

public class SteelIngot extends Item {

	public SteelIngot(int par1) {
		super(par1);
		setMaxStackSize(64);
		setUnlocalizedName("steelIngot");
		setTextureName("minetrek:ingotSteel");
	}

}
