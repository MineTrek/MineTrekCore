package MineTrekCore.net.minetrek.blocks.ores;

public class BauxiteOre extends Ore {

	public BauxiteOre() {
		super("bauxite", 1);

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
