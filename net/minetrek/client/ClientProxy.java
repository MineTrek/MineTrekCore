package net.minetrek.client;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minetrek.CommonProxy;
import net.minetrek.blocks.MineTrekBlocks;
import net.minetrek.blocks.machines.LaserElectronManipulatorItemRenderer;
import net.minetrek.blocks.machines.LaserElectronManipulatorTileEntity;
import net.minetrek.blocks.machines.LaserElectronManipulatorTileEntityRenderer;
import net.minetrek.blocks.machines.PhaserDrillItemRenderer;
import net.minetrek.blocks.machines.PhaserDrillTileEntity;
import net.minetrek.blocks.machines.PhaserDrillTileEntityRenderer;
import net.minetrek.blocks.machines.RadioisotopicGeneratorItemRenderer;
import net.minetrek.blocks.machines.RadioisotopicGeneratorTileEntity;
import net.minetrek.blocks.machines.RadioisotopicGeneratorTileEntityRenderer;
import net.minetrek.blocks.power.ElectricCableItemRenderer;
import net.minetrek.blocks.power.ElectricCableTileEntity;
import net.minetrek.blocks.power.ElectricCableTileEntityRenderer;
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

		ClientRegistry
				.bindTileEntitySpecialRenderer(RadioisotopicGeneratorTileEntity.class, new RadioisotopicGeneratorTileEntityRenderer());
		MinecraftForgeClient.registerItemRenderer(MineTrekBlocks.radioisotopic_generator.blockID, new RadioisotopicGeneratorItemRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(PhaserDrillTileEntity.class, new PhaserDrillTileEntityRenderer());
		MinecraftForgeClient.registerItemRenderer(MineTrekBlocks.phaser_drill.blockID, new PhaserDrillItemRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(ElectricCableTileEntity.class, new ElectricCableTileEntityRenderer());
		MinecraftForgeClient.registerItemRenderer(MineTrekBlocks.electric_cable.blockID, new ElectricCableItemRenderer());

		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBolt.class, new PhaserBoltRenderer());
	}

}