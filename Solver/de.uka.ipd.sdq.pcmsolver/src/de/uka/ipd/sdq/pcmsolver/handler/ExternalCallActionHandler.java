package de.uka.ipd.sdq.pcmsolver.handler;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput;
import de.uka.ipd.sdq.context.computed_usage.Input;
import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.SpecifiedExecutionTime;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypeFactory;
import de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformanceFactory;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.pcmsolver.visitors.VariableUsageHelper;

public class ExternalCallActionHandler {
	
	private SeffVisitor visitor;
	
	private ComputedUsageFactory compUsageFactory = ComputedUsageFactory.eINSTANCE;
	
	private ComputedAllocationFactory compAllocationFactory = ComputedAllocationFactory.eINSTANCE;
	
	private SeffFactory seffFactory = SeffFactory.eINSTANCE;
	
	private SeffPerformanceFactory performanceFactory = SeffPerformanceFactory.eINSTANCE;
	
	private static Logger logger = Logger.getLogger(ExternalCallActionHandler.class.getName());
	
	public ExternalCallActionHandler(SeffVisitor seffVisitor){
		visitor=seffVisitor;
	}
	
	/**
	 * @param call
	 */
	public void handle(ExternalCallAction call) {

		Signature serviceToBeCalled = call.getCalledService_ExternalService();
		ServiceEffectSpecification seff = visitor.getContextWrapper().getNextSEFF(call);
		
		if (seff == null){
			logger.debug("I found no SEFF for service "+serviceToBeCalled.getEntityName() + " called by External Call "+ call.getId() + " thus I assume a System External Call");
			String timeSpecification = getTimeSpecification(serviceToBeCalled);
			createInternalAction(timeSpecification, call);
		} else {
			//logger.debug("Found Assembly Connector");
			
			/* FIXME: This method has to clone the ContextWrapper twice.
			 * This should be avoidable, but it is totally unclear when the ContextWrapper is modified
			 * For example, some constructors modify the passed ContextWrapper 
			 * */ 
			ContextWrapper oldContextWrapper = (ContextWrapper)visitor.getContextWrapper().clone();
			List<ContextWrapper> contextWrapperList = visitor.getContextWrapper().getContextWrapperFor(call);
			SeffVisitor seffVisitor = null;
			for (ContextWrapper contextWrapper : contextWrapperList) {
				seffVisitor = visitSEFF(seff, contextWrapper);
			}
			// because AllocationContexts do not have Parameters, the parameters of the output will be the same for all component instances. 
			// Note that this would be not true anymore if 1:n connectors are introduced on the system level. Then, 
			// another parameter handling mechanism has to be used here.
			if (seffVisitor != null){
				visitor.setContextWrapper((ContextWrapper)oldContextWrapper.clone());
				storeOutputParametersToUsageContext(call, seffVisitor);
			} else {
				throw new RuntimeException("Internal Error: No ContextWrapper could be created for ExternalCall "+call.getEntityName()+ " "+ call.getId());
			}
			
			visitor.setContextWrapper(oldContextWrapper);
		}
	}

	/**
	 * Default, but can be overwritten by subclasses to call other SEFF visitors
	 * @param seff
	 * @param contextWrapper
	 * @return
	 */
	SeffVisitor visitSEFF(ServiceEffectSpecification seff,
			ContextWrapper contextWrapper) {
		SeffVisitor seffVisitor = new SeffVisitor(contextWrapper);
		seffVisitor.doSwitch(seff);
		return seffVisitor;
	}
	
	private void createInternalAction(String timeSpecification, ExternalCallAction call) {
		PCMRandomVariable rv= CoreFactory.eINSTANCE.createPCMRandomVariable();
		rv.setSpecification(timeSpecification);
		
		ParametricResourceDemand demand = performanceFactory.createParametricResourceDemand();
		
		demand.setSpecification_ParametericResourceDemand(rv);
		demand.setRequiredResource_ParametricResourceDemand(getProcessingResourceType());
		
		InternalAction action = seffFactory.createInternalAction();
		action.getResourceDemand_Action().add(demand);
		
		// Add new internal action into control flow after external action
		action.setSuccessor_AbstractAction(call.getSuccessor_AbstractAction());
		action.setPredecessor_AbstractAction(call);
		
		ResourceDemandingBehaviour rdb = (ResourceDemandingBehaviour)call.eContainer();
		rdb.getSteps_Behaviour().add(action);
	}

	private ProcessingResourceType getProcessingResourceType() {
		EList<ResourceContainer> resConList = visitor.getContextWrapper().getPcmInstance().getResourceEnvironment().getResourceContainer_ResourceEnvironment();
		for (ResourceContainer resCon : resConList){
			if (resCon.getEntityName().equals("SystemExternalResourceContainer")){
				return resCon.getActiveResourceSpecifications_ResourceContainer().get(0).getActiveResourceType_ActiveResourceSpecification();
			}
		}
		return createNewProcessingResourceType();
	}

	private ProcessingResourceType createNewProcessingResourceType() {
		ProcessingResourceType resType = ResourcetypeFactory.eINSTANCE.createProcessingResourceType();
		resType.setEntityName("SystemExternalResource");
		visitor.getContextWrapper().getPcmInstance().getResourceRepository().getAvailableResourceTypes_ResourceRepository().add(resType);
		
		ProcessingResourceSpecification res = ResourceenvironmentFactory.eINSTANCE.createProcessingResourceSpecification();
		res.setActiveResourceType_ActiveResourceSpecification(resType);
		
		PCMRandomVariable rv = CoreFactory.eINSTANCE.createPCMRandomVariable();
		rv.setSpecification("1.0");

		res.setProcessingRate_ProcessingResourceSpecification(rv);
		SchedulingPolicy schedulingPolicy = getProcessorSharingSchedulingPolicy(visitor.getContextWrapper().getPcmInstance().getResourceRepository());
		if (schedulingPolicy == null) {
			//TODO: What to do here? Throw an exception?
		}
		res.setSchedulingPolicy(schedulingPolicy);
		
		ResourceContainer resCon = ResourceenvironmentFactory.eINSTANCE.createResourceContainer();
		resCon.setEntityName("SystemExternalResourceContainer");
		resCon.getActiveResourceSpecifications_ResourceContainer().add(res);
		visitor.getContextWrapper().getPcmInstance().getResourceEnvironment().getResourceContainer_ResourceEnvironment().add(resCon);
		
		return resType;
	}

	private String getTimeSpecification(Signature serviceToBeCalled) {
		Interface requiredInterface = (Interface) serviceToBeCalled.eContainer();
		String reqName = requiredInterface.getEntityName();
		
		EList<QoSAnnotations> annList = visitor.getContextWrapper().getPcmInstance().getSystem().getQosAnnotations_System();
		for (QoSAnnotations ann : annList){
			EList<SpecifiedQoSAnnotation> timeList = ann.getSpecifiedQoSAnnotations_QoSAnnotations();
			for (SpecifiedQoSAnnotation annotation : timeList){
				if(!(annotation instanceof SpecifiedExecutionTime)){
					continue;
				}
				SpecifiedExecutionTime time = (SpecifiedExecutionTime)annotation;
				Role role = time.getRole_SpecifiedQoSAnnotation();
				
				// TODO: I had to change RequiredRole to OperationRequiredRole for the code to compile.
				// Check if this still works! FB, 13-06-2010
				if (role instanceof OperationRequiredRole){
					OperationRequiredRole reqRole = (OperationRequiredRole)role;
					String reqIntName = reqRole.getRequiredInterface__OperationRequiredRole().getEntityName();
					if (reqName.equals(reqIntName)){
						String serviceName = time.getSignature_SpecifiedQoSAnnation().getEntityName();
						if (serviceToBeCalled.getEntityName().equals(serviceName)){
							return time.getSpecification_SpecifiedExecutionTime().getSpecification();
						}
					}
				}
				
			}
		}
		logger.warn("No time specification was found for external call "+serviceToBeCalled.getEntityName()+". I'm assuming a demand of 0.");
		return "0";
	}
	
	private SchedulingPolicy getProcessorSharingSchedulingPolicy(ResourceRepository resourceRepository) {
		for (SchedulingPolicy schedulingPolicy : resourceRepository.getSchedulingPolicies__ResourceRepository()) {
			if (schedulingPolicy.getEntityName() != null) {
				if (schedulingPolicy.getId().equals("ProcessorSharing")) {
					return schedulingPolicy;
				}
			}
		}
		return null;
	}

	/**
	 * FIXME: This modifies the visitor.getContextWrapper() because a modifying constructor is called!
	 * @param call
	 * @param nextVisitor
	 */
	private void storeOutputParametersToUsageContext(ExternalCallAction call, SeffVisitor nextVisitor) {
		String returnName = call.getCalledService_ExternalService().getEntityName() + ".RETURN";

		ExternalCallOutput eco = compUsageFactory.createExternalCallOutput();
		eco.setExternalCallAction_ExternalCallOutput(call);
		visitor.getContextWrapper().getCompUsgCtx().getExternalCallOutput_ComputedUsageContext().add(eco);
		
		if (nextVisitor.getContextWrapper().getCompUsgCtx()
				.getOutput_ComputedUsageContext() != null) {
			EList<VariableUsage> outputParamsProducedByExtCall = nextVisitor
					.getContextWrapper().getCompUsgCtx()
					.getOutput_ComputedUsageContext()
					.getParameterCharacterisations_Output();

			ComputedUsageContext dummyContext = compUsageFactory
					.createComputedUsageContext();
			Input input = compUsageFactory.createInput();
			for (VariableUsage vu : outputParamsProducedByExtCall) {
				VariableUsageHelper.copyVariableUsageToInput(input, vu);
			}
			dummyContext.setInput_ComputedUsageContext(input);
			
			ComputedAllocationContext dummyAllContext = compAllocationFactory
					.createComputedAllocationContext();

			ContextWrapper dummyWrapper = ContextWrapper.getContextWrapperFor(call,
					dummyContext, dummyAllContext, visitor.getContextWrapper()).get(0);

			EList<VariableUsage> outputParamsDeclaredInSeff = call
					.getReturnVariableUsage__CallReturnAction();
			for (VariableUsage vu : outputParamsDeclaredInSeff) {
				VariableUsageHelper
						.copySolvedVariableUsageToExternalCallOutput(
								dummyWrapper, eco, vu);
			}
		}
	}
}
