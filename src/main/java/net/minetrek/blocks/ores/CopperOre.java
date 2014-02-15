package net.minetrek.blocks.ores;

public class CopperOre extends Ore {

	public CopperOre() {
		super("copper", 2);

		setHardness(3.0F);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 20;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 64;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 16;
	}

}
