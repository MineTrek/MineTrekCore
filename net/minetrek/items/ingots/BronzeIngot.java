package net.minetrek.items.ingots;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BronzeIngot extends Item {

	public BronzeIngot(int par1) {
		super(par1);
		setMaxStackSize(64);
		setUnlocalizedName("dilithiumIngot");
		setTextureName("minetrek:ingotDilithium");
	}

}
