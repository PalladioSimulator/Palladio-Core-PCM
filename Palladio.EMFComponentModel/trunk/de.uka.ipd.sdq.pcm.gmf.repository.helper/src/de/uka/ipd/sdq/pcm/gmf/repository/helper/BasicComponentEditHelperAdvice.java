package de.uka.ipd.sdq.pcm.gmf.repository.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

class CreateLinkedSeffCommand extends CreateElementCommand {

	private Signature service;

	public CreateLinkedSeffCommand(CreateElementRequest request,
			Signature service) {
		super(request);
		this.service = service;
	}

	@Override
	protected EObject doDefaultElementCreation() {
		ResourceDemandingSEFF seff = (ResourceDemandingSEFF) super
				.doDefaultElementCreation();
		seff.setDescribedService__SEFF(service);
		return seff;
	}

}

public class BasicComponentEditHelperAdvice extends AbstractEditHelperAdvice
		implements IEditHelperAdvice {

	@Override
	protected ICommand getAfterCreateRelationshipCommand(
			CreateRelationshipRequest request) {
		if (request.getTarget() != null
				&& request.getTarget() instanceof Interface) {
			if (request.getElementType().getEClass() == RepositoryPackage.eINSTANCE.getProvidedRole()) {
				Interface target = (Interface) request.getTarget();
				if (target.getSignatures__Interface().size() > 0){
					BasicComponent source = (BasicComponent) request.getSource();
					CompositeCommand createSEFFs = new CompositeCommand(
							"Create SEFFs");
					for (Signature s : target.getSignatures__Interface()) {
						CreateElementRequest ceRequest = new CreateElementRequest(
								source,
								ElementTypeRegistry
										.getInstance()
										.getType(
												"de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingSEFF_1000"),
								RepositoryPackage.eINSTANCE
										.getBasicComponent_ServiceEffectSpecifications__BasicComponent());
						CreateElementCommand cmd = new CreateLinkedSeffCommand(
								ceRequest, s);
						createSEFFs.add(cmd);
					}
					return createSEFFs;
				}
			}
		}
		return super.getAfterCreateRelationshipCommand(request);
	}

}
