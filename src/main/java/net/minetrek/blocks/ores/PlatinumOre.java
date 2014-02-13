package net.minetrek.blocks.ores;

public class PlatinumOre extends Ore {

	public PlatinumOre(int par1) {
		super(par1, "Platinum", 2);

		setHardness(2.0F);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 3;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 32;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 6;
	}

}
