package de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.allocation.Allocation
import de.uka.ipd.sdq.pcm.m2m.xtend.helper.M2TFileSystemAccess
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.DummiesXpt
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.JavaNamesExt
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.PCMext
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.SensorsXpt
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.UsageXpt
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import de.uka.ipd.sdq.pcm.repository.RequiredRole
import de.uka.ipd.sdq.pcm.system.System
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour
import de.uka.ipd.sdq.pcm.usagemodel.Start
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import de.uka.ipd.sdq.pcm.usagemodel.UserData
import de.uka.ipd.sdq.pcm.usagemodel.Workload
import edu.kit.ipd.sdq.xtend2m.annotations.ModelIn

@ModelIn(#[
	"pcm.allocation.Allocation",
	"pcm.repository.InfrastructureRequiredRole",
	"pcm.repository.OperationRequiredRole",
	"pcm.repository.RequiredRole",
	"pcm.system.System",
	"pcm.usagemodel.ClosedWorkload",
	"pcm.usagemodel.OpenWorkload",
	"pcm.usagemodel.ScenarioBehaviour",
	"pcm.usagemodel.Start",
	"pcm.usagemodel.UsageModel",
	"pcm.usagemodel.UsageScenario",
	"pcm.usagemodel.UserData",
	"pcm.usagemodel.Workload"
])
class SimUsageXpt extends UsageXpt {
	@Inject M2TFileSystemAccess fsa		
	
	@Inject extension PCMext
	@Inject extension JavaNamesExt
	
	@Inject extension SimUsageFactoryXpt
	@Inject extension SensorsXpt
	
	def main(UsageModel _this) {
		val systemList = _this.usageScenario_UsageModel
			.map[querySystemCalls].flatten
			.map[providedRole_EntryLevelSystemCall.providingEntity_ProvidedRole]
			.map[it as System]
			.uniqueIterable
			
		val fileName = "main/SimuComControl.java"
		val fileContent = '''
			package main;
			
			/**
			* Main class of this SimuCom instance. Used as entry by the SimuCom Framework. The 
			* simulation starts executing in the abstract base class and calls the methods of this 
			* class as template methods from the template method design pattern. This class is instanciated
			* by the SimuCom framework simulation loader via the simulation dock and Eclipse's service
			* instanciation mechanismn.
			**/
			public class SimuComControl extends de.uka.ipd.sdq.simucomframework.AbstractMain 
			{
				// Override abstract framework method and return the workloads of this usage model
				protected de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver[] getWorkloads(
					de.uka.ipd.sdq.simucomframework.SimuComConfig config) {
						// Create «systemList.size» System(s)
						«FOR system : systemList»
							«system.fqn()» my«system.javaName()» = new «system.fqn()»(getModel());
							«system.usageScenarioConstructorContextInit(_this)»
						«ENDFOR»
					return new de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver[] {
						«FOR us : _this.usageScenario_UsageModel SEPARATOR ","»«us.workloadDriver»«ENDFOR»
					};
				}
			
				// Return the generated resource container class
				protected de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory getResourceContainerFactory(){
					return new ResourceEnvironment();
				}
				
			}
		'''

		fsa.generateFile(fileName, fileContent)
	}
	def usageScenarioConstructorContextInit(System _this, UsageModel usageModel) '''
			«_this.fqnContext()» context«_this.javaName()» = 
				new «_this.fqnContext()»
					(
					«FOR orr : _this.requiredRoles_InterfaceRequiringEntity.filter(typeof(OperationRequiredRole)) SEPARATOR ","»«orr.dummyRequiredSystemTM(_this)»«ENDFOR»
					«IF _this.requiredRoles_InterfaceRequiringEntity.filter(typeof(InfrastructureRequiredRole)).size > 0» 
					«IF _this.requiredRoles_InterfaceRequiringEntity.filter(typeof(OperationRequiredRole)).size > 0», «ENDIF»
					«FOR irr : _this.requiredRoles_InterfaceRequiringEntity.filter(typeof(InfrastructureRequiredRole)) SEPARATOR ","»«irr.dummyRequiredSystemTM(_this)»«ENDFOR»
					«ENDIF»
					);
			// read UserData
			de.uka.ipd.sdq.simucomframework.variables.userdata.UserData userData
				= new de.uka.ipd.sdq.simucomframework.variables.userdata.UserData();
			«FOR ud : usageModel.userData_UsageModel»«ud.initUserData»«ENDFOR»

			context«_this.javaName()».setUserData(userData);

			my«_this.javaName()».setContext(context«_this.javaName()»);
	'''
	
	def initUserData(UserData _this) '''
	«FOR pu : _this.userDataParameterUsages_UserData»
		«FOR vc : pu.variableCharacterisation_VariableUsage»
		userData.addUserData(
			"«_this.assemblyContext_userData.id»",
			"«pu.parameterUsageLHS()+'.'+vc.type.toString()»",
			new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy("«vc.specification_VariableCharacterisation.specification.specificationString()»",
				new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>()));
		«ENDFOR»
	«ENDFOR»
	'''
	
	
	def usageScenario(UsageScenario _this, Allocation a) {
		_this.usageScenarioFactory
		
		val fileName = _this.implementationPackage().fqnToDirectoryPath() + "/" + _this.javaName() + ".java"
		val fileContent = '''
			package «_this.implementationPackage()»;
			public class «_this.javaName()» 
			implements de.uka.ipd.sdq.simucomframework.usage.IScenarioRunner
			{
				/** Default EMF factory for measuring points. */
				private final org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory measuringpointFactory = org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory.eINSTANCE;
	
				private static java.util.Map<String,java.util.List<org.palladiosimulator.probeframework.probes.Probe>> startStopProbes = null;
				
				«FOR pr : _this.querySystemCalls.map[providedRole_EntryLevelSystemCall].toSet»«pr.systemMemberVar»«ENDFOR»
				
				// Workaround to specify and retrieve the priority for a system call
				public int getPriorityForEntryLevelSystemCallID(String id){
					int defaultPriority = 0;
				«FOR entrycall : _this.querySystemCalls()»
					// priority for EntrySystemLevelCall «entrycall.providedRole_EntryLevelSystemCall.entityName»: «entrycall.priority»
					if(id.equalsIgnoreCase("«entrycall.providedRole_EntryLevelSystemCall.id»")){
						return «entrycall.priority»;
					} 
				«ENDFOR»
					return defaultPriority;
				}
				
				
	
				private de.uka.ipd.sdq.simucomframework.Context ctx = null;
				private de.uka.ipd.sdq.simucomframework.model.SimuComModel simuComModel;
				private de.uka.ipd.sdq.simucomframework.model.SimuComModel getModel() {
					return this.simuComModel;
				}
				«_this.usageScenarioConstructor(a)»
				
				«_this.scenarioBehaviour_UsageScenario.scenarioRunner(_this)»
				
				private void setupCalculators() {
					«_this.initCalculatorsTM»
				}
			}
		'''
		
		fsa.generateFile(fileName, fileContent)
	}
	
	def scenarioRunner(ScenarioBehaviour _this, UsageScenario us) '''
		public void scenarioRunner(de.uka.ipd.sdq.simucomframework.SimuComSimProcess thread) {
		
			// Store our thread in the context. The thread is used later to suspend execution in case
			// of waiting at a resource
			ctx.setSimProcess(thread);
		
			// Here comes the usage scenario code...
			«_this.actions_ScenarioBehaviour.filter(typeof(Start)).head.userActions»
			
		
			// A run through this usage model is complete
			// The counter for main measurements is incremented by the SimuComSimProcess.internalLifeCycle that called this  
			// ctx.getModel().increaseMainMeasurementsCount();
		}
	'''
	
	def workloadDriver(UsageScenario _this) '''
		new «_this.workload_UsageScenario.workloadClass(_this)»
	'''
	
	// TODO: error
	def dispatch workloadClass(Workload _this, UsageScenario u) '''
«««		«ERROR "OAW GENERATION ERROR [m2t_transforms/sim/usage.xpt]: AbstractWorkload found! This is imposible!"»
	'''
	
	def dispatch workloadClass(ClosedWorkload _this, UsageScenario u) '''
		«val systemList = u.querySystemCalls
			.map[providedRole_EntryLevelSystemCall.providingEntity_ProvidedRole]
			.map[it as System]
			.uniqueSystemList»
		de.uka.ipd.sdq.simucomframework.usage.ClosedWorkload(
			new «u.implementationPackage()+"."+u.javaName()+"Factory"»(getModel(), "«u.entityName.javaString()»",«FOR system : systemList SEPARATOR ","»«system.systemVariableParameter»«ENDFOR»),
			«_this.population»)
	'''
	
	def systemVariableParameter(System _this) '''
		my«_this.javaName()»
	'''
	
	def systemVariableDecl(System _this) '''
		«_this.fqn()» my«_this.javaName()»
	'''
	
	def dispatch workloadClass(OpenWorkload _this, UsageScenario u) '''
		«val systemList = u.querySystemCalls
			.map[providedRole_EntryLevelSystemCall.providingEntity_ProvidedRole]
			.map[it as System]
			.uniqueSystemList»
		de.uka.ipd.sdq.simucomframework.usage.OpenWorkload(getModel(),
			new «u.implementationPackage()+"."+u.javaName()+"Factory"»(getModel(), "«u.entityName.javaString()»",«FOR system : systemList SEPARATOR ","»«system.systemVariableParameter»«ENDFOR»),
			"«_this.interArrivalTime_OpenWorkload.specification.specificationString()»")
	'''
	
	def usageScenarioConstructor(UsageScenario _this, Allocation a) '''
		«val systemList = _this.querySystemCalls
			.map[providedRole_EntryLevelSystemCall.providingEntity_ProvidedRole]
			.map[it as System]
			.uniqueSystemList»
		public «_this.javaName()»(de.uka.ipd.sdq.simucomframework.model.SimuComModel model,«FOR system : systemList SEPARATOR ","»«system.systemVariableDecl»«ENDFOR») {
			this.simuComModel = model;
			ctx = new «a.fqnAllocationContext()»(model);
			ctx.getStack().createAndPushNewStackFrame();
			«_this.usageScenarioConstructorContextInit(a)»
			if (startStopProbes == null) {
			    startStopProbes = new java.util.HashMap<String,java.util.List<org.palladiosimulator.probeframework.probes.Probe>>();
				setupCalculators();
			}
		}
	'''
	
	@Inject SimCalculatorsXpt simCalculators
//	«REM»Template Method for the calculator initialization«ENDREM»
	def initCalculatorsTM(UsageScenario _this) {
		simCalculators.setupCalculators(_this)
	}
	
	// overwritte template methods
	@Inject DummiesXpt dummies
	override dummyRequiredSystemTM(RequiredRole _this, System s) '''
		«dummies.dummyComponent(_this, s)»
		new «s.implementationPackage».«_this.fqnDummyComponent»()
	'''
	
	override mainTM(UsageModel um) {
		main(um)
		
		// return type String
		// TODO: check if type can be changed to void
		""
	}
	
	override usageScenarioTM(UsageScenario us, Allocation a) {
		usageScenario(us, a)
		
		// return type String
		// TODO: check if type can be changed to void
		""
	}
	
}