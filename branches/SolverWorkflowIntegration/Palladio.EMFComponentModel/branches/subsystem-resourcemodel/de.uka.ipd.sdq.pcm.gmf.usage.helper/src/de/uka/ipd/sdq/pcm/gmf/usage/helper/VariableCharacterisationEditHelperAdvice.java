/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.usage.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @author Roman Andrej
 *
 */
public class VariableCharacterisationEditHelperAdvice extends
	AbstractEditHelperAdvice implements
		IEditHelperAdvice {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {

		IElementType elementType = ElementTypeRegistry.getInstance().
		getType("de.uka.ipd.sdq.pcm.gmf.seff.PCMRandomVariable_9000");
	
		
		CreateElementRequest createElementRequest = new CreateElementRequest(
				request.getElementToConfigure(), elementType, ParameterPackage.eINSTANCE
				.getVariableCharacterisation_Specification_VariableCharacterisation());
		return new CreateElementCommand(createElementRequest);
		
	}

}
