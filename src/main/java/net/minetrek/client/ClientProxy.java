package net.minetrek.client;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minetrek.CommonProxy;
import net.minetrek.blocks.MineTrekBlocks;
import net.minetrek.blocks.machines.LaserElectronManipulatorItemRenderer;
import net.minetrek.blocks.machines.LaserElectronManipulatorTileEntity;
import net.minetrek.blocks.machines.LaserElectronManipulatorTileEntityRenderer;
import net.minetrek.blocks.machines.PhaserDrillItemRenderer;
import net.minetrek.blocks.machines.PhaserDrillTileEntity;
import net.minetrek.blocks.machines.PhaserDrillTileEntityRenderer;
import net.minetrek.blocks.machines.generators.RadioisotopicGeneratorItemRenderer;
import net.minetrek.blocks.machines.generators.RadioisotopicGeneratorTileEntity;
import net.minetrek.blocks.machines.generators.RadioisotopicGeneratorTileEntityRenderer;
import net.minetrek.blocks.machines.replicator.ReplicatorItemRenderer;
import net.minetrek.blocks.machines.replicator.ReplicatorTileEntity;
import net.minetrek.blocks.machines.replicator.ReplicatorTileEntityRenderer;
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
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MineTrekBlocks.laser_electron_manipulator),
				new LaserElectronManipulatorItemRenderer());

		ClientRegistry
				.bindTileEntitySpecialRenderer(RadioisotopicGeneratorTileEntity.class, new RadioisotopicGeneratorTileEntityRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MineTrekBlocks.radioisotopic_generator), new RadioisotopicGeneratorItemRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(PhaserDrillTileEntity.class, new PhaserDrillTileEntityRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MineTrekBlocks.phaser_drill), new PhaserDrillItemRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(ElectricCableTileEntity.class, new ElectricCableTileEntityRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MineTrekBlocks.electric_cable), new ElectricCableItemRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(ReplicatorTileEntity.class, new ReplicatorTileEntityRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MineTrekBlocks.replicator), new ReplicatorItemRenderer());

		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBolt.class, new PhaserBoltRenderer());
	}

}