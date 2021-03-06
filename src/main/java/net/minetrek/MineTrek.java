package net.minetrek;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import net.minetrek.blocks.MineTrekBlocks;
import net.minetrek.blocks.ores.MineTrekOres;
import net.minetrek.blocks.ores.OreGenerator;
import net.minetrek.client.gui.GuiHandler;
import net.minetrek.entities.projectiles.EntityPhaserBolt;
import net.minetrek.items.MineTrekItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = MineTrek.MODID, version = MineTrek.VERSION)
public class MineTrek {

	public static final String MODID = "minetrek";
	public static final String VERSION = "0.0.1";

	@Instance(value = "MineTrek")
	public static MineTrek instance;

	@SidedProxy(clientSide = "net.minetrek.client.ClientProxy", serverSide = "net.minetrek.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs creativeTab;
	public static OreGenerator oreGenerator;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("Initializing MineTrek...");
		instance = this;

		new GuiHandler();

		oreGenerator = new OreGenerator();
		GameRegistry.registerWorldGenerator(oreGenerator, 2);

		creativeTab = new MineTrekCreativeTab("MineTrek");

		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		config.save();

		// Initialize all blocks and items
		MineTrekOres.initialize(creativeTab, oreGenerator);
		MineTrekBlocks.initialize(creativeTab);
		MineTrekItems.initialize(creativeTab);

		EntityRegistry.registerModEntity(EntityPhaserBolt.class, "PhaserBolt", EntityRegistry.findGlobalUniqueEntityId(), this, 64, 1, true);

		RecipeManager.addRecipes();
		proxy.registerRenderers();

		System.out.println("Finished Initializing MineTrek");
	}

}
