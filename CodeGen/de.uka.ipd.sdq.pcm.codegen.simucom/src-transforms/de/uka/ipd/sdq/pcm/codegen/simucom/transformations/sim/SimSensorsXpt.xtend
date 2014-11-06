package de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim

import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.SensorsXpt

class SimSensorsXpt extends SensorsXpt {
	def startResponseTimeMeasurement(String s) '''
	// Take current time
	((org.palladiosimulator.probeframework.probes.TriggeredProbe)this.startStopProbes.get("«s»").get(0)).takeMeasurement(ctx.getThread().getRequestContext());
	'''
	
	def endResponseTimeMeasurement(String s) '''
	// Take current time
	((org.palladiosimulator.probeframework.probes.TriggeredProbe)this.startStopProbes.get("«s»").get(1)).takeMeasurement(ctx.getThread().getRequestContext());
	'''
	
	// overwrite template methods
	override startResponseTimeMeasurementTM(String s) {
		startResponseTimeMeasurement(s)
	}
	
	override endResponseTimeMeasurementTM(String s) {
		endResponseTimeMeasurement(s)
	}
	
}