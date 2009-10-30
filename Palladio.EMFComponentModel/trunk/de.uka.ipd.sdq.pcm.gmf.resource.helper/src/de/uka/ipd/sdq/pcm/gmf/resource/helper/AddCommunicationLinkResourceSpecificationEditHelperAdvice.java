package de.uka.ipd.sdq.pcm.gmf.resource.helper;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

public class AddCommunicationLinkResourceSpecificationEditHelperAdvice extends
		AbstractEditHelperAdvice implements IEditHelperAdvice {

	@Override
	public ICommand getAfterEditCommand(IEditCommandRequest request) {
		CommunicationLinkResourceSpecification spec = ResourceenvironmentFactory.eINSTANCE
				.createCommunicationLinkResourceSpecification();
		SetRequest setRequest = new SetRequest(
				(EObject) request.getElementsToEdit().get(0),
				ResourceenvironmentPackage.eINSTANCE
						.getLinkingResource_CommunicationLinkResourceSpecifications_LinkingResource(),
				spec);

		return new SetValueCommand(setRequest);
	}

//	@Override
//	public ICommand getBeforeEditCommand(IEditCommandRequest request) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void configureRequest(IEditCommandRequest request) {
//		//
//	}

//	@Override
//	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
//		CommunicationLinkResourceSpecification spec = ResourceenvironmentFactory.eINSTANCE
//				.createCommunicationLinkResourceSpecification();
//
//		SetRequest setRequest = new SetRequest(
//				(LinkingResource) request.getElementsToEdit(),
//				ResourceenvironmentPackage.eINSTANCE
//						.getLinkingResource_CommunicationLinkResourceSpecifications_LinkingResource(),
//				spec);
//
//		return new SetValueCommand(setRequest);
//	}

}
