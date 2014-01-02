package MineTrekCore.net.minetrek.blocks.ores;

public class ChromiteOre extends Ore {

	public ChromiteOre(int par1) {
		super(par1, "Chromite", 2);
		setHardness(3.0F);
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
