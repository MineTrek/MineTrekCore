package net.minetrek.blocks.machines.generators;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class RadioisotopicGeneratorTileEntity extends TileEntity implements ISidedInventory {

	private boolean status;
	private final ItemStack[] inventory;

	private static final ArrayList<ItemStack> recipeIngredients = new ArrayList<ItemStack>();
	private static final ArrayList<Integer> recipeProducts = new ArrayList<Integer>();

	public RadioisotopicGeneratorTileEntity() {
		status = true;

		inventory = new ItemStack[1];
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

		inventory[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}

		updateEntity();

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
		return itemstack == null || recipeIngredients.contains(itemstack);
	}

	@Override
	public String getInventoryName() {
		return "Radioisotopic Generator";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		int[] tmp = new int[1];
		tmp[0] = 1;
		return tmp;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int var3) {
		return isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack var2, int var3) {
		return true;
	}

	private boolean validIngredient() {
		return inventory[0] != null && getProduct(inventory[0]) != 0;
	}

	private int getProduct(ItemStack ingredient) {
		for (int i = 0; i < recipeIngredients.size(); i++)
			if (recipeIngredients.get(i).getItem().equals(ingredient.getItem()))
				return recipeProducts.get(i);
		return 0;
	}

	public static void addRecipe(ItemStack in, int out) {
		recipeIngredients.add(in);
		recipeProducts.add(out);
	}

}
