package de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim

import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.SensorsXpt

class SimSensorsXpt extends SensorsXpt {
	def startResponseTimeMeasurement(String s) '''
	// Take current time
	ctx.getModel().getProbeSpecContext().getSampleBlackboard().addSample(
		de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils.buildProbeSetSample(
			ctx.getModel().getProbeSpecContext().getProbeStrategyRegistry().getProbeStrategy(
				de.uka.ipd.sdq.probespec.framework.ProbeType.CURRENT_TIME, null).takeSample(
					"start«s»", ctx.getModel().getSimulationControl()),
						ctx.getThread().getRequestContext(), "«s»", ctx.getModel().getProbeSpecContext().obtainProbeSetId("start«s»")));
	'''
	
	def endResponseTimeMeasurement(String s) '''
	// Take current time
	ctx.getModel().getProbeSpecContext().getSampleBlackboard().addSample(
		de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils.buildProbeSetSample(
			ctx.getModel().getProbeSpecContext().getProbeStrategyRegistry().getProbeStrategy(
				de.uka.ipd.sdq.probespec.framework.ProbeType.CURRENT_TIME, null).takeSample(
					"end«s»", ctx.getModel().getSimulationControl()),
						ctx.getThread().getRequestContext(), "«s»", ctx.getModel().getProbeSpecContext().obtainProbeSetId("end«s»")));
	'''
	
	// overwrite template methods
	override startResponseTimeMeasurementTM(String s) {
		startResponseTimeMeasurement(s)
	}
	
	override endResponseTimeMeasurementTM(String s) {
		endResponseTimeMeasurement(s)
	}
	
}