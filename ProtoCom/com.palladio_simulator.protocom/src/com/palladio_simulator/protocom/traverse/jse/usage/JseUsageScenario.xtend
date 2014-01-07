package com.palladio_simulator.protocom.traverse.jse.usage

import com.palladio_simulator.protocom.traverse.framework.usage.XUsageScenario
import com.palladio_simulator.protocom.lang.java.impl.JClass
import com.palladio_simulator.protocom.tech.rmi.PojoUsageScenario
import com.palladio_simulator.protocom.tech.rmi.PojoUsageClosedScenarioThread
import com.palladio_simulator.protocom.tech.rmi.PojoSystemMain

class JseUsageScenario extends XUsageScenario {
	
	override generate() {
		
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new PojoUsageScenario(entity)))
		
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new PojoUsageClosedScenarioThread(entity)))
		
		// Main class for execution.
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new PojoSystemMain(entity)));
	}
	
}