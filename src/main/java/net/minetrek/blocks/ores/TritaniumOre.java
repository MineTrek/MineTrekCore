package net.minetrek.blocks.ores;

public class TritaniumOre extends Ore {

	public TritaniumOre() {
		super("tritanium", 3);

		setHardness(15.0F);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 2;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 24;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 4;
	}

}
