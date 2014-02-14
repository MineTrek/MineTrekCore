package net.minetrek.blocks.power;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import universalelectricity.api.CompatibilityModule;
import universalelectricity.api.energy.IEnergyInterface;
import universalelectricity.api.vector.Vector3;

public class ElectricCableTileEntity extends TileEntity implements
		IEnergyInterface {

	private final boolean[] attachedSides;
	public final ArrayList<boolean[]> sideDirections;

	public ElectricCableTileEntity() {
		super();
		sideDirections = new ArrayList<boolean[]>();
		for (int i = 0; i < 6; i++) {
			boolean[] tmp = new boolean[4];
			Arrays.fill(tmp, false);
			sideDirections.add(i, tmp);
		}
		attachedSides = new boolean[6];
		Arrays.fill(attachedSides, false);
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

	public void setAttachedSide(int side, boolean attached) {
		attachedSides[side] = attached;

	}

	public boolean isAttached(int side) {
		return attachedSides[side];
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord,
				this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
		for (boolean[] tmp : sideDirections)
			System.out.println(Arrays.toString(tmp));
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < 6; i++) {
			if (isAttached(i)) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Side", (byte) i);
				boolean[] connected = getAttachedDirections(i);
				for (int conn = 0; conn < connected.length; conn++)
					item.setBoolean("Connected" + conn, connected[conn]);
				list.appendTag(item);
			}
		}
		compound.setTag("AttachedSides", list);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		sideDirections.clear();

		for (int i = 0; i < 6; i++) {
			boolean[] tmp = new boolean[4];
			Arrays.fill(tmp, false);
			sideDirections.add(tmp);
		}

		NBTTagList list = compound.getTagList("AttachedSides", 0);
		for (int i = 0; i < list.tagCount(); i++) {

			NBTTagCompound item = (NBTTagCompound) list.getCompoundTagAt(i);

			setAttachedSide(item.getByte("Side"), true);
			boolean[] dirs = new boolean[4];
			for (int conn = 0; conn < 4; conn++) {
				dirs[conn] = item.getBoolean("Connected" + conn);
			}
			sideDirections.set(item.getByte("Side"), dirs);

		}

	}

	public boolean[] getAttachedDirections(int side) {
		return sideDirections.get(side);
	}

	public void checkConnections(World w, int x, int y, int z) {

		sideDirections.clear();

		for (int i = 0; i < 6; i++) {
			boolean[] tmp = new boolean[4];
			Arrays.fill(tmp, false);
			sideDirections.add(i, tmp);
		}

		for (int side = 0; side < 6; side++) {

			if (isAttached(side)) {
				boolean[] dirs = new boolean[4];
				switch (side) {
				case 0:
				case 1:
					dirs[0] = testConnect(ForgeDirection.NORTH);
					dirs[1] = testConnect(ForgeDirection.SOUTH);
					dirs[2] = testConnect(ForgeDirection.EAST);
					dirs[3] = testConnect(ForgeDirection.WEST);
					break;
				case 2:
				case 3:
				case 4:
				case 5:
					break;
				}

				sideDirections.set(side, dirs);

			}
		}

		w.markBlockForUpdate(x, y, z);

	}

	private boolean testConnect(ForgeDirection direction) {
		TileEntity tileEntity = new Vector3(this).translate(direction)
				.getTileEntity(this.worldObj);

		if (tileEntity != null) {
			return CompatibilityModule.canConnect(tileEntity,
					direction.getOpposite());
		}

		return false;
	}
}
