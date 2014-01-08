package net.minetrek;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minetrek.blocks.ores.MineTrekOres;

public class MineTrekCreativeTab extends CreativeTabs {

	public MineTrekCreativeTab(String label) {
		super(label);
	}

	public MineTrekCreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(MineTrekOres.dilithium_ore);
	}

}
