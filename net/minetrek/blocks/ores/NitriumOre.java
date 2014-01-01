package net.minetrek.blocks.ores;

public class NitriumOre extends Ore {

	public NitriumOre(int par1) {
		super(par1, "Nitrium", 2);

		setHardness(1.0F);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 10;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 64;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 8;
	}

}
