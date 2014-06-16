package org.palladiosimulator.protocom.tech.iiop

import de.uka.ipd.sdq.pcm.core.entity.Entity
import org.palladiosimulator.protocom.lang.xml.IJeeClasspath
import org.palladiosimulator.protocom.tech.ConceptMapping

class JavaEEIIOPClasspathFile <E extends Entity> extends ConceptMapping<E> implements IJeeClasspath {
	
	new(E pcmEntity) {
		super(pcmEntity)
	}
	
	override classPathEntries() {
	}
	
	override filePath() {
	}
	
	override projectName() {
	}
	
	override clientClassPathEntry() {
	}
	
	override requiredClientProjects() {
	}
	
}