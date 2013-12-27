package net.minetrek.blocks.ores;

public class SiliconOre extends Ore {

	public SiliconOre(int par1) {
		super(par1, "Silicon", 2);

		setHardness(1.0F);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 6;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 54;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 12;
	}

}
