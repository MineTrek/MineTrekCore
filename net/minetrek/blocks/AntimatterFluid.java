package net.minetrek.blocks;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class AntimatterFluid extends Fluid {

	public AntimatterFluid() {
		super("Antimatter");
		setDensity(10);
		setViscosity(1000);
		FluidRegistry.registerFluid(this);
	}

}
