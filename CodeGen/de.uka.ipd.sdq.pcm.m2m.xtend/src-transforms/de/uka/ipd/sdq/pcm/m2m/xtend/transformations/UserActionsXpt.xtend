package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction
import de.uka.ipd.sdq.pcm.usagemodel.Start
import de.uka.ipd.sdq.pcm.usagemodel.Stop
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
import de.uka.ipd.sdq.pcm.usagemodel.Loop
import de.uka.ipd.sdq.pcm.usagemodel.Branch
import de.uka.ipd.sdq.pcm.usagemodel.Delay
import com.google.inject.Inject

class UserActionsXpt {
	@Inject extension CallsXpt
	@Inject extension JavaNamesExt

	def dispatch userAction(AbstractUserAction aua) '''
		// Unknown user action - bad!
		«/* ERROR "OAW GENERATION ERROR [m2t_transforms/user_actions.xpt]: Unknown user action!" */»
	'''
	
	def dispatch userAction(Start start) ''''''
	def dispatch userAction(Stop stop) ''''''
	def dispatch userAction(EntryLevelSystemCall elsc) '''
				// Set the priority for «elsc.entityName»
				thread.setPriority(«elsc.priority»);
		«elsc.operationSignature__EntryLevelSystemCall.call(
			elsc,
			elsc.providedRole_EntryLevelSystemCall.portMemberVar+".",
			elsc.inputParameterUsages_EntryLevelSystemCall,
			{})»
	'''
	
	def dispatch userAction(Loop loop) ''''''
	def dispatch userAction(Branch branch) ''''''
	def dispatch userAction(Delay delay) ''''''
}