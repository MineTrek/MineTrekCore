package MineTrekCore.net.minetrek.blocks.ores;

public class UraniumOre extends Ore {

	public UraniumOre() {
		super("uranium", 3);

		setHardness(4.0F);
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
