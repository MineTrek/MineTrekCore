package net.minetrek.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minetrek.blocks.machines.LaserElectronManipulator;
import net.minetrek.blocks.machines.Refinery;
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
	public static int initialize(int startID, Configuration conf, CreativeTabs ct) {
		transparent_aluminum = new TransparentAlmuninum(conf.getBlock("TransparentAluminum", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(transparent_aluminum, "transparentAluminum");

		refinery = new Refinery(conf.getBlock("Refinery", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(refinery, "refinery");

		laser_electron_manipulator = new LaserElectronManipulator(conf.getBlock("LaserElectronManipulator", startID++).getInt())
				.setCreativeTab(ct);
		GameRegistry.registerBlock(laser_electron_manipulator, "laserElectronManipulator");

		return startID;
	}

}
