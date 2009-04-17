package de.uka.ipd.sdq.simuservice;

/**
 * The SimuService provides an operation to perform a simulation, and thus
 * provides an entry point to simulation that can be published as a web service.
 * 
 * author: brosch, heupel
 */
public interface SimuService {

	/**
	 * The simulation operation is provided by the service.
	 * 
	 * @param params
	 *            the input parameters to simulation
	 */
	public void simulate(final SimuServiceParams params);
}