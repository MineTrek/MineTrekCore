package net.minetrek.blocks.ores;

import net.minecraft.creativetab.CreativeTabs;
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
	public static void initialize(CreativeTabs ct, OreGenerator gen) {
		dilithium_ore = new DilithiumOre();
		registerOre(dilithium_ore, ct, gen);

		tritanium_ore = new TritaniumOre();
		registerOre(tritanium_ore, ct, gen);

		duranium_ore = new DuraniumOre();
		registerOre(duranium_ore, ct, gen);

		bauxite_ore = new BauxiteOre();
		registerOre(bauxite_ore, ct, gen);

		chromite_ore = new ChromiteOre();
		registerOre(chromite_ore, ct, gen);

		copper_ore = new CopperOre();
		registerOre(copper_ore, ct, gen);

		iridium_ore = new IridiumOre();
		registerOre(iridium_ore, ct, gen);

		platinum_ore = new PlatinumOre();
		registerOre(platinum_ore, ct, gen);

		plutonium_ore = new PlutoniumOre();
		registerOre(plutonium_ore, ct, gen);

		silicon_ore = new SiliconOre();
		registerOre(silicon_ore, ct, gen);

		tin_ore = new TinOre();
		registerOre(tin_ore, ct, gen);

		titanium_ore = new TitaniumOre();
		registerOre(titanium_ore, ct, gen);

		tungsten_ore = new TungstenOre();
		registerOre(tungsten_ore, ct, gen);

		uranium_ore = new UraniumOre();
		registerOre(uranium_ore, ct, gen);

		invisible_ore = new InvisibleOre();
		registerOre(invisible_ore, ct, gen);

		nitrium_ore = new NitriumOre();
		registerOre(nitrium_ore, ct, gen);
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
		GameRegistry.registerBlock(o, o.name);
		gen.addOre(o);

	}

}
