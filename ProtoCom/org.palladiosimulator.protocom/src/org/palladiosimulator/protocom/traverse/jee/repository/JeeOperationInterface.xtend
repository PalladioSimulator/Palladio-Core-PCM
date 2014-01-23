package org.palladiosimulator.protocom.traverse.jee.repository

import org.palladiosimulator.protocom.lang.java.impl.JeeInterface
import org.palladiosimulator.protocom.tech.iiop.repository.JavaEEIIOPOperationInterface
import org.palladiosimulator.protocom.traverse.framework.repository.XOperationInterface

class JeeOperationInterface extends XOperationInterface {
	
	override generate() {

		generatedFiles.add(injector.getInstance(typeof(JeeInterface)).createFor(new JavaEEIIOPOperationInterface(entity)))

	}
}