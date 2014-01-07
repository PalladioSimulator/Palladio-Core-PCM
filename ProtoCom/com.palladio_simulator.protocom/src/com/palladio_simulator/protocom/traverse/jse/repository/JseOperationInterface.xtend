package com.palladio_simulator.protocom.traverse.jse.repository

import com.palladio_simulator.protocom.traverse.framework.repository.XOperationInterface
import com.palladio_simulator.protocom.lang.java.impl.JInterface
import com.palladio_simulator.protocom.tech.rmi.PojoOperationInterface

/**
 * An Operation Interface translates into the following Java compilation units:
 * <ul>
 * 	<li> an interface.
 * </ul>
 * 
 * @author Thomas Zolynski
 */
class JseOperationInterface extends XOperationInterface {
	
	override generate() {

		generatedFiles.add(injector.getInstance(typeof(JInterface)).createFor(new PojoOperationInterface(entity)))

	}
}