package net.minetrek.blocks.ores;

public class DilithiumOre extends Ore {

	public DilithiumOre(int par1) {
		super(par1, "Dilithium", 3);

		setHardness(5.0F);
		setLightValue(.4F);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 1;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 10;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 2;
	}

}
