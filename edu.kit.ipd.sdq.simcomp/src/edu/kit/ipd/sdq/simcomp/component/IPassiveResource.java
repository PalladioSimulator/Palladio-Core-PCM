package edu.kit.ipd.sdq.simcomp.component;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;

/**
 * TODO (SimComp): integrate release
 * 
 * @author Christoph Föhrdes
 *
 */
public interface IPassiveResource extends IResource {

	public boolean acquire(IRequest request, PassiveResource passiveResouce, int i, boolean b, double timeoutValue);

}
