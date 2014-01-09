package com.palladio_simulator.protocom.traverse.jse.system

import com.palladio_simulator.protocom.traverse.framework.system.XSystem
import com.palladio_simulator.protocom.lang.java.impl.JInterface
import com.palladio_simulator.protocom.lang.java.impl.JClass
import com.palladio_simulator.protocom.tech.rmi.PojoSystemClass
import com.palladio_simulator.protocom.tech.rmi.PojoComposedStructureContextClass
import com.palladio_simulator.protocom.tech.rmi.PojoComposedStructureContextInterface
import com.palladio_simulator.protocom.tech.rmi.PojoComposedStructureInterface
import com.palladio_simulator.protocom.tech.rmi.PojoComposedStructurePortClass

/**
 * An System translates into the following Java compilation units:
 * <ul>
 * 	<li> a class used to setup the assembly (a System is a Composed Structure),
 * 	<li> an interface for this component's class,
 * 	<li> a context class for assembly (basically unused, can be removed?),
 * 	<li> an interface for the context class,
 *  <li> a class for each component's port, used by the Usage Scenario. TODO: Move to traverse
 * </ul>
 * 
 * @author Thomas Zolynski
 */
class JseSystem extends XSystem {

	override generate() {

		// Interface. Necessity of this one is debatable. For now, it is included, because the current ProtoCom uses it as well.
		generatedFiles.add(injector.getInstance(typeof(JInterface)).createFor(new PojoComposedStructureInterface(entity)))

		// Class for this component.
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new PojoSystemClass(entity))) 
	
		// Context pattern.
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new PojoComposedStructureContextClass(entity)))
		generatedFiles.add(injector.getInstance(typeof(JInterface)).createFor(new PojoComposedStructureContextInterface(entity)))

		// Ports. See TODO above.
		entity.providedRoles_InterfaceProvidingEntity.forEach[
			generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new PojoComposedStructurePortClass(it)))
		]
		
	}
}
