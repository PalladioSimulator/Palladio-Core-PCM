package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction

class CalculatorsXpt {
	def setupCalculatorResponseTime(String s, String startProbeSetId, String endProbeSetId) '''
		getModel().getProbeSpecContext().getCalculatorRegistry().registerCalculator(
				"«s»", getModel().getProbeSpecContext().getCalculatorFactory().buildResponseTimeCalculator(
						"«s»", 
						getModel().getProbeSpecContext().obtainProbeSetId("«startProbeSetId»"),
						getModel().getProbeSpecContext().obtainProbeSetId("«endProbeSetId»")));
	'''
	
	def setupCalculatorExecutionResult(UsageScenario us) '''
		getModel().getProbeSpecContext().getCalculatorRegistry().registerCalculator(
			"«us.entityName»/«us.id»/ExecutionResult",
			getModel().getProbeSpecContext().getCalculatorFactory().buildExecutionResultCalculator(
				"UsageScenario «us.entityName» <«us.id»>", 
				getModel().getProbeSpecContext().obtainProbeSetId(
					de.uka.ipd.sdq.simucomframework.ReliabilitySensorHelper.getScenarioProbeSetId(
						"«us.id»"))));
	'''
	
	def setupCalculatorExecutionResult(ExternalCallAction eac, String callName) '''
		getModel().getProbeSpecContext().getCalculatorRegistry().registerCalculator(
			"«eac.entityName»/«eac.id»/ExecutionResult",
			getModel().getProbeSpecContext().getCalculatorFactory().buildExecutionResultCalculator(
				"«callName»", 
				getModel().getProbeSpecContext().obtainProbeSetId("«callName»")));
	'''
}