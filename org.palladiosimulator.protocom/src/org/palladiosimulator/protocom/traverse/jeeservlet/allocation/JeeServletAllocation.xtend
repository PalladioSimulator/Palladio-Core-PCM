package org.palladiosimulator.protocom.traverse.jeeservlet.allocation

import org.palladiosimulator.protocom.traverse.framework.allocation.XAllocation
import org.palladiosimulator.protocom.lang.java.impl.JClass
import org.palladiosimulator.protocom.tech.servlet.allocation.ServletAllocationStorage

class JeeServletAllocation extends XAllocation {
	override protected generate() {
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletAllocationStorage(entity)))
	}
}
