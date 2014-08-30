package de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.CalculatorsXpt
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.JavaNamesExt
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.PCMext
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.SensorsExt
import de.uka.ipd.sdq.pcm.repository.BasicComponent
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction
import de.uka.ipd.sdq.pcm.seff.InternalAction
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import edu.kit.student.dwerle.xtendfw.annotations.ModelIn

@ModelIn(#[
	"pcm.repository.BasicComponent",
	"pcm.repository.RepositoryComponent",
	"pcm.seff.ExternalCallAction",
	"pcm.seff.InternalAction",
	"pcm.seff.ResourceDemandingSEFF",
	"pcm.seff.ServiceEffectSpecification",
	"pcm.usagemodel.EntryLevelSystemCall",
	"pcm.usagemodel.UsageScenario"
])
class SimCalculatorsXpt extends CalculatorsXpt {
	@Inject extension JavaNamesExt
	@Inject extension PCMext
	@Inject extension SensorsExt

	def dispatch String setupCalculators(UsageScenario us) '''
		// Setup calculator for usage scenario «us.entityName»
		«us.entityName.setupCalculatorResponseTime("start" + us.entityName, "end" + us.entityName)»
		if(getModel().getConfiguration().getSimulateFailures()){
			«us.setupCalculatorExecutionResult»
		}
	
		«FOR systemCall : us.querySystemCalls»
			«systemCall.setupCalculators»
		«ENDFOR»
	'''

	def dispatch String setupCalculators(EntryLevelSystemCall call) '''
		«val callName = "Call_"+call.operationSignature__EntryLevelSystemCall.javaSignature()+" <EntryLevelSystemCall id: "+call.id+" >"»
			// Setup calculator for system call «call.entityName» («call.id»)
			«callName.setupCalculatorResponseTime("start"+callName, "end"+callName)»
	'''

	def dispatch String setupCalculators(RepositoryComponent comp) '''
		«IF (comp instanceof BasicComponent) »
			«FOR seff : (comp as BasicComponent).serviceEffectSpecifications__BasicComponent»
				«seff.setupCalculators»
			«ENDFOR»
		«ELSE»
		«ENDIF»  
«««		«REM»TODO: Should there be calculators for RepositoryComponents other than BasicComponent?«ENDREM» 
	'''

	def dispatch String setupCalculators(ServiceEffectSpecification seff) '''
		«/* ERROR "This should never be called!" */»
	'''

	def dispatch String setupCalculators(ResourceDemandingSEFF seff) '''
		// Setup calculators for service call «seff.describedService__SEFF.entityName»,
«««		// contained ExternalCallActions: «seff.steps_Behaviour.findStart().queryExternalCallActions(newArrayList).head.entityName» («seff.steps_Behaviour.findStart().queryExternalCallActions(newArrayList).head.id»)
«««		// TODO: head?»
		«FOR callAction : seff.steps_Behaviour.findStart().queryExternalCallActions(newArrayList)»
			«callAction.setupCalculators» 
		«ENDFOR»
«««		«REM»Remove the following two lines in order to disable measurements on infrastructure calls«ENDREM»
«««		// TODO: head?»
«««		// contained InternalActions: «seff.steps_Behaviour.findStart().queryInternalActions(newArrayList).head.entityName» («seff.steps_Behaviour.findStart().queryInternalActions(newArrayList).head.id»)
		«FOR callAction : seff.steps_Behaviour.findStart().queryInternalActions(newArrayList)»
			«callAction.setupCalculators»
		«ENDFOR»
	'''

	def dispatch String setupCalculators(ExternalCallAction action) '''
		// Old: "Call "+this.calledService_ExternalService.interface__OperationSignature.entityName+"."+this.calledService_ExternalService.javaSignature()+" <AssemblyCtx: \"+this.assemblyContext.getId()+\", CallID: "+ this.id +">"
		«val callName = externalCallActionDescription(action.calledService_ExternalService, action)»
			// ExternalCallAction «action.entityName» («action.id»)
			«callName.setupCalculatorResponseTime("start" + callName, "end" + callName)»
			if(getModel().getConfiguration().getSimulateFailures()){
				«action.setupCalculatorExecutionResult(callName)»
			}
	'''
	
	def dispatch String setupCalculators(InternalAction action) '''
		«FOR infrastructureCall : action.infrastructureCall__Action»
			«val callName = internalActionDescription(infrastructureCall.signature__InfrastructureCall, action)»
				// InternalAction «action.entityName» («action.id»)
				«callName.setupCalculatorResponseTime("start" + callName, "end" + callName)»
		«ENDFOR»
	'''
}