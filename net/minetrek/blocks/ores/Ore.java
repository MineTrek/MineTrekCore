package net.minetrek.blocks.ores;

import java.util.Random;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public abstract class Ore extends Block {

	public Ore(int id, String name, int harvestLevel) {
		super(id, Material.rock);

		String shortname = name.replaceFirst(name.substring(0, 1), name
				.substring(0, 1).toLowerCase());

		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(shortname + "Ore");
		setLightValue(0.0f);
		setTextureName("minetrek:ore" + name);
		LanguageRegistry.addName(this, name + " Ore");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", harvestLevel);
	}

	public abstract int getNumberPerChunk(int dimension);

	public abstract int getMaxGenHeight(int dimension);

	public int getMinGenHeight(int dimension) {
		return 0;
	}

	public abstract int blocksPerVein(int dimension);

}
