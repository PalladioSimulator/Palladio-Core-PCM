package org.palladiosimulator.protocom.tech.rmi.system

import org.palladiosimulator.protocom.tech.rmi.PojoClasspathFile
import de.uka.ipd.sdq.pcm.system.System

class PojoClasspath extends PojoClasspathFile<System>{
	
	new(System pcmEntity) {
		super(pcmEntity)
	}
	
	override classPathEntries() {
		'''
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER"/>
	<classpathentry kind="con" path="org.eclipse.pde.core.requiredPlugins"/>
	<classpathentry kind="src" path="src"/>
	<classpathentry kind="output" path="bin"/>'''
	}
	
	override filePath() {
		".classpath"
	}
	
}