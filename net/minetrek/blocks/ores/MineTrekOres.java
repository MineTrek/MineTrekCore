package net.minetrek.blocks.ores;


import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.registry.GameRegistry;

public class MineTrekOres {
	
	public static Block dilithium_ore;
	private static Block duranium_ore;
	private static Block tritanium_ore;
	private static Ore bauxite_ore;
	private static Ore chromite_ore;
	private static Block copper_ore;
	private static Block iridium_ore;
	private static Block platinum_ore;
	private static Block plutonium_ore;
	private static Block silicon_ore;
	private static Block tin_ore;
	private static Block titanium_ore;
	private static Block tungsten_ore;
	private static Block uranium_ore;
	
	public static int initialize(int startID, Configuration conf, CreativeTabs ct, OreGenerator gen){
		dilithium_ore = new DilithiumOre(conf.getBlock("DilithiumOre", startID).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(dilithium_ore, "dilithiumOre");
		
		
		tritanium_ore = new TritaniumOre(conf.getBlock("TritaniumOre", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(tritanium_ore, "tritaniumOre");
		
		duranium_ore = new DuraniumOre(conf.getBlock("DuraniumOre", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(duranium_ore, "duraniumOre");
		
		bauxite_ore = new BauxiteOre(conf.getBlock("BauxiteOre", startID++).getInt());
		registerOre(bauxite_ore, ct, gen);
		
		chromite_ore = new ChromiteOre(conf.getBlock("ChromiteOre", startID++).getInt());
		registerOre(chromite_ore, ct, gen);
		
		copper_ore = new CopperOre(conf.getBlock("CopperOre", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(copper_ore, "copperOre");
		
		iridium_ore = new IridiumOre(conf.getBlock("IridiumOre", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(iridium_ore, "iridiumOre");
		
		platinum_ore = new PlatinumOre(conf.getBlock("PlatinumOre", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(platinum_ore, "platinumOre");
		
		plutonium_ore = new PlutoniumOre(conf.getBlock("PlutoniumOre", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(plutonium_ore, "plutoniumOre");
		
		silicon_ore = new SiliconOre(conf.getBlock("SiliconOre", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(silicon_ore, "siliconOre");
		
		tin_ore = new TinOre(conf.getBlock("TinOre", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(tin_ore, "tinOre");
		
		titanium_ore = new TitaniumOre(conf.getBlock("TitaniumOre", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(titanium_ore, "titaniumOre");
		
		tungsten_ore = new TungstenOre(conf.getBlock("TungstenOre", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(tungsten_ore, "tungstenOre");
		
		uranium_ore = new UraniumOre(conf.getBlock("UraniumOre", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(uranium_ore, "uraniumOre");
		
		return startID;
	}

	private static void registerOre(Ore o, CreativeTabs ct, OreGenerator gen) {
		o.setCreativeTab(ct);
		GameRegistry.registerBlock(o, o.getUnlocalizedName());
		gen.addOre(o);
		
	}

}
