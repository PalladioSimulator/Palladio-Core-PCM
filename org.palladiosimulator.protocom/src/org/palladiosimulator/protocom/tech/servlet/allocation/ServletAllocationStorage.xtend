package org.palladiosimulator.protocom.tech.servlet.allocation

import org.palladiosimulator.protocom.tech.servlet.ServletClass
import de.uka.ipd.sdq.pcm.allocation.Allocation

class ServletAllocationStorage extends ServletClass<Allocation> {
	new(Allocation pcmEntity) {
		super(pcmEntity)
	}
	
	override packageName() {
		"main";
	}
	
	override compilationUnitName() {
		"AllocationStorage"
	}
	
	override filePath() {
		"/src/main/AllocationStorage.java"
	}
	
}
