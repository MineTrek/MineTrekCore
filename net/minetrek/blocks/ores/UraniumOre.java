package net.minetrek.blocks.ores;


public class UraniumOre extends Ore {

	public UraniumOre(int par1) {
		super(par1, "Uranium", 3);
		
		setHardness(4.0F);
		setLightValue(0.2f);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 3;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 12;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 3;
	}

}
