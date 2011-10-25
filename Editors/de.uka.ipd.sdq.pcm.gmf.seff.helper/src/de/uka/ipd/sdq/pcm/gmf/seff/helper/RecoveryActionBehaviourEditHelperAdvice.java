package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

public class RecoveryActionBehaviourEditHelperAdvice extends
		AbstractEditHelperAdvice implements IEditHelperAdvice {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		// Add a minimal SEFF, only Start and Stop Action
		ConfigureMinimalSeffCommand cmd = new ConfigureMinimalSeffCommand(
				request);
		return cmd;
	}

}
