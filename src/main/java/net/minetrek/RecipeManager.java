package net.minetrek;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minetrek.blocks.MineTrekBlocks;
import net.minetrek.blocks.machines.LaserElectronManipulatorTileEntity;
import net.minetrek.blocks.ores.MineTrekOres;
import net.minetrek.items.MineTrekItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeManager {

	public RecipeManager() {
	}

	public static void addRecipes() {
		GameRegistry.addSmelting(MineTrekOres.bauxite_ore, new ItemStack(MineTrekItems.aluminum_ingot), 1.0F);
		GameRegistry.addSmelting(MineTrekOres.tin_ore, new ItemStack(MineTrekItems.tin_ingot), 1.0F);
		GameRegistry.addSmelting(MineTrekOres.copper_ore, new ItemStack(MineTrekItems.copper_ingot), 1.0F);
		GameRegistry.addSmelting(MineTrekOres.titanium_ore, new ItemStack(MineTrekItems.titanium_ingot), 1.0F);
		GameRegistry.addSmelting(MineTrekOres.tungsten_ore, new ItemStack(MineTrekItems.tungsten_ingot), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone), new ItemStack(MineTrekItems.rubble), new ItemStack(MineTrekItems.rubble));

		LaserElectronManipulatorTileEntity.addRecipe(new ItemStack(MineTrekItems.aluminum_ingot), new ItemStack(MineTrekBlocks.transparent_aluminum));

		// RadioisotopicGeneratorTileEntity.addRecipe(new
		// ItemStack(MineTrekOres.d), out);
	}

}
