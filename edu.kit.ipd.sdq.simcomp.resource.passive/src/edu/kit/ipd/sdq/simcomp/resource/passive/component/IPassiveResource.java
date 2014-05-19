package edu.kit.ipd.sdq.simcomp.resource.passive.component;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationComponent;

/**
 * Represents a passive resource simulation component which can be aquired in a specific amount.
 * 
 * @author Christoph Föhrdes
 *
 */
public interface IPassiveResource extends ISimulationComponent {

	public boolean acquire(IRequest request, AssemblyContext ctx, PassiveResource passiveResouce, int i, boolean b, double timeoutValue);

	public void release(IRequest request, AssemblyContext ctx, PassiveResource passiveResouce, int i);

}
