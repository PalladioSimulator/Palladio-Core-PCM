package de.uka.ipd.sdq.capra.simulator.tools;

import umontreal.iro.lecuyer.rng.MRG32k3a;
import umontreal.iro.lecuyer.rng.RandomStream;

/**
 * @author  jens.happe
 */
public class RandomStreamProvider {

	/**
	 * @uml.property  name="selectionStream"
	 */
	private static RandomStream selectionStream = new MRG32k3a();
	
	/**
	 * @uml.property  name="timeStream"
	 */
	private static RandomStream timeStream = new MRG32k3a();
	
	static{
		timeStream.resetNextSubstream();
	}
	
	/**
	 * @return
	 * @uml.property  name="selectionStream"
	 */
	public static RandomStream getSelectionStream(){
		return selectionStream;
	}
	
	/**
	 * @return
	 * @uml.property  name="timeStream"
	 */
	public static RandomStream getTimeStream(){
		return timeStream;
	}
}
