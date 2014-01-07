package com.palladio_simulator.protocom.traverse.jse.resourceenvironment

import com.palladio_simulator.protocom.traverse.framework.resourceenvironment.XResourceEnvironment
import com.palladio_simulator.protocom.lang.java.impl.JClass
import com.palladio_simulator.protocom.tech.rmi.PojoResourceEnvironment

/**
 * Resource Environments for JSE are a config file used for calibration of active resources.
 * 
 * @author Thomas Zolynski
 */
class JseResourceEnvironment extends XResourceEnvironment {
	
	override generate() {
		
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new PojoResourceEnvironment(entity)))
			
	}
	
}