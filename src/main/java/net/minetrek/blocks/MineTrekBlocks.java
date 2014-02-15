package net.minetrek.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.Fluid;
import net.minetrek.blocks.machines.LaserElectronManipulator;
import net.minetrek.blocks.machines.PhaserDrill;
import net.minetrek.blocks.machines.RadioisotopicGenerator;
import net.minetrek.blocks.machines.Refinery;
import net.minetrek.blocks.machines.replicator.Replicator;
import net.minetrek.blocks.power.ElectricCable;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Container for all blocks except ores, and for initialization.
 * 
 * @author The Numenorean
 * 
 */
public class MineTrekBlocks {

	public static Block transparent_aluminum;
	public static Block refinery;
	public static Block laser_electron_manipulator;
	public static Fluid antimatter_fluid;
	public static Block antimatter_fluid_block;
	public static Block phaser_drill;
	public static Block electric_cable;
	public static Block radioisotopic_generator;
	public static Block replicator;
	private static Block dabo_wheel;

	/**
	 * Initializes non-ore blocks
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
	public static void initialize(CreativeTabs ct) {

		// Liquids
		antimatter_fluid = new AntimatterFluid();

		antimatter_fluid_block = new BlockAntimatter().setCreativeTab(ct);
		GameRegistry.registerBlock(antimatter_fluid_block, "antimatterFluidBlock");

		// Machines
		refinery = new Refinery().setCreativeTab(ct);
		GameRegistry.registerBlock(refinery, "refinery");

		laser_electron_manipulator = new LaserElectronManipulator().setCreativeTab(ct);
		GameRegistry.registerBlock(laser_electron_manipulator, "laserElectronManipulator");

		radioisotopic_generator = new RadioisotopicGenerator().setCreativeTab(ct);
		GameRegistry.registerBlock(radioisotopic_generator, "radioisotopicGenerator");

		phaser_drill = new PhaserDrill().setCreativeTab(ct);
		GameRegistry.registerBlock(phaser_drill, "phaserDrill");

		replicator = new Replicator().setCreativeTab(ct);
		GameRegistry.registerBlock(replicator, "replicator");

		// Others
		transparent_aluminum = new TransparentAluminum().setCreativeTab(ct);
		GameRegistry.registerBlock(transparent_aluminum, "transparentAluminum");

		electric_cable = new ElectricCable().setCreativeTab(ct);
		GameRegistry.registerBlock(electric_cable, "electricCable");

		dabo_wheel = new DaboWheel().setCreativeTab(ct);
		GameRegistry.registerBlock(dabo_wheel, "daboWheel");
	}

}
