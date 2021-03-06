package universalelectricity.api.net;

import universalelectricity.api.energy.IEnergyNetwork;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

public class NetworkEvent extends Event {
	public final IEnergyNetwork network;

	public NetworkEvent(IEnergyNetwork network) {
		this.network = network;
	}

	/**
	 * Call this to have your TileEntity produce power into the network.
	 * 
	 * @author Calclavia
	 * 
	 */
	@Cancelable
	public static class EnergyProduceEvent extends NetworkEvent {
		private final Object source;
		private final long amount;
		private final boolean doReceive;

		public EnergyProduceEvent(IEnergyNetwork network, Object source, long amount, boolean doReceive) {
			super(network);
			this.source = source;
			this.amount = amount;
			this.doReceive = doReceive;
		}
	}

	/**
	 * These events are fired when something happens in the network.
	 * 
	 * @author Calclavia
	 * 
	 */
	@Cancelable
	public static class EnergyUpdateEvent extends NetworkEvent {
		public EnergyUpdateEvent(IEnergyNetwork network) {
			super(network);
		}
	}
}
