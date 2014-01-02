package MineTrekCore.net.minetrek.blocks.ores;

public class CopperOre extends Ore {

	public CopperOre(int par1) {
		super(par1, "Copper", 2);

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
