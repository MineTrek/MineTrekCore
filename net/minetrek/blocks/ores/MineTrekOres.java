package net.minetrek.blocks.ores;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.registry.GameRegistry;

public class MineTrekOres {

	public static Ore dilithium_ore;
	public static Ore duranium_ore;
	public static Ore tritanium_ore;
	public static Ore bauxite_ore;
	public static Ore chromite_ore;
	public static Ore copper_ore;
	public static Ore iridium_ore;
	public static Ore platinum_ore;
	public static Ore plutonium_ore;
	public static Ore silicon_ore;
	public static Ore tin_ore;
	public static Ore titanium_ore;
	public static Ore tungsten_ore;
	public static Ore uranium_ore;
	public static Ore invisible_ore;
	public static Ore nitrium_ore;

	/**
	 * Initializes ore blocks
	 * 
	 * @param startID
	 *            First ID to use as a default id for blocks
	 * @param conf
	 *            Configuration to pull block data from
	 * @param ct
	 *            Creative tab to add blocks to (Should probably not be used
	 *            this way)
	 * @return The last id that wasn't used
	 */
	public static int initialize(int startID, Configuration conf, CreativeTabs ct, OreGenerator gen) {
		dilithium_ore = new DilithiumOre(conf.getBlock("DilithiumOre", startID++).getInt());
		registerOre(dilithium_ore, ct, gen);

		tritanium_ore = new TritaniumOre(conf.getBlock("TritaniumOre", startID++).getInt());
		registerOre(tritanium_ore, ct, gen);

		duranium_ore = new DuraniumOre(conf.getBlock("DuraniumOre", startID++).getInt());
		registerOre(duranium_ore, ct, gen);

		bauxite_ore = new BauxiteOre(conf.getBlock("BauxiteOre", startID++).getInt());
		registerOre(bauxite_ore, ct, gen);

		chromite_ore = new ChromiteOre(conf.getBlock("ChromiteOre", startID++).getInt());
		registerOre(chromite_ore, ct, gen);

		copper_ore = new CopperOre(conf.getBlock("CopperOre", startID++).getInt());
		registerOre(copper_ore, ct, gen);

		iridium_ore = new IridiumOre(conf.getBlock("IridiumOre", startID++).getInt());
		registerOre(iridium_ore, ct, gen);

		platinum_ore = new PlatinumOre(conf.getBlock("PlatinumOre", startID++).getInt());
		registerOre(platinum_ore, ct, gen);

		plutonium_ore = new PlutoniumOre(conf.getBlock("PlutoniumOre", startID++).getInt());
		registerOre(plutonium_ore, ct, gen);

		silicon_ore = new SiliconOre(conf.getBlock("SiliconOre", startID++).getInt());
		registerOre(silicon_ore, ct, gen);

		tin_ore = new TinOre(conf.getBlock("TinOre", startID++).getInt());
		registerOre(tin_ore, ct, gen);

		titanium_ore = new TitaniumOre(conf.getBlock("TitaniumOre", startID++).getInt());
		registerOre(titanium_ore, ct, gen);

		tungsten_ore = new TungstenOre(conf.getBlock("TungstenOre", startID++).getInt());
		registerOre(tungsten_ore, ct, gen);

		uranium_ore = new UraniumOre(conf.getBlock("UraniumOre", startID++).getInt());
		registerOre(uranium_ore, ct, gen);

		invisible_ore = new InvisibleOre(conf.getBlock("InvisibleOre", startID++).getInt());
		registerOre(invisible_ore, ct, gen);

		nitrium_ore = new NitriumOre(conf.getBlock("NitriumOre", startID++).getInt());
		registerOre(nitrium_ore, ct, gen);

		return startID;
	}

	/**
	 * Does some standard ore registration. Sets the creative tab, adds it to
	 * the OreGenerator, registers it to the GameRegistry. Mostly a helper
	 * method.
	 * 
	 * @param o
	 *            Ore to do operations on
	 * @param ct
	 *            CreativeTabs to add the ore to.
	 * @param gen
	 *            OreGenerator to add the ore to.
	 */
	private static void registerOre(Ore o, CreativeTabs ct, OreGenerator gen) {
		o.setCreativeTab(ct);
		GameRegistry.registerBlock(o, o.getUnlocalizedName());
		gen.addOre(o);

	}

}
