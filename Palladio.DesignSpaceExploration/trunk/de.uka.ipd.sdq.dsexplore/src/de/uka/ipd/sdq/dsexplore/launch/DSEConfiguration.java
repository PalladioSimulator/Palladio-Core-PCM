package de.uka.ipd.sdq.dsexplore.launch;

import org.eclipse.debug.core.ILaunchConfiguration;

/**
 * TODO: Build from Launch configuration with a builder, and move all configuration here, 
 * so that Opt4JStarter class is cleaner. 
 * @author martens
 *
 */
public class DSEConfiguration {
	
	private String decimalFormat = "0.#######";

	

	public DSEConfiguration(ILaunchConfiguration config) {
		super();
	}



	public String getDecimalFormat() {
		return decimalFormat;
	}
	

}
