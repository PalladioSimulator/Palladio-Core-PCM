package org.palladiosimulator.protocom.traverse.jee.repository

import org.palladiosimulator.protocom.lang.java.impl.JeeClass
import org.palladiosimulator.protocom.lang.java.impl.JeeEjbDescriptor
import org.palladiosimulator.protocom.lang.java.impl.JeeGlassfishEjbDescriptor
import org.palladiosimulator.protocom.lang.java.impl.JeeInterface
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPBasicComponentClass
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPBasicComponentPortClass
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPComponentClassInterface
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPEjbDescriptor
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPGlassfishEjbDescriptor
import org.palladiosimulator.protocom.traverse.framework.repository.XBasicComponent

class JeeBasicComponent  extends XBasicComponent {
	override generate() {

		// Interface. Necessity of this one is debatable. For now it is included, because the current ProtoCom uses it as well.
		generatedFiles.add(injector.getInstance(typeof(JeeInterface)).createFor(new JavaEEIIOPComponentClassInterface(entity))) 

		// Class for this component.
		generatedFiles.add(injector.getInstance(typeof(JeeClass)).createFor(new JavaEEIIOPBasicComponentClass(entity)))
		
		// Ports. TODO? This iterator could be replaced by traversing in the XBasicComponent class.
		entity.providedRoles_InterfaceProvidingEntity.forEach[
			generatedFiles.add(injector.getInstance(typeof(JeeClass)).createFor(new JavaEEIIOPBasicComponentPortClass(it)))
		]
		
		// Glasfish Ejb Descriptor for this component.
		generatedFiles.add(injector.getInstance(typeof(JeeGlassfishEjbDescriptor)).createFor(new JavaEEIIOPGlassfishEjbDescriptor(entity)))
		
		// Ejb Descriptor for this component.
		generatedFiles.add(injector.getInstance(typeof(JeeEjbDescriptor)).createFor(new JavaEEIIOPEjbDescriptor(entity)))
		

	}
}