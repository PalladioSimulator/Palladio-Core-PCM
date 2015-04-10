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
import de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput;
import de.uka.ipd.sdq.context.computed_usage.Input;
import de.uka.ipd.sdq.context.computed_usage.LoopIteration;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.SpecifiedReliabilityAnnotation;
import de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
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
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.VariableUsageHelper;
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
 * TODO: This class is way too big and needs refactoring. For many methods, it
 * would make sense to re-write them so that they only depend on their input
 * parameters (and not on the state of the object). This should make it much
 * easier to understand the code. Moreover, context-independent methods
 * can be outsourced into helper classes.
 * 
 * @see Heiko's dissertation, section 6.2.4 at
 *      http://docserver.bis.uni-oldenburg
 *      .de/_publikationen/dissertation/2008/kozpar08/pdf/kozpar08.pdf
 * @author Heiko Koziolek
 * 
 */
public class ContextWrapper implements Cloneable {

	/**
	 * 
	 */
	protected static Logger logger = Logger.getLogger(ContextWrapper.class
			.getName());

	/**
	 * Creates a List of {@link ContextWrapper}s to handle the given
	 * {@link EntryLevelSystemCall}. One {@link ContextWrapper} is created for
	 * each {@link AllocationContext} the receiving component is allocated to.
	 * Thus, callers must handle multiple component allocation instances of the
	 * called component. One ContextWrapper then handles the context of that
	 * particular component instance (i.e. one replica) These are new
	 * ContextWrappers without any previous context information.
	 * */
	public static List<ContextWrapper> getContextWrapperFor(
			EntryLevelSystemCall elsa, PCMInstance pcm) {

		ContextWrapper templateContextWrapper = new ContextWrapper();
		templateContextWrapper.pcmInstance = pcm;

		List<AssemblyContext> handlingAssemblyContexts = PCMInstanceHelper
				.getHandlingAssemblyContexts(elsa, pcm.getSystem());
		templateContextWrapper.setAssCtxList(handlingAssemblyContexts);

		ComputedUsageContext computedUsageContext = templateContextWrapper
				.getFirstComputedUsageContext(elsa);
		templateContextWrapper.setCompUsgCtx(computedUsageContext);

		List<ContextWrapper> contextWrapperList = createContextWrappersBasedOnTemplate(
				templateContextWrapper, handlingAssemblyContexts,
				computedUsageContext);

		return contextWrapperList;
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
	public static List<ContextWrapper> getContextWrapperFor(
			ExternalCallAction eca, ComputedUsageContext cuc,
			ComputedAllocationContext cac, ContextWrapper oldContextWrapper) {

		ContextWrapper templateContextWrapper = new ContextWrapper();
		templateContextWrapper.pcmInstance = oldContextWrapper.getPcmInstance();

		templateContextWrapper
				.setAssCtxList(PCMInstanceHelper.getHandlingAssemblyContexts(
						eca, oldContextWrapper.assCtxList));
		List<AllocationContext> allocationContextList = templateContextWrapper
				.getNextAllocationContextList(templateContextWrapper
						.getAssCtxList());
		List<ContextWrapper> contextWrapperList = new ArrayList<ContextWrapper>(
				allocationContextList.size());
		for (AllocationContext allocationContext : allocationContextList) {
			// XXX: only a fully initialised context wrapper can be cloned...
			templateContextWrapper.setAllCtx(allocationContext);

			ContextWrapper contextWrapper = (ContextWrapper) templateContextWrapper
					.clone();
			contextWrapper.setAllCtx(allocationContext);
			contextWrapperList.add(contextWrapper);
			contextWrapper.handleComputedContexts(cuc, cac);
		}
		return contextWrapperList;
	}

	/**
	 * Uses the passed ContextWrapper as a template to create new ones for each
	 * called AllocationContext The template is needed to keep existing usage
	 * information such as branch probabilities.
	 * 
	 * @param templateContextWrapper
	 * @param calledAssemblyContextList
	 * @param computedUsageContext
	 * @return
	 */
	private static List<ContextWrapper> createContextWrappersBasedOnTemplate(
			ContextWrapper templateContextWrapper,
			List<AssemblyContext> calledAssemblyContextList,
			ComputedUsageContext computedUsageContext) {

		List<AllocationContext> allocationContextList = templateContextWrapper
				.getNextAllocationContextList(templateContextWrapper
						.getAssCtxList());
		List<ContextWrapper> contextWrapperList = new ArrayList<ContextWrapper>(
				allocationContextList.size());

		for (AllocationContext allocationContext : allocationContextList) {
			ContextWrapper contextWrapper = (ContextWrapper) templateContextWrapper
					.clone();
			contextWrapper.setAllCtx(allocationContext);
			contextWrapper.setCompAllCtx(contextWrapper
					.getNextComputedAllocationContext(contextWrapper
							.getCompUsgCtx()));
			contextWrapper.readComputedContextsToHashMaps();
			contextWrapperList.add(contextWrapper);
		}
		return contextWrapperList;
	}

	/**
	 * 
	 */
	private AllocationContext allCtx;

	/**
	 * See {@link #getAssCtxList()} for info.
	 */
	private List<AssemblyContext> assCtxList;

	/**
	 * 
	 */
	private HashMap<AbstractBranchTransition, Double> branchProbs = new HashMap<AbstractBranchTransition, Double>();

	/**
	 * 
	 */
	private ComputedAllocationContext compAllCtx;

	/**
	 * 
	 */
	private ComputedUsageContext compUsgCtx;

	/**
	 * 
	 */
	private HashMap<ExternalCallAction, Double> inputParameterBytesizes = new HashMap<ExternalCallAction, Double>();

	/**
	 * 
	 */
	private CallsToLinkResourcesMap linkResources = new CallsToLinkResourcesMap();

	/**
	 * 
	 */
	private HashMap<AbstractLoopAction, ManagedPMF> loopIters = new HashMap<AbstractLoopAction, ManagedPMF>();

	/**
	 * 
	 */
	private HashMap<ExternalCallAction, Double> outputParameterBytesizes = new HashMap<ExternalCallAction, Double>();

	/**
	 * 
	 */
	private PCMInstance pcmInstance;

	/**
	 * 
	 */
	private HashMap<ParametricResourceDemand, ProcessingResourceSpecification> procResources = new HashMap<ParametricResourceDemand, ProcessingResourceSpecification>();

	/**
	 * Contains the already solved resource demand in time on the specific
	 * processor
	 */
	private ResourceDemandCache resDemands = new ResourceDemandCache();

	/**
	 * Creates an empty ContextWrapper instance based only on the given PCM
	 * model instance.
	 * 
	 * @param pcmInstance
	 *            the PCM model instance
	 */
	public ContextWrapper(final PCMInstance pcmInstance) {
		this.pcmInstance = pcmInstance;
	}

	/**
	 * Standard constructor.
	 * 
	 * Protected, only for private use through clone().
	 */
	private ContextWrapper() {
	}

	/**
	 * Copies this ContextWrapper. Sets references to the PCM model elements and
	 * the computed context objects, so that the context can be shared (e.g.
	 * retrieving branch probabilities of earlier context wrapper traversals).
	 */
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

		if (compAllCtx != null && compUsgCtx != null) {
			clonedWrapper.readComputedContextsToHashMaps();
		}
		return clonedWrapper;
	}

	/**
	 * 
	 * @return
	 */
	public AllocationContext getAllCtx() {
		return allCtx;
	}

	/**
	 * 
	 * @return
	 */
	public AssemblyContext getAssCtx() {
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

	/**
	 * 
	 * @param abt
	 * @return
	 */
	public Double getBranchProbability(AbstractBranchTransition abt) {
		return branchProbs.get(abt);
	}

	/**
	 * 
	 * @return
	 */
	public ComputedAllocationContext getCompAllCtx() {
		return compAllCtx;
	}

	/**
	 * 
	 * @return
	 */
	public ComputedUsageContext getCompUsgCtx() {
		return compUsgCtx;
	}

	/**
	 * 
	 * @param eca
	 * @param targetAllocationContext
	 * @return
	 */
	public CommunicationLinkResourceSpecification getConcreteLinkingResource(
			ExternalCallAction eca, AllocationContext targetAllocationContext) {
		return linkResources.get(eca, targetAllocationContext);
	}

	/**
	 * 
	 * @param aa
	 * @return
	 */
	public PassiveResource getConcretePassiveResource(AcquireAction aa) {
		// TODO: Passive Resource should depend on AssemblyContext
		return aa.getPassiveresource_AcquireAction();
	}

	/**
	 * 
	 * @param ra
	 * @return
	 */
	public PassiveResource getConcretePassiveResource(ReleaseAction ra) {
		// TODO: Passive Resource should depend on AssemblyContext
		return ra.getPassiveResource_ReleaseAction();
	}

	/**
	 * 
	 * @param prd
	 * @return
	 */
	public ProcessingResourceSpecification getConcreteProcessingResource(
			ParametricResourceDemand prd) {
		return procResources.get(prd);
	}

	/**
	 * FIXME: This method changes the current ContextWrapper this, but returns a
	 * {@link List} of new {@link ContextWrapper} instances created based on
	 * this one. It needs to use the current context in order to retain
	 * information such as branch probabilities
	 * 
	 * @param elsa
	 * @return
	 */
	public List<ContextWrapper> getContextWrapperFor(EntryLevelSystemCall elsa) {

		assCtxList = PCMInstanceHelper.getHandlingAssemblyContexts(elsa,
				pcmInstance.getSystem());
		compUsgCtx = getFirstComputedUsageContext(elsa);

		return createContextWrappersBasedOnTemplate(this, assCtxList,
				compUsgCtx);
	}

	/**
	 * FIXME: This method changes the current ContextWrapper this, but returns a
	 * {@link List} of new {@link ContextWrapper} instances created based on
	 * this one. It needs to use the current context in order to retain
	 * information such as branch probabilities
	 * 
	 * @param eca
	 * @return A {@link List} of new {@link ContextWrapper} instances, but also
	 *         changes this one.
	 */
	public List<ContextWrapper> getContextWrapperFor(ExternalCallAction eca) {

		assCtxList = PCMInstanceHelper.getHandlingAssemblyContexts(eca,
				assCtxList);
		compUsgCtx = getNextComputedUsageContext(eca);

		List<ContextWrapper> contextWrapperList = createContextWrappersBasedOnTemplate(
				this, assCtxList, compUsgCtx);

		return contextWrapperList;
	}

	/**
	 * 
	 * @param eca
	 * @param clrs
	 * @return
	 */
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
	 * 
	 * @param prd
	 * @return
	 */
	public boolean getIsOriginalPDFFor(ParametricResourceDemand prd) {
		return this.resDemands.isOriginalPDF(prd);
	}

	/**
	 * 
	 * @param ala
	 * @return
	 */
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

	/**
	 * 
	 * @param eca
	 * @return
	 */
	public Double getMeanTotalInputParameterBytesize(ExternalCallAction eca) {
		return inputParameterBytesizes.get(eca);
	}

	/**
	 * 
	 * @param eca
	 * @return
	 */
	public Double getMeanTotalOutputParameterBytesize(ExternalCallAction eca) {
		return outputParameterBytesizes.get(eca);
	}

	/**
	 * 
	 * @param elsc
	 * @return
	 */
	public ServiceEffectSpecification getNextSEFF(EntryLevelSystemCall elsc) {
		Signature sig = elsc.getOperationSignature__EntryLevelSystemCall();

		List<AssemblyContext> acList = PCMInstanceHelper
				.getHandlingAssemblyContexts(elsc, pcmInstance.getSystem());

		AssemblyContext ac = acList.get(acList.size() - 1);
		BasicComponent bc = (BasicComponent) ac
				.getEncapsulatedComponent__AssemblyContext();
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
		List<AssemblyContext> acList = PCMInstanceHelper
				.getHandlingAssemblyContexts(eca, assCtxList);
		if (acList.size() == 0) {
			// If no providing AssemblyContexts are found, the call is a system
			// external call, and there is no next SEFF for it:
			return null;
		}

		// Retrieve the actual handling AssemblyContext of the call:
		AssemblyContext ac = acList.get(acList.size() - 1);

		// Retrieve the actual SEFF that handles the call:
		BasicComponent bc = (BasicComponent) ac
				.getEncapsulatedComponent__AssemblyContext();
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

	/**
	 * 
	 * 
	 * @return
	 */
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

	/**
	 * 
	 * @param prd
	 * @return
	 */
	public String getTimeConsumptionSpecification(ParametricResourceDemand prd) {
		String resultSpecification = resDemands.getPDF(prd).toString();
		return resultSpecification;
	}

	/**
	 * 
	 * @param allCtx
	 */
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

	/**
	 * 
	 * @param compAllCtx
	 */
	public void setCompAllCtx(ComputedAllocationContext compAllCtx) {
		this.compAllCtx = compAllCtx;
	}

	/**
	 * 
	 * @param compUsgCtx
	 */
	public void setCompUsgCtx(ComputedUsageContext compUsgCtx) {
		this.compUsgCtx = compUsgCtx;
	}

	/**
	 * 
	 * @param pcmInstance
	 */
	public void setPcmInstance(PCMInstance pcmInstance) {
		this.pcmInstance = pcmInstance;
	}

	/**
	 * 
	 * @param newCompUsgCtx
	 */
	private void addComponentParametersToNewContext(
			ComputedUsageContext newCompUsgCtx) {

		// We need to make a copy because the VariableUsages are changed if they
		// are overwritten by configuration parameters from the assembly
		// context.
		Collection<VariableUsage> compParams = copyComponentParameters(getAssCtx());

		EList<VariableUsage> confParList = this.getAssCtx()
				.getConfigParameterUsages__AssemblyContext();

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

	/**
	 * 
	 * @param eca
	 * @return
	 */
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

	/**
	 * 
	 * @param vuList1
	 * @param vuList2
	 * @return
	 */
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

	/**
	 * 
	 * @param context
	 * @return
	 */
	private Collection<VariableUsage> copyComponentParameters(
			AssemblyContext context) {
		ImplementationComponentType component = (ImplementationComponentType) context
				.getEncapsulatedComponent__AssemblyContext();
		List<VariableUsage> originalVariableUsages = component
				.getComponentParameterUsage_ImplementationComponentType();

		Collection<VariableUsage> newVariableUsages = VariableUsageHelper
				.copyVariableUsageList(originalVariableUsages);

		return newVariableUsages;

	}

	/**
	 * 
	 * @param eca
	 * @return
	 */
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
					.getParentStructure__AssemblyContext();

			// Check for the RequiredDelegationConnector that is connected to
			// this AssemblyContext:
			RequiredDelegationConnector delConn = null;
			for (Connector conn : reqStructure
					.getConnectors__ComposedStructure()) {
				if (conn instanceof RequiredDelegationConnector) {
					RequiredDelegationConnector connector = (RequiredDelegationConnector) conn;
					if (connector
							.getAssemblyContext_RequiredDelegationConnector()
							.getId().equals(assCtxList.get(index).getId())
							&& connector
									.getInnerRequiredRole_RequiredDelegationConnector()
									.getId().equals(reqRole.getId())) {
						delConn = connector;
						break;
					}
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
	 * 
	 * @param compUsgCtx
	 * @return
	 */
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
	 * Try to find an existing {@link ComputedUsageContext} for the passed
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

	/**
	 * 
	 * @param elsa
	 * @return
	 */
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

	/**
	 * 
	 * @param ref
	 * @return
	 */
	private String getFullParameterName(AbstractNamedReference ref) {
		String name = "";
		while (ref instanceof NamespaceReference) {
			NamespaceReference nsRef = (NamespaceReference) ref;
			name += nsRef.getReferenceName() + ".";
			ref = nsRef.getInnerReference_NamespaceReference();
		}
		return name += ref.getReferenceName();
	}

	/**
	 * Assumes that all parameter specifications are solved for the given
	 * ExternalCallAction.
	 * 
	 * Sums up the mean values for all BYTESIZE characterizations for all input
	 * parameters (on the lowest level only). If no BYTESIZE is specified,
	 * assumes 0 bytes.
	 * 
	 * @param eca
	 *            the ExternalCallAction with solved parameters
	 * @return the mean total parameter bytesize
	 */
	private Double getMeanTotalInputParameterBytesize(ExternalCallInput eci) {
		Double meanTotalInputParameterBytesize = 0.0;

		for (VariableUsage usage : eci
				.getParameterCharacterisations_ExternalCallInput()) {
			for (VariableCharacterisation vchar : usage
					.getVariableCharacterisation_VariableUsage()) {
				if (vchar.getType() == VariableCharacterisationType.BYTESIZE) {
					ManagedPMF pmf;
					try {
						pmf = ManagedPMF.createFromString(vchar
								.getSpecification_VariableCharacterisation()
								.getSpecification());
					} catch (Exception e) {
						throw new RuntimeException(
								"Error calculating MeanTotalInputParameterBytesize.");
					}

					meanTotalInputParameterBytesize += pmf.getExpectedValue();
				}
			}
		}

		return meanTotalInputParameterBytesize;
	}

	/**
	 * Assumes that all parameter specifications are solved for the given
	 * ExternalCallAction.
	 * 
	 * Sums up the mean values for all BYTESIZE characterizations for all output
	 * parameters (on the lowest level only). If no BYTESIZE is specified,
	 * assumes 0 bytes.
	 * 
	 * @param eca
	 *            the ExternalCallAction with solved parameters
	 * @return the mean total parameter bytesize
	 */
	private Double getMeanTotalOutputParameterBytesize(ExternalCallOutput eco) {
		Double meanTotalOutputParameterBytesize = 0.0;

		for (VariableUsage usage : eco
				.getParameterCharacterisations_ExternalCallOutput()) {
			for (VariableCharacterisation vchar : usage
					.getVariableCharacterisation_VariableUsage()) {
				if (vchar.getType() == VariableCharacterisationType.BYTESIZE) {
					ManagedPMF pmf;
					try {
						pmf = ManagedPMF.createFromString(vchar
								.getSpecification_VariableCharacterisation()
								.getSpecification());
					} catch (Exception e) {
						throw new RuntimeException(
								"Error calculating MeanTotalInputParameterBytesize.");
					}

					meanTotalOutputParameterBytesize += pmf.getExpectedValueDouble();
				}
			}
		}

		return meanTotalOutputParameterBytesize;
	}

	/**
	 * It can be multiple ones if the component is replicated to several
	 * servers. Otherwise the list contains only one element.
	 * 
	 * @param nextAssCtxIterator
	 * @return
	 * @see #getNextAllocationContextList(List)
	 */
	private List<AllocationContext> getNextAllocationContextList(
			Iterator<AssemblyContext> nextAssCtxIterator) {
		if (nextAssCtxIterator.hasNext()) {
			AssemblyContext nextAssCtx = nextAssCtxIterator.next();

			EList<AllocationContext> allCtxList = pcmInstance.getAllocation()
					.getAllocationContexts_Allocation();

			// return all AllocationContexts this AssemblyContext is allocated
			// to
			List<AllocationContext> targetAllocationContextList = new ArrayList<AllocationContext>();
			for (AllocationContext allCtx : allCtxList) {
				if (allCtx.getAssemblyContext_AllocationContext().getId()
						.equals(nextAssCtx.getId())) {
					targetAllocationContextList.add(allCtx);
				}
			}
			if (targetAllocationContextList.size() >= 0) {
				return targetAllocationContextList;
			} else {
				return getNextAllocationContextList(nextAssCtxIterator);
			}
		}
		// TODO: throw exception
		return null;
	}

	/**
	 * Get the next {@link AllocationContext}s. It can be multiple ones if the
	 * component is replicated to several servers. Otherwise the list contains
	 * only one element. If this is a composite component, then the passed
	 * nextAssCtxList contains several {@link AssemblyContext}. The outer
	 * component is the one that is usally allocated (if composite and
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
	private List<AllocationContext> getNextAllocationContextList(
			List<AssemblyContext> nextAssCtxList) {
		return getNextAllocationContextList(nextAssCtxList.iterator());
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
				.getEncapsulatedComponent__AssemblyContext()
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

	/**
	 * 
	 * @param cuc
	 * @param cac
	 */
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

	/**
	 * 
	 */
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
			ExpressionToPDFWrapper rdWrapper = null;

			try {
				rdWrapper = ExpressionToPDFWrapper
						.createExpressionToPDFWrapper(rdExpression);
			} catch (Exception e) {
				throw new IllegalArgumentException(
						"Could not derive a PDF from expression \"" + spec
								+ "\"; Exception type: "
								+ e.getClass().getName()
								+ "; Error message: \"" + e.getMessage() + "\"");
			}
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

			// special case for system external calls:
			if (prt.getEntityName().equals("SystemExternalResource")) {
				EList<ResourceContainer> containerList = getPcmInstance()
						.getResourceEnvironment()
						.getResourceContainer_ResourceEnvironment();
				for (ResourceContainer container : containerList) {
					if (container.getEntityName().equals(
							"SystemExternalResourceContainer")) {
						ProcessingResourceSpecification prs = container
								.getActiveResourceSpecifications_ResourceContainer()
								.get(0);
						procResources.put(prd, prs);
					}
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

			List<AssemblyContext> acList = PCMInstanceHelper
					.getHandlingAssemblyContexts(eca, assCtxList);

			List<AllocationContext> allocationContextList = getNextAllocationContextList(acList);
			for (AllocationContext nextAllCtx : allocationContextList) {

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

						boolean rc1Contained = exists(
								lr
										.getConnectedResourceContainers_LinkingResource(),
								rc1);
						boolean rc2Contained = exists(
								lr
										.getConnectedResourceContainers_LinkingResource(),
								rc2);
						if (rc1Contained && rc2Contained) {
							CommunicationLinkResourceSpecification clrs = lr
									.getCommunicationLinkResourceSpecifications_LinkingResource();
							linkResources.put(eca, nextAllCtx, clrs);
						}
					}
				}
			}
		}

		// also compute and store parameter BYTESIZEs
		for (ExternalCallInput eci : compUsgCtx
				.getExternalCallInput_ComputedUsageContext()) {
			inputParameterBytesizes.put(eci
					.getExternalCallAction_ExternalCallInput(),
					getMeanTotalInputParameterBytesize(eci));
		}
		for (ExternalCallOutput eco : compUsgCtx
				.getExternalCallOutput_ComputedUsageContext()) {
			outputParameterBytesizes.put(eco
					.getExternalCallAction_ExternalCallOutput(),
					getMeanTotalOutputParameterBytesize(eco));
		}
	}
}
