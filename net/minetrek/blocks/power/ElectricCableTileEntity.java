package net.minetrek.blocks.power;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import universalelectricity.api.energy.IEnergyInterface;

public class ElectricCableTileEntity extends TileEntity implements IEnergyInterface {

	private final boolean[] attachedSides;

	public ElectricCableTileEntity() {
		super();
		attachedSides = new boolean[6];
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long onReceiveEnergy(ForgeDirection arg0, long arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addAttachedSide(int side) {
		attachedSides[side] = true;

	}

	public boolean isAttached(int side) {
		return attachedSides[side];
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
		readFromNBT(packet.data);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < 6; i++) {
			NBTTagCompound item = new NBTTagCompound();
			item.setByte("Side", (byte) i);
			list.appendTag(item);
		}
		compound.setTag("AttachedSides", list);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		NBTTagList list = compound.getTagList("AttachedSides");
		for (int i = 0; i < list.tagCount(); i++) {

			NBTTagCompound item = (NBTTagCompound) list.tagAt(i);

			addAttachedSide(item.getByte("Side"));

		}
	}

}
