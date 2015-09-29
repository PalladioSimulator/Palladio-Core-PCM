package edu.kit.ipd.sdq.simcomp.resource.passive.component;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.PassiveResource;

import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationComponent;

/**
 * Represents a passive resource simulation component which can be aquired in a
 * specific amount.
 * 
 * TODO (SimComp) Introduce passive resource simulation events
 * 
 * @author Christoph Föhrdes
 * 
 */
public interface IPassiveResource extends ISimulationComponent {

	/**
	 * Aquires a specific amount of this passive resource
	 * 
	 * @param request
	 * @param ctx
	 * @param passiveResouce
	 * @param i
	 * @param b
	 * @param timeoutValue
	 * @return
	 */
	public boolean acquire(IRequest request, AssemblyContext ctx, PassiveResource passiveResouce, int i, boolean b, double timeoutValue);

	/**
	 * Releases a specific amount of this passive resource
	 * 
	 * @param request
	 * @param ctx
	 * @param passiveResouce
	 * @param i
	 */
	public void release(IRequest request, AssemblyContext ctx, PassiveResource passiveResouce, int i);

}
