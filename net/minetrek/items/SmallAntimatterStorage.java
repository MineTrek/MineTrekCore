package net.minetrek.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SmallAntimatterStorage extends Item {

	public SmallAntimatterStorage(int par1) {
		super(par1);
		setMaxStackSize(64);
		setUnlocalizedName("smallAntimatterStorage");
		setTextureName("minetrek:dilithiumCrystal");
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	@Override
	public String getItemStackDisplayName(ItemStack is) {
		switch (is.getItemDamage()) {
		case 1:
			return "Full Small Antimatter Storage";
		default:
			return "Small Antimatter Storage";
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tabs, List list) {
		for (int i = 0; i < 2; ++i) {
			list.add(new ItemStack(this, 1, i));
		}
	}

}
