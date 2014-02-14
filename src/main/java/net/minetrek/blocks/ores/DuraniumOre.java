package net.minetrek.blocks.ores;

public class DuraniumOre extends Ore {

	public DuraniumOre() {
		super("duranium", 2);

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
