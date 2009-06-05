package de.uka.sdq.pcm.transformations.builder;

import java.util.ArrayList;
import java.util.Collections;

import de.uka.ipd.sdq.completions.CompletionsFactory;
import de.uka.ipd.sdq.completions.DelegatingExternalCallAction;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.sdq.pcm.transformations.ISignatureDependentDemand;
class InternalActionDescriptor {
	private String resourceDemand;
	private ProcessingResourceType resourceType;
	public InternalActionDescriptor(String resourceDemand,
			ProcessingResourceType resourceType) {
		super();
		this.resourceDemand = resourceDemand;
		this.resourceType = resourceType;
	}
	public String getResourceDemand() {
		return resourceDemand;
	}
	public ProcessingResourceType getResourceType() {
		return resourceType;
	}
	
	
}

public class SeffBuilder {
	ArrayList<Object> preActions = new ArrayList<Object>();
	ArrayList<Object> postActions = new ArrayList<Object>();

	public SeffBuilder() {
	}

	public void appendPreInternalAction(ProcessingResourceType type, String resourceDemandSpec) {
		preActions.add(new InternalActionDescriptor(resourceDemandSpec,type));
	}
	
	public void appendPostInternalAction(ProcessingResourceType type, String resourceDemandSpec) {
		postActions.add(new InternalActionDescriptor(resourceDemandSpec,type));
	}
	
	public void build(BasicComponent basicComponent) {
		for (ProvidedRole providedRole : basicComponent.getProvidedRoles_InterfaceProvidingEntity()) {
			for (Signature providedService : providedRole.getProvidedInterface__ProvidedRole().getSignatures__Interface()){
				ResourceDemandingSEFF seff = buildSeff(providedService);
				basicComponent.getServiceEffectSpecifications__BasicComponent().add(seff);
			}
		}
	}
	
	private ResourceDemandingSEFF buildSeff(Signature signature) {
		ResourceDemandingSEFF seff = SeffFactory.eINSTANCE.createResourceDemandingSEFF();
		seff.setDescribedService__SEFF(signature);
		
		StartAction start = SeffFactory.eINSTANCE.createStartAction();
		AbstractAction lastAction = start;
		
		for (Object o : preActions) {
			AbstractAction action = createAction(o,signature);
			lastAction = createControlFlow(lastAction,action);
			seff.getSteps_Behaviour().add(action);
		}

		DelegatingExternalCallAction delegatingCall = CompletionsFactory.eINSTANCE.createDelegatingExternalCallAction();
		delegatingCall.setCalledService_ExternalService(signature);
		lastAction = createControlFlow(lastAction, delegatingCall);

		for (Object o : postActions) {
			AbstractAction action = createAction(o,signature);
			lastAction = createControlFlow(lastAction,action);
			seff.getSteps_Behaviour().add(action);
		}
		
		StopAction stop = SeffFactory.eINSTANCE.createStopAction();
		createControlFlow(lastAction, stop);
		
		Collections.addAll(seff.getSteps_Behaviour(), start,stop,delegatingCall);
		
		return seff;
	}

	private AbstractAction createAction(Object o, Signature signature) {
		if (o instanceof InternalActionDescriptor) {
			InternalActionDescriptor descriptor = (InternalActionDescriptor) o;
			return createInternalAction(descriptor.getResourceType(), descriptor.getResourceDemand());
		}
		if (o instanceof ISignatureDependentDemand)
			return createInternalAction(((ISignatureDependentDemand)o).getType(), ((ISignatureDependentDemand)o).getDemand(signature));
		return null;
	}

	public void appendPreInternalAction(
			ISignatureDependentDemand signatureDependentDemand) {
		this.preActions.add(signatureDependentDemand);
	}

	private InternalAction createInternalAction(ProcessingResourceType type, String resourceDemandSpec) {
		InternalAction action = SeffFactory.eINSTANCE.createInternalAction();
		ParametricResourceDemand d = SeffFactory.eINSTANCE.createParametricResourceDemand();
		d.setRequiredResource_ParametricResourceDemand(type);
		d.setSpecification(getSaveResourceDemand(resourceDemandSpec));
		d.setUnit("");
		action.getResourceDemand_Action().add(d);
		
		return action;
	}
	
	private String getSaveResourceDemand(String resourceDemandSpec) {
		if (resourceDemandSpec == null)
			return "0";
		if (resourceDemandSpec.equals(""))
			return "0";
		return resourceDemandSpec;
	}

	private AbstractAction createControlFlow(AbstractAction a,
			AbstractAction b) {
		a.setSuccessor_AbstractAction(b);
		return b;
	}

	public void appendPostInternalAction(
			ISignatureDependentDemand signatureDependentDemand) {
		this.postActions.add(signatureDependentDemand);
	}
	
}
