package net.minetrek;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minetrek.blocks.MineTrekBlocks;
import net.minetrek.blocks.ores.MineTrekOres;
import net.minetrek.blocks.ores.OreGenerator;
import net.minetrek.items.MineTrekItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "MineTrek", name = "MineTrek", version = "0.0.1")
@NetworkMod(clientSideRequired = true)
public class MineTrek {

	@Instance(value = "MineTrek")
	public static MineTrek instance;

	@SidedProxy(clientSide = "net.minetrek.client.ClientProxy", serverSide = "net.minetrek.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs creativeTab;
	public static OreGenerator oreGenerator;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		oreGenerator = new OreGenerator();
		GameRegistry.registerWorldGenerator(oreGenerator);
		
		System.out.println("Initializing MineTrek...");
		creativeTab = new CreativeTabs("MineTrek");
		// LanguageRegistry.addName(creativeTab, "MineTrek");

		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		//Initialize all blocks and items
		int currID = MineTrekOres.initialize(1701, config, creativeTab, oreGenerator);
		currID = MineTrekBlocks.initialize(currID, config, creativeTab);
		MineTrekItems.initialize(20000, config, creativeTab);
		
		config.save();
		System.out.println("Finished Initializing MineTrek");
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}

}
