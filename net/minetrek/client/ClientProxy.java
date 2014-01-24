package net.minetrek.client;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minetrek.CommonProxy;
import net.minetrek.blocks.MineTrekBlocks;
import net.minetrek.blocks.machines.LaserElectronManipulatorItemRenderer;
import net.minetrek.blocks.machines.LaserElectronManipulatorTileEntity;
import net.minetrek.blocks.machines.LaserElectronManipulatorTileEntityRenderer;
import net.minetrek.entities.projectiles.EntityPhaserBolt;
import net.minetrek.entities.projectiles.PhaserBoltRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {

		ClientRegistry.bindTileEntitySpecialRenderer(LaserElectronManipulatorTileEntity.class,
				new LaserElectronManipulatorTileEntityRenderer());
		MinecraftForgeClient.registerItemRenderer(MineTrekBlocks.laser_electron_manipulator.blockID,
				new LaserElectronManipulatorItemRenderer());

		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBolt.class, new PhaserBoltRenderer());
	}

}