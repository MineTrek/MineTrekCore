package net.minetrek.blocks.ores;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minetrek.items.MineTrekItems;

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
	
	@Override
	public ArrayList<ItemStack> getBlockDropped(World w, int x, int y, int z, int meta, int fortune){
		ArrayList<ItemStack> stcks = new ArrayList<ItemStack>();
		stcks.add(new ItemStack(MineTrekItems.dilithium_crystal, 1 + fortune));
		return stcks;
	}

}
