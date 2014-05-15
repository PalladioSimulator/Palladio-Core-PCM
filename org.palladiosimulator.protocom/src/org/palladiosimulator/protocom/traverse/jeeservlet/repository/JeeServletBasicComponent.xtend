package org.palladiosimulator.protocom.traverse.jeeservlet.repository

import org.palladiosimulator.protocom.traverse.framework.repository.XBasicComponent
import org.palladiosimulator.protocom.lang.java.impl.JClass
import org.palladiosimulator.protocom.tech.servlet.repository.ServletBasicComponentClass

/**
 * @author Christian Klaussner
 */
class JeeServletBasicComponent extends XBasicComponent {
	override protected generate() {
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletBasicComponentClass(entity)));
	}	
}
