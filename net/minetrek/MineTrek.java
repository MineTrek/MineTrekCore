package net.minetrek;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
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
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
		System.out.println("Initializing MineTrek...");

		new GuiHandler();

		MinecraftForge.EVENT_BUS.register(new SoundLoader());
		instance = this;

		oreGenerator = new OreGenerator();
		GameRegistry.registerWorldGenerator(oreGenerator);

		creativeTab = new MineTrekCreativeTab("MineTrek");
		LanguageRegistry.instance().addStringLocalization("itemGroup.MineTrek", "MineTrek");

		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		// Initialize all blocks and items
		int currID = MineTrekOres.initialize(1701, config, creativeTab, oreGenerator);
		currID = MineTrekBlocks.initialize(currID, config, creativeTab);
		MineTrekItems.initialize(20000, config, creativeTab);

		EntityRegistry
				.registerModEntity(EntityPhaserBolt.class, "PhaserBolt", EntityRegistry.findGlobalUniqueEntityId(), this, 64, 1, true);

		config.save();
		System.out.println("Finished Initializing MineTrek");
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		GameRegistry.addSmelting(MineTrekOres.bauxite_ore.blockID, new ItemStack(MineTrekItems.aluminum_ingot), 1.0F);
		GameRegistry.addSmelting(MineTrekOres.tin_ore.blockID, new ItemStack(MineTrekItems.tin_ingot), 1.0F);
		GameRegistry.addSmelting(MineTrekOres.copper_ore.blockID, new ItemStack(MineTrekItems.copper_ingot), 1.0F);
		GameRegistry.addSmelting(MineTrekOres.titanium_ore.blockID, new ItemStack(MineTrekItems.titanium_ingot), 1.0F);
		GameRegistry.addSmelting(MineTrekOres.tungsten_ore.blockID, new ItemStack(MineTrekItems.tungsten_ingot), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone), new ItemStack(MineTrekItems.rubble), new ItemStack(
				MineTrekItems.rubble));
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}

}
