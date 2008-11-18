/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;


/** @author roman */
public class ParametricResourceDemandEditHelperAdvice 
extends	AbstractCreateRandomVariableEditHelperAdvice 
implements IEditHelperAdvice {
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		return new ParametricResourceDemandConfigureCommand(request);
	}
}
