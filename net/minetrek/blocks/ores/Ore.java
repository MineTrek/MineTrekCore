package net.minetrek.blocks.ores;

import java.util.Random;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

/**
 * A class used to represent an ore, it is primarily for simplifying ore
 * constructors and add ore generation methods.
 * 
 * @author The Numenorean
 * 
 */
public abstract class Ore extends Block {

	/**
	 * Creates an Ore with several standard settings, such as Material(rock), StepSound(stone),
	 * unlocalizedName, textureName, and HarvestLevel(pickaxe). It also adds a
	 * Human readable name to the language registry.
	 * 
	 * All these settings can be overridden in the extending class.
	 * 
	 * @param id
	 *            ID to give the block
	 * @param name
	 *            Name of the ore (should have capitals and be in Human readable
	 *            format with no spaces [aka "Strontium", not "strontium"])
	 * @param harvestLevel
	 *            HarvestLevel for the block, 0 - 3 for wood - diamond pickaxes
	 */
	public Ore(int id, String name, int harvestLevel) {
		super(id, Material.rock);

		String shortname = name.replaceFirst(name.substring(0, 1), name
				.substring(0, 1).toLowerCase());

		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(shortname + "Ore");
		setTextureName("minetrek:ore" + name);
		LanguageRegistry.addName(this, name + " Ore");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", harvestLevel);
	}

	/**
	 * Gets the number of veins of ore there should be in a chunk.
	 * @param dimension The dimension of the world its in.
	 * @return The number of veins
	 */
	public abstract int getNumberPerChunk(int dimension);

	/**
	 * The max height at which to generate.
	 * @param dimension The dimension of the world its in.
	 * @return The max height at which to generate
	 */
	public abstract int getMaxGenHeight(int dimension);

	/**
	 * Gets the Minimum height at which to generate
	 * @param dimension The dimension of the world being generated.
	 * @return The Minimum height
	 */
	public int getMinGenHeight(int dimension) {
		return 0;
	}

	/**
	 * How many blocks per vein there should be(about)
	 * @param dimension The dimension of the world its in.
	 * @return How many blocks on aveage to generate
	 */
	public abstract int blocksPerVein(int dimension);

}
