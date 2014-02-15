package net.minetrek.blocks.ores;

public class PlutoniumOre extends Ore {

	public PlutoniumOre() {
		super("plutonium", 3);

		setHardness(5.0F);

	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 1;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 16;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 2;
	}

}
