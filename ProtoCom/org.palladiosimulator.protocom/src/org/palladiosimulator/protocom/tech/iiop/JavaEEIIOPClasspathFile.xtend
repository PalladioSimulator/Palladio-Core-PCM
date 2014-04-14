package org.palladiosimulator.protocom.tech.iiop

import de.uka.ipd.sdq.pcm.core.entity.Entity
import org.palladiosimulator.protocom.lang.xml.IClasspath
import org.palladiosimulator.protocom.tech.ConceptMapping

class JavaEEIIOPClasspathFile <E extends Entity> extends ConceptMapping<E> implements IClasspath {
	
	new(E pcmEntity) {
		super(pcmEntity)
	}
	
	override classPathEntries() {
	}
	
	override filePath() {
	}
	
	override projectName() {
	}
	
}