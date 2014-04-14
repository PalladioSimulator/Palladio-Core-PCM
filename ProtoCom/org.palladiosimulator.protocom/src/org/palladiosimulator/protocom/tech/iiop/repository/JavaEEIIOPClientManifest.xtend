package org.palladiosimulator.protocom.tech.iiop.repository

import de.uka.ipd.sdq.pcm.repository.BasicComponent
import org.palladiosimulator.protocom.lang.java.util.JavaNames

class JavaEEIIOPClientManifest extends JavaEEIIOPManifest{
	
	new(BasicComponent pcmEntity) {
		super(pcmEntity)
	}
	
	override classPath(){
	}
	
	override projectName() {
		JavaNames::fqnJavaEEOperationInterfaceProjectName(pcmEntity)
	}
	
}