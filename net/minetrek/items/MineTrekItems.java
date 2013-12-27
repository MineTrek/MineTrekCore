package net.minetrek.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minetrek.items.ingots.DilithiumIngot;

public class MineTrekItems {
	
	public static Item dilithium_ingot;
	
	public static int initialize(int startID, Configuration conf, CreativeTabs tab){
		dilithium_ingot = new DilithiumIngot(conf.getBlock("TransparentAluminum", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(dilithium_ingot, "Dilithium Ingot");
		
		return startID;
		
	}

}
