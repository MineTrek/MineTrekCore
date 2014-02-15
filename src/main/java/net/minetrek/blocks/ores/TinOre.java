package MineTrekCore.net.minetrek.blocks.ores;

public class TinOre extends Ore {

	public TinOre() {
		super("tin", 1);

		setHardness(1.0F);
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
