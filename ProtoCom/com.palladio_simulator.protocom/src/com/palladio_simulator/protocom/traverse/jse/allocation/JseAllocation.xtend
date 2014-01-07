package com.palladio_simulator.protocom.traverse.jse.allocation

import com.palladio_simulator.protocom.traverse.framework.allocation.XAllocation
import com.palladio_simulator.protocom.lang.java.impl.JClass
import com.palladio_simulator.protocom.tech.rmi.PojoAllocationStorage

/**
 * An Allocation for JSE translates into one additional container information file.
 * 
 * @author Thomas Zolynski
 */
class JseAllocation extends XAllocation {
	
	override generate() {
		
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new PojoAllocationStorage(entity)))
		
	}
	
}