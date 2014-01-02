package MineTrekCore.net.minetrek.blocks.ores;

public class TungstenOre extends Ore {

	public TungstenOre(int par1) {
		super(par1, "Tungsten", 2);

		setHardness(3.0F);
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 4;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 44;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 5;
	}

}
