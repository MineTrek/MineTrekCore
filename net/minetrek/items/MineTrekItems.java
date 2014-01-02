package MineTrekCore.net.minetrek.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import MineTrekCore.net.minetrek.items.*;
import MineTrekCore.net.minetrek.items.ingots.*;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MineTrekItems {

	public static Item dilithium_ingot;
	public static Item bronze_ingot;
	public static Item brass_ingot;
	public static Item chromium_ingot;
	public static Item copper_ingot;
	public static Item duranium_ingot;
	public static Item invisible_ingot;
	public static Item iridium_ingot;
	public static Item platinum_ingot;
	public static Item plutonium_ingot;
	public static Item silicon_ingot;
	public static Item steel_ingot;
	public static Item tin_ingot;
	public static Item titanium_ingot;
	public static Item tritanium_ingot;
	public static Item tungsten_ingot;
	public static Item uranium_ingot;
	public static Item aluminum_ingot;
	public static Item latinum;

	public static int initialize(int startID, Configuration conf, CreativeTabs tab) {
		aluminum_ingot = new DilithiumIngot(conf.getItem("AluminumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(aluminum_ingot, "Aluminum Ingot");

		dilithium_ingot = new DilithiumIngot(conf.getItem("DilithiumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(dilithium_ingot, "Dilithium Ingot");
		
		latinum = new Latinum(conf.getItem("Latinum", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(latinum, "Latinum");

		bronze_ingot = new BronzeIngot(conf.getItem("BronzeIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(bronze_ingot, "Bronze Ingot");

		brass_ingot = new BrassIngot(conf.getItem("BrassIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(brass_ingot, "Brass Ingot");

		chromium_ingot = new ChromiumIngot(conf.getItem("ChromiumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(chromium_ingot, "Chromium Ingot");

		copper_ingot = new CopperIngot(conf.getItem("CopperIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(copper_ingot, "Copper Ingot");

		duranium_ingot = new DuraniumIngot(conf.getItem("DuraniumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(duranium_ingot, "Duranium Ingot");

		invisible_ingot = new InvisibleIngot(conf.getItem("InvisibleIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(invisible_ingot, "Invisible Ingot");

		iridium_ingot = new IridiumIngot(conf.getItem("IridiumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(iridium_ingot, "Iridium Ingot");

		platinum_ingot = new PlatinumIngot(conf.getItem("PlatinumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(platinum_ingot, "Platinum Ingot");

		plutonium_ingot = new PlutoniumIngot(conf.getItem("PlutoniumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(plutonium_ingot, "Plutonium Ingot");

		silicon_ingot = new SiliconIngot(conf.getItem("SiliconIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(silicon_ingot, "Silicon Ingot");

		steel_ingot = new SteelIngot(conf.getItem("SteelIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(steel_ingot, "Steel Ingot");

		tin_ingot = new TinIngot(conf.getItem("TinIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(tin_ingot, "Tin Ingot");

		titanium_ingot = new TitaniumIngot(conf.getItem("TitaniumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(titanium_ingot, "Titanium Ingot");

		tritanium_ingot = new TritaniumIngot(conf.getItem("TritaniumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(tritanium_ingot, "Tritanium Ingot");

		tungsten_ingot = new TungstenIngot(conf.getItem("TungstenIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(tungsten_ingot, "Tungsten Ingot");

		uranium_ingot = new UraniumIngot(conf.getItem("UraniumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(uranium_ingot, "Uranium Ingot");

		return startID;

	}

}
