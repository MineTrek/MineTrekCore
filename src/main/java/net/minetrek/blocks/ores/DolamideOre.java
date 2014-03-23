package net.minetrek.blocks.ores;

public class DolamideOre extends Ore {

	public DolamideOre() {
		super("dolamide", 1);

		setHardness(1.0F);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 3;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 64;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 4;
	}

}
