package net.minetrek.blocks.machines;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import universalelectricity.api.CompatibilityModule;
import universalelectricity.api.energy.EnergyStorageHandler;
import universalelectricity.api.energy.IEnergyContainer;
import universalelectricity.api.energy.IEnergyInterface;
import universalelectricity.api.vector.Vector3;

public class LaserElectronManipulatorTileEntity extends TileEntity implements ISidedInventory, IEnergyInterface, IEnergyContainer {

	private final ItemStack[] inventory;
	public EnergyStorageHandler energy;
	private final ArrayList<ForgeDirection> outputDirections;

	private static final ArrayList<ItemStack> recipeIngredients = new ArrayList<ItemStack>(), recipeProducts = new ArrayList<ItemStack>();

	public LaserElectronManipulatorTileEntity() {
		super();

		inventory = new ItemStack[2];
		energy = new EnergyStorageHandler(1000);

		outputDirections = new ArrayList<ForgeDirection>();
		for (ForgeDirection fd : ForgeDirection.values())
			if (!fd.equals(ForgeDirection.UNKNOWN))
				outputDirections.add(fd);
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
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int slot, int count) {
		ItemStack itemstack = getStackInSlot(slot);
		if (itemstack != null) {
			if (itemstack.stackSize <= count) {
				setInventorySlotContents(slot, null);
			} else {
				itemstack = itemstack.splitStack(count);
				this.updateEntity();
			}
		}
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		ItemStack itemstack = getStackInSlot(i);
		setInventorySlotContents(i, null);
		return itemstack;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {

		System.out.println(itemstack);

		inventory[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}

	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		System.out.println(i + " " + itemstack);
		return itemstack == null || (i != 1 && recipeIngredients.contains(itemstack));
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < getSizeInventory(); i++) {
			ItemStack itemstack = getStackInSlot(i);
			if (itemstack != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("LEMSlot", (byte) i);
				itemstack.writeToNBT(item);
				list.appendTag(item);
			}
		}
		compound.setTag("LEMItems", list);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		NBTTagList list = compound.getTagList("LEMItems", 0);
		for (int i = 0; i < list.tagCount(); i++) {

			NBTTagCompound item = list.getCompoundTagAt(i);

			int slot = item.getByte("LEMSlot");
			if (slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}

	@Override
	public boolean canConnect(ForgeDirection arg0) {
		return true;
	}

	@Override
	public long getEnergy(ForgeDirection arg0) {
		return energy.getEnergy();
	}

	@Override
	public long getEnergyCapacity(ForgeDirection arg0) {
		return energy.getEnergyCapacity();
	}

	@Override
	public void setEnergy(ForgeDirection arg0, long arg1) {
		energy.setEnergy(arg1);
	}

	@Override
	public long onExtractEnergy(ForgeDirection arg0, long arg1, boolean arg2) {
		return energy.extractEnergy(arg1, arg2);
	}

	@Override
	public long onReceiveEnergy(ForgeDirection arg0, long arg1, boolean arg2) {
		return produce(energy.receiveEnergy(arg1, arg2), arg0);
	}

	protected long produce(long outputEnergy, ForgeDirection arg0) {
		long usedEnergy = 0;

		for (ForgeDirection direction : outputDirections) {
			if (outputEnergy > 0 && !direction.equals(arg0)) {
				TileEntity tileEntity = new Vector3(this).translate(direction).getTileEntity(this.worldObj);

				if (tileEntity != null) {
					usedEnergy += CompatibilityModule.receiveEnergy(tileEntity, direction.getOpposite(), outputEnergy, true);
				}
			}
		}

		return usedEnergy;
	}

	public static void addRecipe(ItemStack in, ItemStack out) {
		recipeIngredients.add(in);
		recipeProducts.add(out);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		int[] tmp = new int[1];
		if (var1 == 4)
			tmp[0] = 0;
		else if (var1 == 5)
			tmp[0] = 1;
		else
			tmp = new int[0];
		return tmp;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return true;
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getInventoryName() {
		return "Laser Electron Manipulator";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub

	}

}
