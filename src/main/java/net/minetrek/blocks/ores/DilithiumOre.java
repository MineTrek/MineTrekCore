package net.minetrek.blocks.ores;

import java.util.Random;

import net.minecraft.item.Item;
import net.minetrek.items.MineTrekItems;

public class DilithiumOre extends Ore {

	public DilithiumOre() {
		super("dilithium", 3);

		setHardness(5.0F);
		setLightLevel(.4F);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 1;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 10;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 2;
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int idk) {
		return MineTrekItems.dilithium_crystal;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random rand) {
		return 1 + fortune;
	}

}
