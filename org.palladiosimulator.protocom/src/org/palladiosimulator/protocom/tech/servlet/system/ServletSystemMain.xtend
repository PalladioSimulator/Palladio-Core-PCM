package org.palladiosimulator.protocom.tech.servlet.system

import org.palladiosimulator.protocom.tech.servlet.ServletClass
import de.uka.ipd.sdq.pcm.system.System;

class ServletSystemMain extends ServletClass<System> {
	new(System pcmEntity) {
		super(pcmEntity)
	}	
	
	override superClass() {
		"org.palladiosimulator.protocom.framework.jee.servlet.AbstractMain"
	}
	
	override compilationUnitName() {
		"Main"
	}
	
	override packageName() {
		"main"
	}
	
	override filePath() {
		"/src/main/Main.java"
	}
}
