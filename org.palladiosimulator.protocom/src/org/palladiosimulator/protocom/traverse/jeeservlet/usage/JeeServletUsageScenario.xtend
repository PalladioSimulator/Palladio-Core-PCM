package org.palladiosimulator.protocom.traverse.jeeservlet.usage

import org.palladiosimulator.protocom.traverse.framework.usage.XUsageScenario
import org.palladiosimulator.protocom.lang.java.impl.JClass
import org.palladiosimulator.protocom.tech.servlet.usage.ServletUsageScenario
import org.palladiosimulator.protocom.tech.servlet.system.ServletSystemMain

class JeeServletUsageScenario extends XUsageScenario {
	override protected generate() {
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletUsageScenario(entity)))
	}
}
