package de.uka.ipd.sdq.pipesandfilters.framework.exceptions;

/**
 * The exception thrown by classes in the pipes and filters packages.
 * 
 * @author Baum
 * 
 */
public class PipesAndFiltersException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * The constructor of a pipes and filters exception
	 * 
	 * @param desc
	 *            The exception description
	 */
	public PipesAndFiltersException(String desc) {
		super(desc);
	}
}
