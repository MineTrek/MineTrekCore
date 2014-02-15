package net.minetrek.blocks.power;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import universalelectricity.api.CompatibilityModule;
import universalelectricity.api.energy.IEnergyInterface;
import universalelectricity.api.vector.Vector3;

public class ElectricCableTileEntity extends TileEntity implements IEnergyInterface {

	private final ArrayList<ForgeDirection> attachedSides;

	public ElectricCableTileEntity() {
		super();
		attachedSides = new ArrayList<ForgeDirection>();
	}

	@Override
	public boolean canConnect(ForgeDirection direction) {
		if (direction == null || direction.equals(ForgeDirection.UNKNOWN)) {
			return false;
		}

		return true;
	}

	@Override
	public long onExtractEnergy(ForgeDirection arg0, long arg1, boolean arg2) {
		return 0;
	}

	@Override
	public long onReceiveEnergy(ForgeDirection arg0, long arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addAttachedSide(ForgeDirection fd) {
		attachedSides.add(fd);

	}

	public boolean isAttached(ForgeDirection fd) {
		return attachedSides.contains(fd);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		for (ForgeDirection fd : attachedSides) {

			compound.setBoolean(fd.name(), true);

		}
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		attachedSides.clear();

		for (ForgeDirection fd : ForgeDirection.VALID_DIRECTIONS) {
			if (compound.hasKey(fd.name()))
				addAttachedSide(fd);
		}

	}

	public void checkConnections(World w, int x, int y, int z) {
		if (testConnect(ForgeDirection.NORTH))
			attachedSides.add(ForgeDirection.NORTH);
		if (testConnect(ForgeDirection.SOUTH))
			attachedSides.add(ForgeDirection.SOUTH);
		if (testConnect(ForgeDirection.EAST))
			attachedSides.add(ForgeDirection.EAST);
		if (testConnect(ForgeDirection.WEST))
			attachedSides.add(ForgeDirection.WEST);
		if (testConnect(ForgeDirection.UP))
			attachedSides.add(ForgeDirection.UP);
		if (testConnect(ForgeDirection.DOWN))
			attachedSides.add(ForgeDirection.DOWN);
		System.out.println(attachedSides);

		w.markBlockForUpdate(x, y, z);

	}

	private boolean testConnect(ForgeDirection direction) {
		TileEntity tileEntity = new Vector3(this).translate(direction).getTileEntity(this.worldObj);

		if (tileEntity != null) {
			return CompatibilityModule.canConnect(tileEntity, direction.getOpposite());
		}

		return false;
	}

	public ArrayList<ForgeDirection> getAttachedSides() {
		return attachedSides;
	}
}
