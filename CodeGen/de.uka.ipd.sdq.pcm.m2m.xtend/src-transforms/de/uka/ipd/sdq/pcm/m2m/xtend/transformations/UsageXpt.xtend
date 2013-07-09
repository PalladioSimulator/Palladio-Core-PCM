package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.usagemodel.UsageModel
import de.uka.ipd.sdq.pcm.allocation.Allocation
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction
import de.uka.ipd.sdq.pcm.usagemodel.Stop
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole
import de.uka.ipd.sdq.pcm.system.System
import com.google.inject.Inject

class UsageXpt {
	@Inject extension JavaNamesExt
	@Inject extension PCMext
	@Inject extension UserActionsXpt

	//-----------------------------------
	// For a usage model generate for each
	// usage scenario a usage scenario driver
	// and finally (optionally) a main class which can be run
	// standalone
	//-----------------------------------
	def usageModel(UsageModel um, Allocation a) '''
		«FOR scenario : um.usageScenario_UsageModel»«scenario.usageScenarioTM(a)»«ENDFOR»
		«um.mainTM»
	'''
	
	//------------------------------------
	// Template method to generate a main
	// class which starts the usage scenarios
	// in the usage model. Can be used to 
	// generate runnable test drivers
	//------------------------------------
	def mainTM(UsageModel um) '''
	'''
	
	//------------------------------------
	// Template method to generate a class
	// implementing the usage scenario driver
	//------------------------------------
	def usageScenarioTM(UsageScenario us, Allocation a) '''
	'''
	
	//----------------------
	// Generic helper methods
	//----------------------
	def dispatch systemMemberVar(OperationProvidedRole opr) '''
	   protected «opr.providedInterface__OperationProvidedRole.fqn()» «opr.portMemberVar()» = null;
	'''
	
	def dispatch systemMemberVar(InfrastructureProvidedRole ipr) '''
	   protected «ipr.providedInterface__InfrastructureProvidedRole.fqn()» «ipr.portMemberVar()» = null;
	'''
	
	def userActions(AbstractUserAction aua) '''
	   «aua.userAction»
	   «IF !(aua instanceof Stop)»
	      «aua.successor.userActions»
	   «ENDIF»
	'''
	
	def dispatch dummyRequiredSystemTM(OperationRequiredRole orr, System s) '''
		null
	'''
	
	def dispatch dummyRequiredSystemTM(InfrastructureRequiredRole irr, System s) '''
		null
	'''

	def usageScenarioConstructorContextInit(UsageScenario us, Allocation a) '''
		// Initialise local interface pointer pointing to system roles
		«FOR pr : us.querySystemCalls.map[providedRole_EntryLevelSystemCall].toSet»
			«pr.portMemberVar()» = my«pr.providingEntity_ProvidedRole.javaName()».«pr.portGetterName()»();
		«ENDFOR»
	'''	
}