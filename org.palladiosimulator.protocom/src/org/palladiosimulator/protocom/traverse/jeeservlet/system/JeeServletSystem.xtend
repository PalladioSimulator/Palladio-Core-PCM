package org.palladiosimulator.protocom.traverse.jeeservlet.system

import org.palladiosimulator.protocom.traverse.framework.system.XSystem
import org.palladiosimulator.protocom.lang.xml.impl.Classpath
import org.palladiosimulator.protocom.tech.servlet.ServletClasspath
import org.palladiosimulator.protocom.lang.java.impl.JClass
import org.palladiosimulator.protocom.tech.servlet.system.ServletSystemClass

class JeeServletSystem extends XSystem {
	override protected generate() {
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletSystemClass(entity)))
		generatedFiles.add(injector.getInstance(typeof(Classpath)).createFor(new ServletClasspath(entity)))
	}
}
