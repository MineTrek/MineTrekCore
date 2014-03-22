package net.minetrek.blocks.machines;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class RadioisotopicGeneratorTileEntity extends TileEntity {

	private boolean status;

	public RadioisotopicGeneratorTileEntity() {
		status = true;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setBoolean("status", status);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		status = par1.getBoolean("status");
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

	public void setStatus(boolean on) {
		status = on;
	}

	public boolean isOn() {
		return status;
	}

}
