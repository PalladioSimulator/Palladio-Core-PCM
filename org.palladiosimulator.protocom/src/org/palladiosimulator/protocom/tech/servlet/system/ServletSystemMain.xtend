package org.palladiosimulator.protocom.tech.servlet.system

import org.palladiosimulator.protocom.tech.servlet.ServletClass
import de.uka.ipd.sdq.pcm.system.System;
import org.palladiosimulator.protocom.lang.java.impl.JAnnotation
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.impl.JField

class ServletSystemMain extends ServletClass<System> {
	new(System pcmEntity) {
		super(pcmEntity)
	}	
	
	override superClass() {
		"org.palladiosimulator.protocom.framework.jee.servlet.main.Main"
	}
	
	override annotations() {
		#[new JAnnotation().withName("javax.servlet.annotation.WebServlet").withValues(#['''urlPatterns = ""'''])]
	}
	
	override compilationUnitName() {
		"Main"
	}
	
	override packageName() {
		"main"
	}
	
	override fields() {
		#[
			new JField().asDefaultSerialVersionUID()
		]
	}
	
	override methods() {
		#[
			new JMethod()
				.withVisibilityModifier("protected")
				.withName("initModules")
				.withImplementation('''
				// TODO: Stuff
				''')
		]
	}
	
	override filePath() {
		"/src/main/Main.java"
	}
}
