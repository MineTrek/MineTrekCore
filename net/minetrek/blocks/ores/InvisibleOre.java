package MineTrekCore.net.minetrek.blocks.ores;

import net.minecraft.world.IBlockAccess;

public class InvisibleOre extends Ore {

	public InvisibleOre(int id) {
		super(id, "Invisible", 3);
		setHardness(5.0F);
		setTextureName("minetrek:ore");

	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess i, int par2, int par3, int par4, int par5) {
		return true;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getNumberPerChunk(int dimension) {
		return 1;
	}

	@Override
	public int getMaxGenHeight(int dimension) {
		return 6;
	}

	@Override
	public int blocksPerVein(int dimension) {
		return 1;
	}

}
