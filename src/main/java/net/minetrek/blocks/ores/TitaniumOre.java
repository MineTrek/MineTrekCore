package net.minetrek.blocks.ores;

public class TitaniumOre extends Ore {

	public TitaniumOre() {
		super("titanium", 2);

		setHardness(3.0F);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 6;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 45;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 7;
	}

}
