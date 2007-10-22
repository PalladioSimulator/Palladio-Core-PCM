package de.uka.ipd.sdq.pcmsolver.transformations;

import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext;
import de.uka.ipd.sdq.context.computed_allocation.ResourceDemand;
import de.uka.ipd.sdq.context.computed_usage.BranchProbability;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallInput;
import de.uka.ipd.sdq.context.computed_usage.Input;
import de.uka.ipd.sdq.context.computed_usage.LoopIteration;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.StringNotPDFException;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;

public class ContextWrapper implements Cloneable{

	private AssemblyContext assCtx;
	private AllocationContext allCtx;
	private ComputedAllocationContext compAllCtx;
	private ComputedUsageContext compUsgCtx;
	private PCMInstance pcmInstance;
	
	private HashMap<AbstractBranchTransition, Double> branchProbs;
	private HashMap<AbstractLoopAction, ManagedPMF> loopIters;
	private HashMap<ParametricResourceDemand, ManagedPDF> resDemands;
	private HashMap<ParametricResourceDemand, ProcessingResourceSpecification> procResources;
	private HashMap<ExternalCallAction, CommunicationLinkResourceSpecification> linkResources;

	
	public ContextWrapper(EntryLevelSystemCall elsa, PCMInstance pcm){
		pcmInstance = pcm;
		assCtx = getFirstAssemblyContext(elsa);
		allCtx = getNextAllocationContext(assCtx);
		compUsgCtx = getFirstComputedUsageContext(elsa);
		compAllCtx = getNextComputedAllocationContext();
		readComputedContextsToHashMaps();	
		
		
		
		
	}
	
	public ContextWrapper(EntryLevelSystemCall elsa, PCMInstance pcm, ComputedUsageContext cuc, ComputedAllocationContext cac){
		pcmInstance = pcm;
		assCtx = getFirstAssemblyContext(elsa);
		allCtx = getNextAllocationContext(assCtx);
		handleComputedContexts(cuc, cac);	
	}

	public ContextWrapper(ExternalCallAction eca, ComputedUsageContext cuc, ComputedAllocationContext cac, ContextWrapper oldContextWrapper){
		pcmInstance = oldContextWrapper.getPcmInstance();
		assCtx = oldContextWrapper.getNextAssemblyContext(eca);
		allCtx = getNextAllocationContext(assCtx);
		handleComputedContexts(cuc, cac);
	}
	
	protected ContextWrapper(){
	}
	
	@Override
	public Object clone() {
		ContextWrapper clonedWrapper = new ContextWrapper();
		clonedWrapper.setAssCtx(assCtx);
		clonedWrapper.setAllCtx(allCtx);
		clonedWrapper.setCompAllCtx(compAllCtx);
		clonedWrapper.setCompUsgCtx(compUsgCtx);
		clonedWrapper.setPcmInstance(pcmInstance);
		clonedWrapper.readComputedContextsToHashMaps();	
		return clonedWrapper;
	}
	
	private void handleComputedContexts(ComputedUsageContext cuc,
			ComputedAllocationContext cac) {
		compUsgCtx = cuc;
		compUsgCtx.setAssemblyContext_ComputedUsageContext(assCtx);
		compAllCtx = cac;
		compAllCtx.setAllocationContext_ComputedAllocationContext(allCtx);
		readComputedContextsToHashMaps();
	}
	
	
	public ContextWrapper getContextWrapperFor(ExternalCallAction eca){
		assCtx = getNextAssemblyContext(eca);
		allCtx = getNextAllocationContext(assCtx);
		compUsgCtx = getNextComputedUsageContext(eca);
		compAllCtx = getNextComputedAllocationContext();
		readComputedContextsToHashMaps();
		return this;
	}


	public ContextWrapper getContextWrapperFor(EntryLevelSystemCall elsa){
		assCtx = getFirstAssemblyContext(elsa);
		allCtx = getNextAllocationContext(assCtx);
		compUsgCtx = getFirstComputedUsageContext(elsa);
		compAllCtx = getNextComputedAllocationContext();
		readComputedContextsToHashMaps();
		return this;
	}
	
	public double getBranchProbability(AbstractBranchTransition abt){
		return branchProbs.get(abt);
	}


	public ManagedPMF getLoopIterations(AbstractLoopAction ala){
		return loopIters.get(ala);
	}


	public ManagedPDF getTimeConsumption(ParametricResourceDemand prd){
		return resDemands.get(prd);
	}


	public ManagedPDF getDelayOnLinkingResource(ExternalCallAction eca, CommunicationLinkResourceSpecification clrs){
		EList<ExternalCallInput> eciList = compUsgCtx.getExternalCallInput_ComputedUsageContext();
		long byteSize = 0;
		for (ExternalCallInput eci : eciList){
			if (eci.getExternalCallAction_ExternalCallInput().getId().equals(eca.getId())){
				// getByteSize of all parameters
			}
		}
		return null;
	}


	public ProcessingResourceSpecification getConcreteProcessingResource(ParametricResourceDemand prd){
		return procResources.get(prd);
	}


	public PassiveResource getConcretePassiveResource(AcquireAction aa){
		// TODO: Passive Resource should depend on AssemblyContext
		return aa.getPassiveresource_AcquireAction();
	}


	public PassiveResource getConcretePassiveResource(ReleaseAction ra){
		// TODO: Passive Resource should depend on AssemblyContext
		return ra.getPassiveResource_ReleaseAction();
	}


	public CommunicationLinkResourceSpecification getConcreteLinkingResource(ExternalCallAction eca){
		return linkResources.get(eca);
	}

	public ServiceEffectSpecification getNextSEFF(ExternalCallAction eca){
		AssemblyContext ac = getNextAssemblyContext(eca);
		Signature sig = eca.getCalledService_ExternalService();
		if (ac != null)
			return getSeff(ac, sig);
		else
			return null;
	}

	public ServiceEffectSpecification getNextSEFF(EntryLevelSystemCall elsc){
		AssemblyContext ac = getFirstAssemblyContext(elsc);
		Signature sig = elsc.getSignature_EntryLevelSystemCall();
		if (ac != null)
			return getSeff(ac, sig);
		else
			return null;
	}

	private ServiceEffectSpecification getSeff(AssemblyContext ac, Signature sig) {
		ProvidesComponentType pct = ac.getEncapsulatedComponent_ChildComponentContext();
		
		if (pct instanceof BasicComponent){
			String serviceName = sig.getServiceName();
			BasicComponent bc = (BasicComponent) pct;
			EList<ServiceEffectSpecification> seffList = bc
					.getServiceEffectSpecifications__BasicComponent();
			for (ServiceEffectSpecification seff : seffList) {
				if (seff.getDescribedService__SEFF().getServiceName().equals(
						serviceName)) {
					return seff;
				}
			}
		} else if (pct instanceof CompositeComponent){ 
			// TODO: support other component types
		}
		return null;
	}
	
	private ComputedUsageContext getFirstComputedUsageContext(
			EntryLevelSystemCall elsa) {
		EList<VariableUsage> vuList = elsa.getInputParameterUsages_EntryLevelSystemCall();
		return matchVariableUsages(vuList);
	}


	private AssemblyContext getFirstAssemblyContext(EntryLevelSystemCall elsa) {
		Signature serviceToBeCalled = elsa.getSignature_EntryLevelSystemCall();
		Interface requiredInterface = (Interface) serviceToBeCalled.eContainer();

		ProvidedRole role = elsa.getProvidedRole_EntryLevelSystemCall();

		EList<ProvidedDelegationConnector> pdcList = pcmInstance.getSystem().getProvidedDelegationConnectors_ComposedStructure();
		for (ProvidedDelegationConnector pdc : pdcList){
			if (pdc.getOuterProvidedRole_ProvidedDelegationConnector().getId().equals(role.getId())){
				pdc.getChildComponentContext_ProvidedDelegationConnector();
				return pdc.getChildComponentContext_ProvidedDelegationConnector();
				//TODO: testen, abfrage interface?
			}
		}
		return null;
	}

	private void readComputedContextsToHashMaps() {
		branchProbs = new HashMap<AbstractBranchTransition, Double>();
		EList<BranchProbability> bpList = compUsgCtx.getBranchProbabilities_ComputedUsageContext();
		for (BranchProbability bp : bpList){
			branchProbs.put(bp.getBranchtransition_BranchProbability(), bp.getProbability());
		}
		
		loopIters = new HashMap<AbstractLoopAction, ManagedPMF>();
		EList<LoopIteration> liList = compUsgCtx.getLoopiterations_ComputedUsageContext();
		for (LoopIteration li : liList){
			String spec = li.getSpecification_LoopIteration().getSpecification();
			ManagedPMF pmf = null;
			try {
				pmf = ManagedPMF.createFromString(spec);
			} catch (StringNotPDFException e) {
				e.printStackTrace();
			} catch (RecognitionException e) {
				e.printStackTrace();
			}
			loopIters.put(li.getLoopaction_LoopIteration(), pmf);
		}
		
		resDemands = new HashMap<ParametricResourceDemand, ManagedPDF>();
		EList<ResourceDemand> rdList = compAllCtx.getResourceDemands_ComputedAllocationContext();
		for (ResourceDemand rd : rdList){
			String spec = rd.getSpecification_ResourceDemand().getSpecification();
			ManagedPDF pdf = null;
			try {
				pdf = ManagedPDF.createFromString(spec);
			} catch (StringNotPDFException e) {
				e.printStackTrace();
			} catch (RecognitionException e) {
				e.printStackTrace();
			}
			resDemands.put(rd.getParametricResourceDemand_ResourceDemand(), pdf);
		}
		
		procResources = new HashMap<ParametricResourceDemand, ProcessingResourceSpecification>();
		for (ResourceDemand rd : rdList){
			ParametricResourceDemand prd = rd.getParametricResourceDemand_ResourceDemand();
			String prtName = prd.getRequiredResource_ParametricResourceDemand().getEntityName();
			EList<ProcessingResourceSpecification> prsList = allCtx.getResourceContainer_AllocationContext().getActiveResourceSpecifications_ResourceContainer();
			for (ProcessingResourceSpecification prs : prsList){
				String prsName = prs.getActiveResourceType_ActiveResourceSpecification().getEntityName();
				if (prsName.equals(prtName)){
					procResources.put(prd, prs);
				}
			}
		}
		
		linkResources = new HashMap<ExternalCallAction, CommunicationLinkResourceSpecification>();

		EList<ExternalCallInput> eciList = compUsgCtx.getExternalCallInput_ComputedUsageContext();
		EList<LinkingResource> lrList = pcmInstance.getResourceEnvironment().getLinkingresource();
		ResourceContainer rc1 = allCtx.getResourceContainer_AllocationContext();
		for (ExternalCallInput eci : eciList){
			ExternalCallAction eca = eci
					.getExternalCallAction_ExternalCallInput();

			AssemblyContext nextAssCtx = getNextAssemblyContext(eca);
			AllocationContext nextAllCtx = getNextAllocationContext(nextAssCtx);
			ResourceContainer rc2 = nextAllCtx
					.getResourceContainer_AllocationContext();
			
			for (LinkingResource lr : lrList){
				if (lr.getFromResourceContainer_LinkingResource().contains(rc1) 
				 && lr.getToResourceContainer_LinkingResource().contains(rc2)) {
					// TODO: TEST!! (does contains work?) 
					CommunicationLinkResourceSpecification clrs = lr.getCommunicationLinkResourceSpecifications_LinkingResource();
					linkResources.put(eca, clrs);
				}
			}
		}
	}
	
	private ComputedAllocationContext getNextComputedAllocationContext() {
		EList<ComputedAllocationContext> allCtxList = pcmInstance
				.getComputedAllocation()
				.getComputedAllocationContexts_ComputedAllocation();
		for (ComputedAllocationContext cac : allCtxList) {
			if (cac.getAllocationContext_ComputedAllocationContext().getId().equals(allCtx.getId())
			 && cac.getUsageContext_ComputedAllocationContext().getId().equals(compUsgCtx.getId())) {
				return cac;
			}
		}
		// TODO: throw exception
		return null;
	}

	private ComputedUsageContext getNextComputedUsageContext(ExternalCallAction eca) {
		EList<ExternalCallInput> eciList = compUsgCtx.getExternalCallInput_ComputedUsageContext();
		for(ExternalCallInput eci : eciList){
			if (eci.getExternalCallAction_ExternalCallInput().getId().equals(eca.getId())){
				EList<VariableUsage> inputVUList = eci.getParameterCharacterisations_ExternalCallInput();
				ComputedUsageContext cuc = matchVariableUsages(inputVUList);
				if (cuc!=null) return cuc;
			}
		}
		// TODO: throw exception
		return null;
	}

	private ComputedUsageContext matchVariableUsages(EList<VariableUsage> vuList){
		EList<ComputedUsageContext> cucList = pcmInstance.getComputedUsage().getUsageContexts_ComputedUsage();
		for (ComputedUsageContext cuc : cucList){
			if (cuc.getAssemblyContext_ComputedUsageContext().getId().equals(assCtx.getId())){
				Input input = cuc.getInput_ComputedUsageContext();
				EList<VariableUsage> vuList2 = input.getParameterChacterisations_Input();
				
				if (areEqual(vuList, vuList2)){
					return cuc;
				}
			}
		}
		// TODO: throw exception
		return null;
	}
	
	private boolean areEqual(EList<VariableUsage> vuList1,
			EList<VariableUsage> vuList2) {
		
		int varUsgCounter = 0;
		for (VariableUsage vu1 : vuList1){
			for (VariableUsage vu2: vuList2){
				if (getFullParameterName(vu1.getNamedReference_VariableUsage())
						.equals(
					getFullParameterName(vu2.getNamedReference_VariableUsage()))) {
					EList<VariableCharacterisation> vcList = vu1.getVariableCharacterisation_VariableUsage();
					int varCharFoundCounter = 0;

					for (VariableCharacterisation vc1 : vcList){
						EList<VariableCharacterisation> vcList2 = vu2.getVariableCharacterisation_VariableUsage();
						boolean singleVarCharFound = false;
						for (VariableCharacterisation vc2 : vcList2){
							 if (vc1.getType().getLiteral().equals(vc2.getType().getLiteral())
							  && vc1.getSpecification_VariableCharacterisation().getSpecification().equals(vc2.getSpecification_VariableCharacterisation().getSpecification())){
								 singleVarCharFound = true;
							 }
						}
						// found a single matching characterisation
						if (singleVarCharFound) varCharFoundCounter++; 
					}
					// all characterisations for a parameter found:
					if (varCharFoundCounter == vcList.size()) varUsgCounter++;
				}
			}
		}
		// return true if all matching variable usages found 
		return (varUsgCounter == vuList1.size());
	}
	
	private String getFullParameterName(AbstractNamedReference ref) {
		String name = ""; 
		while (ref instanceof NamespaceReference){
			NamespaceReference nsRef = (NamespaceReference)ref;
			name += nsRef.getReferenceName() + ".";
			ref = nsRef.getInnerReference_NamespaceReference();
		}
		return name += ref.getReferenceName();
	}
	
	private AllocationContext getNextAllocationContext(AssemblyContext nextAssCtx) {
		// The following assumes that there is only one allocation
		// context for each assembly context. This is a preliminary
		// simplification until further concepts for component 
		// replication are worked out.
		
		EList<AllocationContext> allCtxList = pcmInstance.getAllocation()
				.getAllocationContexts_Allocation();
	
		for (AllocationContext allCtx : allCtxList) {
			if (allCtx.getAssemblyContext_AllocationContext().getId().equals(
					nextAssCtx.getId())) {
				return allCtx;
			}
		}
		// TODO: throw exception
		return null;
	}

	private AssemblyContext getNextAssemblyContext(ExternalCallAction eca) {
		Signature serviceToBeCalled = eca.getCalledService_ExternalService();
		Interface requiredInterface = (Interface) serviceToBeCalled.eContainer();

		AssemblyConnector matchingAssConn = null;
		EList<AssemblyConnector> assConnList = pcmInstance.getSystem()
				.getCompositeAssemblyConnectors_ComposedStructure();
		for (AssemblyConnector assConn : assConnList) {
			if (assConn
					.getRequiringChildComponentContext_CompositeAssemblyConnector()
					.getId().equals(assCtx.getId())
			 && assConn
			 		.getRequiredRole_CompositeAssemblyConnector()
					.getRequiredInterface__RequiredRole().getId()
					.equals(requiredInterface.getId())) {
				matchingAssConn = assConn;
			}
		}

		if (matchingAssConn != null){
			return matchingAssConn
			.getProvidingChildComponentContext_CompositeAssemblyConnector();
		} else 
			return null;
	}

	public AssemblyContext getAssCtx() {
		return assCtx;
	}

	public void setAssCtx(AssemblyContext assCtx) {
		this.assCtx = assCtx;
	}

	public AllocationContext getAllCtx() {
		return allCtx;
	}

	public void setAllCtx(AllocationContext allCtx) {
		this.allCtx = allCtx;
	}

	public ComputedAllocationContext getCompAllCtx() {
		return compAllCtx;
	}

	public void setCompAllCtx(ComputedAllocationContext compAllCtx) {
		this.compAllCtx = compAllCtx;
	}

	public ComputedUsageContext getCompUsgCtx() {
		return compUsgCtx;
	}

	public void setCompUsgCtx(ComputedUsageContext compUsgCtx) {
		this.compUsgCtx = compUsgCtx;
	}

	public PCMInstance getPcmInstance() {
		return pcmInstance;
	}

	public void setPcmInstance(PCMInstance pcmInstance) {
		this.pcmInstance = pcmInstance;
	}
	
}
