package net.minetrek;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minetrek.items.MineTrekItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MineTrekCreativeTab extends CreativeTabs {

	public MineTrekCreativeTab(String label) {
		super(label);
	}

	public MineTrekCreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return MineTrekItems.phaser;
	}

}
