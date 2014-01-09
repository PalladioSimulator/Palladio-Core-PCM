package org.palladiosimulator.protocom.traverse.jse.repository

import org.palladiosimulator.protocom.traverse.framework.repository.XBasicComponent
import org.palladiosimulator.protocom.lang.java.impl.JInterface
import org.palladiosimulator.protocom.lang.java.impl.JClass
import org.palladiosimulator.protocom.tech.rmi.PojoComponentClassInterface
import org.palladiosimulator.protocom.tech.rmi.PojoBasicComponentClass
import org.palladiosimulator.protocom.tech.rmi.PojoBasicComponentContextClass
import org.palladiosimulator.protocom.tech.rmi.PojoBasicComponentContextInterface
import org.palladiosimulator.protocom.tech.rmi.PojoBasicComponentPortClass

/**
 * A Basic Component translates into the following Java compilation units:
 * <ul>
 * 	<li> a class implementing the component's resource demands,
 * 	<li> an interface for the component class,
 * 	<li> a context class for assembly,
 * 	<li> an interface for the context class,
 *  <li> a class for each component's port.
 * </ul>
 * 
 * @author Thomas Zolynski
 */
class JseBasicComponent extends XBasicComponent {
	override generate() {

		// Interface. Necessity of this one is debatable. For now it is included, because the current ProtoCom uses it as well.
		generatedFiles.add(injector.getInstance(typeof(JInterface)).createFor(new PojoComponentClassInterface(entity))) 

		// Class for this component.
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new PojoBasicComponentClass(entity)))

		// Context pattern.
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new PojoBasicComponentContextClass(entity)))
		generatedFiles.add(
			injector.getInstance(typeof(JInterface)).createFor(new PojoBasicComponentContextInterface(entity)))

		// Ports. TODO? This iterator could be replaced by traversing in the XBasicComponent class.
		entity.providedRoles_InterfaceProvidingEntity.forEach[
			generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new PojoBasicComponentPortClass(it)))
		]

	}
}
