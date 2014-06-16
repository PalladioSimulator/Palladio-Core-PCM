package org.palladiosimulator.protocom.tech.iiop.repository

import de.uka.ipd.sdq.pcm.repository.BasicComponent
import org.palladiosimulator.protocom.lang.java.util.JavaNames

class JavaEEIIOPClientPreferences extends JavaEEIIOPPreferences {
	
	new(BasicComponent pcmEntity) {
		super(pcmEntity)
	}
	
	override projectName() {
		JavaNames::fqnJavaEEOperationInterfaceProjectName(pcmEntity)	
	}
}