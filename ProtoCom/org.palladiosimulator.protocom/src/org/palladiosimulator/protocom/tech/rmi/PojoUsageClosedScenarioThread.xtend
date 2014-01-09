package org.palladiosimulator.protocom.tech.rmi

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.impl.JMethod

class PojoUsageClosedScenarioThread extends PojoClass<UsageScenario> {
	
	new(UsageScenario pcmEntity) {
		super(pcmEntity)
	}
	
	override superClass() {
		'''org.palladiosimulator.protocom.framework.usage.AbstractClosedScenarioThread'''
	}
	
	override constructors() {
		#[
			new JMethod()
				.withParameters('''de.uka.ipd.sdq.sensorframework.entities.Experiment exp, de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun, org.palladiosimulator.protocom.framework.utils.RunProperties runProps''')
				.withImplementation('''super(exp, expRun, "Response Time of «pcmEntity.entityName»", runProps);''')
		]
	}
	
	override compilationUnitName() {
		JavaNames::javaName(pcmEntity) + "Thread"
	}
	
	override methods() {
		#[
			new JMethod()
				.withName("getScenarioRunner")
				.withParameters("org.palladiosimulator.protocom.framework.utils.RunProperties runProps")
				.withReturnType("Runnable")
				.withImplementation('''
					if (runProps.hasOption('R')) {
						org.palladiosimulator.protocom.framework.registry.RmiRegistry.setRemoteAddress(runProps.getOptionValue('R'));
					}
					else {
						org.palladiosimulator.protocom.framework.registry.RmiRegistry.setRemoteAddress(org.palladiosimulator.protocom.framework.registry.RmiRegistry.LOCALHOST);
					}
					return new «JavaNames::fqn(pcmEntity)»();
				''')
		]
	}
	
	override filePath() {
		JavaNames::fqnToDirectoryPath(JavaNames::implementationPackage(pcmEntity)) + "/" + JavaNames::javaName(pcmEntity) + "Thread.java"
	}
	
}