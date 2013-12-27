package net.minetrek.blocks.ores;

public class DuraniumOre extends Ore {

	public DuraniumOre(int par1) {
		super(par1, "Duranium", 2);

		setHardness(3.0F);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 6;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 40;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 5;
	}

}
