package de.uka.ipd.sdq.pcm.diagram.edit.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;

/**
 * @generated
 */
public class CommunicationLinkResourceSpecificationCreateCommand extends
		CreateElementCommand {

	/**
	 * @generated
	 */
	public CommunicationLinkResourceSpecificationCreateCommand(
			CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest()).getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (getEClass() != null) {
			return getEClass().isSuperTypeOf(getEClassToEdit());
		}
		return true;
	}

	/**
	 * @generated
	 */
	protected EReference getContainmentFeature() {
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		// Uncomment to put "phantom" objects into the diagram file.		
		// org.eclipse.emf.ecore.resource.Resource resource = 
		// 		((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getContainer().eResource();
		// if (resource == null) {
		// 	return null;
		// }
		Resource resource = getElementToEdit().eResource();
		CommunicationLinkResourceSpecification newElement = ResourceenvironmentFactory.eINSTANCE
				.createCommunicationLinkResourceSpecification();

		resource.getContents().add(newElement);
		return newElement;
	}

}
