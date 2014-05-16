package edu.kit.ipd.sdq.simcomp.component;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;

/**
 * 
 * @author Christoph Föhrdes
 *
 */
public interface IPassiveResource extends IResource {

	public boolean acquire(IRequest request, AssemblyContext ctx, PassiveResource passiveResouce, int i, boolean b, double timeoutValue);

	public void release(IRequest request, AssemblyContext ctx, PassiveResource passiveResouce, int i);

}
