package edu.kit.ipd.sdq.simcomp.component;



/**
 * Represents a system user which is spawned by an {@link IWorkload} to perform calls to an {@link ISystem}
 * 
 * @author Christoph Föhrdes
 */
public interface IUser {

	/**
	 * A unique identifier for the user instance.
	 * 
	 * @return A unique identifier
	 */
	public String getId();
	
}
