package net.minetrek.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SmallAntimatterStorage extends Item {

	private IIcon empty;
	private IIcon full;

	public SmallAntimatterStorage() {
		super();
		setMaxStackSize(64);
		setUnlocalizedName("smallAntimatterStorage");
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	@Override
	public IIcon getIconFromDamage(int dam) {
		return dam == 1 ? full : empty;
	}

	@Override
	public void registerIcons(IIconRegister ir) {
		empty = ir.registerIcon("minetrek:smallAntimatterStorage_empty");
		full = ir.registerIcon("minetrek:smallAntimatterStorage_full");
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
	public void getSubItems(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < 2; ++i) {
			list.add(new ItemStack(this, 1, i));
		}
	}

}
