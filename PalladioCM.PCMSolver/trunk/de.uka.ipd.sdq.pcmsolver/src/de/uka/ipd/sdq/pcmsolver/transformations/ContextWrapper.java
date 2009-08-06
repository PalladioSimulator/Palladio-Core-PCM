package de.uka.ipd.sdq.pcmsolver.transformations;

import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
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
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.VariableUsageHelper;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.StringNotPDFException;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;

/**
 * For convenient implementation of model transformations in Java from PCM
 * instances to performance models, the DS provides a so-called ContextWrapper.
 * It hides all specified and computed context models from the transformation
 * and assists the traversal of a PCM instance. A transformation can instantiate
 * a new ContextWrapper upon visiting an EntryLevelSystemCall or
 * ExternalCallAction as it is specific for each RDSEFF call.
 * 
 * Transformations must instantiate a ContextWrapper initially when visiting the
 * first EntryLevelSystemCall by calling its constructor and passing a
 * reference to the current PCM instance, which already includes the specified
 * contexts as well as the computed contexts from a former run of the DS. Thus,
 * from an EntryLevelSystemCall and the given PCM instance, the ContextWrapper
 * can retrieve the called assembly context, allocation context, computed usage
 * context, and computed allocation context internally. The ContextWrapper also
 * includes functions to retrieve the RDSEFF called by an EntryLevelSystemCall
 * or ExternalCallAction, which a transformation needs to continue traversing a
 * PCM instance. These functions (getNextSEFF) hide the context-dependent
 * traversal through the model via delegation and assembly connectors from the
 * transformation.
 * 
 * When a model transformation visits RDSEFF actions, it may call the Context-
 * Wrapper for performance annotations, such as branch probabilities, loop
 * iteration numbers, or timing values. This information is not contained in the
 * parameterized RDSEFF, but only in the computed contexts. The ContextWrapper
 * retrieves the information from the computed contexts given for example an
 * AbstractBranchTransition or ParametricResourceDemand.
 * 
 * @see Heiko's dissertation, section 6.2.4 at
 *      http://docserver.bis.uni-oldenburg.de/_publikationen/dissertation/2008/kozpar08/pdf/kozpar08.pdf
 * @author Heiko Koziolek
 * 
 */
public class ContextWrapper implements Cloneable {

	private static Logger logger = Logger.getLogger(ContextWrapper.class
			.getName());

	//private AssemblyContext assCtx;
	private EList<AssemblyContext> assCtxList;
	private AllocationContext allCtx;
	private ComputedAllocationContext compAllCtx;
	private ComputedUsageContext compUsgCtx;
	private PCMInstance pcmInstance;

	private HashMap<AbstractBranchTransition, Double> branchProbs;
	private HashMap<AbstractLoopAction, ManagedPMF> loopIters;
	/** Contains the already solved resource demand in time on the specific processor */
	private HashMap<ParametricResourceDemand, ProbabilityDensityFunction> resDemands;
	private HashMap<ParametricResourceDemand, ProcessingResourceSpecification> procResources;
	private HashMap<ExternalCallAction, CommunicationLinkResourceSpecification> linkResources;
	
	public ContextWrapper(PCMInstance pcm) {
		pcmInstance = pcm;
	}

	public ContextWrapper(EntryLevelSystemCall elsa, PCMInstance pcm) {
		pcmInstance = pcm;
		//assCtx = getFirstAssemblyContext(elsa);
		//allCtx = getNextAllocationContext(assCtx);
		assCtxList = getFirstAssemblyContext2(elsa);
		allCtx = getNextAllocationContext(assCtxList.get(0));
	
		compUsgCtx = getFirstComputedUsageContext(elsa);
		compAllCtx = getNextComputedAllocationContext();
		readComputedContextsToHashMaps();
	}

	public ContextWrapper(EntryLevelSystemCall elsa, PCMInstance pcm,
			ComputedUsageContext cuc, ComputedAllocationContext cac) {
		pcmInstance = pcm;
//		assCtx = getFirstAssemblyContext(elsa);
//		allCtx = getNextAllocationContext(assCtx);
		assCtxList = getFirstAssemblyContext2(elsa);
		allCtx = getNextAllocationContext(assCtxList.get(0));
		
		handleComputedContexts(cuc, cac);
	}

	/**
	 * Attention: This constructor modifies the passed ContextWrapper!
	 * @param eca
	 * @param cuc
	 * @param cac
	 * @param oldContextWrapper IS MODIFIED!
	 */
	public ContextWrapper(ExternalCallAction eca, ComputedUsageContext cuc,
			ComputedAllocationContext cac, ContextWrapper oldContextWrapper) {
		pcmInstance = oldContextWrapper.getPcmInstance();
//		assCtx = oldContextWrapper.getNextAssemblyContext(eca);
//		allCtx = getNextAllocationContext(assCtx);
		assCtxList = oldContextWrapper.getNextAssemblyContext(eca,true);
		allCtx = getNextAllocationContext(assCtxList.get(0));
		
		handleComputedContexts(cuc, cac);
	}

	protected ContextWrapper() {
	}

	@Override
	public Object clone() {
		ContextWrapper clonedWrapper = new ContextWrapper();
		EList<AssemblyContext> list = new BasicEList<AssemblyContext>();
		for (AssemblyContext ac : assCtxList){
			list.add(ac);
		}

		clonedWrapper.setAssCtxList(list);
		//clonedWrapper.setAssCtx(assCtx);
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
		compUsgCtx.setAssemblyContext_ComputedUsageContext(getAssCtx());
		compAllCtx = cac;
		compAllCtx.setAllocationContext_ComputedAllocationContext(allCtx);
		readComputedContextsToHashMaps();
	}

	/**
	 * FIXME: This method changes the current ContextWrapper this 
	 * @param eca
	 * @return this after changing it. 
	 */
	public ContextWrapper getContextWrapperFor(ExternalCallAction eca) {
//		assCtx = getNextAssemblyContext(eca);
//		allCtx = getNextAllocationContext(assCtx);
		assCtxList = getNextAssemblyContext(eca,true);
		allCtx = getNextAllocationContext(assCtxList.get(0));

		compUsgCtx = getNextComputedUsageContext(eca);
		compAllCtx = getNextComputedAllocationContext();
		readComputedContextsToHashMaps();
		return this;
	}

	public ContextWrapper getContextWrapperFor(EntryLevelSystemCall elsa) {
//		assCtx = getFirstAssemblyContext(elsa);
//		allCtx = getNextAllocationContext(assCtx);
		assCtxList = getFirstAssemblyContext2(elsa);
		allCtx = getNextAllocationContext(assCtxList.get(0));
		
		compUsgCtx = getFirstComputedUsageContext(elsa);
		compAllCtx = getNextComputedAllocationContext();
		readComputedContextsToHashMaps();
		return this;
	}

	public double getBranchProbability(AbstractBranchTransition abt) {
		return branchProbs.get(abt);
	}

	public ManagedPMF getLoopIterations(AbstractLoopAction ala) {
		return loopIters.get(ala);
	}

	/**
	 * Gets the time demanded by prd on its processor in this context. 
	 * Note that the processing rate has already been taken into account here.  
	 * @param prd 
	 * @return A ManagedPDF representing the time demanded by prd
	 */
	public ManagedPDF getTimeConsumption(ParametricResourceDemand prd) {
		return new ManagedPDF(resDemands.get(prd));
	}

	public ManagedPDF getDelayOnLinkingResource(ExternalCallAction eca,
			CommunicationLinkResourceSpecification clrs) {
		EList<ExternalCallInput> eciList = compUsgCtx
				.getExternalCallInput_ComputedUsageContext();
		
		for (ExternalCallInput eci : eciList) {
			if (eci.getExternalCallAction_ExternalCallInput().getId().equals(
					eca.getId())) {
				// getByteSize of all parameters
			}
		}
		return null;
	}

	public ProcessingResourceSpecification getConcreteProcessingResource(
			ParametricResourceDemand prd) {
		return procResources.get(prd);
	}

	public PassiveResource getConcretePassiveResource(AcquireAction aa) {
		// TODO: Passive Resource should depend on AssemblyContext
		return aa.getPassiveresource_AcquireAction();
	}

	public PassiveResource getConcretePassiveResource(ReleaseAction ra) {
		// TODO: Passive Resource should depend on AssemblyContext
		return ra.getPassiveResource_ReleaseAction();
	}

	public CommunicationLinkResourceSpecification getConcreteLinkingResource(
			ExternalCallAction eca) {
		return linkResources.get(eca);
	}

	/**
	 * Finds the next SEFF for a given external call action and its
	 * referenced signature. Uses the 
	 * current assembly context ids from the context wrapper as reference.
	 * @param eca
	 * @return
	 */
	public ServiceEffectSpecification getNextSEFF(ExternalCallAction eca) {
		Signature sig = eca.getCalledService_ExternalService();

		// get the list of assembly context ids for the called component
		EList<AssemblyContext> acList = getNextAssemblyContext(eca,false);

		// retrieve the last (most current, most inner nested) assembly context 
		// from the list of assembly context in the context wrapper
		AssemblyContext ac = acList.get(acList.size()-1);
		
		// it should always result in a basic component, because getNextAssemblyContext
		// from above returns either a basic component in the current composite component or 
		// a basic component in the next composite component
		BasicComponent bc = (BasicComponent)ac.getEncapsulatedComponent_AssemblyContext();
		EList<ServiceEffectSpecification> seffList = bc
			.getServiceEffectSpecifications__BasicComponent();
		for (ServiceEffectSpecification seff : seffList) {
			if (seff.getDescribedService__SEFF().getServiceName().equals(sig.getServiceName())) {
				return seff;
			}
		}
		
		// should not happen:
		logger.error("Could not find next SEFF " +
				"for ExternalCallAction "+eca.getCalledService_ExternalService()+"!");
		return null;
	}

	
//	public ServiceEffectSpecification getNextSEFF2(ExternalCallAction eca) {
//		AssemblyContext ac = getNextAssemblyContext(eca);
//		Signature sig = eca.getCalledService_ExternalService();
//		if (ac != null)
//			return getSeff(ac, sig);
//		else
//			return null;
//	}

	public ServiceEffectSpecification getNextSEFF(EntryLevelSystemCall elsc) {
		Signature sig = elsc.getSignature_EntryLevelSystemCall();

		EList<AssemblyContext> acList = getFirstAssemblyContext2(elsc);

		AssemblyContext ac = acList.get(acList.size()-1);
		BasicComponent bc = (BasicComponent)ac.getEncapsulatedComponent_AssemblyContext();
		EList<ServiceEffectSpecification> seffList = bc
			.getServiceEffectSpecifications__BasicComponent();
		for (ServiceEffectSpecification seff : seffList) {
			if (seff.getDescribedService__SEFF().getServiceName().equals(sig.getServiceName())) {
				return seff;
			}
		}
		return null;
	}
	
//	public ServiceEffectSpecification getNextSEFF2(EntryLevelSystemCall elsc) {
//		AssemblyContext ac = getFirstAssemblyContext(elsc);
//		
//		Signature sig = elsc.getSignature_EntryLevelSystemCall();
//		if (ac != null)
//			return getSeff(ac, sig);
//		else
//			return null;
//	}

//	private ServiceEffectSpecification getSeff(AssemblyContext ac, Signature sig) {
//		RepositoryComponent rc = ac.getEncapsulatedComponent_AssemblyContext();
//		
//		if (rc instanceof BasicComponent){
//			String serviceName = sig.getServiceName();
//			BasicComponent bc = (BasicComponent) rc;
//			EList<ServiceEffectSpecification> seffList = bc
//					.getServiceEffectSpecifications__BasicComponent();
//			for (ServiceEffectSpecification seff : seffList) {
//				if (seff.getDescribedService__SEFF().getServiceName().equals(
//						serviceName)) {
//					return seff;
//				}
//			}
//		} else if (rc instanceof CompositeComponent){ 
//			CompositeComponent cc = (CompositeComponent)rc;
//			EList<AssemblyContext> inner = cc.getAssemblyContexts_ComposedStructure();
//			if (inner.size() == 0){
//				logger.error("Empty CompositeComponent "+cc.getEntityName());
//				throw new RuntimeException("Empty CompositeComponent "+cc.getEntityName());
//			}
//			logger.debug("Retrieving inner SEFF of CompositeComponent "+cc.getEntityName());
//			//recursive call of this method for the internals of the CompositeComponent
//			return getSeff(inner.get(0),sig);
//		}
//		return null;
//	}

	private ComputedUsageContext getFirstComputedUsageContext(
			EntryLevelSystemCall elsa) {
		logger.debug("In getFirstComputedUsageContext");

		EList<VariableUsage> vuList = elsa
				.getInputParameterUsages_EntryLevelSystemCall();
		ComputedUsageContext cuc = matchVariableUsages(vuList);
		if (cuc != null) {
			logger.debug("Reusing existing computed usage context for "
					+ getAssCtx().getEntityName());
			return cuc;
		} else {
			logger.debug("Creating new computed usage context for "
					+ getAssCtx().getEntityName());

			ComputedUsageContext newCompUsgCtx = ComputedUsageFactory.eINSTANCE
					.createComputedUsageContext();
			pcmInstance.getComputedUsage().getUsageContexts_ComputedUsage()
					.add(newCompUsgCtx);

			newCompUsgCtx.setAssemblyContext_ComputedUsageContext(getAssCtx());

			Input newInput = ComputedUsageFactory.eINSTANCE.createInput();
			newCompUsgCtx.setInput_ComputedUsageContext(newInput);

			EList<VariableUsage> parList = elsa
					.getInputParameterUsages_EntryLevelSystemCall();
			for (VariableUsage vu : parList) {
				VariableUsageHelper
						.copySolvedVariableUsageToInput(newCompUsgCtx
								.getInput_ComputedUsageContext(), this, vu);
			}

			addComponentParametersToNewContext(newCompUsgCtx);
			return newCompUsgCtx;
		}
	}

	private EList<AssemblyContext> getFirstAssemblyContext2(EntryLevelSystemCall elsa){
		String roleId = elsa.getProvidedRole_EntryLevelSystemCall().getId();
//		Signature serviceToBeCalled = elsa.getSignature_EntryLevelSystemCall();
//		Interface requiredInterface = (Interface) serviceToBeCalled
//				.eContainer();
//		String interfaceId = requiredInterface.getId();
		ProvidedRole startingRole = elsa.getProvidedRole_EntryLevelSystemCall();
		
		AssemblyContext startingAssCtx = null;
		
		EList<ProvidedDelegationConnector> pdcList = pcmInstance
			.getSystem()
			.getProvidedDelegationConnectors_ComposedStructure();
		for (ProvidedDelegationConnector pdc : pdcList) {
			if (pdc.getOuterProvidedRole_ProvidedDelegationConnector()
					.getId().equals(roleId)){
				 startingAssCtx = pdc.getAssemblyContext_ProvidedDelegationConnector();
			}
		}
		
		if (startingAssCtx != null){
			return getAssCtxs(startingAssCtx, startingRole, new BasicEList<AssemblyContext>());	
		} else {
			// "Something is wrong with your ProvidedDelegationConnectors: Are they all bound to proper roles?"
			return null;
		}
	}
	
	private AssemblyContext getFirstAssemblyContext(EntryLevelSystemCall elsa) {
		Signature serviceToBeCalled = elsa.getSignature_EntryLevelSystemCall();
		Interface requiredInterface = (Interface) serviceToBeCalled
				.eContainer();

		ProvidedRole role = elsa.getProvidedRole_EntryLevelSystemCall();

		try {
			EList<ProvidedDelegationConnector> pdcList = pcmInstance
					.getSystem()
					.getProvidedDelegationConnectors_ComposedStructure();
			for (ProvidedDelegationConnector pdc : pdcList) {
				if (pdc.getOuterProvidedRole_ProvidedDelegationConnector()
						.getId().equals(role.getId())) {
					// pdc.getChildComponentContext_ProvidedDelegationConnector();
					return pdc
							.getAssemblyContext_ProvidedDelegationConnector();
					// TODO: testen, abfrage interface?
				}
			}
			// If ProvidedDelegationConnectors are not bound to outer roles (for
			// example you changed your Systems only interface, deleting the old
			// one, and a danglin ProvidedConnector remains),
			// NullPointerEcxeptions can occur in the upper part.
		} catch (RuntimeException e) {
			throw new RuntimeException(
					"Something is wrong with your ProvidedDelegationConnectors: Are they all bound to proper roles?",
					e);
		}
		return null;
	}

	private void readComputedContextsToHashMaps() {
		branchProbs = new HashMap<AbstractBranchTransition, Double>();
		EList<BranchProbability> bpList = compUsgCtx
				.getBranchProbabilities_ComputedUsageContext();
		for (BranchProbability bp : bpList) {
			branchProbs.put(bp.getBranchtransition_BranchProbability(), bp
					.getProbability());
		}

		loopIters = new HashMap<AbstractLoopAction, ManagedPMF>();
		EList<LoopIteration> liList = compUsgCtx
				.getLoopiterations_ComputedUsageContext();
		for (LoopIteration li : liList) {
			String spec = li.getSpecification_LoopIteration()
					.getSpecification();
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

		// resDemands = new HashMap<ParametricResourceDemand, ManagedPDF>();
		resDemands = new HashMap<ParametricResourceDemand, ProbabilityDensityFunction>();
		EList<ResourceDemand> rdList = compAllCtx
				.getResourceDemands_ComputedAllocationContext();
		for (ResourceDemand rd : rdList) {
			String spec = rd.getSpecification_ResourceDemand()
					.getSpecification();
			ProbabilityFunctionLiteral blah = (ProbabilityFunctionLiteral) ExpressionHelper
					.parseToExpression(spec);
			ProbabilityDensityFunction pdf = (ProbabilityDensityFunction) blah
					.getFunction_ProbabilityFunctionLiteral();
			// ManagedPDF pdf = null;
			// try {
			// pdf = ManagedPDF.createFromString(spec);
			// } catch (StringNotPDFException e) {
			// e.printStackTrace();
			// } catch (RecognitionException e) {
			// e.printStackTrace();
			// }
			resDemands
					.put(rd.getParametricResourceDemand_ResourceDemand(), pdf);
		}

		// Store the mapping which ParametricResourceDemand accesses which Resource in this context.
		procResources = new HashMap<ParametricResourceDemand, ProcessingResourceSpecification>();
		for (ResourceDemand rd : rdList) {
			ParametricResourceDemand prd = rd
					.getParametricResourceDemand_ResourceDemand();
			ProcessingResourceType prt = prd.getRequiredResource_ParametricResourceDemand();
			EList<ProcessingResourceSpecification> prsList = allCtx
					.getResourceContainer_AllocationContext()
					.getActiveResourceSpecifications_ResourceContainer();
			for (ProcessingResourceSpecification prs : prsList) {
				ProcessingResourceType prsType = prs.getActiveResourceType_ActiveResourceSpecification();
				if (prsType.getId().equals(prt.getId())) {
					procResources.put(prd, prs);
				}
			}
		}

		linkResources = new HashMap<ExternalCallAction, CommunicationLinkResourceSpecification>();

		EList<ExternalCallInput> eciList = compUsgCtx
				.getExternalCallInput_ComputedUsageContext();
		EList<LinkingResource> lrList = pcmInstance.getResourceEnvironment()
				.getLinkingresource();
		ResourceContainer rc1 = allCtx.getResourceContainer_AllocationContext();
		for (ExternalCallInput eci : eciList) {
			ExternalCallAction eca = eci
					.getExternalCallAction_ExternalCallInput();

			EList<AssemblyContext> acList = getNextAssemblyContext(eca,false);
			AllocationContext nextAllCtx = getNextAllocationContext(acList.get(0));
			ResourceContainer rc2 = nextAllCtx
					.getResourceContainer_AllocationContext();

			for (LinkingResource lr : lrList) {
				// ------------------------------
				// contains() does NOT work (fb)!
				// ------------------------------
				// if
				// (lr.getFromResourceContainer_LinkingResource().contains(rc1)
				// &&
				// lr.getToResourceContainer_LinkingResource().contains(rc2)){
				boolean rc1Contained = exists(lr
						.getFromResourceContainer_LinkingResource(), rc1);
				boolean rc2Contained = exists(lr
						.getToResourceContainer_LinkingResource(), rc2);
				if (rc1Contained && rc2Contained) {
					CommunicationLinkResourceSpecification clrs = lr
							.getCommunicationLinkResourceSpecifications_LinkingResource();
					linkResources.put(eca, clrs);
				}
			}
		}
	}

	/**
	 * Checks if a resource container exists in a list of containers.
	 * 
	 * @param list
	 *            the list of resource containers
	 * @param container
	 *            the resource container to find
	 * @return TRUE if the container is in the list
	 */
	private boolean exists(final EList<ResourceContainer> list,
			final ResourceContainer container) {
		// Go through the list of resource containers:
		for (ResourceContainer element : list) {
			if (element.getId().equals(container.getId())) {
				return true;
			}
		}
		return false;
	}

	private ComputedAllocationContext getNextComputedAllocationContext() {
		logger.debug("In getNextComputedAllocationContext ");

		ComputedAllocationContext cac = getExistingComputedAllocationContext();
		if (cac != null) {
			logger.debug("Reusing existing computed allocation context for "
					+ getAssCtx().getEntityName());
			return cac;
		} else {
			logger.debug("Creating new computed allocation context for "
					+ getAssCtx().getEntityName());
			ComputedAllocationContext newCompAllCtx = ComputedAllocationFactory.eINSTANCE
					.createComputedAllocationContext();
			pcmInstance.getComputedAllocation()
					.getComputedAllocationContexts_ComputedAllocation().add(
							newCompAllCtx);
			newCompAllCtx.setUsageContext_ComputedAllocationContext(compUsgCtx);
			newCompAllCtx
					.setAllocationContext_ComputedAllocationContext(allCtx);
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
	private ComputedUsageContext getNextComputedUsageContext(
			ExternalCallAction eca) {
		logger.debug("In getNextComputedUsageContext " + eca.getEntityName());

		ComputedUsageContext cuc = getExistingComputedUsageContext(eca);
		if (cuc != null) {
			logger.debug("Reusing existing computed usage context for "
					+ getAssCtx().getEntityName());
			return cuc;
		} else {
			logger.debug("Creating new computed usage context for "
					+ getAssCtx().getEntityName());
			return createNewComputedUsageContext(eca);
		}
	}

	private ComputedUsageContext createNewComputedUsageContext(
			ExternalCallAction eca) {
		// create new computed usage context
		ComputedUsageContext newCompUsgCtx = ComputedUsageFactory.eINSTANCE
				.createComputedUsageContext();
		pcmInstance.getComputedUsage().getUsageContexts_ComputedUsage().add(
				newCompUsgCtx);

		newCompUsgCtx.setAssemblyContext_ComputedUsageContext(getAssCtx());

		Input newInput = ComputedUsageFactory.eINSTANCE.createInput();
		newCompUsgCtx.setInput_ComputedUsageContext(newInput);

		EList<VariableUsage> parList = eca
				.getInputParameterUsages_ExternalCallAction();
		for (VariableUsage vu : parList) {
			VariableUsageHelper.copySolvedVariableUsageToInput(newCompUsgCtx
					.getInput_ComputedUsageContext(), this, vu);
		}

		// TODO: add default component parameters by component developer
		addComponentParametersToNewContext(newCompUsgCtx);

		return newCompUsgCtx;
	}

	private EList<VariableUsage> getComponentParameters(AssemblyContext context)
	{
		ImplementationComponentType component=(ImplementationComponentType)context.getEncapsulatedComponent_AssemblyContext();
		
		return component.getComponentParameterUsage_ImplementationComponentType();
		
	}
	
	private void addComponentParametersToNewContext(
			ComputedUsageContext newCompUsgCtx) {

		EList<VariableUsage> compParams=getComponentParameters(getAssCtx());
		for (VariableUsage vu : compParams) {
			VariableUsageHelper.copySolvedVariableUsageToInput(newCompUsgCtx
					.getInput_ComputedUsageContext(), this, vu);
		}
		
		EList<VariableUsage> confParList = this.getAssCtx()
				.getConfigParameterUsages_AssemblyContext();
		for (VariableUsage vu : confParList) {
			VariableUsageHelper.copySolvedVariableUsageToInput(newCompUsgCtx
					.getInput_ComputedUsageContext(), this, vu);
		}

		UsageModel um = this.getPcmInstance().getUsageModel();
		EList<UserData> userDataList = um.getUserData_UsageModel();
		for (UserData ud : userDataList) {
			if (ud.getAssemblyContext_userData().getId().equals(
					this.getAssCtx().getId())) {
				EList<VariableUsage> userParList = ud
						.getUserDataParameterUsages_UserData();
				for (VariableUsage vu : userParList) {
					VariableUsageHelper.copySolvedVariableUsageToInput(
							newCompUsgCtx.getInput_ComputedUsageContext(),
							this, vu);
				}
			}
		}
	}

	private ExternalCallInput addExternalCallInputToCurrentContext(
			ExternalCallAction eca) {
		EList<VariableUsage> parList = eca
				.getInputParameterUsages_ExternalCallAction();
		ExternalCallInput eci = ComputedUsageFactory.eINSTANCE
				.createExternalCallInput();
		eci.setExternalCallAction_ExternalCallInput(eca);
		compUsgCtx.getExternalCallInput_ComputedUsageContext().add(eci);
		for (VariableUsage vu : parList) {
			VariableUsageHelper.copySolvedVariableUsageToExternalCallInput(
					this, eci, vu);
		}
		return eci;
	}

	private ComputedUsageContext getExistingComputedUsageContext(
			ExternalCallAction eca) {
		EList<ExternalCallInput> eciList = compUsgCtx
				.getExternalCallInput_ComputedUsageContext();
		if (eciList.size() == 0) {
			EList<ComputedUsageContext> cucList = pcmInstance
					.getComputedUsage().getUsageContexts_ComputedUsage();
			for (ComputedUsageContext cuc : cucList) {
				// assCtx already points to the next assCtx after the external
				// call
				if (cuc.getAssemblyContext_ComputedUsageContext().getId()
						.equals(getAssCtx().getId())
						&& cuc.getInput_ComputedUsageContext()
								.getParameterChacterisations_Input().size() == 0) {
					// do not forget to create the external call input to current context:
					ExternalCallInput extCallIn = addExternalCallInputToCurrentContext(eca);
					return cuc;
				}
			}
			// matching external call input does not exist, create new one
			ExternalCallInput extCallIn = addExternalCallInputToCurrentContext(eca);
			// check whether following computed usage context contains matching
			// input
			EList<VariableUsage> inputVUList = extCallIn
					.getParameterCharacterisations_ExternalCallInput();
			ComputedUsageContext cuc = matchVariableUsages(inputVUList);
			if (cuc != null)
				return cuc;
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
			// check whether following computed usage context contains matching
			// input
			EList<VariableUsage> inputVUList = extCallIn
					.getParameterCharacterisations_ExternalCallInput();
			ComputedUsageContext cuc = matchVariableUsages(inputVUList);
			if (cuc != null)
				return cuc;
		}
		return null;
	}

	private ComputedUsageContext matchVariableUsages(EList<VariableUsage> vuList) {
		EList<ComputedUsageContext> cucList = pcmInstance.getComputedUsage()
				.getUsageContexts_ComputedUsage();
		for (ComputedUsageContext cuc : cucList) {
			if (cuc.getAssemblyContext_ComputedUsageContext().getId().equals(
					getAssCtx().getId())) {
				Input input = cuc.getInput_ComputedUsageContext();
				EList<VariableUsage> vuList2 = input
						.getParameterChacterisations_Input();

				// logger.debug("List1: "+vuList);
				// logger.debug("List2: "+vuList2);

				if (areEqual(vuList, vuList2)) {
					// logger.debug("Are Equal Successful!");
					return cuc;
				}
			}
		}
		logger.debug("Matching Input Variables for External Call failed.");

		// TODO: throw exception
		return null;
	}

	private boolean areEqual(EList<VariableUsage> vuList1,
			EList<VariableUsage> vuList2) {

		int varUsgCounter = 0;
		for (VariableUsage vu1 : vuList1) {
			for (VariableUsage vu2 : vuList2) {
				if (getFullParameterName(vu1.getNamedReference_VariableUsage())
						.equals(
								getFullParameterName(vu2
										.getNamedReference_VariableUsage()))) {
					EList<VariableCharacterisation> vcList = vu1
							.getVariableCharacterisation_VariableUsage();
					int varCharFoundCounter = 0;

					for (VariableCharacterisation vc1 : vcList) {
						EList<VariableCharacterisation> vcList2 = vu2
								.getVariableCharacterisation_VariableUsage();
						boolean singleVarCharFound = false;
						for (VariableCharacterisation vc2 : vcList2) {
							if (vc1.getType().getLiteral().equals(
									vc2.getType().getLiteral())
									&& vc1
											.getSpecification_VariableCharacterisation()
											.getSpecification()
											.equals(
													vc2
															.getSpecification_VariableCharacterisation()
															.getSpecification())) {
								singleVarCharFound = true;
							}
						}
						// found a single matching characterisation
						if (singleVarCharFound)
							varCharFoundCounter++;
					}
					// all characterisations for a parameter found:
					if (varCharFoundCounter == vcList.size())
						varUsgCounter++;
				}
			}
		}
		// return true if all matching variable usages found
		return (varUsgCounter == vuList1.size());
	}

	private String getFullParameterName(AbstractNamedReference ref) {
		String name = "";
		while (ref instanceof NamespaceReference) {
			NamespaceReference nsRef = (NamespaceReference) ref;
			name += nsRef.getReferenceName() + ".";
			ref = nsRef.getInnerReference_NamespaceReference();
		}
		return name += ref.getReferenceName();
	}

	private AllocationContext getNextAllocationContext(
			AssemblyContext nextAssCtx) {
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


	/**
	 * FIXME: This method modifies the passed ContextWrapper if 
	 * isCreateContextWrapper is true, which makes everything very unclear!
	 * @param eca
	 * @param isCreateContextWrapper
	 * @return
	 */
	public EList<AssemblyContext> getNextAssemblyContext(ExternalCallAction eca, boolean isCreateContextWrapper){
		String roleId = eca.getRole_ExternalService().getId();
		Signature serviceToBeCalled = eca.getCalledService_ExternalService();
		Interface requiredInterface = (Interface) serviceToBeCalled
				.eContainer();
		String interfaceId = requiredInterface.getId();
		
		// navigate upwards through the stack of assembly contexts
		AssemblyConnector matchingAssConn = getMatchingAssConn(roleId, interfaceId, isCreateContextWrapper);
		
		if (matchingAssConn != null) {
			AssemblyContext startingAssCtx = matchingAssConn.getProvidingAssemblyContext_AssemblyConnector();
			Role startingRole = matchingAssConn.getProvidedRole_AssemblyConnector();
			
			// navigate downwards through the possibly nested components (within composite components):
			if (isCreateContextWrapper){
				return getAssCtxs(startingAssCtx, startingRole, assCtxList);	
			} else {
				
				AssemblyContext reqAssCtx = matchingAssConn.getRequiringAssemblyContext_AssemblyConnector();
				EList<AssemblyContext> newAssCtxList = new BasicEList<AssemblyContext>();

				if (reqAssCtx.getId().equals(getAssCtx().getId())){
					// in this case the assembly contexts have to be inherited
					for (AssemblyContext ac : assCtxList) {
						newAssCtxList.add(ac);
					}
					newAssCtxList.remove(newAssCtxList.size()-1);
				} 				
				
				return getAssCtxs(startingAssCtx, startingRole, newAssCtxList);
			}
		} else {
			logger.debug("Found no matching assembly connector for " +
					"ExternalCallAction ("+eca.getCalledService_ExternalService()+
					")! Check your model.");
		}
		return null;

	}
	
	/**
	 * Find the AsemblyConnector that points from the given 
	 * AssemblyContext ac to the next AssemblyContext used via the given 
	 * RequiredRole and Interface. 
	 * There can be RequiredDelegationConnectors in between if ComposedStructures are
	 * used. 
	 * 
	 * @param roleId
	 * @param interfaceId
	 * @param isCreateContextWrapper if true, this ContextWrapper is modified and the found AssemblyContext is removed from the internal assCtxList. FIXME: Why does this make sense ever?  
	 * @return An AssemblyContext that either is a matching Assem
	 */
	private AssemblyConnector getMatchingAssConn(String roleId, String interfaceId, boolean isCreateContextWrapper) {
		
		// navigate upwards through the stack of assembly context
		// find the matching assembly connector
		for (int i=assCtxList.size()-1; i >= 0; i--){
			
			//Look for an AssemblyConnector directly attached to ac
			AssemblyConnector matchingAssConn = findFromAssemblyConnector(roleId,interfaceId,assCtxList.get(i));
			if (matchingAssConn != null) {
				if (isCreateContextWrapper) assCtxList.remove(i);	
				return matchingAssConn;
			}
			
			//If no AssemblyConnector directly attached to ac was found, check for RequiredDelegationConnectors one level up and for an 
			//AssemblyConnector connecting the parent of ac to something. 
			matchingAssConn = findFromDelegationConnector(roleId,interfaceId,assCtxList.get(i),i);
			if (matchingAssConn != null) {
				if (isCreateContextWrapper) {
					assCtxList.remove(i);
					assCtxList.remove(i-1);
				}
				return matchingAssConn;
			}
			
		}
		// should not happen with valid models:
		logger.error("No matching assembly connector found for (Role: "+roleId+", Interface: "+interfaceId+"). Check your model!");
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Look at all AssemblyConnector in the parent ComposedStructure of AssemblyContext ac
	 * and return the one
	 * that has the given roleId, interfaceId and ac on the required side. 
	 * @param roleId The id of the RequiredRole to match 
	 * @param interfaceId The id of the Interface to match on the required side
	 * @param ac The AssemblyContext to match on the required side.
	 * @return A matching AssemblyContext from the parent ComposedStructure of ac
	 */
	private AssemblyConnector findFromAssemblyConnector(String roleId,
			String interfaceId, AssemblyContext ac) {
		
		EList<AssemblyConnector> assConnList = ac
			.getParentStructure_AssemblyContext()
			.getAssemblyConnectors_ComposedStructure();
		for (AssemblyConnector assConn : assConnList) {
			if (assConn
					.getRequiringAssemblyContext_AssemblyConnector()
					.getId().equals(ac.getId())
		     && assConn.getRequiredRole_AssemblyConnector()
					.getRequiredInterface__RequiredRole().getId()
					.equals(interfaceId)
			 && assConn.getRequiredRole_AssemblyConnector()
			 		.getId().equals(roleId)) {
				return assConn;
			}
		}
		return null;
	}

	/**
	 * Find a matching AssemblyConnector by looking at the 
	 * RequiredDelegationConnectors of this AssemblyContext ac. 
	 * Step up the composition one step and find the matching AssemblyConnector 
	 * and then return that found AssemblyConnector.
	 * 
	 * FIXME: If the composition is deeper than 1, this probably does not work. 
	 * It should be recursive.      
	 *   
	 * @param roleId
	 * @param interfaceId
	 * @param ac
	 * @param i
	 * @return
	 */
	private AssemblyConnector findFromDelegationConnector(String roleId,
			String interfaceId, AssemblyContext ac, int i) {
		EList<RequiredDelegationConnector> reqDelConnList = ac
		.getParentStructure_AssemblyContext()
		.getRequiredDelegationConnectors_ComposedStructure();

		for (RequiredDelegationConnector reqConn : reqDelConnList){
			if (reqConn
					.getInnerRequiredRole_RequiredDelegationConnector().getId()
					.equals(roleId) &&
					reqConn
					.getInnerRequiredRole_RequiredDelegationConnector()
					.getRequiredInterface__RequiredRole().getId()
					.equals(interfaceId)){
				String outerRoleId = reqConn.getOuterRequiredRole_RequiredDelegationConnector().getId();
				AssemblyContext compositeComponentAssemblyContext = assCtxList.get(i-1);
				String compositeComponentAssCtxId = compositeComponentAssemblyContext.getId();


				EList<AssemblyConnector> assConnList = compositeComponentAssemblyContext
				.getParentStructure_AssemblyContext()
				.getAssemblyConnectors_ComposedStructure();


				for (AssemblyConnector assConn : assConnList) {
					if (assConn
							.getRequiringAssemblyContext_AssemblyConnector()
							.getId().equals(compositeComponentAssCtxId)
							&& assConn.getRequiredRole_AssemblyConnector()
							.getRequiredInterface__RequiredRole().getId()
							.equals(interfaceId)
							&& assConn.getRequiredRole_AssemblyConnector()
							.getId().equals(outerRoleId)) {
						return assConn;
					}
				}
			}
		}
		return null;
	}
	
//	public AssemblyContext getNextAssemblyContext(ExternalCallAction eca) {
//		String roleId = eca.getRole_ExternalService().getId();
//		Signature serviceToBeCalled = eca.getCalledService_ExternalService();
//		Interface requiredInterface = (Interface) serviceToBeCalled
//				.eContainer();
//
//		AssemblyConnector matchingAssConn = null;
//		EList<AssemblyConnector> assConnList = pcmInstance.getSystem()
//				.getAssemblyConnectors_ComposedStructure();
//	
//		for (AssemblyConnector assConn : assConnList) {
//			if (assConn
//					.getRequiringAssemblyContext_AssemblyConnector()
//					.getId().equals(getAssCtx().getId())
//		     && assConn.getRequiredRole_AssemblyConnector()
//					.getRequiredInterface__RequiredRole().getId()
//					.equals(requiredInterface.getId())
//			 && assConn.getRequiredRole_AssemblyConnector()
//			 		.getId().equals(roleId)) {
//				matchingAssConn = assConn;
//			}
//		}
//		
//		if (matchingAssConn != null) {
//			return matchingAssConn
//					.getProvidingAssemblyContext_AssemblyConnector();
//		} else 
//			return null;
//	}

	/**
	 * Builds a list of assembly context ids by searching for nested components. Is called recursively.
	 * @param ac
	 * @param role
	 * @param acList
	 * @return
	 */
	public EList<AssemblyContext> getAssCtxs(AssemblyContext ac, Role role, EList<AssemblyContext> acList){
		RepositoryComponent rc = ac.getEncapsulatedComponent_AssemblyContext();
		
		if (rc instanceof BasicComponent){
			acList.add(ac);
			return acList;
		} else if (rc instanceof CompositeComponent){
			CompositeComponent cc = (CompositeComponent)rc;
			EList<ProvidedDelegationConnector> pdcList = cc.getProvidedDelegationConnectors_ComposedStructure();
			for (ProvidedDelegationConnector pdc : pdcList){
				// traverse down the provided delegation connectors of the composite component
				if (pdc.getOuterProvidedRole_ProvidedDelegationConnector().getId()
						.equals(role.getId())){
					
					// add the found assembly context
					acList.add(ac);
					
					// search for more inner assembly contexts by continuing the traversal on provided
					// delegation connectors:
					AssemblyContext childAssCtx = pdc.getAssemblyContext_ProvidedDelegationConnector(); 
					return getAssCtxs(childAssCtx, pdc.getInnerProvidedRole_ProvidedDelegationConnector(), acList);
				}
			}
		} 
		// should not happen
		logger.error("The current assembly context contains a child component, " +
				"which is neither BasicComponent nor CompositeComponent. " +
				"This is not supported by the PCMSolver!");
		throw new UnsupportedOperationException();
	}
	
	
	public AssemblyContext getAssCtx() {
		
		//return assCtx;
		return assCtxList.get(assCtxList.size()-1);
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

	public EList<AssemblyContext> getAssCtxList() {
		return assCtxList;
	}

	public void setAssCtxList(EList<AssemblyContext> assCtxList) {
		this.assCtxList = assCtxList;
	}
}
