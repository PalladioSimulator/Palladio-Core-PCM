package de.uka.ipd.sdq.capra.simulator.tools;

import umontreal.iro.lecuyer.rng.MRG32k3a;
import umontreal.iro.lecuyer.rng.RandomStream;

public class RandomStreamProvider {

	private static RandomStream selectionStream = new MRG32k3a();
	
	private static RandomStream timeStream = new MRG32k3a();
	
	public static RandomStream getSelectionStream(){
		return selectionStream;
	}
	
	public static RandomStream getTimeStream(){
		return timeStream;
	}
}
