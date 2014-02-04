package net.minetrek.blocks.machines;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minetrek.entities.projectiles.EntityPhaserBolt;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PhaserDrill extends BlockContainer {

	public PhaserDrill(int par1) {
		super(par1, Material.iron);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("phaserDrill");
		LanguageRegistry.addName(this, "Phaser Drill");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 1);
		setTextureName("minetrek:phaserDrill");

		this.setBlockBounds(0F, 0F, 0F, 1.0F, 2.0F, 1.0F);

		GameRegistry.registerTileEntity(PhaserDrillTileEntity.class, "phaserDrillTileEntity");
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new PhaserDrillTileEntity();
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase player, ItemStack is) {
		int dir = MathHelper.floor_double((player.rotationYaw * 4F) / 360F + 0.5D) % 3;
		w.setBlockMetadataWithNotify(x, y, z, dir, 0);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new PhaserDrillTileEntity();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		Random r = new Random();
		shootBlock(world, x + r.nextInt(11) + 1, y + r.nextInt(5) - 2, z + r.nextInt(11) + 1, x, y, z);

		return true;

	}

	public void shootBlock(World world, int x, int y, int z, int fromX, int fromY, int fromZ) {
		EntityPhaserBolt e = new EntityPhaserBolt(world, fromX + 0.5D, fromY + 1.5D, fromZ + 0.5D);
		e.setThrowableHeading(fromX - x, fromY - y, fromZ - z, 5.0F, 0.0F);
		world.playSound(fromX, fromY, fromZ, "minetrek:phaser", 0.5F, 0.4F / (new Random().nextFloat() * 0.4F + 0.8F), true);
		world.spawnEntityInWorld(e);
	}

}
