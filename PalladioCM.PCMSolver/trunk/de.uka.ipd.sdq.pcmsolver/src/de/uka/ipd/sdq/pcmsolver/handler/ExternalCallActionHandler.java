package de.uka.ipd.sdq.pcmsolver.handler;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallInput;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput;
import de.uka.ipd.sdq.context.computed_usage.Input;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedExecutionTime;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypeFactory;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;
import de.uka.ipd.sdq.pcmsolver.models.Context;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.pcmsolver.visitors.VariableUsageHelper;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.PCMRandomVariable;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.VariableReference;

public class ExternalCallActionHandler {
	
	private SeffVisitor visitor;
	
	private ComputedUsageFactory compUsageFactory = ComputedUsageFactory.eINSTANCE;
	
	private ComputedAllocationFactory compAllocationFactory = ComputedAllocationFactory.eINSTANCE;
	
	private ParameterFactory parameterFactory = ParameterFactory.eINSTANCE;
	
	private SeffFactory seffFactory = SeffFactory.eINSTANCE;
	
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
			logger.info("Found System External Call");
			String timeSpecification = getTimeSpecification(serviceToBeCalled);
			createInternalAction(timeSpecification, call);
		} else {
			logger.info("Found Assembly Connector");
			ContextWrapper contextWrapper = createContextWrapper(call);

			SeffVisitor seffVisitor = new SeffVisitor(contextWrapper);
			seffVisitor.doSwitch(seff);
			
			storeOutputParametersToUsageContext(call, seffVisitor);
		}
	}
	
	private ContextWrapper createContextWrapper(ExternalCallAction call) {
		ComputedUsageContext compUsgCtx = compUsageFactory
				.createComputedUsageContext();
		Input newInput = compUsageFactory.createInput();
		compUsgCtx.setInput_ComputedUsageContext(newInput);
		EList<VariableUsage> parList = call
				.getInputParameterUsages_ExternalCallAction();
		
		ContextWrapper oldContextWrapper = visitor.getContextWrapper();
		ExternalCallInput eci = compUsageFactory.createExternalCallInput();
		eci.setExternalCallAction_ExternalCallInput(call);		
		oldContextWrapper.getCompUsgCtx().getExternalCallInput_ComputedUsageContext().add(eci);
		
		for (VariableUsage vu : parList) {
			VariableUsageHelper.copySolvedVariableUsageToInput(newInput, oldContextWrapper, vu);
			VariableUsageHelper.copySolvedVariableUsageToExternalCallInput(oldContextWrapper, eci, vu);
		}
		
		ComputedAllocationContext compAllCtx = compAllocationFactory
				.createComputedAllocationContext();
		compAllCtx.setUsageContext_ComputedAllocationContext(compUsgCtx);


		ContextWrapper contextWrapper = new ContextWrapper(call, compUsgCtx, compAllCtx, visitor.getContextWrapper());  
			
		//TODO: add default component parameters by component developer
		EList<VariableUsage> confParList = contextWrapper.getAssCtx().getConfigParameterUsages_AssemblyContext();
		for (VariableUsage vu : confParList) {
			VariableUsageHelper.copySolvedVariableUsageToInput(newInput, contextWrapper, vu);
		}
		
		UsageModel um = contextWrapper.getPcmInstance().getUsageModel();
		EList<UserData> userDataList = um.getUserData_UsageModel();
		for (UserData ud : userDataList){
			if (ud.getAssemblyContext_userData().getId().equals(
					contextWrapper.getAssCtx().getId())) {
				EList<VariableUsage> userParList = ud.getUserDataParameterUsages_UserData();
				for (VariableUsage vu : userParList){
					VariableUsageHelper.copySolvedVariableUsageToInput(newInput, contextWrapper, vu);
				}
			}
		}
		
		return contextWrapper; 
	}

	private void createInternalAction(String timeSpecification, ExternalCallAction call) {
		PCMRandomVariable rv = StoexFactory.eINSTANCE.createPCMRandomVariable();
		rv.setSpecification(timeSpecification);
		
		ParametricResourceDemand demand = seffFactory.createParametricResourceDemand();
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
		
		PCMRandomVariable rv = StoexFactory.eINSTANCE.createPCMRandomVariable();
		rv.setSpecification("1.0");

		res.setProcessingRate_ProcessingResourceSpecification(rv);
		res.setSchedulingPolicy(SchedulingPolicy.PROCESSOR_SHARING);
		
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
			EList<SpecifiedExecutionTime> timeList = 
				ann.getSpecifiedExecutionTimes_QoSAnnotations();
			for (SpecifiedExecutionTime time : timeList){
				Role role = time.getRole_SpecifiedExecutionTime();
				if (role instanceof RequiredRole){
					RequiredRole reqRole = (RequiredRole)role;
					String reqIntName = reqRole.getRequiredInterface__RequiredRole().getEntityName();
					if (reqName.equals(reqIntName)){
						String serviceName = time.getSignature_SpecifiedTimeConsumption().getServiceName();
						if (serviceToBeCalled.getServiceName().equals(serviceName)){
							return time.getSpecification_SpecifiedExecutionTime().getSpecification();
						}
					}
				}
				
			}
		}
		return "0";
		
	}

	private void storeOutputParametersToUsageContext(ExternalCallAction call, SeffVisitor nextVisitor) {
		String returnName = call.getCalledService_ExternalService().getServiceName() + ".RETURN";

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

			ContextWrapper dummyWrapper = new ContextWrapper(call,
					dummyContext, null, visitor.getContextWrapper());

			EList<VariableUsage> outputParamsDeclaredInSeff = call
					.getOutputVariableUsages_ExternalCallAction();
			for (VariableUsage vu : outputParamsDeclaredInSeff) {
				VariableUsageHelper
						.copySolvedVariableUsageToExternalCallOutput(
								dummyWrapper, eco, vu);
			}
		}
	}
}
