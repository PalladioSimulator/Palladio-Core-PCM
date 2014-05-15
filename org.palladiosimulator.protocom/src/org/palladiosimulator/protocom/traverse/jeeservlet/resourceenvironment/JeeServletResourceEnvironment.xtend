package org.palladiosimulator.protocom.traverse.jeeservlet.resourceenvironment

import org.palladiosimulator.protocom.traverse.framework.resourceenvironment.XResourceEnvironment
import org.palladiosimulator.protocom.lang.java.impl.JClass
import org.palladiosimulator.protocom.tech.servlet.resourceenvironment.ServletResourceEnvironment

class JeeServletResourceEnvironment extends XResourceEnvironment {
	override protected generate() {
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletResourceEnvironment(entity)))
	}
}
