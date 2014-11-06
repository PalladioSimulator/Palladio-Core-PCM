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

class SimCalculatorsXpt extends CalculatorsXpt {
	@Inject extension JavaNamesExt
	@Inject extension PCMext
	@Inject extension SensorsExt

	def dispatch String setupCalculators(UsageScenario us) '''
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
	
//	«REM»
//«DEFINE CalculatorRoot FOR UsageModel»
//	«FILE "main/CalculatorRepositoryFactory.java"»
//		package main;
//		import de.uka.ipd.sdq.simucomframework.calculator.CalculatorRepository;
//		import de.uka.ipd.sdq.simucomframework.calculator.ICalculatorRepositoryFactory;
//		import org.palladiosimulator.probeframework.SampleBlackboard;
//		import org.palladiosimulator.recorderframework.*;
//		import org.palladiosimulator.recorderframework.*;
//		import org.palladiosimulator.probeframework.calculator.*;
//		
//		public class CalculatorRepositoryFactory implements ICalculatorRepositoryFactory {
//		
//			private static CalculatorRepositoryFactory instance = new CalculatorRepositoryFactory();
//			
//			public CalculatorRepository createCalculatorRepository(SampleBlackboard blackboard) {
//				CalculatorRepository repository = new CalculatorRepository();
//				
//				«EXPAND CreateCalculatorForUsageScenario FOREACH this.usageScenario_UsageModel»
//				
//				return repository;
//			}
//		
//			public static CalculatorRepositoryFactory getInstance() {
//				return instance;
//			}
//		}
//	«ENDFILE»
//«ENDDEFINE»
//«ENDREM»
//
//«REM»
//«DEFINE CalculatorRoot FOR Repository»
//	«IF this.components__Repository.size > 0»
//		«FILE this.basePackageName() + "/CalculatorFactory.java"»
//			package «this.basePackageName()»;
//			
//			// CalculatorRoot FOR Repository: «this.datatypes_Repository.toString()»
//			public class CalculatorFactory {
//				public static void createCalculators(String assemblyContext) {
//					«EXPAND CreateCalculatorForComponents FOREACH this.components__Repository»
//				}
//			}
//		«ENDFILE»
//	«ENDIF»
//«ENDDEFINE»
//
//«DEFINE CreateCalculatorForComponents FOR RepositoryComponent»
//	// Nothing to do?? (Create calculators solely for BasicComponents?)
//«ENDDEFINE»
//
//«DEFINE CreateCalculatorForComponents FOR BasicComponent»
//	// CreateCalculatorForComponents FOR BasicComponent
//	«EXPAND CreateCalculatorForComponents(this) FOREACH this.serviceEffectSpecifications__BasicComponent.describedService__SEFF»
//«ENDDEFINE»
//
//«DEFINE CreateCalculatorForComponents(RepositoryComponent component) FOR Signature»
//	// CreateCalculatorForComponents(RepositoryComponent component) FOR Signature
//	«IF this.hasSEFF(component)»
//   	  	«LET ((ResourceDemandingSEFF)this.getSEFF(component)) AS seff»
//	      «EXPAND CreateCalculatorForComponents FOREACH seff.steps_Behaviour.findStart().queryExternalCallActions({})»      
//    	«ENDLET»
//   	  «ENDIF»
//«ENDDEFINE»
//
//«DEFINE CreateCalculatorForComponents FOR ExternalCallAction»
//	// CreateCalculatorForComponents FOR ExternalCallAction
//	// «this.entityName»
//«ENDDEFINE»«ENDREM»
//
//«REM»Creates one calculator for each UsageScenario«ENDREM»
//«REM»«DEFINE CreateCalculatorForUsageScenario FOR UsageScenario»
//	// Initialise calculator for «this.entityName»
//	Recorder recorder = new RawRecorder(new ConsoleWriteStrategy());
//	PipesAndFiltersManager pipesAndFiltersManager = new PipesAndFiltersManager(recorder);
//	Calculator calculator = new ResponseTimeCalculator(blackboard,
//			"start«this.entityName»", "end«this.entityName»");
//	calculator.setPipesAndFiltersManager(pipesAndFiltersManager);
//	repository.addCalculator("«this.entityName»", calculator);
//	
//	// «this.scenarioBehaviour_UsageScenario.querySystemCalls()»
//«ENDDEFINE»
//
//«DEFINE CreateCalculators FOR System»
//	«this.toString()»
//«ENDDEFINE» 
//
//«DEFINE CreateCalculator FOR EntryLevelSystemCall»
//	// Create calculator for «this.toString()»
//«ENDDEFINE»
//«ENDREM»

}