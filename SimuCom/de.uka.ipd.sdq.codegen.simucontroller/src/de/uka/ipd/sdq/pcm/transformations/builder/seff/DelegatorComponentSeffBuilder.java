package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.uka.ipd.sdq.completions.CompletionsFactory;
import de.uka.ipd.sdq.completions.DelegatingExternalCallAction;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
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
public class DelegatorComponentSeffBuilder extends AbstractSeffBuilder 
implements ISeffBuilder {
	
	protected ArrayList<AbstractActionDescriptor> preActions = new ArrayList<AbstractActionDescriptor>();
	protected ArrayList<AbstractActionDescriptor> postActions = new ArrayList<AbstractActionDescriptor>();
	protected OperationRequiredRole domainReqRole;
	protected OperationProvidedRole domainProvRole;
	private ArrayList<ResourceDemandingSEFF> createdSeffs = new ArrayList<ResourceDemandingSEFF>();

	public DelegatorComponentSeffBuilder(OperationProvidedRole domainProvRole, OperationRequiredRole domainReqRole) {
		this.domainReqRole = domainReqRole;
		this.domainProvRole = domainProvRole;
	}

	/**
	 * Append an internal action in the chain of actions to be executed before the delegating call
	 * @param signatureDependentDemand A description of the internal action's demand
	 */
	public void appendPreAction(
			AbstractActionDescriptor signatureDependentDemand) {
		this.preActions.add(signatureDependentDemand);
	}

	/**
	 * Append an internal action in the chain of actions to be executed after the delegating call
	 * @param signatureDependentDemand A description of the internal action's demand
	 */
	public void appendPostAction(
			AbstractActionDescriptor signatureDependentDemand) {
		this.postActions.add(signatureDependentDemand);
	}	
	
	public void build() {
		for (OperationSignature providedService : domainProvRole.getProvidedInterface__OperationProvidedRole().getSignatures__OperationInterface()){
			ResourceDemandingSEFF seff = buildSeff(providedService);
			this.createdSeffs.add(seff);
		}
	}
	
	
	@Override
	protected ResourceDemandingSEFF buildSeff(OperationSignature signature) {
		ResourceDemandingSEFF seff = super.buildSeff(signature);
		StartAction start = SeffFactory.eINSTANCE.createStartAction();
		AbstractAction lastAction = start;
		
		setSignatureInActions(preActions,signature);
		setSignatureInActions(postActions,signature);
		
		for (AbstractActionDescriptor descriptor : preActions) {
			AbstractAction action = descriptor.createAction();
			lastAction = createControlFlow(lastAction,action);
			seff.getSteps_Behaviour().add(action);
		}
	
		DelegatingExternalCallAction delegatingCall = CompletionsFactory.eINSTANCE.createDelegatingExternalCallAction();
		delegatingCall.setCalledService_ExternalService(signature);
		delegatingCall.setRole_ExternalService(domainReqRole);
		lastAction = createControlFlow(lastAction, delegatingCall);
	
		for (AbstractActionDescriptor descriptor : postActions) {
			AbstractAction action = descriptor.createAction();
			lastAction = createControlFlow(lastAction,action);
			seff.getSteps_Behaviour().add(action);
		}
		
		StopAction stop = SeffFactory.eINSTANCE.createStopAction();
		createControlFlow(lastAction, stop);
		
		Collections.addAll(seff.getSteps_Behaviour(), start,stop,delegatingCall);
		
		return seff;
	}

	private void setSignatureInActions(
			ArrayList<AbstractActionDescriptor> actions, OperationSignature sig) {
		for (AbstractActionDescriptor descriptor : actions) {
			if (descriptor instanceof ISignatureDependentAction) {
				ISignatureDependentAction sigDescriptor = (ISignatureDependentAction) descriptor;
				sigDescriptor.setCurrentSignature(sig);
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see de.uka.sdq.pcm.transformations.builder.seff.ISeffBuilder#getSeff(de.uka.ipd.sdq.pcm.repository.Signature)
	 */
	public List<ResourceDemandingSEFF> getSeffs() {
		return Collections.unmodifiableList(this.createdSeffs);
	}
}
