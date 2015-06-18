package de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim

import com.google.inject.Inject
import de.fzi.se.quality.qualityannotation.PCMParameterPartition
import de.uka.ipd.sdq.pcm.core.entity.Entity
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.CallsXpt
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.JavaNamesExt
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.PCMext
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.SEFFBodyXpt
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.SensorsExt
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.SensorsXpt
import de.uka.ipd.sdq.pcm.parameter.VariableUsage
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature
import de.uka.ipd.sdq.pcm.repository.OperationSignature
import de.uka.ipd.sdq.pcm.repository.Signature
import de.uka.ipd.sdq.pcm.seff.AbstractAction
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction
import de.uka.ipd.sdq.pcm.seff.InternalAction
import java.util.List


class SimCallsXpt extends CallsXpt {
	@Inject extension JavaNamesExt
	@Inject extension PCMext
	@Inject extension SensorsExt
	@Inject extension SensorsXpt
	@Inject extension SEFFBodyXpt
	@Inject extension SimAccuracyInfluenceExt
	@Inject extension SimAccuracyXpt

	def dispatch preCall(OperationSignature signature, Object call, String prefix, List<VariableUsage> parameterUsages) '''		
		«IF (call instanceof ExternalCallAction)»
			«val externalCall = call as ExternalCallAction»
				«val id = externalCall.id.javaVariableName()»
			//start handling potential failures
					«val triesVar = javaVariableName("tries_"+ externalCall.calledService_ExternalService.javaSignature())»
			int «triesVar» = 1 + «externalCall.retryCount»; //The call plus the retries
			// Execute the external call until it succeeds or the maximal try count is exeeded.
			boolean callSucceeded = false;
			for(int retries=0; retries<«triesVar»; ++retries) {
	
				// Check if the call has already succeeded:
				if(callSucceeded == true) {
					break;
				}
	
						«externalCall.initFailureHandling(id)»
				try { // needs to be closed after the call in PostCall
			// end of failure handling before the call

		«ENDIF»
		«signature.genericPreCall(call,parameterUsages,prefix)»
	'''

	def dispatch preCall(InfrastructureSignature signature, Object call, String prefix, List<VariableUsage> parameterUsages) '''
		«IF !(call instanceof InternalAction)»
			«/* ERROR "OAW GENERATION ERROR [m2t_transforms/sim/calls.xpt]: PreCall(Object call, String prefix, List[VariableUsage] parameterUsages) does not support a call for the provided action type." */»
		«ENDIF»
		«signature.genericPreCall(call,parameterUsages)»
	'''

	//«REM»This generic pre call does not include simulation of network failures (see preCall for OperationSignature above) but does include latency. «ENDREM»
	def genericPreCall(OperationSignature signature, Object call, List<VariableUsage> parameterUsages, String prefix) '''
		try {
		«signature.prepareSimulatedStackFrame(parameterUsages)»
		«IF (call instanceof ExternalCallAction)»
			«signature.externalCallActionDescription(call).startResponseTimeMeasurementTM»
		«ELSE»
			«signature.entryLevelSystemCallActionDescription(call).startResponseTimeMeasurementTM»
		«ENDIF»
		«IF (call instanceof ExternalCallAction || call instanceof InternalAction)»			
	        «signature.handleRemoteExternalCall(prefix)»
	    «ENDIF»
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =
	'''

	def genericPreCall(InfrastructureSignature signature, Object call,List<VariableUsage> parameterUsages) '''
		«signature.prepareSimulatedStackFrame(parameterUsages)»
		«IF (call instanceof InternalAction)»
			«signature.internalActionDescription(call).startResponseTimeMeasurementTM»
		«ELSE»
			«/* ERROR "OAW GENERATION ERROR [m2t_transforms/sim/calls.xpt]: GenericPreCall(Object call,List[VariableUsage] parameterUsages) does not support a call for the provided action type." */»
		«ENDIF»
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =
	'''

	def prepareSimulatedStackFrame(Signature signature, List<VariableUsage> parameterUsages) '''
		// Start Simulate an external call
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
		// prepare stackframe
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
		«FOR pu : parameterUsages»
			«val lhs_prefix = pu.parameterUsageLHS()»
				«FOR vc : pu.variableCharacterisation_VariableUsage»
					«IF pu.namedReference__VariableUsage.isInnerReference()»
						stackframe.addValue("«lhs_prefix+'.'+vc.type.toString()»",
						   	new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy("«vc.specification_VariableCharacterisation.specification.specificationString()»",currentFrame.copyFrame()));
					«ELSE»
						stackframe.addValue("«lhs_prefix+'.'+vc.type.toString()»",
						   	ctx.evaluate("«vc.specification_VariableCharacterisation.specification.specificationString()»",currentFrame));
					«ENDIF»
				«ENDFOR»
		«ENDFOR»
	'''

	def tidySimulatedStackFrame(Signature siganture) '''
	 	ctx.getStack().removeStackFrame();
	'''

	//«REM»This generic post call does not include simulation of network failures and latency. «ENDREM»
	def genericPostCall(OperationSignature signature, Object call, String prefix, List<VariableUsage> outParameterUsages) '''
		«IF (call instanceof ExternalCallAction)»
			«signature.handleRemoteExternalCall(prefix)»
			// Stop the time measurement
			«signature.externalCallActionDescription(call).endResponseTimeMeasurementTM»
		«ELSE»
		    // Stop the time measurement
			«("Call_"+signature.javaSignature+" <EntryLevelSystemCall id: "+(call as Entity).id+" >").endResponseTimeMeasurementTM»
		«ENDIF»
«««		«REM»Handle accuracy influence analysis. «ENDREM»
		«IF (call instanceof AbstractAction)»
			«IF getQualityAnnotationRepository() != null»
				«IF (call as AbstractAction).getRdseff().getQualityAnnotation() != null»
					«val qualityAnnotation = (call as AbstractAction).getRdseff().getQualityAnnotation()»
						«FOR partition : qualityAnnotation.validForParameterPartitions.filter(typeof(PCMParameterPartition))»
							«partition.checkAccuracy((call as AbstractAction).rdseff, (call as AbstractAction))»
						«ENDFOR»
				«ELSE»
«««				«REM»Accuracy analysis was requested but no quality annotation could be found for this RDSEFF«ENDREM»
					SeverityAndIssue issue = AccuracyIssueFactory.createMissingQualityAnnotationIssue("«(call as AbstractAction).getRdseff().getResourceName()»", "«(call as AbstractAction).getRdseff().id»");
					config.addIssue(issue);
				«ENDIF»
			«ELSE»
«««				«REM»Accuracy analysis was not requested. Do nothing.«ENDREM»
			«ENDIF»
		«ENDIF»
	
««« TODO: check if = / != null check is correct
		«IF (outParameterUsages != null)»
		«FOR pu : outParameterUsages»
			«val lhs_prefix = pu.parameterUsageLHS()»
				// Copy out parameter «lhs_prefix» to local stack frame
				«FOR vc : pu.variableCharacterisation_VariableUsage»
					«IF pu.namedReference__VariableUsage.isInnerReference()»
						methodBodyStackFrame.addValue("«lhs_prefix+'.'+vc.type.toString()»",
						   	new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy("«vc.specification_VariableCharacterisation.specification.specificationString()»",callResult.copyFrame()));
					«ELSE»
						methodBodyStackFrame.addValue("«lhs_prefix+'.'+vc.type.toString()»",
						   	ctx.evaluate("«vc.specification_VariableCharacterisation.specification.specificationString()»",callResult));
					«ENDIF»
				«ENDFOR»
		«ENDFOR»
		«ENDIF»
		}
		finally
		{
			«signature.tidySimulatedStackFrame»
		}
		// END Simulate an external call
	'''

	def genericPostCall(InfrastructureSignature is, Object call, String prefix) '''
		// Stop the time measurement
		«IF (call instanceof InternalAction)»
		    «is.handleRemoteExternalCall(prefix)»
			«is.internalActionDescription(call).endResponseTimeMeasurementTM»
		«ELSE»
			«/* ERROR "OAW GENERATION ERROR [m2t_transforms/sim/calls.xpt]: GenericPostCall(Object call, List[VariableUsage] outParameterUsages) does not support a call for the provided action type." */»
		«ENDIF»
		«is.tidySimulatedStackFrame»
		// END Simulate an external call
	'''

	def postCall(OperationSignature os, Object call, String prefix, List<VariableUsage> outParameterUsages) '''
		«os.genericPostCall(call,prefix,outParameterUsages)»
		«IF (call instanceof ExternalCallAction)»
			} // end of try block from the pre call failure handling section
			«val externalCall = (call as ExternalCallAction)»
			«val id = externalCall.id.javaVariableName()»
			«val triesVar = javaVariableName("tries_"+ externalCall.calledService_ExternalService.javaSignature())»
« /* TODO: ->> am ende richtig übersetzen */»
					«externalCall.catchFailureExceptions(id)»
			«val callName = "Call "+os.interface__OperationSignature.entityName+"."+os.javaSignature()+" <Component: "+(call as ExternalCallAction).findContainerComponent().entityName+", AssemblyCtx: \"+this.assemblyContext.getId()+\", CallID: "+(call as ExternalCallAction).id+">"»
			de.uka.ipd.sdq.simucomframework.ReliabilitySensorHelper.recordExternalCallResult(
				"«callName»",
				"«externalCall.id»",
				failureException_«id»,
				ctx.getModel(),
				ctx.getThread().getRequestContext());
			if(failureException_«id» != null) { // failure occurred

				// Check if we handle this failure-on-demand occurrence:
				if(!«externalCall.checkIfExceptionIsHandled(id)») { // is this failure type handled?
					throw failureException_«id»;
				}
				if(retries == «triesVar»-1) { // retry count exceeded?
					throw failureException_«id»;
				}

				// If the failure-on-demand occurrence is handled,
				// update the failure statistics accordingly:
				this.getModel().getFailureStatistics().increaseFailureCounter(
		de.uka.ipd.sdq.reliability.core.FailureStatistics.FailureType.HANDLED, failureException_«id».getFailureType()); //count handled failure

			} else {

				// Mark this call as successful:
				callSucceeded = true;
			}
		}
		// End failure handling section.
		«ENDIF»
	'''

	def postCall(InfrastructureSignature is, Object call, String prefix) '''
		«is.genericPostCall(call, prefix)»
	'''
	
	def dispatch handleRemoteExternalCall(OperationSignature os, String prefix) '''
		«os.handleNetworkLatencyAndFailures(prefix)»
	'''
	
	def dispatch handleRemoteExternalCall(InfrastructureSignature is, String prefix) '''
		«is.handleNetworkLatencyAndFailures(prefix)»
	'''

	def handleNetworkLatencyAndFailures(Signature signature, String prefix) '''
«««				«REM»
«««					Options for moving this code into the framework should be checked.
«««					The main problem is how to find out if an external call goes over a network link or not.
«««				«ENDREM» 
				// If the call goes over network, simulate the link latency and the possibility of a communication link failure.
				// Do this only in case that the "simulate linking resources" option is deactivated, because otherwise,
				// completions handle the link behaviour.
				if (!ctx.getModel().getConfig().getSimulateLinkingResources()) {
					de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer fromContainer = null;
					de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer toContainer = null;
					try {
						fromContainer = ctx.findResource(this.assemblyContext.getId());
						toContainer = ctx.findResource(«prefix»getComponentAssemblyContext().getId());
					} catch (de.uka.ipd.sdq.simucomframework.exceptions.ResourceContainerNotFound exception) {
						// If the call is system external, no target resource container will be found.
					}
					if ((fromContainer != null) && (toContainer != null) && (!fromContainer.getResourceContainerID().equals(toContainer.getResourceContainerID()))) {
						String linkingResourceID = main.ResourceEnvironment.getInstance().getLinkingResourceContainerID(fromContainer.getResourceContainerID(), toContainer.getResourceContainerID());
						if (linkingResourceID == null) {
							linkingResourceID = main.ResourceEnvironment.getInstance().getLinkingResourceContainerID(toContainer.getResourceContainerID(), fromContainer.getResourceContainerID());
						}
						// If the linkingResourceID is NULL, we have to assume that no linking resource has been specified.
						// In this case, we assume a perfect link that never fails and has no latency and unlimited throughput.
						if (linkingResourceID != null) {
							de.uka.ipd.sdq.simucomframework.resources.SimulatedLinkingResourceContainer linkingContainer = ctx.findLinkingResource(linkingResourceID);
							// Load linking resource with a demand of 0 byte so that only the latency is considered.
							// The bytesize is only considered when the completions are activated (ctx.getModel().getConfig().getSimulateLinkingResources() == true).
							double demand = 0.0;
							try {
								// If completions are activated, they fill in the results of their BYTESIZE calculation into the variable stream.BYTESIZE
								// in the stackframe of this method (stored as currentStackframe above).
								if (currentFrame.getValue("stream.BYTESIZE") != null) {
									demand = de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter.toDouble(de.uka.ipd.sdq.simucomframework.variables.StackContext.evaluateStatic("stream.BYTESIZE", Double.class, currentFrame));
								}
							} catch(de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException valueNotInFrameException) {
								try {
									// if no stream.BYTESIZE variable is available, the demand is calculated by summing up all the sent variables with BYTESIZE characterization  
									java.util.ArrayList<java.util.Map.Entry<String, Object>> stackFrameContent = stackframe.getContents();
									for (java.util.Map.Entry<String, Object> entry : stackFrameContent) {
										if (entry.getKey().endsWith("BYTESIZE")){
											if (entry.getKey().contains(".INNER.")){
												// TODO: include logic to determine proper BYTESIZE of the call, take from completions code. 
												logger.warn("Network demand cannot be properly determined for INNER BYTESIZE characterizations yet, the simulation will assume that there is just a single element in the collection. Please enable the ''simulate middleware marshalling / demarshalling of remote calls'' in the feature settings tab or directly define the BYTESIZE of the collection.");
											}
											demand += de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter.toDouble(entry.getValue());
										}
									}
								} catch (RuntimeException e){
									logger.error("Cannot cast BYTESIZE characterization of the following variable to double for calculating the network demand in "+this.getClass()+": "+e.getMessage());
								}
							}
							linkingContainer.loadActiveResource(ctx.getThread(), fromContainer.getResourceContainerID(), linkingContainer.getLinkingResourceTypeId(), demand);
						} else {
							throw new RuntimeException("A component on the resource container with id "+fromContainer.getResourceContainerID()+" calls a component on resource container with id "+toContainer.getResourceContainerID()+", but there is no linking resource between the containers! Add a LinkingResource or change the component allocation.");
						}
					}
				}
	'''
	
	// overwritten template methods
	override preCallTM(OperationSignature signature, Entity call, String prefix, List<VariableUsage> parameterUsages) {
		preCall(signature, call, prefix, parameterUsages)
	}
	override preCallTM(InfrastructureSignature signature, Entity call, String prefix, List<VariableUsage> parameterUsages) {
		preCall(signature, call, prefix, parameterUsages)
	}
	
	override postCallTM(InfrastructureSignature signature, Entity call, String prefix) {
		postCall(signature, call, prefix)
	}
	
	override postCallTM(OperationSignature signature, Entity call, String prefix, List<VariableUsage> outParameterUsages) {
		postCall(signature, call, prefix, outParameterUsages)
	}
	
}