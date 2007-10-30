package de.uka.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.uka.ipd.sdq.completions.CompletionsFactory;
import de.uka.ipd.sdq.completions.DelegatingExternalCallAction;
import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;

/**
 * A builder which builds identical SEFFs for all services contained in the passed interface. Useful for creating components which delegate their 
 * call to other components
 * @author Snowball
 *
 */
public class DelegatorComponentSeffBuilder 
implements ISeffBuilder {
	
	protected ArrayList<AbstractInternalActionDescriptor> preActions = new ArrayList<AbstractInternalActionDescriptor>();
	protected ArrayList<AbstractInternalActionDescriptor> postActions = new ArrayList<AbstractInternalActionDescriptor>();
	protected RequiredRole domainReqRole;
	protected ProvidedRole domainProvRole;
	private ArrayList<ResourceDemandingSEFF> createdSeffs = new ArrayList<ResourceDemandingSEFF>();

	public DelegatorComponentSeffBuilder(ProvidedRole domainProvRole, RequiredRole domainReqRole) {
		this.domainReqRole = domainReqRole;
		this.domainProvRole = domainProvRole;
	}

	/**
	 * Append an internal action in the chain of actions to be executed before the delegating call
	 * @param signatureDependentDemand A description of the internal action's demand
	 */
	public void appendPreInternalAction(
			AbstractInternalActionDescriptor signatureDependentDemand) {
		this.preActions.add(signatureDependentDemand);
	}

	/**
	 * Append an internal action in the chain of actions to be executed after the delegating call
	 * @param signatureDependentDemand A description of the internal action's demand
	 */
	public void appendPostInternalAction(
			AbstractInternalActionDescriptor signatureDependentDemand) {
		this.postActions.add(signatureDependentDemand);
	}	
	
	public void build() {
		for (Signature providedService : domainProvRole.getProvidedInterface__ProvidedRole().getSignatures__Interface()){
			ResourceDemandingSEFF seff = buildSeff(providedService);
			this.createdSeffs.add(seff);
		}
	}
	
	/* (non-Javadoc)
	 * @see de.uka.sdq.pcm.transformations.builder.seff.ISeffBuilder#getSeff(de.uka.ipd.sdq.pcm.repository.Signature)
	 */
	public List<ResourceDemandingSEFF> getSeffs() {
		return Collections.unmodifiableList(this.createdSeffs);
	}
	
	private ResourceDemandingSEFF buildSeff(Signature signature) {
		ResourceDemandingSEFF seff = SeffFactory.eINSTANCE.createResourceDemandingSEFF();
		seff.setDescribedService__SEFF(signature);
		
		StartAction start = SeffFactory.eINSTANCE.createStartAction();
		AbstractAction lastAction = start;
		
		for (AbstractInternalActionDescriptor o : preActions) {
			AbstractAction action = createAction(o,signature);
			lastAction = createControlFlow(lastAction,action);
			seff.getSteps_Behaviour().add(action);
		}

		DelegatingExternalCallAction delegatingCall = CompletionsFactory.eINSTANCE.createDelegatingExternalCallAction();
		delegatingCall.setCalledService_ExternalService(signature);
		delegatingCall.setRole_ExternalService(domainReqRole);
		lastAction = createControlFlow(lastAction, delegatingCall);

		for (AbstractInternalActionDescriptor o : postActions) {
			AbstractAction action = createAction(o,signature);
			lastAction = createControlFlow(lastAction,action);
			seff.getSteps_Behaviour().add(action);
		}
		
		StopAction stop = SeffFactory.eINSTANCE.createStopAction();
		createControlFlow(lastAction, stop);
		
		Collections.addAll(seff.getSteps_Behaviour(), start,stop,delegatingCall);
		
		return seff;
	}

	private AbstractAction createAction(AbstractInternalActionDescriptor descriptor, Signature signature) {
		if (descriptor instanceof SignatureDependentInternalActionDescriptor)
			((SignatureDependentInternalActionDescriptor)descriptor).setCurrentSignature(signature);
		return createInternalAction(descriptor.getResourceType(), descriptor.getResourceDemand());
	}


	private InternalAction createInternalAction(ProcessingResourceType type, String resourceDemandSpec) {
		InternalAction action = SeffFactory.eINSTANCE.createInternalAction();
		ParametricResourceDemand d = SeffFactory.eINSTANCE.createParametricResourceDemand();
		d.setRequiredResource_ParametricResourceDemand(type);
		PCMRandomVariable specification = CoreFactory.eINSTANCE.createPCMRandomVariable();
		specification.setSpecification(getSaveResourceDemand(resourceDemandSpec));
		d.setSpecification_ParametericResourceDemand(specification);
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
}
