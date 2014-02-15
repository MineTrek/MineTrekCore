package MineTrekCore.net.minetrek.blocks.ores;

public class IridiumOre extends Ore {

	public IridiumOre() {
		super("iridium", 2);

		setHardness(1.0F);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 5;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 40;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 6;
	}

}
