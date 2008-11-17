package de.uka.ipd.sdq.pcmsolver.transformations;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory;
import de.uka.ipd.sdq.context.computed_allocation.ResourceDemand;
import de.uka.ipd.sdq.context.computed_usage.BranchProbability;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
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
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;
import de.uka.ipd.sdq.pcmsolver.handler.ExternalCallActionHandler;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.VariableUsageHelper;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.StringNotPDFException;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;

public class ContextWrapper implements Cloneable{

	private static Logger logger = Logger.getLogger(ContextWrapper.class.getName());
	
	private AssemblyContext assCtx;
	private AllocationContext allCtx;
	private ComputedAllocationContext compAllCtx;
	private ComputedUsageContext compUsgCtx;
	private PCMInstance pcmInstance;
	
	private HashMap<AbstractBranchTransition, Double> branchProbs;
	private HashMap<AbstractLoopAction, ManagedPMF> loopIters;
	private HashMap<ParametricResourceDemand, ProbabilityDensityFunction> resDemands;
	private HashMap<ParametricResourceDemand, ProcessingResourceSpecification> procResources;
	private HashMap<ExternalCallAction, CommunicationLinkResourceSpecification> linkResources;


	public ContextWrapper(PCMInstance pcm){
		pcmInstance = pcm;
	}

	
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
		return new ManagedPDF(resDemands.get(prd));
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
			CompositeComponent cc = (CompositeComponent)pct;
			EList<AssemblyContext> inner = cc.getChildComponentContexts_ComposedStructure();
			if (inner.size() == 0){
				logger.error("Empty CompositeComponent "+cc.getEntityName());
				throw new RuntimeException("Empty CompositeComponent "+cc.getEntityName());
			}
			logger.debug("Retrieving inner SEFF of CompositeComponent "+cc.getEntityName());
			//recursive call of this method for the internals of the CompositeComponent
			return getSeff(inner.get(0),sig);
		}
		return null;
	}
	
	private ComputedUsageContext getFirstComputedUsageContext(
			EntryLevelSystemCall elsa) {
		logger.info("In getFirstComputedUsageContext");
		
		EList<VariableUsage> vuList = elsa.getInputParameterUsages_EntryLevelSystemCall();
		ComputedUsageContext cuc = matchVariableUsages(vuList);
		if (cuc!=null){
			logger.info("Reusing existing computed usage context for "+assCtx.getEntityName());
			return cuc;
		} else {
			logger.info("Creating new computed usage context for "+assCtx.getEntityName());

			ComputedUsageContext newCompUsgCtx = ComputedUsageFactory.eINSTANCE.createComputedUsageContext();
			pcmInstance.getComputedUsage().getUsageContexts_ComputedUsage().add(newCompUsgCtx);
			
			newCompUsgCtx.setAssemblyContext_ComputedUsageContext(assCtx);
			
			Input newInput = ComputedUsageFactory.eINSTANCE.createInput();
			newCompUsgCtx.setInput_ComputedUsageContext(newInput);
			
			EList<VariableUsage> parList = elsa.getInputParameterUsages_EntryLevelSystemCall();
			for (VariableUsage vu : parList) {
				VariableUsageHelper.copySolvedVariableUsageToInput(newCompUsgCtx.getInput_ComputedUsageContext(), this, vu);
			}
			
			addComponentParametersToNewContext(newCompUsgCtx);
			return newCompUsgCtx;
		}
	}


	private AssemblyContext getFirstAssemblyContext(EntryLevelSystemCall elsa) {
		Signature serviceToBeCalled = elsa.getSignature_EntryLevelSystemCall();
		Interface requiredInterface = (Interface) serviceToBeCalled.eContainer();

		ProvidedRole role = elsa.getProvidedRole_EntryLevelSystemCall();

		try {
		EList<ProvidedDelegationConnector> pdcList = pcmInstance.getSystem().getProvidedDelegationConnectors_ComposedStructure();
		for (ProvidedDelegationConnector pdc : pdcList){
			if (pdc.getOuterProvidedRole_ProvidedDelegationConnector().getId().equals(role.getId())){
				//pdc.getChildComponentContext_ProvidedDelegationConnector();
				return pdc.getChildComponentContext_ProvidedDelegationConnector();
				//TODO: testen, abfrage interface?
			}
		}
		//If ProvidedDelegationConnectors are not bound to outer roles (for example you changed your Systems only interface, deleting the old one, and a danglin ProvidedConnector remains), NullPointerEcxeptions can occur in the upper part.  
		} catch (RuntimeException e){
			throw new RuntimeException("Something is wrong with your ProvidedDelegationConnectors: Are they all bound to proper roles?",e);
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
		
		//resDemands = new HashMap<ParametricResourceDemand, ManagedPDF>();
		resDemands = new HashMap<ParametricResourceDemand, ProbabilityDensityFunction>();
		EList<ResourceDemand> rdList = compAllCtx.getResourceDemands_ComputedAllocationContext();
		for (ResourceDemand rd : rdList){
			String spec = rd.getSpecification_ResourceDemand().getSpecification();
			ProbabilityFunctionLiteral blah = (ProbabilityFunctionLiteral)ExpressionHelper.parseToExpression(spec);
			ProbabilityDensityFunction pdf = (ProbabilityDensityFunction)blah.getFunction_ProbabilityFunctionLiteral();
//			ManagedPDF pdf = null;
//			try {
//				pdf = ManagedPDF.createFromString(spec);
//			} catch (StringNotPDFException e) {
//				e.printStackTrace();
//			} catch (RecognitionException e) {
//				e.printStackTrace();
//			}
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

//		EList<ExternalCallInput> eciList = compUsgCtx.getExternalCallInput_ComputedUsageContext();
//		EList<LinkingResource> lrList = pcmInstance.getResourceEnvironment().getLinkingresource();
//		ResourceContainer rc1 = allCtx.getResourceContainer_AllocationContext();
//		for (ExternalCallInput eci : eciList){
//			ExternalCallAction eca = eci
//					.getExternalCallAction_ExternalCallInput();
//
//			AssemblyContext nextAssCtx = getNextAssemblyContext(eca);
//			AllocationContext nextAllCtx = getNextAllocationContext(nextAssCtx);
//			ResourceContainer rc2 = nextAllCtx
//					.getResourceContainer_AllocationContext();
//			
//			for (LinkingResource lr : lrList){
//				if (lr.getFromResourceContainer_LinkingResource().contains(rc1) 
//				 && lr.getToResourceContainer_LinkingResource().contains(rc2)) {
//					// TODO: TEST!! (does contains work?) 
//					CommunicationLinkResourceSpecification clrs = lr.getCommunicationLinkResourceSpecifications_LinkingResource();
//					linkResources.put(eca, clrs);
//				}
//			}
//		}
	}
	
	private ComputedAllocationContext getNextComputedAllocationContext() {
		logger.info("In getNextComputedAllocationContext ");
		
		ComputedAllocationContext cac = getExistingComputedAllocationContext();
		if (cac!=null){
			logger.info("Reusing existing computed allocation context for "+assCtx.getEntityName());
			return cac;
		} else {
			logger.info("Creating new computed allocation context for "+assCtx.getEntityName());
			ComputedAllocationContext newCompAllCtx = ComputedAllocationFactory.eINSTANCE.createComputedAllocationContext();
			pcmInstance.getComputedAllocation().getComputedAllocationContexts_ComputedAllocation().add(newCompAllCtx);
			newCompAllCtx.setUsageContext_ComputedAllocationContext(compUsgCtx);
			newCompAllCtx.setAllocationContext_ComputedAllocationContext(allCtx);
			return newCompAllCtx;
		}
	}

	private ComputedAllocationContext getExistingComputedAllocationContext() {
		EList<ComputedAllocationContext> allCtxList = pcmInstance
				.getComputedAllocation()
				.getComputedAllocationContexts_ComputedAllocation();
		for (ComputedAllocationContext cac : allCtxList) {
			if (cac.getAllocationContext_ComputedAllocationContext().getId()
					.equals(allCtx.getId())
					&& cac.getUsageContext_ComputedAllocationContext().getId()
							.equals(compUsgCtx.getId())) {
				return cac;
			}
		}
		return null;
	}

	/**
	 * @param eca
	 * @return
	 */
	private ComputedUsageContext getNextComputedUsageContext(ExternalCallAction eca) {
		logger.info("In getNextComputedUsageContext "+eca.getEntityName());
		
		ComputedUsageContext cuc = getExistingComputedUsageContext(eca);
		if (cuc!=null){
			logger.info("Reusing existing computed usage context for "+assCtx.getEntityName());
			return cuc;
		} else {
			logger.info("Creating new computed usage context for "+assCtx.getEntityName());
			return createNewComputedUsageContext(eca);
		}
	}

	private ComputedUsageContext createNewComputedUsageContext(ExternalCallAction eca) {
		// create new computed usage context
		ComputedUsageContext newCompUsgCtx = ComputedUsageFactory.eINSTANCE.createComputedUsageContext();
		pcmInstance.getComputedUsage().getUsageContexts_ComputedUsage().add(newCompUsgCtx);
		
		newCompUsgCtx.setAssemblyContext_ComputedUsageContext(assCtx);
		
		Input newInput = ComputedUsageFactory.eINSTANCE.createInput();
		newCompUsgCtx.setInput_ComputedUsageContext(newInput);
		
		EList<VariableUsage> parList = eca.getInputParameterUsages_ExternalCallAction();
		for (VariableUsage vu : parList) {
			VariableUsageHelper.copySolvedVariableUsageToInput(newCompUsgCtx.getInput_ComputedUsageContext(), this, vu);
		}
		
		//TODO: add default component parameters by component developer
		addComponentParametersToNewContext(newCompUsgCtx);
		
		return newCompUsgCtx;
	}

	private void addComponentParametersToNewContext(
			ComputedUsageContext newCompUsgCtx) {
		//TODO: add default component parameters by component developer

		EList<VariableUsage> confParList = this.getAssCtx().getConfigParameterUsages_AssemblyContext();
		for (VariableUsage vu : confParList) {
			VariableUsageHelper.copySolvedVariableUsageToInput(newCompUsgCtx.getInput_ComputedUsageContext(), this, vu);
		}
		
		UsageModel um = this.getPcmInstance().getUsageModel();
		EList<UserData> userDataList = um.getUserData_UsageModel();
		for (UserData ud : userDataList){
			if (ud.getAssemblyContext_userData().getId().equals(
					this.getAssCtx().getId())) {
				EList<VariableUsage> userParList = ud.getUserDataParameterUsages_UserData();
				for (VariableUsage vu : userParList){
					VariableUsageHelper.copySolvedVariableUsageToInput(newCompUsgCtx.getInput_ComputedUsageContext(), this, vu);
				}
			}
		}
	}

	private ExternalCallInput addExternalCallInputToCurrentContext(ExternalCallAction eca) {
		EList<VariableUsage> parList = eca.getInputParameterUsages_ExternalCallAction();
		ExternalCallInput eci = ComputedUsageFactory.eINSTANCE.createExternalCallInput();
		eci.setExternalCallAction_ExternalCallInput(eca);
		compUsgCtx.getExternalCallInput_ComputedUsageContext().add(eci);
		for (VariableUsage vu : parList) {
			VariableUsageHelper.copySolvedVariableUsageToExternalCallInput(this, eci, vu);
		}
		return eci;
	}

	private ComputedUsageContext getExistingComputedUsageContext(ExternalCallAction eca){
		EList<ExternalCallInput> eciList = compUsgCtx.getExternalCallInput_ComputedUsageContext();
		if (eciList.size()==0){
			EList<ComputedUsageContext> cucList = pcmInstance.getComputedUsage().getUsageContexts_ComputedUsage();
			for (ComputedUsageContext cuc : cucList){
				// assCtx already points to the next assCtx after the external call
				if (cuc.getAssemblyContext_ComputedUsageContext().getId().equals(assCtx.getId()) 
						&& cuc.getInput_ComputedUsageContext().getParameterChacterisations_Input().size()==0){
					return cuc;
				}
			}
			// matching external call input does not exist, create new one
			ExternalCallInput extCallIn = addExternalCallInputToCurrentContext(eca);
			// check whether following computed usage context contains matching input
			EList<VariableUsage> inputVUList = extCallIn.getParameterCharacterisations_ExternalCallInput();
			ComputedUsageContext cuc = matchVariableUsages(inputVUList);
			if (cuc != null) return cuc;
		} else {
			// check if matching external call input already exists
			for (ExternalCallInput eci : eciList) {
				if (eci.getExternalCallAction_ExternalCallInput().getId()
						.equals(eca.getId())) {
					EList<VariableUsage> inputVUList = eci
							.getParameterCharacterisations_ExternalCallInput();

					ComputedUsageContext cuc = matchVariableUsages(inputVUList);
					if (cuc != null)
						return cuc;
				} 
			}
			// matching external call input does not exist, create new one
			ExternalCallInput extCallIn = addExternalCallInputToCurrentContext(eca);
			// check whether following computed usage context contains matching input
			EList<VariableUsage> inputVUList = extCallIn.getParameterCharacterisations_ExternalCallInput();
			ComputedUsageContext cuc = matchVariableUsages(inputVUList);
			if (cuc != null) return cuc;
		}
		return null;
	}
	
	private ComputedUsageContext matchVariableUsages(EList<VariableUsage> vuList){
		EList<ComputedUsageContext> cucList = pcmInstance.getComputedUsage().getUsageContexts_ComputedUsage();
		for (ComputedUsageContext cuc : cucList){
			if (cuc.getAssemblyContext_ComputedUsageContext().getId().equals(assCtx.getId())){
				Input input = cuc.getInput_ComputedUsageContext();
				EList<VariableUsage> vuList2 = input.getParameterChacterisations_Input();
				
//				logger.info("List1: "+vuList);
//				logger.info("List2: "+vuList2);
				
				if (areEqual(vuList, vuList2)){
					//logger.info("Are Equal Successful!");
					return cuc;
				}
			}
		}
		logger.info("Matching Input Variables for External Call failed.");

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

	public AssemblyContext getNextAssemblyContext(ExternalCallAction eca) {
		Signature serviceToBeCalled = eca.getCalledService_ExternalService();
		Interface requiredInterface = (Interface) serviceToBeCalled.eContainer();

		AssemblyConnector matchingAssConn = null;
		EList<AssemblyConnector> assConnList = pcmInstance.getSystem()
				.getCompositeAssemblyConnectors_ComposedStructure();
		for (AssemblyConnector assConn : assConnList) {
			String myAssId = assCtx.getId();
			String assId = assConn.getRequiringChildComponentContext_CompositeAssemblyConnector().getId();
			
			String myIfId = requiredInterface.getId();
			String ifId = assConn.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole().getId();
			
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
