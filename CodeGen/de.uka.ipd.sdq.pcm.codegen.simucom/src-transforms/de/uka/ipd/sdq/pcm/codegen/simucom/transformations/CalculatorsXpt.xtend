package de.uka.ipd.sdq.pcm.codegen.simucom.transformations

import de.uka.ipd.sdq.pcm.seff.ExternalCallAction
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario

class CalculatorsXpt {
	def setupCalculatorResponseTime(String s, String startProbeSetId, String endProbeSetId) '''
		{
			java.util.List<org.palladiosimulator.probeframework.probes.Probe> probes = 
				java.util.Arrays.asList(
					(org.palladiosimulator.probeframework.probes.Probe)new de.uka.ipd.sdq.simucomframework.probes.TakeCurrentSimulationTimeProbe(getModel().getSimulationControl()),
					(org.palladiosimulator.probeframework.probes.Probe)new de.uka.ipd.sdq.simucomframework.probes.TakeCurrentSimulationTimeProbe(getModel().getSimulationControl()));
			
			// TODO get rid of StringMeasuringPoint and use a more concrete one.
			org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint mp = measuringpointFactory.createStringMeasuringPoint();
			mp.setMeasuringPoint("«s»");
			
			org.palladiosimulator.edp2.models.measuringpoint.MeasuringPointRepository myMeasurementPointRepository = 
					org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory.eINSTANCE.createMeasuringPointRepository();
			myMeasurementPointRepository.getMeasuringPoints().add(mp);
			mp.setMeasuringPointRepository(myMeasurementPointRepository);
		
			getModel().getProbeFrameworkContext().getCalculatorFactory().buildResponseTimeCalculator(mp,probes);
			this.startStopProbes.put("«s»",probes);
		}
	'''

	def setupCalculatorExecutionResult(UsageScenario us) '''
		//Newer Version has bugs so this old version is just commented out
		//getModel().getProbeSpecContext().getCalculatorRegistry().registerCalculator(
		//	"«us.entityName»/«us.id»/ExecutionResult",
		//	getModel().getProbeSpecContext().getCalculatorFactory().buildExecutionResultCalculator(
		//		"UsageScenario «us.entityName» <«us.id»>", 
		//		getModel().getProbeSpecContext().obtainProbeSetId(
		//			de.uka.ipd.sdq.simucomframework.ReliabilitySensorHelper.getScenarioProbeSetId(
		//				"«us.id»"))));
	'''

	def setupCalculatorExecutionResult(ExternalCallAction eac, String callName) '''
		//See method above
		//	getModel().getProbeSpecContext().getCalculatorRegistry().registerCalculator(
		//		"«eac.entityName»/«eac.id»/ExecutionResult",
		//		getModel().getProbeSpecContext().getCalculatorFactory().buildExecutionResultCalculator(
		//			"«callName»", 
		//			getModel().getProbeSpecContext().obtainProbeSetId("«callName»")));
	'''
}
