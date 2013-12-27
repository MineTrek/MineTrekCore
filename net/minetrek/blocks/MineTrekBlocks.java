package net.minetrek.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;

public class MineTrekBlocks {

	public static Block transparent_aluminum;

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
	public static int initialize(int startID, Configuration conf,
			CreativeTabs ct) {
		transparent_aluminum = new TransparentAlmuninum(conf.getBlock(
				"TransparentAluminum", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(transparent_aluminum, "transparentAluminum");
		return startID;
	}

}
