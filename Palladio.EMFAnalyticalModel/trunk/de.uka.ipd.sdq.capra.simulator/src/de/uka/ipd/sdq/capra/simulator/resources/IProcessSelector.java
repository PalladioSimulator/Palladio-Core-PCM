package de.uka.ipd.sdq.capra.simulator.resources;


public interface IProcessSelector {

	ActiveProcess select(SimResourceInstance instance);

}
