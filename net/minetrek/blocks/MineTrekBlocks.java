package net.minetrek.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;

public class MineTrekBlocks {
	
	public static Block transparent_aluminum;
	
	public static int initialize(int startID, Configuration conf, CreativeTabs ct){
		transparent_aluminum = new TransparentAlmuninum(conf.getBlock("TransparentAluminum", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(transparent_aluminum, "transparentAluminum");
		return startID;
	}

}
