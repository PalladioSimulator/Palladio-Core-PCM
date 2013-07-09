package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.repository.PassiveResource
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand
import de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall

class ResourcesXpt {
	// For each resource demand load a resource
	def resourceDemands(AbstractInternalControlFlowAction aicfa) '''
		«FOR action : aicfa.resourceDemand_Action»«action.resourceDemandTM»«ENDFOR»
		«FOR action : aicfa.resourceCall__Action»«action.resourceDemandTM»«ENDFOR»
	'''
	
	// What to do with the actual demand is target dependant
	def dispatch resourceDemandTM(ParametricResourceDemand prd) '''
		«/* ERROR "OAW GENERATION ERROR [m2t_transforms/resources.xpt]: ResourceDemandTM is a template method and must be overridden" */»
	'''

	def dispatch resourceDemandTM(ResourceCall rc) '''
		«/* ERROR "OAW GENERATION ERROR [m2t_transforms/resources.xpt]: ResourceDemandTM is a template method and must be overridden" */»
	'''
	
	def passiveResourceInitTM(PassiveResource pr) '''
		«/* ERROR "OAW GENERATION ERROR [m2t_transforms/resources.xpt]: PassiveResourceInitTM is a template method and must be overridden" */»
	'''
}