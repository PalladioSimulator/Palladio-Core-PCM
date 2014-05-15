package org.palladiosimulator.protocom.traverse.jeeservlet.repository

import org.palladiosimulator.protocom.traverse.framework.repository.XBasicComponent
import org.palladiosimulator.protocom.lang.java.impl.JClass
import org.palladiosimulator.protocom.tech.servlet.repository.ServletBasicComponentClass
import org.palladiosimulator.protocom.lang.java.impl.JInterface
import org.palladiosimulator.protocom.tech.servlet.repository.ServletComponentClassInterface
import org.palladiosimulator.protocom.tech.servlet.repository.ServletBasicComponentContextClass
import org.palladiosimulator.protocom.tech.servlet.repository.ServletBasicComponentContextInterface
import org.palladiosimulator.protocom.tech.servlet.repository.ServletBasicComponentPortClass

/**
 * @author Christian Klaussner
 */
class JeeServletBasicComponent extends XBasicComponent {
	override protected generate() {
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletBasicComponentClass(entity)))
		generatedFiles.add(injector.getInstance(typeof(JInterface)).createFor(new ServletComponentClassInterface(entity)))
		
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletBasicComponentContextClass(entity)))
		generatedFiles.add(injector.getInstance(typeof(JInterface)).createFor(new ServletBasicComponentContextInterface(entity)))
		
		entity.providedRoles_InterfaceProvidingEntity.forEach[
			generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletBasicComponentPortClass(it)))
		]
	}	
}
