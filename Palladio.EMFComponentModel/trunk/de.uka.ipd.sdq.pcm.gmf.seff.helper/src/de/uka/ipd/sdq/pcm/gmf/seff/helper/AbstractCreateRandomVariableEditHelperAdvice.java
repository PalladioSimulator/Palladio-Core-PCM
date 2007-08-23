package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

public class AbstractCreateRandomVariableEditHelperAdvice extends
		AbstractEditHelperAdvice {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		IElementType elementType = ElementTypeRegistry.getInstance().
			getType("de.uka.ipd.sdq.pcm.gmf.seff.PCMRandomVariable_9000");
		
		CreateElementRequest createElementRequest = new CreateElementRequest(
				request.getElementToConfigure(), elementType);
		return new CreateElementCommand(createElementRequest);
	}

}
