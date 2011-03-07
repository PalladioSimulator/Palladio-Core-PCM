/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

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
		
		
//		PCMRandomVariable randomVariable = CoreFactory.eINSTANCE
//				.createPCMRandomVariable();
//
//		randomVariable.setSpecification("1");
//
//		SetRequest setRequest = new SetRequest(
//				(VariableCharacterisation) request.getElementToConfigure(),
//				ParameterPackage.eINSTANCE
//						.getVariableCharacterisation_Specification_VariableCharacterisation(),
//				randomVariable);
//
//		// TODO Auto-generated method stub
//		return new SetValueCommand(setRequest);
	}

}
