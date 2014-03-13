package net.minetrek.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minetrek.MineTrek;
import net.minetrek.items.tools.Phaser;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Contains and initializes all MineTrek Items
 * 
 * @author The Numenorean
 * 
 */
public class MineTrekItems {

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
	public static Item rubble;
	public static Item dilithium_crystal;
	public static Item phaser;
	public static Item smallAntimatterStorage;
	public static Item latinum;
	public static Item aluminum_dust;
	public static Item bronze_dust;
	public static Item brass_dust;
	public static Item chromium_dust;
	public static Item copper_dust;
	public static Item duranium_dust;
	public static Item invisible_dust;
	public static Item iridium_dust;
	public static Item platinum_dust;
	public static Item tin_dust;
	public static Item titanium_dust;
	public static Item tritanium_dust;
	public static Item tungsten_dust;

	public static void initialize(CreativeTabs tab) {

		// Ingots
		aluminum_ingot = registerIngot("aluminumIngot");
		bronze_ingot = registerIngot("bronzeIngot");
		brass_ingot = registerIngot("brassIngot");
		chromium_ingot = registerIngot("chromiumIngot");
		copper_ingot = registerIngot("copperIngot");
		duranium_ingot = registerIngot("duraniumIngot");
		invisible_ingot = registerIngot("invisibleIngot");
		iridium_ingot = registerIngot("iridiumIngot");
		platinum_ingot = registerIngot("platinumIngot");
		plutonium_ingot = registerIngot("plutoniumIngot");
		silicon_ingot = registerIngot("siliconIngot");
		steel_ingot = registerIngot("steelIngot");
		tin_ingot = registerIngot("tinIngot");
		titanium_ingot = registerIngot("titaniumIngot");
		tritanium_ingot = registerIngot("tritaniumIngot");
		tungsten_ingot = registerIngot("tungstenIngot");
		uranium_ingot = registerIngot("uraniumIngot");

		// Dust
		aluminum_dust = registerDust("aluminumDust");
		bronze_dust = registerDust("bronzeDust");
		brass_dust = registerDust("brassDust");
		chromium_dust = registerDust("chromiumDust");
		copper_dust = registerDust("copperDust");
		duranium_dust = registerDust("duraniumDust");
		invisible_dust = registerDust("invisibleDust");
		iridium_dust = registerDust("iridiumDust");
		platinum_dust = registerDust("platinumDust");
		tin_dust = registerDust("tinDust");
		titanium_dust = registerDust("titaniumDust");
		tritanium_dust = registerDust("tritaniumDust");
		tungsten_dust = registerDust("tungstenDust");

		// Tools
		phaser = new Phaser().setCreativeTab(tab);
		GameRegistry.registerItem(phaser, "phaser");

		// Others
		rubble = new Rubble().setCreativeTab(tab);
		GameRegistry.registerItem(rubble, "rubble");

		dilithium_crystal = new DilithiumCrystal().setCreativeTab(tab);
		GameRegistry.registerItem(dilithium_crystal, "dilithiumCrystal");

		smallAntimatterStorage = new SmallAntimatterStorage().setCreativeTab(tab);
		GameRegistry.registerItem(smallAntimatterStorage, "smallAntimatterStorage");

		latinum = new Latinum().setCreativeTab(tab);
		GameRegistry.registerItem(latinum, "latinum");

	}

	private static Item registerIngot(String name) {
		Item ingot = new Item().setCreativeTab(MineTrek.creativeTab).setUnlocalizedName(name).setTextureName(MineTrek.MODID + ":" + name);
		GameRegistry.registerItem(ingot, name);
		return ingot;
	}

	private static Item registerDust(String name) {
		Item dust = new Item().setCreativeTab(MineTrek.creativeTab).setUnlocalizedName(name).setTextureName(MineTrek.MODID + ":" + name);
		GameRegistry.registerItem(dust, name);
		return dust;
	}

}
