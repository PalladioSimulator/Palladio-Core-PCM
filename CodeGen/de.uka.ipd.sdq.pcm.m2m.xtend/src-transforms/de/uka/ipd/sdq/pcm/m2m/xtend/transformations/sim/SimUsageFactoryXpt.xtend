package de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.m2m.xtend.helper.M2TFileSystemAccess
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.JavaNamesExt
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.PCMext
import de.uka.ipd.sdq.pcm.system.System
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import de.uka.ipd.sdq.pcm.usagemodel.Workload
import edu.kit.student.dwerle.xtendfw.annotations.ModelIn

@ModelIn(#[
	"pcm.system.System",
	"pcm.usagemodel.ClosedWorkload",
	"pcm.usagemoel.OpenWorkload",
	"pcm.usagemodel.UsageScenario",
	"pcm.usagemodel.Workload"
])
class SimUsageFactoryXpt {
	@Inject M2TFileSystemAccess fsa	
	
	@Inject extension JavaNamesExt
	@Inject extension PCMext 
	@Inject extension SimMeasuringPointExt
	
	@Inject extension SimUsageXpt
	
	//------------------------------------
	// Generate a factory which can generate closed 
	// or open workload users for simucom
	//------------------------------------
	def usageScenarioFactory(UsageScenario _this) {
		val systemList = _this.querySystemCalls
			.map[providedRole_EntryLevelSystemCall.providingEntity_ProvidedRole]
			.map[it as System]
			.uniqueSystemList
			
		val fileName = _this.implementationPackage().fqnToDirectoryPath() + "/" + _this.javaName() + "Factory.java"
		val fileContent = '''
			package «_this.implementationPackage()»;
			public class «_this.javaName()+"Factory"» 
			extends «_this.workload_UsageScenario.usageFactoryBaseClass»
			{
				«_this.factoryConstructor»
				
				public de.uka.ipd.sdq.simucomframework.usage.IScenarioRunner createScenarioRunner() {
					return new «_this.implementationPackage()+"."+_this.javaName()»(model,«FOR system : systemList SEPARATOR ","»«system.systemVariableParameter»«ENDFOR»);
				}
			}
		'''
		
		fsa.generateFile(fileName, fileContent)
	}
	
	// TODO error
	def dispatch usageFactoryBaseClass(Workload _this) '''
«««		«ERROR "OAW GENERATION ERROR [m2t_transforms/sim/usage_factory.xpt]: AbstractWorkload found! This is imposible!"»
	'''
	
	def dispatch usageFactoryBaseClass(ClosedWorkload _this) '''
	de.uka.ipd.sdq.simucomframework.usage.ClosedWorkloadUserFactory
	'''
	
	def dispatch usageFactoryBaseClass(OpenWorkload _this) '''
	de.uka.ipd.sdq.simucomframework.usage.OpenWorkloadUserFactory
	'''
	
	def dispatch String factoryConstructor(UsageScenario _this) '''
		«val systemList = _this.querySystemCalls
			.map[providedRole_EntryLevelSystemCall.providingEntity_ProvidedRole]
			.map[it as System]
			.uniqueSystemList»
		private final de.uka.ipd.sdq.simucomframework.model.SimuComModel model;
		«FOR system : systemList»
		private «system.fqn()» my«system.javaName()» = null;
		«ENDFOR»
		public «_this.javaName()+"Factory"»(de.uka.ipd.sdq.simucomframework.model.SimuComModel model, String usageID, «FOR system : systemList SEPARATOR ","»«system.systemVariableDecl»«ENDFOR»){
			«_this.workload_UsageScenario.factoryConstructor»
			this.model = model;
			«FOR system : systemList»
			this.my«system.javaName()» = my«system.javaName()»; 
			«ENDFOR»
		}
	'''
	
	// TODO: error
	def dispatch String factoryConstructor(Workload _this) '''
«««		«ERROR "OAW GENERATION ERROR [m2t_transforms/sim/usage_factory.xpt]: AbstractWorkload found! This is imposible!"»
	'''
	
	def dispatch String factoryConstructor(ClosedWorkload _this) '''
		super(model, "«_this.thinkTime_ClosedWorkload.specification.specificationString()»", "«_this.usageScenario_Workload.getResourceURI()»");
	'''
	
	def dispatch String factoryConstructor(OpenWorkload _this) '''
		super(model, "«_this.usageScenario_Workload.getResourceURI()»");
	'''
}