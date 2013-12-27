package net.minetrek.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minetrek.items.ingots.BrassIngot;
import net.minetrek.items.ingots.BronzeIngot;
import net.minetrek.items.ingots.ChromiumIngot;
import net.minetrek.items.ingots.DilithiumIngot;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MineTrekItems {

	public static Item dilithium_ingot;
	public static Item bronze_ingot;
	public static Item brass_ingot;
	public static Item chromium_ingot;

	public static int initialize(int startID, Configuration conf, CreativeTabs tab) {
		dilithium_ingot = new DilithiumIngot(conf.getItem("DilithiumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(dilithium_ingot, "Dilithium Ingot");

		bronze_ingot = new BronzeIngot(conf.getItem("BronzeIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(bronze_ingot, "Bronze Ingot");

		brass_ingot = new BrassIngot(conf.getItem("BrassIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(brass_ingot, "Brass Ingot");

		chromium_ingot = new ChromiumIngot(conf.getItem("ChromiumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(chromium_ingot, "Chromium Ingot");

		return startID;

	}

}
