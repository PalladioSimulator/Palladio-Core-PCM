package de.uka.ipd.sdq.pcmsolver.transformations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation;
import de.uka.ipd.sdq.pcm.qosannotations.reliability.SpecifiedReliabilityAnnotation;
import de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
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
import de.uka.ipd.sdq.pcm.system.System;
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
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.NamespaceReference;

/**
 * For convenient implementation of model transformations in Java from PCM
 * instances to performance models, the DS provides a so-called ContextWrapper.
 * It hides all specified and computed context models from the transformation
 * and assists the traversal of a PCM instance. A transformation can instantiate
 * a new ContextWrapper upon visiting an EntryLevelSystemCall or
 * ExternalCallAction as it is specific for each RDSEFF call.
 * 
 * Transformations must instantiate a ContextWrapper initially when visiting the
 * first EntryLevelSystemCall by calling its constructor and passing a reference
 * to the current PCM instance, which already includes the specified contexts as
 * well as the computed contexts from a former run of the DS. Thus, from an
 * EntryLevelSystemCall and the given PCM instance, the ContextWrapper can
 * retrieve the called assembly context, allocation context, computed usage
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
 *      http://docserver.bis.uni-oldenburg
 *      .de/_publikationen/dissertation/2008/kozpar08/pdf/kozpar08.pdf
 * @author Heiko Koziolek
 * 
 */
public class ContextWrapper implements Cloneable {

	protected static Logger logger = Logger.getLogger(ContextWrapper.class
			.getName());

	// private AssemblyContext assCtx;

	/**
	 * Builds a list of assembly context ids by searching for nested components.
	 * Is called recursively. This method is static to ensure that it does not
	 * modify this Context Wrapper
	 * 
	 * @param ac
	 * @param role
	 * @param assCtxList2
	 * @return
	 */
	public static List<AssemblyContext> getAssCtxs(AssemblyContext ac,
			Role role, List<AssemblyContext> assCtxList2) {
		RepositoryComponent rc = ac.getEncapsulatedComponent_AssemblyContext();

		if (rc instanceof BasicComponent) {
			assCtxList2.add(ac);
			return assCtxList2;
		} else if (rc instanceof ComposedStructure) {
			ComposedStructure cs = (ComposedStructure) rc;
			EList<ProvidedDelegationConnector> pdcList = cs
					.getProvidedDelegationConnectors_ComposedStructure();
			for (ProvidedDelegationConnector pdc : pdcList) {
				// traverse down the provided delegation connectors of the
				// composite component
				if (pdc.getOuterProvidedRole_ProvidedDelegationConnector()
						.getId().equals(role.getId())) {

					// add the found assembly context
					assCtxList2.add(ac);

					// search for more inner assembly contexts by continuing the
					// traversal on provided
					// delegation connectors:
					AssemblyContext childAssCtx = pdc
							.getAssemblyContext_ProvidedDelegationConnector();
					return getAssCtxs(
							childAssCtx,
							pdc
									.getInnerProvidedRole_ProvidedDelegationConnector(),
							assCtxList2);
				}
			}
			String message = "Could not handle inner AssemblyContexts of ComposedStructure "
					+ cs.getEntityName()
					+ ". Make sure to define the internals properly.";
			logger.error(message);
			throw new UnsupportedOperationException(message);

		}
		// should not happen
		logger
				.error("The current assembly context contains a child component, "
						+ "which is neither BasicComponent nor CompositeComponent. "
						+ "This is not supported by the PCMSolver!");
		throw new UnsupportedOperationException();
	}

	private AllocationContext allCtx;
	/** See {@link #getAssCtxList()} for info */
	private List<AssemblyContext> assCtxList;
	private HashMap<AbstractBranchTransition, Double> branchProbs = new HashMap<AbstractBranchTransition, Double>();
	private ComputedAllocationContext compAllCtx;

	private ComputedUsageContext compUsgCtx;
	private HashMap<ExternalCallAction, CommunicationLinkResourceSpecification> linkResources = new HashMap<ExternalCallAction, CommunicationLinkResourceSpecification>();
	private HashMap<AbstractLoopAction, ManagedPMF> loopIters = new HashMap<AbstractLoopAction, ManagedPMF>();
	private PCMInstance pcmInstance;
	private HashMap<ParametricResourceDemand, ProcessingResourceSpecification> procResources = new HashMap<ParametricResourceDemand, ProcessingResourceSpecification>();;

	/**
	 * Contains the already solved resource demand in time on the specific
	 * processor
	 */
	private ResourceDemandCache resDemands = new ResourceDemandCache();

	public ContextWrapper(EntryLevelSystemCall elsa, PCMInstance pcm) {
		pcmInstance = pcm;
		// assCtx = getFirstAssemblyContext(elsa);
		// allCtx = getNextAllocationContext(assCtx);
		assCtxList = getFirstAssemblyContext2(elsa);
		allCtx = getNextAllocationContext(assCtxList);

		compUsgCtx = getFirstComputedUsageContext(elsa);
		compAllCtx = getNextComputedAllocationContext(compUsgCtx);
		readComputedContextsToHashMaps();
	}

	public ContextWrapper(EntryLevelSystemCall elsa, PCMInstance pcm,
			ComputedUsageContext cuc, ComputedAllocationContext cac) {
		pcmInstance = pcm;
		// assCtx = getFirstAssemblyContext(elsa);
		// allCtx = getNextAllocationContext(assCtx);
		assCtxList = getFirstAssemblyContext2(elsa);
		allCtx = getNextAllocationContext(assCtxList);

		handleComputedContexts(cuc, cac);
	}

	/**
	 * Attention: This constructor modifies the passed ContextWrapper!
	 * 
	 * @param eca
	 * @param cuc
	 * @param cac
	 * @param oldContextWrapper
	 *            IS MODIFIED!
	 */
	public ContextWrapper(ExternalCallAction eca, ComputedUsageContext cuc,
			ComputedAllocationContext cac, ContextWrapper oldContextWrapper) {
		pcmInstance = oldContextWrapper.getPcmInstance();
		// assCtx = oldContextWrapper.getNextAssemblyContext(eca);
		// allCtx = getNextAllocationContext(assCtx);
		assCtxList = oldContextWrapper.findProvidingAssemblyContexts(eca, true);
		allCtx = getNextAllocationContext(assCtxList);

		handleComputedContexts(cuc, cac);
	}

	public ContextWrapper(PCMInstance pcm) {
		pcmInstance = pcm;
	}

	protected ContextWrapper() {
	}

	@Override
	public Object clone() {
		ContextWrapper clonedWrapper = new ContextWrapper();
		EList<AssemblyContext> list = new BasicEList<AssemblyContext>();
		for (AssemblyContext ac : assCtxList) {
			list.add(ac);
		}

		clonedWrapper.setAssCtxList(list);
		// clonedWrapper.setAssCtx(assCtx);
		clonedWrapper.setAllCtx(allCtx);
		clonedWrapper.setCompAllCtx(compAllCtx);
		clonedWrapper.setCompUsgCtx(compUsgCtx);
		clonedWrapper.setPcmInstance(pcmInstance);
		clonedWrapper.readComputedContextsToHashMaps();
		return clonedWrapper;
	}

	/**
	 * Searches for the providing AssemblyContexts that handle the given
	 * ExternalCallAction.
	 * 
	 * If the ExternalCallAction is a system external call, the method returns
	 * an empty list. If the providing side is a nested structure of
	 * AssemblyContexts, all providing AssemblyContexts are returned in a list,
	 * with the actual handling context as the last element.
	 * 
	 * @param externalCall
	 *            the ExternallCallAction on
	 * @param isCreateContextWrapper
	 *            FIXME: This method modifies the passed ContextWrapper if
	 *            isCreateContextWrapper is true, which makes everything very
	 *            unclear!
	 * @return the providing AssemblyContexts
	 */
	public List<AssemblyContext> findProvidingAssemblyContexts(
			final ExternalCallAction externalCall,
			final boolean isCreateContextWrapper) {

		// Create the result variable:
		BasicEList<AssemblyContext> resultList = new BasicEList<AssemblyContext>();

		// Collect information about the externalCall:
		String roleId = externalCall.getRole_ExternalService().getId();
		Signature serviceToBeCalled = externalCall
				.getCalledService_ExternalService();
		Interface requiredInterface = (Interface) serviceToBeCalled
				.eContainer();
		String interfaceId = requiredInterface.getId();

		// Search for an AssemblyConnector between the calling
		// AssemblyContext and the handling AssemblyContext:
		AssemblyConnector connector = findAssemblyContextForRequiredRole(
				roleId, interfaceId, isCreateContextWrapper);
		if (connector == null) {
			// If no AssemblyConnector is found, the call is a system external
			// call and has no handling AssemblyContext:
			return resultList;
		}

		// Retrieve the direct providing AssemblyContext of the connector:
		AssemblyContext providingContext = connector
				.getProvidingAssemblyContext_AssemblyConnector();
		Role providingRole = connector.getProvidedRole_AssemblyConnector();

		// Navigate downwards through the possibly nested AssemblyContexts,
		// until the actual handling AssemblyContext is found:
		if (isCreateContextWrapper) {
			return getAssCtxs(providingContext, providingRole, assCtxList);
		} else {
			AssemblyContext reqAssCtx = connector
					.getRequiringAssemblyContext_AssemblyConnector();
			if (reqAssCtx.getId().equals(getAssCtx().getId())) {
				// in this case the assembly contexts have to be inherited
				for (AssemblyContext ac : assCtxList) {
					resultList.add(ac);
				}
				resultList.remove(resultList.size() - 1);
			}
			return getAssCtxs(providingContext, providingRole, resultList);
		}
	}

	public AllocationContext getAllCtx() {
		return allCtx;
	}

	// TODO: idea to fix the above problematic methods, however, it does not
	// work
	// The assCtxList is not properly maintained.
	/*
	 * public ContextWrapper getContextWrapperFor(ExternalCallAction eca) {
	 * 
	 * ContextWrapper newContextWrapper = new ContextWrapper(pcmInstance);
	 * newContextWrapper.setAssCtxList(getNextAssemblyContext(eca,true));
	 * newContextWrapper.setAllCtx(getNextAllocationContext(assCtxList.get(0)));
	 * 
	 * newContextWrapper.setCompUsgCtx(getNextComputedUsageContext(eca));
	 * newContextWrapper
	 * .setCompAllCtx(getNextComputedAllocationContext(newContextWrapper
	 * .getCompUsgCtx())); newContextWrapper.readComputedContextsToHashMaps();
	 * return this; }
	 * 
	 * public ContextWrapper getContextWrapperFor(EntryLevelSystemCall elsa) {
	 * 
	 * ContextWrapper newContextWrapper = new ContextWrapper(pcmInstance);
	 * newContextWrapper.setAssCtxList(getFirstAssemblyContext2(elsa));
	 * newContextWrapper.setAllCtx(getNextAllocationContext(assCtxList.get(0)));
	 * 
	 * newContextWrapper.setCompUsgCtx(getFirstComputedUsageContext(elsa));
	 * newContextWrapper
	 * .setCompAllCtx(getNextComputedAllocationContext(newContextWrapper
	 * .getCompUsgCtx())); newContextWrapper.readComputedContextsToHashMaps();
	 * 
	 * return newContextWrapper; }
	 */

	public AssemblyContext getAssCtx() {

		// return assCtx;
		return assCtxList.get(assCtxList.size() - 1);
	}

	/**
	 * @return The {@link AssemblyContext} this {@link ContextWrapper} describes
	 *         plus all the containing {@link AssemblyContext}s: If the
	 *         components are composite components, one {@link AssemblyContext}
	 *         does not define the context within a {@link System}, you need all
	 *         {@link AssemblyContext}s up to the {@link System}.
	 * 
	 *         The current {@link AssemblyContext} is the last in the list, the
	 *         previous one is its "parent", and so on.
	 */
	public List<AssemblyContext> getAssCtxList() {
		return assCtxList;
	}

	public double getBranchProbability(AbstractBranchTransition abt) {
		return branchProbs.get(abt);
	}

	public ComputedAllocationContext getCompAllCtx() {
		return compAllCtx;
	}

	public ComputedUsageContext getCompUsgCtx() {
		return compUsgCtx;
	}

	public CommunicationLinkResourceSpecification getConcreteLinkingResource(
			ExternalCallAction eca) {
		return linkResources.get(eca);
	}

	public PassiveResource getConcretePassiveResource(AcquireAction aa) {
		// TODO: Passive Resource should depend on AssemblyContext
		return aa.getPassiveresource_AcquireAction();
	}

	public PassiveResource getConcretePassiveResource(ReleaseAction ra) {
		// TODO: Passive Resource should depend on AssemblyContext
		return ra.getPassiveResource_ReleaseAction();
	}

	public ProcessingResourceSpecification getConcreteProcessingResource(
			ParametricResourceDemand prd) {
		return procResources.get(prd);
	}

	public ContextWrapper getContextWrapperFor(EntryLevelSystemCall elsa) {
		// assCtx = getFirstAssemblyContext(elsa);
		// allCtx = getNextAllocationContext(assCtx);
		assCtxList = getFirstAssemblyContext2(elsa);
		allCtx = getNextAllocationContext(assCtxList);

		compUsgCtx = getFirstComputedUsageContext(elsa);
		compAllCtx = getNextComputedAllocationContext(compUsgCtx);
		readComputedContextsToHashMaps();
		return this;
	}

	// public ServiceEffectSpecification getNextSEFF2(ExternalCallAction eca) {
	// AssemblyContext ac = getNextAssemblyContext(eca);
	// Signature sig = eca.getCalledService_ExternalService();
	// if (ac != null)
	// return getSeff(ac, sig);
	// else
	// return null;
	// }

	/**
	 * FIXME: This method changes the current ContextWrapper this
	 * 
	 * @param eca
	 * @return this after changing it.
	 */
	public ContextWrapper getContextWrapperFor(ExternalCallAction eca) {
		// assCtx = getNextAssemblyContext(eca);
		// allCtx = getNextAllocationContext(assCtx);
		assCtxList = findProvidingAssemblyContexts(eca, true);
		allCtx = getNextAllocationContext(assCtxList);

		compUsgCtx = getNextComputedUsageContext(eca);
		compAllCtx = getNextComputedAllocationContext(compUsgCtx);
		readComputedContextsToHashMaps();
		return this;
	}

	// public ServiceEffectSpecification getNextSEFF2(EntryLevelSystemCall elsc)
	// {
	// AssemblyContext ac = getFirstAssemblyContext(elsc);
	//		
	// Signature sig = elsc.getSignature_EntryLevelSystemCall();
	// if (ac != null)
	// return getSeff(ac, sig);
	// else
	// return null;
	// }

	// private ServiceEffectSpecification getSeff(AssemblyContext ac, Signature
	// sig) {
	// RepositoryComponent rc = ac.getEncapsulatedComponent_AssemblyContext();
	//		
	// if (rc instanceof BasicComponent){
	// String serviceName = sig.getServiceName();
	// BasicComponent bc = (BasicComponent) rc;
	// EList<ServiceEffectSpecification> seffList = bc
	// .getServiceEffectSpecifications__BasicComponent();
	// for (ServiceEffectSpecification seff : seffList) {
	// if (seff.getDescribedService__SEFF().getServiceName().equals(
	// serviceName)) {
	// return seff;
	// }
	// }
	// } else if (rc instanceof CompositeComponent){
	// CompositeComponent cc = (CompositeComponent)rc;
	// EList<AssemblyContext> inner =
	// cc.getAssemblyContexts_ComposedStructure();
	// if (inner.size() == 0){
	// logger.error("Empty CompositeComponent "+cc.getEntityName());
	// throw new
	// RuntimeException("Empty CompositeComponent "+cc.getEntityName());
	// }
	// logger.debug("Retrieving inner SEFF of CompositeComponent "+cc.getEntityName());
	// //recursive call of this method for the internals of the
	// CompositeComponent
	// return getSeff(inner.get(0),sig);
	// }
	// return null;
	// }

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

	/**
	 * Retrieves the list of FailureOccurrenceDescriptions for the given system
	 * external call.
	 * 
	 * The FailureOccurrenceDescriptions may be given to the system as a
	 * SpecifiedReliabilityAnnotation. If no SpecifiedReliabilityAnnotation for
	 * the system external call is found, an empty list is returned.
	 * 
	 * @param externalCallAction
	 *            the system externall call
	 * @return the list of FailureOccurrenceDescriptions
	 */
	public List<ExternalFailureOccurrenceDescription> getFailureOccurrenceDescriptionsForSystemExternalCall(
			final ExternalCallAction externalCallAction) {

		// Create the result list:
		BasicEList<ExternalFailureOccurrenceDescription> resultList = new BasicEList<ExternalFailureOccurrenceDescription>();

		// Retrieve the system required role that is reached from this external
		// call action:
		OperationRequiredRole systemRequiredRole = findSystemRequiredRoleForCurrentAssemblyContext(getRequiredRoleForExternalCallAction(externalCallAction));
		if (systemRequiredRole == null) {
			return resultList;
		}

		// Retrieve a corresponding SpecifiedReliabilityAnnotation:
		SpecifiedReliabilityAnnotation reliabilityAnnotation = findReliabilityAnnotationForSystemExternalCall(
				externalCallAction, systemRequiredRole);
		if (reliabilityAnnotation == null) {
			return resultList;
		}

		// Fill and return the result list:
		resultList
				.addAll(reliabilityAnnotation
						.getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation());
		return resultList;
	}

	/**
	 * Retrieves the SpecifiedReliabilityAnnotation that belongs to the given
	 * system external call.
	 * 
	 * It is assumed that the external call action belongs to the component that
	 * is encapsulated by the current assembly context. The current assembly
	 * context is the last element of assCtxList. If no corresponding
	 * SpecifiedReliabilityAnnotation exists, the method returns NULL.
	 * 
	 * @param externalCallAction
	 *            the system external call
	 * @param systemRequiredRole
	 *            the system required role that provides the called service
	 * @return the corresponding SpecifiedReliabilityAnnotation (if one exists)
	 */
	private SpecifiedReliabilityAnnotation findReliabilityAnnotationForSystemExternalCall(
			final ExternalCallAction externalCallAction,
			final OperationRequiredRole systemRequiredRole) {

		// Search through the system's QoS annotations:
		for (QoSAnnotations annotation : pcmInstance.getSystem()
				.getQosAnnotations_System()) {
			for (SpecifiedQoSAnnotation specifiedAnnotation : annotation
					.getSpecifiedQoSAnnotations_QoSAnnotations()) {
				if (!(specifiedAnnotation instanceof SpecifiedReliabilityAnnotation)) {
					continue;
				}
				if (specifiedAnnotation.getRole_SpecifiedQoSAnnotation()
						.getId().equals(systemRequiredRole.getId())) {
					if (specifiedAnnotation.getSignature_SpecifiedQoSAnnation()
							.getId().equals(
									externalCallAction
											.getCalledService_ExternalService()
											.getId())) {
						return (SpecifiedReliabilityAnnotation) specifiedAnnotation;
					}
				}
			}
		}

		// No corresponding reliability annotation found:
		return null;
	}

	/**
	 * Retrieves the OperationRequiredRole that belongs to the given external
	 * call action.
	 * 
	 * It is assumed that the external call action belongs to the component that
	 * is encapsulated by the current assembly context. The current assembly
	 * context is the last element of assCtxList.
	 * 
	 * @param externalCallAction
	 *            the external call action
	 * @return the OperationRequiredRole
	 */
	private OperationRequiredRole getRequiredRoleForExternalCallAction(
			final ExternalCallAction externalCallAction) {

		// First retrieve the interface:
		OperationInterface reqInterface = externalCallAction
				.getCalledService_ExternalService()
				.getInterface__OperationSignature();

		// Search through the required roles of the current AssemblyContext:
		for (RequiredRole role : assCtxList.get(assCtxList.size() - 1)
				.getEncapsulatedComponent_AssemblyContext()
				.getRequiredRoles_InterfaceRequiringEntity()) {
			if (role instanceof OperationRequiredRole) {
				if (((OperationRequiredRole) role)
						.getRequiredInterface__OperationRequiredRole().getId()
						.equals(reqInterface.getId())) {
					return (OperationRequiredRole) role;
				}
			}
		}

		// Nothing found (should not happen):
		return null;
	}

	public boolean getIsOriginalPDFFor(ParametricResourceDemand prd) {
		return this.resDemands.isOriginalPDF(prd);
	}

	public ManagedPMF getLoopIterations(AbstractLoopAction ala) {
		return loopIters.get(ala);
	}

	/**
	 * Gets the mean time demanded by prd on its processor in this context. Note
	 * that the processing rate has already been taken into account here.
	 * 
	 * @param prd
	 * @return A Double representing the mean time demanded by prd
	 */
	public Double getMeanTimeConsumption(ParametricResourceDemand prd) {
		return resDemands.getDouble(prd);
	}

	public ServiceEffectSpecification getNextSEFF(EntryLevelSystemCall elsc) {
		Signature sig = elsc.getOperationSignature__EntryLevelSystemCall();

		List<AssemblyContext> acList = getFirstAssemblyContext2(elsc);

		AssemblyContext ac = acList.get(acList.size() - 1);
		BasicComponent bc = (BasicComponent) ac
				.getEncapsulatedComponent_AssemblyContext();
		EList<ServiceEffectSpecification> seffList = bc
				.getServiceEffectSpecifications__BasicComponent();
		for (ServiceEffectSpecification seff : seffList) {
			if (seff.getDescribedService__SEFF().getEntityName().equals(
					sig.getEntityName())) {
				return seff;
			}
		}
		return null;
	}

	/**
	 * Finds the next SEFF for a given external call action and its referenced
	 * signature. Uses the current assembly context ids from the context wrapper
	 * as reference.
	 * 
	 * @param eca
	 * @return
	 */
	public ServiceEffectSpecification getNextSEFF(ExternalCallAction eca) {
		Signature sig = eca.getCalledService_ExternalService();

		// Get the list of providing AssemblyContexts for this call:
		List<AssemblyContext> acList = findProvidingAssemblyContexts(eca, false);
		if (acList.size() == 0) {
			// If no providing AssemblyContexts are found, the call is a system
			// external call, and there is no next SEFF for it:
			return null;
		}

		// Retrieve the actual handling AssemblyContext of the call:
		AssemblyContext ac = acList.get(acList.size() - 1);

		// Retrieve the actual SEFF that handles the call:
		BasicComponent bc = (BasicComponent) ac
				.getEncapsulatedComponent_AssemblyContext();
		EList<ServiceEffectSpecification> seffList = bc
				.getServiceEffectSpecifications__BasicComponent();
		for (ServiceEffectSpecification seff : seffList) {
			if (seff.getDescribedService__SEFF().getEntityName().equals(
					sig.getEntityName())) {
				return seff;
			}
		}

		// should not happen:
		logger.error("Could not find next SEFF " + "for ExternalCallAction "
				+ eca.getCalledService_ExternalService() + "!");
		return null;
	}

	public PCMInstance getPcmInstance() {
		return pcmInstance;
	}

	/**
	 * Gets the time demanded by prd on its processor in this context. Note that
	 * the processing rate has already been taken into account here.
	 * 
	 * @param prd
	 * @return A ManagedPDF representing the time demanded by prd
	 */
	public ManagedPDF getTimeConsumptionAsPDF(ParametricResourceDemand prd) {
		return resDemands.getPDF(prd);
	}

	public void setAllCtx(AllocationContext allCtx) {
		this.allCtx = allCtx;
	}

	/**
	 * Set the internal list of {@link AssemblyContext}s. This list contains the
	 * {@link AssemblyContext} this {@link ContextWrapper} describes plus all
	 * the containing {@link AssemblyContext}s: If the components are composite
	 * components, one {@link AssemblyContext} does not define the context
	 * within a {@link System}, you need all {@link AssemblyContext}s up to the
	 * {@link System}.
	 * 
	 * @param assCtxList
	 */
	public void setAssCtxList(List<AssemblyContext> assCtxList) {
		this.assCtxList = assCtxList;
	}

	public void setCompAllCtx(ComputedAllocationContext compAllCtx) {
		this.compAllCtx = compAllCtx;
	}

	public void setCompUsgCtx(ComputedUsageContext compUsgCtx) {
		this.compUsgCtx = compUsgCtx;
	}

	public void setPcmInstance(PCMInstance pcmInstance) {
		this.pcmInstance = pcmInstance;
	}

	private void addComponentParametersToNewContext(
			ComputedUsageContext newCompUsgCtx) {

		// We need to make a copy because the VariableUsages are changed if they
		// are overwritten by configuration parameters from the assembly
		// context.
		Collection<VariableUsage> compParams = copyComponentParameters(getAssCtx());

		EList<VariableUsage> confParList = this.getAssCtx()
				.getConfigParameterUsages_AssemblyContext();

		// Remove variable characterization that are overwritten in the assembly
		// context. Compare
		// the variable usage pairwise by both name and then variable
		// characterization.
		// Finally, add the config parameters to the component parameter list
		// (compParams).
		for (VariableUsage confParVariableUsage : confParList) {
			boolean repoVariableUsageWithSameNameFound = false;
			for (VariableUsage repoVariableUsage : compParams) {
				if (confParVariableUsage.getNamedReference__VariableUsage()
						.getReferenceName().equals(
								repoVariableUsage
										.getNamedReference__VariableUsage()
										.getReferenceName())) {
					repoVariableUsageWithSameNameFound = true;
					//
					List<VariableCharacterisation> confParCharacterisations = confParVariableUsage
							.getVariableCharacterisation_VariableUsage();
					List<VariableCharacterisation> repoCharacterisations = repoVariableUsage
							.getVariableCharacterisation_VariableUsage();
					List<VariableCharacterisation> vcsToBeDeleted = new ArrayList<VariableCharacterisation>(
							repoCharacterisations.size());
					for (VariableCharacterisation repoVariableCharacterisation : repoCharacterisations) {
						for (VariableCharacterisation confParVariableCharacterisation : confParCharacterisations) {
							if (repoVariableCharacterisation.getType().equals(
									confParVariableCharacterisation.getType())) {
								vcsToBeDeleted
										.add(repoVariableCharacterisation);
							}
						}
					}
					// remove all overwritten characterizations
					repoCharacterisations.removeAll(vcsToBeDeleted);
					// Add all variable characterizations of this
					// confParVariableUsage instead
					repoVariableUsage
							.getVariableCharacterisation_VariableUsage()
							.addAll(
									VariableUsageHelper
											.copyVariableCharacterisations(confParCharacterisations));
				}
			}
			// If there is no variable with the name specified in the assembly
			// context, add the whole VariableUsage from the AssemblyContext.
			if (!repoVariableUsageWithSameNameFound) {
				compParams.add((VariableUsage) EcoreUtil
						.copy(confParVariableUsage));
			}
		}

		VariableUsageHelper.copySolvedVariableUsageToInput(newCompUsgCtx
				.getInput_ComputedUsageContext(), this, compParams);

		UsageModel um = this.getPcmInstance().getUsageModel();
		EList<UserData> userDataList = um.getUserData_UsageModel();
		for (UserData ud : userDataList) {
			if (ud.getAssemblyContext_userData().getId().equals(
					this.getAssCtx().getId())) {
				EList<VariableUsage> userParList = ud
						.getUserDataParameterUsages_UserData();
				VariableUsageHelper.copySolvedVariableUsageToInput(
						newCompUsgCtx.getInput_ComputedUsageContext(), this,
						userParList);
			}
		}
	}

	private ExternalCallInput addExternalCallInputToCurrentContext(
			ExternalCallAction eca) {
		EList<VariableUsage> parList = eca.getInputVariableUsages__CallAction();
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

	private boolean areEqual(EList<VariableUsage> vuList1,
			EList<VariableUsage> vuList2) {

		int varUsgCounter = 0;
		for (VariableUsage vu1 : vuList1) {
			for (VariableUsage vu2 : vuList2) {
				if (getFullParameterName(vu1.getNamedReference__VariableUsage())
						.equals(
								getFullParameterName(vu2
										.getNamedReference__VariableUsage()))) {
					EList<VariableCharacterisation> vcList = vu1
							.getVariableCharacterisation_VariableUsage();
					int varCharFoundCounter = 0;

					for (VariableCharacterisation vc1 : vcList) {
						EList<VariableCharacterisation> vcList2 = vu2
								.getVariableCharacterisation_VariableUsage();
						boolean singleVarCharFound = false;
						for (VariableCharacterisation vc2 : vcList2) {
							// added replaceAll(" ", "") below so that different
							// formatting of specifications will not lead to
							// handling them as being different. There seems to
							// be some pretty printing going on somewhere.
							// XXX: This may not be enough to handle the pretty
							// printing, maybe the pretty printing introduces
							// other errors that are not handled by this.
							if (vc1.getType().getLiteral().equals(
									vc2.getType().getLiteral())
									&& vc1
											.getSpecification_VariableCharacterisation()
											.getSpecification()
											.replaceAll(" ", "")
											.equals(
													vc2
															.getSpecification_VariableCharacterisation()
															.getSpecification()
															.replaceAll(" ", ""))) {
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

	private Collection<VariableUsage> copyComponentParameters(
			AssemblyContext context) {
		ImplementationComponentType component = (ImplementationComponentType) context
				.getEncapsulatedComponent_AssemblyContext();
		List<VariableUsage> originalVariableUsages = component
				.getComponentParameterUsage_ImplementationComponentType();

		Collection<VariableUsage> newVariableUsages = VariableUsageHelper
				.copyVariableUsageList(originalVariableUsages);

		return newVariableUsages;

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

		EList<VariableUsage> parList = eca.getInputVariableUsages__CallAction();
		VariableUsageHelper.copySolvedVariableUsageToInput(newCompUsgCtx
				.getInput_ComputedUsageContext(), this, parList);

		addComponentParametersToNewContext(newCompUsgCtx);

		return newCompUsgCtx;
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

	/**
	 * Searches for an AssemblyConnector that connects a given
	 * requiringAssemblyContext via its requiredRole to its providing
	 * counterpart.
	 * 
	 * Notice that the requiredRole of the requiringAssemblyContext could also
	 * be associated to a RequiredDelegationConnector instead of an
	 * AssemblyConnector. In this case, NULL is returned.
	 * 
	 * @param requiredRoleId
	 *            the id of the RequiredRole to match
	 * @param requiredInterfaceId
	 *            the id of the Interface to match
	 * @param requiringAssemblyContext
	 *            the AssemblyContext to match
	 * @return the matching AssemblyConnector within the parent
	 *         ComposedStructure
	 */
	private AssemblyConnector findAssemblyConnectorForRequiringAssemblyContext(
			final String requiredRoleId, final String requiredInterfaceId,
			final AssemblyContext requiringAssemblyContext) {

		// Retrieve the list of AssemblyConnectors within the parent
		// ComposedStructure:
		EList<AssemblyConnector> assConnList = requiringAssemblyContext
				.getParentStructure_AssemblyContext()
				.getAssemblyConnectors_ComposedStructure();

		// Check for each AssemblyConnector in the list if it fulfills
		// the requirements:
		for (AssemblyConnector assConn : assConnList) {
			if (assConn.getRequiringAssemblyContext_AssemblyConnector().getId()
					.equals(requiringAssemblyContext.getId())
					&& assConn.getRequiredRole_AssemblyConnector()
							.getRequiredInterface__OperationRequiredRole()
							.getId().equals(requiredInterfaceId)
					&& assConn.getRequiredRole_AssemblyConnector().getId()
							.equals(requiredRoleId)) {
				return assConn;
			}
		}

		// No AssmblyConnector found:
		return null;
	}

	/**
	 * Searches for the required role of the system that is reached from the
	 * current AssemblyContext via its given required role.
	 * 
	 * The current AssemblyContext is the last element of the assCtxList. If the
	 * required role of the AssemblyContext does not lead to a system required
	 * role, the method returns NULL.
	 * 
	 * @param requiredRole
	 *            the required role of the current AssemblyContext
	 * @return the system required role
	 */
	private OperationRequiredRole findSystemRequiredRoleForCurrentAssemblyContext(
			final OperationRequiredRole requiredRole) {

		// Initialize variables:
		ComposedStructure reqStructure = null;
		int index = assCtxList.size() - 1;
		OperationRequiredRole reqRole = requiredRole;

		// Navigate upwards through the list of parent contexts:
		while ((reqStructure == null)
				|| (!reqStructure.getId().equals(
						pcmInstance.getSystem().getId()))) {

			// Set reqStructure to the parent ComposedStructure of this
			// AssemblyContext:
			reqStructure = assCtxList.get(index)
					.getParentStructure_AssemblyContext();

			// Check for the RequiredDelegationConnector that is connected to
			// this AssemblyContext:
			RequiredDelegationConnector delConn = null;
			for (RequiredDelegationConnector connector : reqStructure
					.getRequiredDelegationConnectors_ComposedStructure()) {
				if (connector.getAssemblyContext_RequiredDelegationConnector()
						.getId().equals(assCtxList.get(index).getId())
						&& connector
								.getInnerRequiredRole_RequiredDelegationConnector()
								.getId().equals(reqRole.getId())) {
					delConn = connector;
					break;
				}
			}
			if (delConn == null) {

				// No RequiredDelegationConnector found:
				return null;
			}

			// Retrieve the outer required role of the connector:
			reqRole = delConn
					.getOuterRequiredRole_RequiredDelegationConnector();

			// Navigate upwards:
			index--;
		}

		// No RequiredDelegationConnector found:
		return reqRole;
	}

	/**
	 * Searches for an AssemblyConnector that connects the current
	 * AssemblyContext via its given requiredRole to its providing counterpart.
	 * 
	 * The current AssemblyContext is the last element of this.assCtxList. The
	 * method traverses any RequiredDelegationConnectors that lie between the
	 * AssemblyContext and its AssemblyConnector. If the role is connected to
	 * the system boundary, the method returns NULL.
	 * 
	 * @param requiredRoleId
	 *            the id of the RequiredRole to match
	 * @param requiredInterfaceId
	 *            the id of the Interface to match
	 * @param isCreateContextWrapper
	 *            if true, this ContextWrapper is modified and the found
	 *            AssemblyContext is removed from the internal assCtxList.
	 *            FIXME: Why does this make sense ever?
	 * @return An AssemblyContext that either is a matching Assem
	 */
	private AssemblyConnector findAssemblyContextForRequiredRole(
			final String requiredRoleId, final String requiredInterfaceId,
			final boolean isCreateContextWrapper) {

		// Navigate upwards the stack of parent AssemblyContexts
		// (starting from the current AssemblyContext):
		for (int i = assCtxList.size() - 1; i >= 0; i--) {

			// Check if the searched AssemblyConnector is directly
			// connected to this AssemblyContext:
			AssemblyConnector matchingAssConn = findAssemblyConnectorForRequiringAssemblyContext(
					requiredRoleId, requiredInterfaceId, assCtxList.get(i));
			if (matchingAssConn != null) {
				if (isCreateContextWrapper) {
					assCtxList.remove(i);
				}
				return matchingAssConn;
			}

			// If no AssemblyConnector is directly attached to this
			// AssemblyContext, check for a RequiredDelegationConnector leading
			// to the boundary of the next higher ComposedStructure. If we are
			// already on the top level (i = 0), the AssemblyConnector is
			// connected to the system boundary, and no providing
			// AssemblyContext exists.
			if (i != 0) {
				matchingAssConn = findFromDelegationConnector(requiredRoleId,
						requiredInterfaceId, assCtxList.get(i), i);
				if (matchingAssConn != null) {
					if (isCreateContextWrapper) {
						assCtxList.remove(i);
						assCtxList.remove(i - 1);
					}
					return matchingAssConn;
				}
			}
		}

		// No AssemblyContext found:
		return null;
	}

	// public AssemblyContext getNextAssemblyContext(ExternalCallAction eca) {
	// String roleId = eca.getRole_ExternalService().getId();
	// Signature serviceToBeCalled = eca.getCalledService_ExternalService();
	// Interface requiredInterface = (Interface) serviceToBeCalled
	// .eContainer();
	//
	// AssemblyConnector matchingAssConn = null;
	// EList<AssemblyConnector> assConnList = pcmInstance.getSystem()
	// .getAssemblyConnectors_ComposedStructure();
	//	
	// for (AssemblyConnector assConn : assConnList) {
	// if (assConn
	// .getRequiringAssemblyContext_AssemblyConnector()
	// .getId().equals(getAssCtx().getId())
	// && assConn.getRequiredRole_AssemblyConnector()
	// .getRequiredInterface__RequiredRole().getId()
	// .equals(requiredInterface.getId())
	// && assConn.getRequiredRole_AssemblyConnector()
	// .getId().equals(roleId)) {
	// matchingAssConn = assConn;
	// }
	// }
	//		
	// if (matchingAssConn != null) {
	// return matchingAssConn
	// .getProvidingAssemblyContext_AssemblyConnector();
	// } else
	// return null;
	// }

	/**
	 * Find a matching AssemblyConnector by looking at the
	 * RequiredDelegationConnectors of this AssemblyContext ac. Step up the
	 * composition one step and find the matching AssemblyConnector and then
	 * return that found AssemblyConnector.
	 * 
	 * Does not modify this ContextWrapper.
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

		for (RequiredDelegationConnector reqConn : reqDelConnList) {
			if (reqConn.getInnerRequiredRole_RequiredDelegationConnector()
					.getId().equals(roleId)
					&& reqConn
							.getInnerRequiredRole_RequiredDelegationConnector()
							.getRequiredInterface__OperationRequiredRole()
							.getId().equals(interfaceId)) {
				String outerRoleId = reqConn
						.getOuterRequiredRole_RequiredDelegationConnector()
						.getId();
				AssemblyContext compositeComponentAssemblyContext = assCtxList
						.get(i - 1);
				String compositeComponentAssCtxId = compositeComponentAssemblyContext
						.getId();

				EList<AssemblyConnector> assConnList = compositeComponentAssemblyContext
						.getParentStructure_AssemblyContext()
						.getAssemblyConnectors_ComposedStructure();

				for (AssemblyConnector assConn : assConnList) {
					if (assConn.getRequiringAssemblyContext_AssemblyConnector()
							.getId().equals(compositeComponentAssCtxId)
							&& assConn
									.getRequiredRole_AssemblyConnector()
									.getRequiredInterface__OperationRequiredRole()
									.getId().equals(interfaceId)
							&& assConn.getRequiredRole_AssemblyConnector()
									.getId().equals(outerRoleId)) {
						return assConn;
					}
				}
			}
		}
		return null;
	}

	private ComputedAllocationContext getExistingComputedAllocationContext(
			ComputedUsageContext compUsgCtx) {
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
	 * Try to find an existingf {@link ComputedUsageContext} for the passed
	 * ExternalCall. This method checks whether the references
	 * {@link AssemblyContext} match as well as whether the required variables
	 * match. If none is found, null is returned and a new
	 * {@link ComputedUsageContext} needs to be created. As a side effect, the
	 * {@link ExternalCallInput} of the current context is set by calling
	 * addExternalCallInputToCurrentContext.
	 * 
	 * @param eca
	 * @return A found matching {@link ComputedUsageContext} or null.
	 */
	private ComputedUsageContext getExistingComputedUsageContext(
			ExternalCallAction eca) {
		EList<ExternalCallInput> eciList = compUsgCtx
				.getExternalCallInput_ComputedUsageContext();
		if (eciList.size() == 0) {
			EList<ComputedUsageContext> cucList = pcmInstance
					.getComputedUsage().getUsageContexts_ComputedUsage();

			// if input has no variables, we can take the first matching one
			// without variables.
			if (eca.getInputVariableUsages__CallAction().size() == 0) {
				for (ComputedUsageContext cuc : cucList) {
					// assCtx already points to the next assCtx after the
					// external
					// call
					AssemblyContext referencedAssemblyContext = cuc
							.getAssemblyContext_ComputedUsageContext();
					AssemblyContext assemblyContextThisCallIsComingFrom = getAssCtx();
					if (referencedAssemblyContext.getId().equals(
							assemblyContextThisCallIsComingFrom.getId())
							&& cuc.getInput_ComputedUsageContext()
									.getParameterChacterisations_Input().size() == 0) {
						// do not forget to create the external call input to
						// current context:
						ExternalCallInput extCallIn = addExternalCallInputToCurrentContext(eca);
						return cuc;
					}
				}
			}
			ExternalCallInput extCallIn = addExternalCallInputToCurrentContext(eca);
			// check whether this pcm instances context contains matching input,
			// compare by variable list.
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

	private AssemblyContext getFirstAssemblyContext(EntryLevelSystemCall elsa) {
		Signature serviceToBeCalled = elsa
				.getOperationSignature__EntryLevelSystemCall();
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
					return pdc.getAssemblyContext_ProvidedDelegationConnector();
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

	public List<AssemblyContext> getFirstAssemblyContext2(
			EntryLevelSystemCall elsa) {
		String roleId = elsa.getProvidedRole_EntryLevelSystemCall().getId();
		// Signature serviceToBeCalled =
		// elsa.getSignature_EntryLevelSystemCall();
		// Interface requiredInterface = (Interface) serviceToBeCalled
		// .eContainer();
		// String interfaceId = requiredInterface.getId();
		ProvidedRole startingRole = elsa.getProvidedRole_EntryLevelSystemCall();

		AssemblyContext startingAssCtx = null;

		EList<ProvidedDelegationConnector> pdcList = pcmInstance.getSystem()
				.getProvidedDelegationConnectors_ComposedStructure();
		for (ProvidedDelegationConnector pdc : pdcList) {
			if (pdc.getOuterProvidedRole_ProvidedDelegationConnector().getId()
					.equals(roleId)) {
				startingAssCtx = pdc
						.getAssemblyContext_ProvidedDelegationConnector();
				startingRole = pdc
						.getInnerProvidedRole_ProvidedDelegationConnector();
			}
		}

		if (startingAssCtx != null) {
			return getAssCtxs(startingAssCtx, startingRole,
					new BasicEList<AssemblyContext>());
		} else {
			// "Something is wrong with your ProvidedDelegationConnectors: Are they all bound to proper roles?"
			return null;
		}
	}

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
			VariableUsageHelper.copySolvedVariableUsageToInput(newCompUsgCtx
					.getInput_ComputedUsageContext(), this, parList);

			addComponentParametersToNewContext(newCompUsgCtx);
			return newCompUsgCtx;
		}
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
			Iterator<AssemblyContext> nextAssCtxIterator) {
		// The following assumes that there is only one allocation
		// context for each assembly context. This is a preliminary
		// simplification until further concepts for component
		// replication are worked out.

		if (nextAssCtxIterator.hasNext()) {
			AssemblyContext nextAssCtx = nextAssCtxIterator.next();

			EList<AllocationContext> allCtxList = pcmInstance.getAllocation()
					.getAllocationContexts_Allocation();

			for (AllocationContext allCtx : allCtxList) {
				if (allCtx.getAssemblyContext_AllocationContext().getId()
						.equals(nextAssCtx.getId())) {
					return allCtx;
				}
			}
			return getNextAllocationContext(nextAssCtxIterator);
		}
		// TODO: throw exception
		return null;
	}

	/**
	 * Get the next {@link AllocationContext}. If this is a composite component,
	 * then the passed nextAssCtxList contains several {@link AssemblyContext}.
	 * The outer component is the one that is usally allocated (if composite and
	 * non-completion). If no allocation for the outer can be found, check for
	 * inner (e.g. for subsystems and completions).
	 * 
	 * @param nextAssCtxList
	 *            : List of the hierarchy of the current assembly contexts.
	 *            Contains several {@link AssemblyContext} if the components are
	 *            composite The first is the outmost component.
	 * @see ContextWrapper#getAssCtxList()
	 * @return
	 */
	private AllocationContext getNextAllocationContext(
			List<AssemblyContext> nextAssCtxList) {
		return getNextAllocationContext(nextAssCtxList.iterator());
	}

	/**
	 * Calculated the next context based on the passed one and the current
	 * allCtx of this ContextWrapper.
	 * 
	 * @param compUsgCtx
	 * @return
	 */
	private ComputedAllocationContext getNextComputedAllocationContext(
			ComputedUsageContext compUsgCtx) {
		logger.debug("In getNextComputedAllocationContext ");

		ComputedAllocationContext cac = getExistingComputedAllocationContext(compUsgCtx);
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

	private void handleComputedContexts(ComputedUsageContext cuc,
			ComputedAllocationContext cac) {
		compUsgCtx = cuc;
		compUsgCtx.setAssemblyContext_ComputedUsageContext(getAssCtx());
		compAllCtx = cac;
		compAllCtx.setAllocationContext_ComputedAllocationContext(allCtx);
		readComputedContextsToHashMaps();
	}

	/**
	 * Tries to find the {@link ComputedUsageContext} in the pcm instance that
	 * 1) references the same assembly context for that we want to have an
	 * ComputedUsageContext and 2) references the same list of variables we are
	 * looking for.
	 * 
	 * @param vuList
	 * @return A matching {@link ComputedUsageContext} or null.
	 */
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
		return null;
	}

	private void readComputedContextsToHashMaps() {
		EList<BranchProbability> bpList = compUsgCtx
				.getBranchProbabilities_ComputedUsageContext();
		for (BranchProbability bp : bpList) {
			branchProbs.put(bp.getBranchtransition_BranchProbability(), bp
					.getProbability());
		}

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

		EList<ResourceDemand> rdList = compAllCtx
				.getResourceDemands_ComputedAllocationContext();
		for (ResourceDemand rd : rdList) {
			// These are already solved expressions, they do not contain
			// variables.
			String spec = rd.getSpecification_ResourceDemand()
					.getSpecification();

			Expression rdExpression = ExpressionHelper.parseToExpression(spec);

			ExpressionToPDFWrapper rdWrapper = ExpressionToPDFWrapper
					.createExpressionToPDFWrapper(rdExpression);
			resDemands.put(rd.getParametricResourceDemand_ResourceDemand(),
					rdWrapper);

			/*
			 * FunctionLiteral function;
			 * function.getParameters_FunctionLiteral()
			 */

			// ManagedPDF pdf = null;
			// try {
			// pdf = ManagedPDF.createFromString(spec);
			// } catch (StringNotPDFException e) {
			// e.printStackTrace();
			// } catch (RecognitionException e) {
			// e.printStackTrace();
			// }

		}

		// Store the mapping which ParametricResourceDemand accesses which
		// Resource in this context.
		for (ResourceDemand rd : rdList) {
			ParametricResourceDemand prd = rd
					.getParametricResourceDemand_ResourceDemand();
			ProcessingResourceType prt = prd
					.getRequiredResource_ParametricResourceDemand();
			EList<ProcessingResourceSpecification> prsList = allCtx
					.getResourceContainer_AllocationContext()
					.getActiveResourceSpecifications_ResourceContainer();
			for (ProcessingResourceSpecification prs : prsList) {
				ProcessingResourceType prsType = prs
						.getActiveResourceType_ActiveResourceSpecification();
				if (prsType.getId().equals(prt.getId())) {
					procResources.put(prd, prs);
				}
			}
		}

		EList<ExternalCallInput> eciList = compUsgCtx
				.getExternalCallInput_ComputedUsageContext();
		EList<LinkingResource> lrList = pcmInstance.getResourceEnvironment()
				.getLinkingResources__ResourceEnvironment();
		ResourceContainer rc1 = allCtx.getResourceContainer_AllocationContext();
		for (ExternalCallInput eci : eciList) {
			ExternalCallAction eca = eci
					.getExternalCallAction_ExternalCallInput();

			List<AssemblyContext> acList = findProvidingAssemblyContexts(eca,
					false);
			AllocationContext nextAllCtx = getNextAllocationContext(acList);
			ResourceContainer rc2 = nextAllCtx
					.getResourceContainer_AllocationContext();

			if (rc1 != rc2) {
				for (LinkingResource lr : lrList) {

					// ------------------------------
					// contains() does NOT work (fb)!
					// ------------------------------
					// if
					// (lr.getFromResourceContainer_LinkingResource().contains(rc1)
					// &&
					// lr.getToResourceContainer_LinkingResource().contains(rc2)){

					boolean rc1Contained = exists(lr
							.getConnectedResourceContainers_LinkingResource(),
							rc1);
					boolean rc2Contained = exists(lr
							.getConnectedResourceContainers_LinkingResource(),
							rc2);
					if (rc1Contained && rc2Contained) {
						CommunicationLinkResourceSpecification clrs = lr
								.getCommunicationLinkResourceSpecifications_LinkingResource();
						linkResources.put(eca, clrs);
					}
				}
			}
		}
	}
}

/**
 * Cache for the solved resource demands. Stores both pdfs and constant demands.
 * Offers methods to retrieve the actual demand for a ParametricResourceDemand
 * as aa double (i.e. mean value or constant) or PDF.
 * 
 * @author martens
 * 
 */
class ResourceDemandCache {
	private HashMap<ParametricResourceDemand, ExpressionToPDFWrapper> resDemandDistributions = new HashMap<ParametricResourceDemand, ExpressionToPDFWrapper>();

	/**
	 * Returns the resource demand for the passed
	 * {@link ParametricResourceDemand} as a {@link Double}. May return null if
	 * there was no matching resource demand found internally. If the resource
	 * demand was only given as a pdf before, it also puts the Double in the
	 * cache for future use.
	 * 
	 * @param prd
	 * @return
	 */
	public Double getDouble(ParametricResourceDemand prd) {
		if (this.resDemandDistributions.containsKey(prd)) {
			return this.resDemandDistributions.get(prd).getMeanValue();
		}
		return null;
	}

	/**
	 * Returns the resource demand for the passed
	 * {@link ParametricResourceDemand} as a {@link ManagedPDF}. May return null
	 * if there was no matching resource demand found internally. If the
	 * resource demand was only given as a double before, it also puts the new
	 * pdf in the cache for future use.
	 * 
	 * @param prd
	 * @return
	 */
	public ManagedPDF getPDF(ParametricResourceDemand prd) {
		if (this.resDemandDistributions.containsKey(prd)) {
			return new ManagedPDF(resDemandDistributions.get(prd).getPDF());
		}
		return null;
	}

	/**
	 * Returns whether this resource demand is a derived pdf (i.e. it has been
	 * created using a mean value) or whether it is an original pdf (i.e. the
	 * mean value is derived).
	 * 
	 * @return true if it has been created using
	 *         {@link #put(ParametricResourceDemand, ProbabilityDensityFunction)}
	 *         , false if this has been created using
	 *         {@link #put(ParametricResourceDemand, Double)}.
	 */
	public boolean isOriginalPDF(ParametricResourceDemand prd) {
		if (this.resDemandDistributions.containsKey(prd)) {
			return this.resDemandDistributions.get(prd).isOriginalPDF();
		} else {
			return false;
		}
	}

	public void put(ParametricResourceDemand parametricResourceDemand,
			ExpressionToPDFWrapper rdWrapper) {
		this.resDemandDistributions.put(parametricResourceDemand, rdWrapper);

	}

}
